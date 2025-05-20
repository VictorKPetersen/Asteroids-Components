package dk.sdu.vkp.common.asteroid;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;
import org.springframework.web.client.RestTemplate;

public abstract class Asteroid extends Entity {
    private final MovementComponent movementComponent;
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
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
        increaseScore("http://localhost:8080/increase?score=1");
        super.takeHit(gameData);
    }

    private void increaseScore(String url) {
        try {
            REST_TEMPLATE.getForObject(url, String.class);
        } catch (Exception e) {
            System.out.println("Failed to increase score");
            e.printStackTrace();
        }
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }
}