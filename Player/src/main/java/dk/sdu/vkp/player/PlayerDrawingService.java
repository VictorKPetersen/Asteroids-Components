package dk.sdu.vkp.player;

import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.DrawingService;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PlayerDrawingService implements DrawingService {
    @Override
    public void draw(final GraphicsContext graphicsContext,
                     final GameData gameData) {
        for (Player player : gameData.getEntities().getEntities(Player.class)) {
            graphicsContext.setFill(Color.GREEN);
            graphicsContext.fillRect(10, 10, 100, 100);
        }
    }
}