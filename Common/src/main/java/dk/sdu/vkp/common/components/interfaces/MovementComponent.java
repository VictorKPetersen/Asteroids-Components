package dk.sdu.vkp.common.components.interfaces;

public interface MovementComponent {

    /**
     * Updates the position component to move forward
     * based on the current direction.
     *
     * @param position The position component to update
     */
    void moveForward(PositionComponent position);

    /**
     * Updates the position component to rotate
     * in a counter-clockwise direction.
     *
     * @param position The position component to update
     */
    void rotateLeft(PositionComponent position);

    /**
     * Updates the position component to rotate
     * in a clockwise direction.
     *
     * @param position The position component to update
     */
    void rotateRight(PositionComponent position);
}
