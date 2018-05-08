package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        initRootLayout();
        showReport();
    }

    public void showReport() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/report.fxml"));
        AnchorPane reportOverview = (AnchorPane) loader.load();

        rootLayout.setCenter(reportOverview);
    }

    public void initLoginLayout() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/login.fxml"));
        this.primaryStage.setTitle("Hello World");
        this.primaryStage.setScene(new Scene(root, 300, 275));
        this.primaryStage.show();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
