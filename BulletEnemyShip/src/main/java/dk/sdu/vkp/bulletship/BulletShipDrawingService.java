package dk.sdu.vkp.bulletship;

import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.DrawingService;
import javafx.scene.canvas.GraphicsContext;

public class BulletShipDrawingService implements DrawingService {
    @Override
    public void draw(final GraphicsContext graphicsContext,
                     final GameData gameData) {
        for (BulletShip bulletShip : gameData.getEntities().getEntities(BulletShip.class)) {
            bulletShip.getDrawingComponent().render(graphicsContext, bulletShip);
        }
    }
}