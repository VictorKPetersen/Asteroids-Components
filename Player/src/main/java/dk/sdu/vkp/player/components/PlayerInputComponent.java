package dk.sdu.vkp.player.components;

import dk.sdu.vkp.common.components.impl.BasicPositionComponent;
import dk.sdu.vkp.common.components.interfaces.InputComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.data.GameKeys;
import dk.sdu.vkp.common.weapon.WeaponComponent;
import javafx.scene.input.KeyCode;

public class PlayerInputComponent implements InputComponent {
    private final MovementComponent movement;
    private final WeaponComponent weapon;

    /**
     * Creates a PlayerInputComponent with the specified MovementComponent.
     * @param movement  The {@link MovementComponent} to be used for player movement.
     */
    public PlayerInputComponent(final MovementComponent movement, WeaponComponent weapon) {
        this.movement = movement;
        this.weapon = weapon;
    }

    /**
     * Processes the input for the given player based on the current game state and controls.
     * Updates the player's movement and rotation according to the active keys.
     *
     * @param entity The entity whose input is being handled.
     * @param gameData The game data containing the current state of the game, including active keys.
     */
    public void handleInput(final Entity entity,
                            final GameData gameData) {
        GameKeys keys = gameData.getKeys();
        handleMovement(entity, keys);
        handleAttack(entity, gameData);
    }

    private void handleMovement(final Entity entity, final GameKeys keys) {
        if (keys.isActive(KeyCode.UP) || keys.isActive(KeyCode.W)) {
            movement.moveForward(entity.getPosition());
        }
        if (keys.isActive(KeyCode.LEFT) || keys.isActive(KeyCode.A)) {
            movement.rotateLeft(entity.getPosition());
        }
        if (keys.isActive(KeyCode.RIGHT) || keys.isActive(KeyCode.D)) {
            movement.rotateRight(entity.getPosition());
        }
    }

    private void handleAttack(final Entity entity, final GameData gameData) {
        GameKeys keys = gameData.getKeys();
        if (keys.isJustPressed(KeyCode.SPACE) && weapon != null) {
            PositionComponent pos = entity.getPosition();
            double radians = Math.toRadians(pos.getRotation());

            double spawnX = pos.getX() + Math.cos(radians) * weapon.getOffsetX();
            double spawnY = pos.getY() + Math.sin(radians) * weapon.getOffsetY();

            PositionComponent spawnPos = new BasicPositionComponent(spawnX, spawnY, pos.getRotation());
            weapon.fire(gameData, spawnPos);
        }
    }
}