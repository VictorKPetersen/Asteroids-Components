package dk.sdu.vkp.splitterasteroid;

import dk.sdu.vkp.common.asteroid.Asteroid;
import dk.sdu.vkp.common.components.impl.BasicPositionComponent;
import dk.sdu.vkp.common.components.impl.CircleDrawingComponent;
import dk.sdu.vkp.common.components.impl.CircularHitboxComponent;
import dk.sdu.vkp.common.components.impl.LinearMovementComponent;
import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import javafx.scene.paint.Color;

import java.util.Random;


public class SplitterAsteroid extends Asteroid {
    private final double baseRadius;
    private final int layers;
    private final static double SPEED = 4;
    private final static double ROTATION_SPEED = 35;
    private final static Color COLOR = Color.YELLOWGREEN;
    /**
     * Constructs a new Entity instance with
     * the specified position and drawing components.
     *
     * @param baseRadius        The radius of the asteroid.
     * @param position          The {@link PositionComponent}
     *                          that defines the position and rotation of the entity.
     * @param drawingComponent  The {@link DrawingComponent}
     *                          responsible for rendering the entity.
     * @param hitbox            The {@link HitboxComponent} used for collision detection.
     * @param movementComponent The {@link MovementComponent} used for moving the entity.
     * @param layers            A number > 0 representing the number of hits the asteroid can take.
     */
    public SplitterAsteroid(final PositionComponent position,
                            final DrawingComponent drawingComponent,
                            final HitboxComponent hitbox,
                            final MovementComponent movementComponent, final double baseRadius,
                            final int layers) {
        super((baseRadius * layers), position, drawingComponent, hitbox, movementComponent);
        this.baseRadius = baseRadius;
        this.layers = layers;
    }

    @Override
    public void takeHit(final GameData gameData) {
        super.takeHit(gameData);
        if (layers > 1) {
            for (int i = 0; i < 2; i++) {
                SplitterAsteroid ast = split();
                gameData.getEntities().addEntity(ast);
            }
        }
    }

    private SplitterAsteroid split() {
        Random random = new Random();
        double angleOffset = (random.nextDouble() * 360);

        int asteroidLayers = this.layers - 1;
        PositionComponent oldPos = this.getPosition();
        PositionComponent pos = new BasicPositionComponent(oldPos.getX(), oldPos.getY(), angleOffset);
        DrawingComponent draw = new CircleDrawingComponent(COLOR);
        HitboxComponent hitbox = new CircularHitboxComponent(baseRadius * asteroidLayers);
        MovementComponent movement = new LinearMovementComponent(SPEED, ROTATION_SPEED);

        return new SplitterAsteroid(
                pos, draw, hitbox, movement, baseRadius, asteroidLayers
        );
    }

    public static double getSpeed() {
        return SPEED;
    }

    public static double getRotationSpeed() {
        return ROTATION_SPEED;
    }

    public static Color getColor() {
        return COLOR;
    }

}