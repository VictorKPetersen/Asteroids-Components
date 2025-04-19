package dk.sdu.vkp.common.data;

import dk.sdu.vkp.common.components.DrawingComponent;
import dk.sdu.vkp.common.components.PositionComponent;
import javafx.scene.canvas.GraphicsContext;

import java.util.UUID;

public class Entity {
    private final UUID id = UUID.randomUUID();
    private final PositionComponent position;
    private final DrawingComponent drawingComponent;

    /**
     * Constructs a new Entity instance with
     * the specified position and drawing components.
     *
     * @param position The {@link PositionComponent}
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

    /**
     * Renders the entity using the provided graphics context.
     * @param graphicsContext The {@link GraphicsContext} used for rendering.
     */
    public void render(final GraphicsContext graphicsContext) {
        drawingComponent.render(graphicsContext, this);
    }

    public PositionComponent getPosition() {
        return position;
    }
}