package dk.sdu.vkp.common.data;

import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class GameKeys {
    private final Set<KeyCode> activeKeys = new HashSet<>();
    private final Set<KeyCode> justPressedKeys = new HashSet<>();

    /**
     * Adds the provided key to the set of active keys.
     * If the key is not already present in the activeKeys set,
     * it is added to the justPressedKeys set as well.
     *
     * @param keyCode the key to be added to the set of active keys.
     */
    public void addActiveKey(final KeyCode keyCode) {
        // Add to justPressedKeys if keyCode is not currently in activeKeys.
        if (!activeKeys.contains(keyCode)) {
            justPressedKeys.add(keyCode);
        }
        activeKeys.add(keyCode);
    }
 
    /**
     * Removes the specified key from the set of active keys.
     *
     * @param keyCode the key to be removed from the set of active keys.
     */
    public void removeActiveKey(final KeyCode keyCode) {
        activeKeys.remove(keyCode);
    }

    /**
     * Checks if a specific key is currently active.
     *
     * @param keyCode the key to check for active state.
     * @return true if the key is active, false otherwise.
     */
    public boolean isActive(final KeyCode keyCode) {
        return activeKeys.contains(keyCode);
    }

    /**
     * Checks if a specific key was just pressed in the current frame.
     *
     * @param keyCode the key to check for just-pressed state
     * @return true if the key was just pressed, false otherwise
     */
    public boolean isJustPressed(final KeyCode keyCode) {
        return justPressedKeys.contains(keyCode);
    }

    /**
     * Clears the set of just-pressed keys.
     * This should be called at the end of each frame to reset the
     * just-pressed state.
     */
    public void clearJustPressedKeys() {
        justPressedKeys.clear();
    }
}
