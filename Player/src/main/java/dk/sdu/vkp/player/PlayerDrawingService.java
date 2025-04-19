package dk.sdu.vkp.player;

import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.DrawingService;
import javafx.scene.canvas.GraphicsContext;

public class PlayerDrawingService implements DrawingService {
    @Override
    public void draw(final GraphicsContext graphicsContext,
                     final GameData gameData) {
        for (Player player : gameData.getEntities().getEntities(Player.class)) {
            player.render(graphicsContext);
        }
    }
}