package dk.sdu.vkp.main;

import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.data.GameEntities;
import dk.sdu.vkp.common.data.GameKeys;
import dk.sdu.vkp.common.map.Map;
import dk.sdu.vkp.common.services.CollisionProcessingService;
import dk.sdu.vkp.common.services.DrawingService;
import dk.sdu.vkp.common.services.PluginStarterService;
import dk.sdu.vkp.common.services.ProcessingService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Game {
    private final static int WINDOW_WIDTH = 1920;
    private final static int WINDOW_HEIGHT = 1080;
    private Image image;

    private List<PluginStarterService> pluginStarterServices;
    private List<ProcessingService> processingServices;
    private List<DrawingService> drawingServices;
    private CollisionProcessingService collisionProcessingService;
    private Map mapService;
    private RestTemplate restTemplate;

    public void start(final Stage stage) {
        image = new Image("BlueNebulaBackground.png");

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
        scene.setOnKeyPressed(event -> gameKeys.addActiveKey(event.getCode()));
        scene.setOnKeyReleased(event -> gameKeys.removeActiveKey(event.getCode()));
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
                actionEvent -> {
                    update(gameData);
                    draw(gameData, graphicsContext);
                }
        );

        gameLoop.getKeyFrames().add(keyFrame);
        gameLoop.play();
    }

    /**
     * Starts all the plugin services.
     * @param gameData  The {@link GameData} to act upon.
     */
    private void startPluginServices(final GameData gameData) {
        for (PluginStarterService plugin : pluginStarterServices) {
            plugin.start(gameData);
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
        for (ProcessingService processingService : processingServices) {
            processingService.process(gameData);
        }

        if (collisionProcessingService != null) {
            collisionProcessingService.processCollisions(gameData);
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
        graphicsContext.fillText("Score: " +
                getScoreFromMicroService("http://localhost:8080/retrieve"),
                20, 40);
    }

    private int getScoreFromMicroService(String url) {
        try {
            String resp = restTemplate.getForObject(url, String.class);
            return Integer.parseInt(resp);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Calls all the processing services.
     * Also calls the draw for the map, if it is not null.
     * @param graphicsContext The {@link GraphicsContext}
     *                       which is used for rendering.
     * @param gameData The {@link GameData} used as common data point.
     */
    private void callDrawingServices(final GameData gameData,
                                     final GraphicsContext graphicsContext) {
        if (mapService != null) {
            mapService.renderBg(
                    graphicsContext,
                    image,
                    gameData.getWindowWidth(),
                    gameData.getWindowHeight()
            );
        }

        for (DrawingService drawingService : drawingServices) {
            drawingService.draw(graphicsContext, gameData);
        }
    }

    public void setPluginStarterServices(
            final List<PluginStarterService> pluginStarterServices) {
        this.pluginStarterServices = pluginStarterServices;
    }

    public void setProcessingServices(
            final List<ProcessingService> processingServices) {
        this.processingServices = processingServices;
    }

    public void setDrawingServices(
            final List<DrawingService> drawingServices) {
        this.drawingServices = drawingServices;
    }

    public void setCollisionProcessingService(
            final CollisionProcessingService collisionProcessingService) {
        this.collisionProcessingService = collisionProcessingService;
    }

    public void setMapService(
            final Map mapService) {
        this.mapService = mapService;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
