package dk.sdu.vkp.common.data;

public class GameData {
    private int windowWidth;
    private int windowHeight;

    private final GameKeys keys = new GameKeys();

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
}
