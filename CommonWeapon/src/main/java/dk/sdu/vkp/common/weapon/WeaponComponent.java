package dk.sdu.vkp.common.weapon;

import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;

public interface WeaponComponent {
    void fire(GameData gameData, PositionComponent spawnPosition);
}