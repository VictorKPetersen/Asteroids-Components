package dk.sdu.vkp.common.components.interfaces;

import dk.sdu.vkp.common.data.Entity;

public interface HitboxComponent {
    /**
     * Gets the radius of the hitbox.
     * @return the radius of the hitbox as a double.
     */
    public double getHitboxRadius(Entity entity);
}
