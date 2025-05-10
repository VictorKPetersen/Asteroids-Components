package dk.sdu.vkp.map;

import dk.sdu.vkp.common.map.Map;
import javafx.scene.canvas.GraphicsContext;

public class SpaceMap implements Map {
    @Override
    public void renderBg(final GraphicsContext gc,
                         final double width,
                         final double height) {
        System.out.println("Rendering the stars");
    }
}
