package dk.sdu.vkp.common.weapon;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;

public class Projectile extends Entity {
    private final MovementComponent movementComponent;
    /**
     * Constructs a new Entity instance with
     * the specified position and drawing components.
     *
     * @param size
     * @param position         The {@link PositionComponent}
     *                         that defines the position and rotation of the entity.
     * @param drawingComponent The {@link DrawingComponent}
     *                         responsible for rendering the entity.
     */
    public Projectile(final double size, final PositionComponent position,
                      final DrawingComponent drawingComponent, final MovementComponent movementComponent) {
        super(size, position, drawingComponent);
        this.movementComponent = movementComponent;
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }
}
