package dk.sdu.vkp.player;

import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.ProcessingService;

public class PlayerProcessingService implements ProcessingService {
    @Override
    public void process(final GameData gameData) {
        for (Player player : gameData.getEntities().getEntities(Player.class)) {
            player.getPlayerInputComponent().handleInput(player, gameData);
            checkBounds(gameData, player);
        }
    }

    private void checkBounds(final GameData gameData, final Player player) {
        PositionComponent position = player.getPosition();
        double x = position.getX();
        double y = position.getY();
        double maxWidth = gameData.getWindowWidth();
        double maxHeight = gameData.getWindowHeight();
        double bufferPixels = 5;

        if (x > maxWidth + bufferPixels) {
            position.setX(-bufferPixels);
        } else if (x < -bufferPixels) {
            position.setX(maxWidth + bufferPixels);
        }
        if (y > maxHeight + bufferPixels) {
            position.setY(-bufferPixels);
        } else if (y < -bufferPixels) {
            position.setY(maxHeight + bufferPixels);
        }
    }
}