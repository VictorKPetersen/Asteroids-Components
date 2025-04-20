package dk.sdu.vkp.common.enemy;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.enemy.components.interfaces.AIControllerComponent;
import dk.sdu.vkp.common.weapon.WeaponComponent;

public abstract class Enemy extends Entity {
    private final MovementComponent movementComponent;
    private final AIControllerComponent aiControllerComponent;
    private final WeaponComponent weaponComponent;
    /**
     * Constructs a new Entity instance with
     * the specified position and drawing components.
     *
     * @param size
     * @param position         The {@link PositionComponent}
     *                         that defines the position and rotation of the entity.
     * @param drawingComponent The {@link DrawingComponent}
     *                         responsible for rendering the entity.
     * @param movementComponent The {@link MovementComponent}
     *                          that can move the entity.
     * @param aiControllerComponent The {@link AIControllerComponent} which can calculate the entity's next movement.'
     * @param weaponComponent The{@link WeaponComponent} which allows the entity to attack.
     *
     * @param hitbox The {@link HitboxComponent} used for collision detection.
     */

    public Enemy(final double size, final PositionComponent position,
                 final DrawingComponent drawingComponent, final MovementComponent movementComponent,
                 final AIControllerComponent aiControllerComponent, final WeaponComponent weaponComponent,
                 final HitboxComponent hitbox) {
        super(size, position, drawingComponent, hitbox);
        this.movementComponent = movementComponent;
        this.aiControllerComponent = aiControllerComponent;
        this.weaponComponent = weaponComponent;
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    public AIControllerComponent getAiControllerComponent() {
        return aiControllerComponent;
    }

    public WeaponComponent getWeaponComponent() {
        return weaponComponent;
    }
}