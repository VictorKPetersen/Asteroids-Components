package dk.sdu.vkp.common.services;

import dk.sdu.vkp.common.data.GameData;

public interface CollisionProcessingService {
    /**
     * Processes collisions between entities in the game.
     * This should run after {@link ProcessingService#process(GameData)}} is called.
     */
    void processCollisions(GameData gameData);
}
