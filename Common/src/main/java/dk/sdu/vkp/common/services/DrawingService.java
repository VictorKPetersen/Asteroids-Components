package dk.sdu.vkp.common.services;

import dk.sdu.vkp.common.data.GameData;
import javafx.scene.canvas.GraphicsContext;

public interface DrawingService {
    /**
     * Draws the service. Is called late in the frame.
     * Should display the newest state of the object in the window.
     * @param graphicsContext   The {@link GraphicsContext}
     *                         which is linked to the window scene.
     * @param gameData The {@link GameData} used for central data sharing.
     */
    void draw(GraphicsContext graphicsContext, GameData gameData);
}