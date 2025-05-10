package dk.sdu.vkp.common.weapon;

import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;

public interface WeaponComponent {
    /**
     * Fires a projectile from the weapon.
     *
     * @param gameData      The game data containing current game state
     * @param spawnPosition The position from which to spawn the projectile
     */
    void fire(GameData gameData, PositionComponent spawnPosition);

    /**
     * Gets the horizontal offset of the weapon relative to its bearer.
     *
     * @return The X-axis offset as a double value
     */
    double getOffsetX();

    /**
     * Gets the vertical offset of the weapon relative to its bearer.
     *
     * @return The Y-axis offset as a double value
     */
    double getOffsetY();
}