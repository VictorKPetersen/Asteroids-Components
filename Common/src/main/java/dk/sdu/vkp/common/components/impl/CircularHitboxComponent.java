package dk.sdu.vkp.common.components.impl;

import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.data.Entity;

public class CircularHitboxComponent implements HitboxComponent {
    private final double radius;

    public CircularHitboxComponent(double radius) {
        this.radius = radius;
    }

    @Override
    public double getHitboxRadius(Entity entity) {
        return radius;
    }
}
