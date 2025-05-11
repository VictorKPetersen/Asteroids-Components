package dk.sdu.vkp.map;

import dk.sdu.vkp.common.map.Map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class SpaceMap implements Map {
    @Override
    public void renderBg(GraphicsContext gc, Image image, double width, double height) {
        gc.drawImage(image, 0, 0, width, height);
        gc.setFill(Color.rgb(255, 0, 0, 0.3));
        gc.fillRect(0, 0, width, height);
        gc.setGlobalBlendMode(BlendMode.SRC_OVER);
    }
}
