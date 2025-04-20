package dk.sdu.vkp.common.components.interfaces;

public interface PositionComponent {
    /**
     * Gets the x-coordinate of the position.
     *
     * @return The x-coordinate as a double
     */
    double getX();

    /**
     * Gets the y-coordinate of the position.
     *
     * @return The y-coordinate as a double
     */
    double getY();

    /**
     * Gets the rotation angle of the position.
     *
     * @return The rotation in degrees as a double
     */
    double getRotation();

    /**
     * Sets the x-coordinate of the position.
     *
     * @param x The new x-coordinate value
     */
    void setX(double x);

    /**
     * Sets the y-coordinate of the position.
     *
     * @param y The new y-coordinate value
     */
    void setY(double y);

    /**
     * Sets the rotation angle of the position.
     *
     * @param rotation The new rotation value in degrees
     */
    void setRotation(double rotation);
    
}
