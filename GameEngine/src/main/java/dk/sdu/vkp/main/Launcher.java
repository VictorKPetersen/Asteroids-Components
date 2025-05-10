package dk.sdu.vkp.main;

import javafx.application.Application;

public final class Launcher {
    private Launcher() {}

    /**
     * The main method serves as the entry point for the application.
     * It launches the application defined in {@link Game}.
     *
     * @param args command-line arguments
     *            passed to the application during execution
     */
    public static void main(final String[] args) {
        System.out.println("Application started");
        Application.launch(Game.class);

    }
}
