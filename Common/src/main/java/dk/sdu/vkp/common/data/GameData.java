package dk.sdu.vkp.common.data;

public class GameData {
    private int windowWidth;
    private int windowHeight;

    private final GameKeys keys;
    private final GameEntities entities;

    /**
     * Creates a new instance of {@link GameData}.
     * @param keys The {@link GameKeys} to inject.
     * @param entities The {@link GameEntities} to inject.
     */
    public GameData(GameKeys keys, GameEntities entities) {
        this.keys = keys;
        this.entities = entities;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(final int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(final int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public GameKeys getKeys() {
        return keys;
    }

    public GameEntities getEntities() {
        return entities;
    }
}