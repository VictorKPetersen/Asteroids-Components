package dk.sdu.vkp.player;

import dk.sdu.vkp.common.components.PositionComponent;
import dk.sdu.vkp.common.components.TriangleDrawingComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.PluginStarterService;
import dk.sdu.vkp.player.components.PlayerInputComponent;
import javafx.scene.paint.Color;

public class PlayerPluginStarterService implements PluginStarterService {
    @Override
    public void start(final GameData gameData) {
        Player player = createPlayer();
        gameData.getEntities().addEntity(player);
    }

    private Player createPlayer() {
        int playerSpawnY = 100;
        int playerSpawnX = 100;

        return new Player(
                new PositionComponent(playerSpawnX, playerSpawnY, 0),
                new TriangleDrawingComponent(Color.GREEN),
                new PlayerInputComponent()
        );
    }
}