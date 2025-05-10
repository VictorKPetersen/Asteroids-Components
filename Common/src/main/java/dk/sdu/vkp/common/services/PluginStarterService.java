package dk.sdu.vkp.common.services;

import dk.sdu.vkp.common.data.GameData;

public interface PluginStarterService {
    /**
     * Starts the module, this code is run on window start.
     * Pre: gameData must not be null
     * Pre: gameData.getEntities() must not be null
     * Post: The module's entities and components are initialized and added
     * to the gameData
     * Post: The module is ready for game execution
     * @param gameData  The {@link GameData} used for central data sharing.
     *
     */
    void start(GameData gameData);
}