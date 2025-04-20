package dk.sdu.vkp.bullet;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.weapon.Projectile;

public class Bullet extends Projectile {
    /**
     * Constructs a new Entity instance with
     * the specified position and drawing components.
     *
     * @param size
     * @param position          The {@link PositionComponent}
     *                          that defines the position and rotation of the entity.
     * @param drawingComponent  The {@link DrawingComponent}
     *                          responsible for rendering the entity.
     * @param movementComponent
     */
    public Bullet(double size, PositionComponent position, DrawingComponent drawingComponent, MovementComponent movementComponent) {
        super(size, position, drawingComponent, movementComponent);
    }
}
