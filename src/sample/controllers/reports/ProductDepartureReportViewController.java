package sample.controllers.reports;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;
import sample.controllers.reports.edit.ProductDepartureReportEditDialogController;
import sample.models.reports.ProductDepartureReport;

public class ProductDepartureReportViewController {

    @FXML
    private TableView<ProductDepartureReport> productDepartureReportTable;
    @FXML
    private TableColumn<ProductDepartureReport, String> numberColumn;
    @FXML
    private TableColumn<ProductDepartureReport, String> nameColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label measureLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label totalLabel;
    @FXML
    private Label notesLabel;

    private Stage primaryStage;

    private ObservableList<ProductDepartureReport> productDepartureReportData = FXCollections.observableArrayList();

    public ProductDepartureReportViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showProductDepartureReportDetails(null);

        productDepartureReportTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showProductDepartureReportDetails(newValue));
        productDepartureReportTable.setItems(productDepartureReportData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showProductDepartureReportDetails(ProductDepartureReport productDepartureReport) {
        if (productDepartureReport == null) {
            numberLabel.setText("");
            nameLabel.setText("");
            measureLabel.setText("");
            priceLabel.setText("");
            amountLabel.setText("");
            dateLabel.setText("");
            totalLabel.setText("");
            notesLabel.setText("");
        } else {
            numberLabel.setText(productDepartureReport.getNumber());
            nameLabel.setText(productDepartureReport.getName());
            measureLabel.setText(productDepartureReport.getMeasure());
            priceLabel.setText(productDepartureReport.getPrice());
            amountLabel.setText(productDepartureReport.getAmount());
            dateLabel.setText(productDepartureReport.getDate());
            totalLabel.setText(productDepartureReport.getTotal());
            notesLabel.setText(productDepartureReport.getNotes());
        }
    }

    @FXML
    public boolean showEditDialog(ProductDepartureReport productDepartureReport) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/reports/edit/productDepartureReportEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать динамику расхода ТМЦ");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        ProductDepartureReportEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setProductDepartureReport(productDepartureReport);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewProductDepartureReport() throws Exception {
        ProductDepartureReport productDepartureReport = new ProductDepartureReport();
        boolean okClicked = showEditDialog(productDepartureReport);
        if (okClicked) {
            productDepartureReportData.add(productDepartureReport);
        }
    }

    @FXML
    public void handleEditProductDepartureReport() throws Exception {
        ProductDepartureReport selectedProductDepartureReport =
                productDepartureReportTable.
                        getSelectionModel().
                        getSelectedItem();
        if (selectedProductDepartureReport != null) {
            boolean okClicked = showEditDialog(selectedProductDepartureReport);
            if (okClicked) {
                showProductDepartureReportDetails(selectedProductDepartureReport);
            }
        } else {
            showAlert();
        }
    }

    @FXML
    public void handleDeleteProductDepartureReport() {
        int selectedIndex = productDepartureReportTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            productDepartureReportTable.getItems().remove(selectedIndex);
        } else {
            showAlert();
        }
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(primaryStage);
        alert.setTitle("Ничего не выбранно");
        alert.setHeaderText("Не выбран отчет списания ТМЦ");
        alert.setContentText("Пожалуйста, выберите отчет списания ТМЦ из таблицы");

        alert.showAndWait();
    }
}
