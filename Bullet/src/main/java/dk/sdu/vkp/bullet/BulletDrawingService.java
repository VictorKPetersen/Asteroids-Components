package dk.sdu.vkp.bullet;

import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.DrawingService;
import javafx.scene.canvas.GraphicsContext;

public class BulletDrawingService implements DrawingService {
    @Override
    public void draw(GraphicsContext graphicsContext, GameData gameData) {
        for (Bullet bullet : gameData.getEntities().getEntities(Bullet.class)) {
            bullet.getDrawingComponent().render(graphicsContext, bullet);
        }
    }
}
