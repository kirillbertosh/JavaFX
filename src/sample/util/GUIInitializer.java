package sample.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Main;
import sample.controllers.MainMenuLayoutController;
import sample.controllers.invoices.InvoicesRootLayoutController;

public class GUIInitializer {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private BorderPane mainMenuLayout;
    private BorderPane invoicesLayout;
    private MainMenuLayoutController mainMenuLayoutController;
    private InvoicesRootLayoutController invoicesRootLayoutController;

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

        mainMenuLayoutController = loader.getController();
        mainMenuLayoutController.setMainMenuLayout(mainMenuLayout);
    }

    public void showInvoiceLayout() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/invoicesRootLayout.fxml"));
        invoicesLayout = (BorderPane) loader.load();

        mainMenuLayout.setCenter(invoicesLayout);
        invoicesRootLayoutController = loader.getController();
        invoicesRootLayoutController.setInvoicesLayout(invoicesLayout);
    }

    public void showJournalLayout() throws Exception {

    }

    public void showReportLayout() throws Exception {

    }

    public void showDirectoryLayout() throws Exception {

    }
}
