package dk.sdu.vkp.common.components.interfaces;

import dk.sdu.vkp.common.data.Entity;

public interface MovementComponent {

    /**
     * Moves the entity forward in the direction it is facing.
     *
     * @param entity The entity to move forward
     */
    void moveForward(Entity entity);

    /**
     * Rotates the entity counter-clockwise.
     *
     * @param entity The entity to rotate left
     */
    void rotateLeft(Entity entity);

    /**
     * Rotates the entity clockwise.
     *
     * @param entity The entity to rotate right
     */
    void rotateRight(Entity entity);
}
