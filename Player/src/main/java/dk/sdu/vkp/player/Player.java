package dk.sdu.vkp.player;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.InputComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.weapon.WeaponComponent;

public class Player extends Entity {
    private final InputComponent playerInputComponent;
    private final MovementComponent movementComponent;
    private final WeaponComponent weaponComponent;

    /**
     * Creates a Player entity with the specified position, drawing, and input components.
     *
     * @param position The PositionComponent defining the player's position and rotation in the game world.
     * @param drawingComponent The DrawingComponent responsible for rendering the player entity.
     * @param playerInputComponent The PlayerInputComponent managing the player's input and movement logic.
     * @param movementComponent The MovementComponent managing the player's movement logic.
     * @param weaponComponent The WeaponComponent used for attacking.
     *
     * @param hitboxComponent The {@link HitboxComponent} used for collision detection.
     */
    public Player(final double size,
                  final PositionComponent position,
                  final DrawingComponent drawingComponent,
                  final InputComponent playerInputComponent,
                  final MovementComponent movementComponent,
                  final WeaponComponent weaponComponent,
                  final HitboxComponent hitboxComponent) {
        super(size, position, drawingComponent, hitboxComponent);
        this.playerInputComponent = playerInputComponent;
        this.movementComponent = movementComponent;
        this.weaponComponent = weaponComponent;
    }

    @Override
    public void takeHit(GameData gameData) {
        gameData.getEntities().clearEntities();
    }

    public InputComponent getPlayerInputComponent() {
        return playerInputComponent;
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    public WeaponComponent getWeaponComponent() {
        return weaponComponent;
    }
}
