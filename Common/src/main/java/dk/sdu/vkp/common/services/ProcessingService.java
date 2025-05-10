package dk.sdu.vkp.common.services;

import dk.sdu.vkp.common.data.GameData;

public interface ProcessingService {
    /**
     * Processes a singular update of the service.
     * Is called every frame.
     * Pre: gameData must not be null
     * Pre: gameData.getEntities() must not be null
     * Post: The game state in gameData will be updated according to the
     * service's processing logic.
     * Post: The service's internal state will reflect the latest processing
     * cycle.
     *
     * @param gameData The {@link GameData} used for central data sharing.
     */
    void process(GameData gameData);
}
