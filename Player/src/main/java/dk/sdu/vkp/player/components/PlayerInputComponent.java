package dk.sdu.vkp.player.components;

import dk.sdu.vkp.common.components.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.data.GameKeys;
import dk.sdu.vkp.player.Player;
import javafx.scene.input.KeyCode;

public class PlayerInputComponent {
    /**
     * Processes the input for the given player based on the current game state and controls.
     * Updates the player's movement and rotation according to the active keys.
     *
     * @param player The player entity whose input is being handled.
     * @param gameData The game data containing the current state of the game, including active keys.
     */
    public void handleInput(final Player player,
                            final GameData gameData) {
        GameKeys keys = gameData.getKeys();
        handleMovement(player, keys);
    }

    private void handleMovement(final Player player, final GameKeys keys) {
        PositionComponent position = player.getPosition();
        if (keys.isActive(KeyCode.UP) || keys.isActive(KeyCode.W)) {
            double radians = Math.toRadians(position.getRotation());
            position.setX(position.getX()
                    + Math.cos(radians) * player.getSpeed());
            position.setY(position.getY()
                    + Math.sin(radians) * player.getSpeed());
        }
        if (keys.isActive(KeyCode.LEFT) || keys.isActive(KeyCode.A)) {
            position.setRotation(position.getRotation()
                    - player.getRotationSpeed());
        }
        if (keys.isActive(KeyCode.RIGHT) || keys.isActive(KeyCode.D)) {
            position.setRotation(position.getRotation()
                    + player.getRotationSpeed());
        }
    }

}