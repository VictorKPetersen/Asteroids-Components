package dk.sdu.vkp.common.components.impl;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleDrawingComponent implements DrawingComponent {
    private final Color color;

    /**
     * Constructs the drawing component with a given color.
     * @param color The color which the drawing should take.
     */
    public CircleDrawingComponent(final Color color) {
        this.color = color;
    }

    @Override
    public void render(final GraphicsContext graphicsContext,
                       final Entity entity) {
        PositionComponent position = entity.getPosition();
        double size = entity.getSize();

        graphicsContext.save();

        graphicsContext.translate(position.getX(), position.getY());
        graphicsContext.rotate(position.getRotation());

        graphicsContext.setFill(color);
        graphicsContext.fillOval(-0.5 * size, -0.5 * size, size, size);

        graphicsContext.restore();

    }
}