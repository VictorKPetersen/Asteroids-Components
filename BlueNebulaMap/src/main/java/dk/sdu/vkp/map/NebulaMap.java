package dk.sdu.vkp.map;

import dk.sdu.vkp.common.map.Map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class NebulaMap implements Map {
    private static final Image BACKGROUND_IMAGE =
            new Image("BlueNebulaBackground.png");

    @Override
    public void renderBg(GraphicsContext gc, double width, double height) {
        gc.drawImage(BACKGROUND_IMAGE, 0, 0, width, height);
    }
}
