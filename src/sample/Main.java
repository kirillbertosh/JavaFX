package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.util.GUIInitializer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GUIInitializer initializer = new GUIInitializer(primaryStage);
        initializer.initialize();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
