package sample.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Main;
import sample.controllers.MainMenuLayoutController;

public class GUIInitializer {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private BorderPane mainMenuLayout;
    private BorderPane invoicesLayout;

    public GUIInitializer(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initialize() throws Exception {
        initRootLayout();
        initMainMenuLayout();
    }

    public void initLoginLayout() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/login.fxml"));
        this.primaryStage.setTitle("Hello World");
        this.primaryStage.setScene(new Scene(root, 300, 275));
        this.primaryStage.show();
    }

    private void initRootLayout() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/rootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initMainMenuLayout() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/mainMenuLayout.fxml"));
        mainMenuLayout = (BorderPane) loader.load();

        rootLayout.setCenter(mainMenuLayout);

        MainMenuLayoutController mainMenuLayoutController = loader.getController();
        mainMenuLayoutController.setMainMenuLayout(mainMenuLayout);
        mainMenuLayoutController.setPrimaryStage(primaryStage);
    }
}
