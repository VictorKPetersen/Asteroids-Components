package dk.sdu.vkp.common.components.interfaces;

import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;

public interface InputComponent {
    /**
     * Processes the input for the given entity based on the current game state.
     * @param entity    The entity to process input for.
     * @param gameData  The {@link GameData} which contains access to user input.
     */
    void handleInput(Entity entity, GameData gameData);
}
