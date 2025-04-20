package dk.sdu.vkp.bullet;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
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
     * @param movementComponent The {@link MovementComponent} used for moving the entity.
     * @param hitbox The {@link HitboxComponent} used for collision detection.
     */
    public Bullet(final double size, final PositionComponent position,
                  final DrawingComponent drawingComponent,final MovementComponent movementComponent,
                  final HitboxComponent hitbox) {
        super(size, position, drawingComponent, movementComponent, hitbox);
    }
}
