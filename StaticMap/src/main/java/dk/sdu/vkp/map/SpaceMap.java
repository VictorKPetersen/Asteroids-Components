package dk.sdu.vkp.map;

import dk.sdu.vkp.common.map.Map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceMap implements Map {
    @Override
    public void renderBg(GraphicsContext gc, Image image, double width, double height) {
        gc.drawImage(image, 0, 0, width, height);
    }
}
