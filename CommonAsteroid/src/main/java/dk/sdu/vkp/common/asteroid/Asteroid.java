package dk.sdu.vkp.common.asteroid;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;

public abstract class Asteroid extends Entity {
    private final MovementComponent movementComponent;

    /**
     * Constructs a new Entity instance with
     * the specified position and drawing components.
     *
     * @param radius            The radius of the asteroid.
     * @param position         The {@link PositionComponent}
     *                         that defines the position and rotation of the entity.
     * @param drawingComponent The {@link DrawingComponent}
     *                         responsible for rendering the entity.
     * @param hitbox           The {@link HitboxComponent} used for collision detection.
     * @param movementComponent The {@link MovementComponent} used for moving the entity.
     */
    public Asteroid(final double radius, final PositionComponent position,
                    final DrawingComponent drawingComponent, final HitboxComponent hitbox,
                    final MovementComponent movementComponent) {
        super(radius, position, drawingComponent, hitbox);
        this.movementComponent = movementComponent;
    }

    @Override
    public void takeHit(final GameData gameData) {
        gameData.increamentGameScore();
        super.takeHit(gameData);
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }
}