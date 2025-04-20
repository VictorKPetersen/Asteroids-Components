package dk.sdu.vkp.common.components.impl;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TriangleDrawingComponent implements DrawingComponent {
    private final Color color;

    /**
     * Constructs a new TriangleDrawingComponent instance with the specified color.
     * @param color The color of the triangle. Triangle will be filled.
     */
    public TriangleDrawingComponent(final Color color) {
        this.color = color;
    }

    @Override
    public void render(final GraphicsContext graphicsContext, final Entity entity) {
        PositionComponent position = entity.getPosition();

        graphicsContext.save();

        graphicsContext.translate(position.getX(), position.getY());
        graphicsContext.rotate(position.getRotation());

        graphicsContext.setFill(color);

        graphicsContext.beginPath();
        graphicsContext.moveTo(20, 0);
        graphicsContext.lineTo(-10, 10);
        graphicsContext.lineTo(-10, -10);
        graphicsContext.closePath();
        graphicsContext.fill();

        graphicsContext.restore();
    }
}
