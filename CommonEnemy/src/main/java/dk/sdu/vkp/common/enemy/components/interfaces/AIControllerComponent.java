package dk.sdu.vkp.common.enemy.components.interfaces;


import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.enemy.Enemy;

public interface AIControllerComponent {
    void update(Enemy enemy, GameData gameData);
}
