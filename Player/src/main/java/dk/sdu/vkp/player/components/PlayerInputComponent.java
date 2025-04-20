package dk.sdu.vkp.player.components;

import dk.sdu.vkp.common.components.interfaces.InputComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.data.GameKeys;
import javafx.scene.input.KeyCode;

public class PlayerInputComponent implements InputComponent {
    private final MovementComponent movement;

    /**
     * Creates a PlayerInputComponent with the specified MovementComponent.
     * @param movement  The {@link MovementComponent} to be used for player movement.
     */
    public PlayerInputComponent(final MovementComponent movement) {
        this.movement = movement;
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
    }

    private void handleMovement(final Entity entity, final GameKeys keys) {
        if (keys.isActive(KeyCode.UP) || keys.isActive(KeyCode.W)) {
            movement.moveForward(entity);
        }
        if (keys.isActive(KeyCode.LEFT) || keys.isActive(KeyCode.A)) {
            movement.rotateLeft(entity);
        }
        if (keys.isActive(KeyCode.RIGHT) || keys.isActive(KeyCode.D)) {
            movement.rotateRight(entity);
        }
    }
}