package dk.sdu.vkp.player;

import dk.sdu.vkp.common.components.DrawingComponent;
import dk.sdu.vkp.common.components.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.player.components.PlayerInputComponent;

public class Player extends Entity {
    private final double speed = 10;
    private final double rotationSpeed = 10;
    private final PlayerInputComponent playerInputComponent;

    /**
     * Creates a Player entity with the specified position, drawing, and input components.
     *
     * @param position The PositionComponent defining the player's position and rotation in the game world.
     * @param drawingComponent The DrawingComponent responsible for rendering the player entity.
     * @param playerInputComponent The PlayerInputComponent managing the player's input and movement logic.
     */
    public Player(final PositionComponent position,
                  final DrawingComponent drawingComponent,
                  final PlayerInputComponent playerInputComponent) {
        super(position, drawingComponent);
        this.playerInputComponent = playerInputComponent;
    }

    public double getSpeed() {
        return speed;
    }

    public double getRotationSpeed() {
        return rotationSpeed;
    }

    public PlayerInputComponent getPlayerInputComponent() {
        return playerInputComponent;
    }
}
