package sample.controllers.reports;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.Main;

public class ReportsRootLayoutController {

    private BorderPane reportLayout;

    public ReportsRootLayoutController() {

    }

    @FXML
    public void initialize() {

    }

    public void setReportLayout(BorderPane reportLayout) {
        this.reportLayout = reportLayout;
    }

    @FXML
    public void showExpenditureDynamicReport() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/reports/expenditureDynamicReportView.fxml"));
        AnchorPane expenditureDynamicLayout = (AnchorPane) loader.load();

        reportLayout.setCenter(expenditureDynamicLayout);
    }

    @FXML
    public void showProductBalanceReport() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/reports/productBalanceReportView.fxml"));
        AnchorPane productBalanceLayout = (AnchorPane) loader.load();

        reportLayout.setCenter(productBalanceLayout);
    }

    @FXML
    public void showProductDepartureReport() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/reports/productDepartureReportView.fxml"));
        AnchorPane productDepartureLayout = (AnchorPane) loader.load();

        reportLayout.setCenter(productDepartureLayout);
    }
}
