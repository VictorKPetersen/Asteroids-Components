package dk.sdu.vkp.bulletship;

import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.enemy.components.interfaces.AIControllerComponent;
import dk.sdu.vkp.common.services.ProcessingService;

public class BulletShipProcessingService implements ProcessingService {
    @Override
    public void process(GameData gameData) {
        for (BulletShip bulletShip : gameData.getEntities().getEntities(BulletShip.class)) {
            AIControllerComponent ai = bulletShip.getAiControllerComponent();

            ai.update(bulletShip, gameData);

            checkBounds(gameData, bulletShip);
        }

    }

    private void checkBounds(final GameData gameData, final BulletShip bulletShip) {
        PositionComponent position = bulletShip.getPosition();
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