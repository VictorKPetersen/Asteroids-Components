package dk.sdu.vkp.splitterasteroid;

import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.ProcessingService;

public class SplitterAsteroidProcessingService implements ProcessingService {
    @Override
    public void process(GameData gameData) {
        for (SplitterAsteroid asteroid : gameData.getEntities().getEntities(SplitterAsteroid.class)) {
           asteroid.getMovementComponent().moveForward(asteroid.getPosition());
            checkBounds(gameData, asteroid);
        }
    }
    
    private void checkBounds(final GameData gameData, final SplitterAsteroid splitter) {
        PositionComponent position = splitter.getPosition();
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
