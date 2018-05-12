package sample.controllers.invoices;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Main;

public class InvoicesRootLayoutController {

    private BorderPane invoicesLayout;
    private Stage primaryStage;

    public InvoicesRootLayoutController() {

    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    public void initialize() {
    }

    @FXML
    public void showSalesInvoices() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/salesInvoiceView.fxml"));
        AnchorPane salesInvoices = (AnchorPane) loader.load();

        invoicesLayout.setCenter(salesInvoices);
        SalesInvoiceViewController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
    }

    @FXML
    public void showCancellationActs() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/cancellationActView.fxml"));
        AnchorPane salesInvoices = (AnchorPane) loader.load();

        invoicesLayout.setCenter(salesInvoices);
        CancellationActViewController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
    }

    @FXML
    public void showComingInvoices() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/comingInvoiceView.fxml"));
        AnchorPane salesInvoices = (AnchorPane) loader.load();

        invoicesLayout.setCenter(salesInvoices);
        ComingInvoiceViewController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
    }

    public void setInvoicesLayout(BorderPane invoicesLayout) {
        this.invoicesLayout = invoicesLayout;
    }
}
