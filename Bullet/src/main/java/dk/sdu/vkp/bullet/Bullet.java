package dk.sdu.vkp.bullet;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;

public class Bullet extends Entity {
    private final MovementComponent movementComponent;
    /**
     * Constructs a new Entity instance with
     * the specified position and drawing components.
     *
     * @param position         The {@link PositionComponent}
     *                         that defines the position and rotation of the entity.
     * @param drawingComponent The {@link DrawingComponent}
     *                         responsible for rendering the entity.
     */
    public Bullet(final double size, final PositionComponent position,
                  final DrawingComponent drawingComponent,
                  final MovementComponent movementComponent) {
        super(size, position, drawingComponent);
        this.movementComponent = movementComponent;
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }
}
