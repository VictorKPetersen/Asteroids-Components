package dk.sdu.vkp.player;

import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.PluginStarterService;

public class PlayerPluginStarterService implements PluginStarterService {
    @Override
    public void start(final GameData gameData) {
        Player player = createPlayer();
        gameData.getEntities().addEntity(player);
    }

    private Player createPlayer() {
        Player player = new Player();
        return player;
    }
}