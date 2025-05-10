package dk.sdu.vkp.common.data;

public class GameData {
    private int windowWidth;
    private int windowHeight;

    private int gameScore;

    private final GameKeys keys;
    private final GameEntities entities;

    /**
     * Creates a new instance of {@link GameData}.
     * @param keys The {@link GameKeys} to inject.
     * @param entities The {@link GameEntities} to inject.
     */
    public GameData(final GameKeys keys, final GameEntities entities) {
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

    public int getGameScore() {
        return gameScore;
    }

    /**
     * Increments the game score by 1.
     */
    public void increamentGameScore() {
        ++gameScore;
    }

    public GameKeys getKeys() {
        return keys;
    }

    public GameEntities getEntities() {
        return entities;
    }
}