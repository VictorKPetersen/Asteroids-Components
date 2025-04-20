package dk.sdu.vkp.player;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.InputComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;

public class Player extends Entity {
    private final InputComponent playerInputComponent;
    private final MovementComponent movementComponent;

    /**
     * Creates a Player entity with the specified position, drawing, and input components.
     *
     * @param position The PositionComponent defining the player's position and rotation in the game world.
     * @param drawingComponent The DrawingComponent responsible for rendering the player entity.
     * @param playerInputComponent The PlayerInputComponent managing the player's input and movement logic.
     * @param movementComponent The MovementComponent managing the player's movement logic.'
     */
    public Player(final PositionComponent position,
                  final DrawingComponent drawingComponent,
                  final InputComponent playerInputComponent,
                  final MovementComponent movementComponent) {
        super(position, drawingComponent);
        this.playerInputComponent = playerInputComponent;
        this.movementComponent = movementComponent;
    }

    public InputComponent getPlayerInputComponent() {
        return playerInputComponent;
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }
}
