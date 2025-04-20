package dk.sdu.vkp.common.data;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.impl.BasicPositionComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;

import java.util.UUID;

public class Entity {
    private final UUID id = UUID.randomUUID();
    private final PositionComponent position;
    private final DrawingComponent drawingComponent;

    /**
     * Constructs a new Entity instance with
     * the specified position and drawing components.
     *
     * @param position The {@link BasicPositionComponent}
     *                that defines the position and rotation of the entity.
     * @param drawingComponent The {@link DrawingComponent}
     *                        responsible for rendering the entity.
     */
    public Entity(final PositionComponent position,
                  final DrawingComponent drawingComponent) {
        this.position = position;
        this.drawingComponent = drawingComponent;
    }

    public UUID getId() {
        return id;
    }

    public PositionComponent getPosition() {
        return position;
    }

    public DrawingComponent getDrawingComponent() {
        return drawingComponent;
    }
}