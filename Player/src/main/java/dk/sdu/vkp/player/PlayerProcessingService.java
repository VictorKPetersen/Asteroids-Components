package dk.sdu.vkp.player;

import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.ProcessingService;

public class PlayerProcessingService implements ProcessingService {
    @Override
    public void process(final GameData gameData) {
        for (Player player : gameData.getEntities().getEntities(Player.class)) {
            player.sayHello();
        }
    }
}