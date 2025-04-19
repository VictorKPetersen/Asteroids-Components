package dk.sdu.vkp.common.services;

import dk.sdu.vkp.common.data.GameData;

public interface ProcessingService {
    /**
     * Processes a singular update of the service.
     * Is called every frame.
     * @param gameData The {@link GameData} used for central data sharing.
     */
    void process(GameData gameData);
}
