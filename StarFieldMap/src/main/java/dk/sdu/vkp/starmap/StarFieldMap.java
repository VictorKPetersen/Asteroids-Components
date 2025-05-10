package dk.sdu.vkp.starmap;

import dk.sdu.vkp.common.map.Map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class StarFieldMap implements Map {
    private static final Image BACKGROUND_IMAGE = new Image("StarField.png");
    @Override
    public void renderBg(GraphicsContext gc, double width, double height) {
        gc.drawImage(BACKGROUND_IMAGE, 0, 0, width, height);
    }
}
