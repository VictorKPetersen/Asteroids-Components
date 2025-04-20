package dk.sdu.vkp.bulletship;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.enemy.Enemy;
import dk.sdu.vkp.common.enemy.components.interfaces.AIControllerComponent;
import dk.sdu.vkp.common.weapon.WeaponComponent;

public class BulletShip extends Enemy {
    /**
     * Constructs a new Entity instance with
     * the specified position and drawing components.
     *
     * @param size
     * @param position          The {@link PositionComponent}
     *                          that defines the position and rotation of the entity.
     * @param drawingComponent  The {@link DrawingComponent}
     *                          responsible for rendering the entity.
     * @param movementComponent The {@link MovementComponent}
     *                          that can move the entity.
     * @param ai The {@link AIControllerComponent} which can calculate the entity's next movement.'
     * @param weaponComponent   The{@link WeaponComponent} which allows the entity to attack.
     */
    public BulletShip(final double size, final PositionComponent position,
                      final DrawingComponent drawingComponent, final MovementComponent movementComponent,
                      final AIControllerComponent ai, final WeaponComponent weaponComponent) {
        super(size, position, drawingComponent, movementComponent, ai, weaponComponent);
    }
}