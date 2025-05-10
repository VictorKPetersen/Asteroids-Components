package dk.sdu.vkp.common.components.impl;

import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;

public class LinearMovementComponent implements MovementComponent {
    private final double speed;
    private final double rotationSpeed;

    /**
     * Constructs a LinearMovementComponent with specified speed and rotation speed,
     * allowing an entity to move in a straight line and rotate at defined rates.
     *
     * @param speed The linear speed at which the entity moves forward.
     * @param rotationSpeed The angular speed at which the entity rotates.
     */
    public LinearMovementComponent(final double speed, final double rotationSpeed) {
        this.speed = speed;
        this.rotationSpeed = rotationSpeed;
    }

    @Override
    public void moveForward(final PositionComponent position) {
        double radians = Math.toRadians(position.getRotation());
        position.setX(position.getX() + Math.cos(radians) * speed);
        position.setY(position.getY() + Math.sin(radians) * speed);
    }

    @Override
    public void rotateLeft(final PositionComponent position) {
        position.setRotation(position.getRotation() - rotationSpeed);
    }

    @Override
    public void rotateRight(final PositionComponent position) {
        position.setRotation(position.getRotation() + rotationSpeed);
    }
}
