package dk.sdu.vkp.common.enemy.components.interfaces;


import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.enemy.Enemy;

public interface AIControllerComponent {
    /**
     * Process the current frame for a given enemy.
     * @param enemy The non-null {@link Enemy} to process.
     * @param gameData The non-null {@link GameData}
     *                with other entites information.
     */
    void update(Enemy enemy, GameData gameData);
}
