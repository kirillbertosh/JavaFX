package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.controllers.invoices.InvoicesRootLayoutController;
import sample.util.GUIInitializer;

public class Main extends Application {
    private GUIInitializer initializer;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private BorderPane mainMenuLayout;
    private BorderPane invoicesLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        initializer = new GUIInitializer(primaryStage);
        this.primaryStage = primaryStage;
        initializer.initialize();
        //initializer.showInvoiceLayout();
        //initSalesInvoices();
    }

    public BorderPane getInvoicesLayout() {
        return invoicesLayout;
    }

    public void showReport() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/report.fxml"));
        AnchorPane reportOverview = (AnchorPane) loader.load();

        rootLayout.setCenter(reportOverview);
    }

    public void initSalesInvoices() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/salesInvoiceView.fxml"));
        AnchorPane reportOverview = (AnchorPane) loader.load();

        invoicesLayout.setCenter(reportOverview);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
