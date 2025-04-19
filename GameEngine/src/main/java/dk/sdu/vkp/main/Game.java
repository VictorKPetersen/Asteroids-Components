package dk.sdu.vkp.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {
    @Override
    public void start(final Stage stage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        Canvas canvas = new Canvas(1920, 1080);
        pane.getChildren().add(canvas);

        stage.setTitle("Asteroids");
        stage.setScene(scene);

        stage.show();
    }
}
