package dk.sdu.vkp.splitterasteroid;

import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.DrawingService;
import javafx.scene.canvas.GraphicsContext;

public class SplitterAsteroidDrawingService implements DrawingService {
    @Override
    public void draw(final GraphicsContext graphicsContext, final GameData gameData) {
        for (SplitterAsteroid asteroid : gameData.getEntities().getEntities(SplitterAsteroid.class)) {
            asteroid.getDrawingComponent().render(graphicsContext, asteroid);
        }
    }
}
