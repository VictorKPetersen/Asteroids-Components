package dk.sdu.vkp.main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class Launcher extends Application {
    private AnnotationConfigApplicationContext context;

    /**
     * The main method serves as the entry point for the application.
     * It launches the Bean configuration for a {@link Game}.
     *
     * @param args command-line arguments
     *            passed to the application during execution
     */
    public static void main(final String[] args) {
        launch(Launcher.class);
    }

    @Override
    public void init() throws Exception {
        context = new AnnotationConfigApplicationContext(ModuleConfig.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        Game game = context.getBean(Game.class);
        game.start(stage);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        context.close();
    }
}
