package dk.sdu.vkp.common.components.impl;

import dk.sdu.vkp.common.components.interfaces.PositionComponent;

public class BasicPositionComponent implements PositionComponent {
    private double x;
    private double y;
    private double rotation;

    /**
     * Constructs a new PositionComponent instance with the specified position
     * coordinates and rotation.
     *
     * @param x The x-coordinate of the position in the game world.
     * @param y The y-coordinate of the position in the game world.
     * @param rotation The rotation in degrees, representing the orientation.
     */
    public BasicPositionComponent(final double x, final double y, final double rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public double getX() {
        return x;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(final double y) {
        this.y = y;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(final double rotation) {
        this.rotation = rotation;
    }
}
