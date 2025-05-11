package dk.sdu.vkp.common.map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public interface Map {
    /**
     * Should render a background image
     * onto the screen with the given parameters.
     * @param gc The instance of {@link GraphicsContext}
     *          to render on the canvas.
     * @param image The image to be rendered.
     * @param width The width of the image to be rendered in pixels.
     * @param height The height of the image to be rendered in pixels.
     */
    void renderBg(GraphicsContext gc, Image image, double width, double height);
}
