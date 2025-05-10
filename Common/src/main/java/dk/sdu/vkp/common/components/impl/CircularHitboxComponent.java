package dk.sdu.vkp.common.components.impl;

import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;

public class CircularHitboxComponent implements HitboxComponent {
    private final double radius;

    /**
     * Creates a circular hitbox with the specified radius.
     *
     * @param radius The radius of the circular hitbox.
     */
    public CircularHitboxComponent(final double radius) {
        this.radius = radius;
    }

    @Override
    public double getHitboxRadius(final Entity entity) {
        return radius;
    }

    @Override
    public void hit(final Entity entity, final GameData gameData) {
        entity.takeHit(gameData);
    }
}
