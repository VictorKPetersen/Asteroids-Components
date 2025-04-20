package dk.sdu.vkp.common.components.interfaces;

import dk.sdu.vkp.common.data.Entity;
import javafx.scene.canvas.GraphicsContext;

public interface DrawingComponent {
    /**
     * Renders the specified entity using the provided graphics context.
     *
     * @param graphicsContext The {@link GraphicsContext}
     *                       used to perform the rendering operations.
     * @param entity          The {@link Entity} to be rendered.
     */
    void render(GraphicsContext graphicsContext, Entity entity);
}
