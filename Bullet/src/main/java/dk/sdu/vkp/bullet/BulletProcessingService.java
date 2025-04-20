package dk.sdu.vkp.bullet;

import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.ProcessingService;

public class BulletProcessingService implements ProcessingService {
    @Override
    public void process(GameData gameData) {
        for (Bullet bullet : gameData.getEntities().getEntities(Bullet.class)) {
            bullet.getMovementComponent().moveForward(bullet.getPosition());
            checkBounds(bullet, gameData);
        }
    }

    private void checkBounds(Bullet bullet, GameData gameData) {
        PositionComponent position = bullet.getPosition();
        double x = position.getX();
        double y = position.getY();
        double maxWidth = gameData.getWindowWidth();
        double maxHeight = gameData.getWindowHeight();
        double bufferPixels = bullet.getSize() * 2;

        if (x > maxWidth + bufferPixels) {
            gameData.getEntities().removeEntity(bullet);
        } else if (x < -bufferPixels) {
            gameData.getEntities().removeEntity(bullet);
        }
        if (y > maxHeight + bufferPixels) {
            gameData.getEntities().removeEntity(bullet);
        } else if (y < -bufferPixels) {
            gameData.getEntities().removeEntity(bullet);
        }
    }
}