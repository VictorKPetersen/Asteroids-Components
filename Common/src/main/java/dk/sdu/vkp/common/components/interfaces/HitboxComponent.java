package dk.sdu.vkp.common.components.interfaces;

import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;

public interface HitboxComponent {
    /**
     * Gets the radius of the hitbox.
     * @param entity the entity which hitbox should be looked at.
     * @return the radius of the hitbox as a double.
     */
    double getHitboxRadius(Entity entity);

    /**
     * Called when the entity collides with another entity.
     * @param entity    The entity which has collided with another entity.
     * @param gameData  The {@link GameData} for manipulating world state.
     */
    void hit(Entity entity, GameData gameData);


}
