package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import sample.Main;

public class MainMenuLayoutController {

    private BorderPane mainMenuLayout;


    public MainMenuLayoutController() {

    }

    public void setMainMenuLayout(BorderPane mainMenuLayout) {
        this.mainMenuLayout = mainMenuLayout;
    }

    @FXML
    public void initialize() {

    }

    @FXML
    public void showInvoicesMenu() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/invoicesRootLayout.fxml"));
        BorderPane invoicesLayout = (BorderPane) loader.load();

        mainMenuLayout.setCenter(invoicesLayout);
    }

    @FXML
    public void showReportsMenu() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/reports/reportsRootLayout.fxml"));
        BorderPane reportsLayout = (BorderPane) loader.load();

        mainMenuLayout.setCenter(reportsLayout);
    }

    @FXML
    public void showJournalsMenu() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/journals/journalsRootLayout.fxml"));
        BorderPane reportsLayout = (BorderPane) loader.load();

        mainMenuLayout.setCenter(reportsLayout);
    }

    @FXML
    public void showDirectoryMenu() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/directory/directoryRootLayout.fxml"));
        BorderPane reportsLayout = (BorderPane) loader.load();

        mainMenuLayout.setCenter(reportsLayout);
    }
}
