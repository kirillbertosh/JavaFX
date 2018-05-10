package sample.controllers.invoices;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.Main;

public class InvoicesRootLayoutController {

    private BorderPane invoicesLayout;

    public InvoicesRootLayoutController() {

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
    }

    @FXML
    public void showCancellationActs() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/cancellationActView.fxml"));
        AnchorPane salesInvoices = (AnchorPane) loader.load();

        invoicesLayout.setCenter(salesInvoices);
    }

    @FXML
    public void showComingInvoices() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/comingInvoiceView.fxml"));
        AnchorPane salesInvoices = (AnchorPane) loader.load();

        invoicesLayout.setCenter(salesInvoices);
    }

    public void setInvoicesLayout(BorderPane invoicesLayout) {
        this.invoicesLayout = invoicesLayout;
    }
}
