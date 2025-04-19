package dk.sdu.vkp.common.services;

import dk.sdu.vkp.common.data.GameData;

public interface PluginStarterService {
    /**
     * Starts the module, this code is run on window start.
     * @param gameData  The {@link GameData} used for central data sharing.
     */
    void start(GameData gameData);
}