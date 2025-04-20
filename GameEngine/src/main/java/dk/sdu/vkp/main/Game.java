package dk.sdu.vkp.main;

import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.data.GameEntities;
import dk.sdu.vkp.common.data.GameKeys;
import dk.sdu.vkp.common.services.CollisionProcessingService;
import dk.sdu.vkp.common.services.DrawingService;
import dk.sdu.vkp.common.services.PluginStarterService;
import dk.sdu.vkp.common.services.ProcessingService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ServiceLoader;

public class Game extends Application {
    private final static int WINDOW_WIDTH = 1920;
    private final static int WINDOW_HEIGHT = 1080;
    @Override
    public void start(final Stage stage) {
        GameData gameData = new GameData(
                new GameKeys(),
                new GameEntities()
        );
        setupOptions(gameData, stage);

        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        Canvas canvas = new Canvas(
                gameData.getWindowWidth(), gameData.getWindowHeight());
        pane.getChildren().add(canvas);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        stage.setScene(scene);

        setupKeyHandlers(scene, gameData.getKeys());
        startGameLoop(gameData, graphicsContext);
        stage.show();
    }

    /**
     * Sets up the game options.
     * @param gameData  Instance to store options in.
     * @param stage Instance to set title of game on.
     */
    private void setupOptions(final GameData gameData, final Stage stage) {
        stage.setTitle("Asteroids");

        gameData.setWindowWidth(WINDOW_WIDTH);
        gameData.setWindowHeight(WINDOW_HEIGHT);
    }

    /**
     * Sets up key handlers for the game.
     * @param scene The {@link Scene} where Key events should be registered.
     * @param gameKeys The {@link GameKeys} which handles key events.
     */
    private void setupKeyHandlers(final Scene scene, final GameKeys gameKeys) {
        scene.setOnKeyPressed(event -> {
            gameKeys.addActiveKey(event.getCode());
        });
        scene.setOnKeyReleased(event -> {
            gameKeys.removeActiveKey(event.getCode());
        });
    }

    /**
     * Starts the main game loop which updates
     * and renders the game at a fixed frame rate.
     * The game loop uses a {@link Timeline}
     * for continuous execution and runs indefinitely.
     *
     * @param graphicsContext The {@link GraphicsContext}
     *                       used for rendering game objects.
     * @param gameData The {@link GameData} used as common data point.
     */
    private void startGameLoop(final GameData gameData,
                               final GraphicsContext graphicsContext) {
        startPluginServices(gameData);
        Timeline gameLoop = new Timeline();
        // Runs forever
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame keyFrame = new KeyFrame(
                Duration.millis(1000 / 60f),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent actionEvent) {
                        update(gameData);
                        draw(gameData, graphicsContext);
                    }
                }
        );

        gameLoop.getKeyFrames().add(keyFrame);
        gameLoop.play();
    }

    /**
     * Starts all the plugin services.
     * Loads the services using the {@link ServiceLoader}.
     * @param gameData  The {@link GameData} to act upon.
     */
    private void startPluginServices(final GameData gameData) {
        for (PluginStarterService pluginStarterService
                : ServiceLoader.load(PluginStarterService.class)) {
            pluginStarterService.start(gameData);
        }
    }

    /**
     * Updates the game states, is run before drawing occurs.
     * @param gameData The {@link GameData} used as common data point.
     */
    private void update(final GameData gameData) {
        callProcessingServices(gameData);

        // Flush the justPressedKeys
        gameData.getKeys().clearJustPressedKeys();
    }

    /**
     * Calls all the processing services.
     * @param gameData  The {@link GameData} which contains entity information.
     */
    private void callProcessingServices(final GameData gameData) {
        for (ProcessingService processingService
                : ServiceLoader.load(ProcessingService.class)) {
            processingService.process(gameData);
        }

        for (CollisionProcessingService collisionService
                : ServiceLoader.load(CollisionProcessingService.class)) {
            collisionService.processCollisions(gameData);
        }
    }

    /**
     * Draws, the game states, is run after updating occurs.
     * @param graphicsContext The {@link GraphicsContext} used for rendering.
     * @param gameData The {@link GameData} used as common data point.
     */
    private void draw(final GameData gameData,
                      final GraphicsContext graphicsContext) {
        // Clears the canvas.
        graphicsContext.clearRect(0, 0,
                gameData.getWindowWidth() , gameData.getWindowWidth());
        callDrawingServices(gameData, graphicsContext);

        graphicsContext.setFill(Color.GOLD); // or whatever color works
        graphicsContext.setFont(new Font("Arial", 24));
        graphicsContext.fillText("Score: " + gameData.getGameScore(), 20, 40);
    }

    /**
     * Calls all the processing services.
     * @param graphicsContext The {@link GraphicsContext}
     *                       which is used for rendering.
     * @param gameData The {@link GameData} used as common data point.
     */
    private void callDrawingServices(final GameData gameData,
                                     final GraphicsContext graphicsContext) {
        for (DrawingService drawingService
                : ServiceLoader.load(DrawingService.class)) {
            drawingService.draw(graphicsContext, gameData);
        }
    }
}
