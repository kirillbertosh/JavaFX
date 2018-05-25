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
import sample.controllers.reports.edit.ProductBalanceReportEditDialogController;
import sample.models.reports.ProductBalanceReport;

public class ProductBalanceReportViewController {

    @FXML
    private TableView<ProductBalanceReport> productBalanceReportTable;
    @FXML
    private TableColumn<ProductBalanceReport, String> numberColumn;
    @FXML
    private TableColumn<ProductBalanceReport, String> nameColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label measureLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label storageLabel;
    @FXML
    private Label notesLabel;

    private Stage primaryStage;

    private ObservableList<ProductBalanceReport> productBalanceReportData = FXCollections.observableArrayList();

    public ProductBalanceReportViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showProductBalanceReportDetails(null);

        productBalanceReportTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showProductBalanceReportDetails(newValue));
        productBalanceReportTable.setItems(productBalanceReportData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showProductBalanceReportDetails(ProductBalanceReport productBalanceReport) {
        if (productBalanceReport == null) {
            numberLabel.setText("");
            nameLabel.setText("");
            measureLabel.setText("");
            amountLabel.setText("");
            storageLabel.setText("");
            notesLabel.setText("");
        } else {
            numberLabel.setText(productBalanceReport.getNumber());
            nameLabel.setText(productBalanceReport.getName());
            measureLabel.setText(productBalanceReport.getMeasure());
            amountLabel.setText(productBalanceReport.getAmountInStorage());
            storageLabel.setText(productBalanceReport.getStorage());
            notesLabel.setText(productBalanceReport.getNotes());
        }
    }

    @FXML
    public boolean showEditDialog(ProductBalanceReport productBalanceReport) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/reports/edit/productBalanceReportEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать динамику расхода ТМЦ");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        ProductBalanceReportEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setProductBalanceReport(productBalanceReport);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewProductBalanceReport() throws Exception {
        ProductBalanceReport productBalanceReport = new ProductBalanceReport();
        boolean okClicked = showEditDialog(productBalanceReport);
        if (okClicked) {
            productBalanceReportData.add(productBalanceReport);
        }
    }

    @FXML
    public void handleEditProductBalanceReport() throws Exception {
        ProductBalanceReport selectedProductBalanceReport =
                productBalanceReportTable.
                        getSelectionModel().
                        getSelectedItem();
        if (selectedProductBalanceReport != null) {
            boolean okClicked = showEditDialog(selectedProductBalanceReport);
            if (okClicked) {
                showProductBalanceReportDetails(selectedProductBalanceReport);
            }
        } else {
            showAlert();
        }
    }

    @FXML
    public void handleDeleteProductBalanceReport() {
        int selectedIndex = productBalanceReportTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            productBalanceReportTable.getItems().remove(selectedIndex);
        } else {
            showAlert();
        }
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(primaryStage);
        alert.setTitle("Ничего не выбранно");
        alert.setHeaderText("Не выбран отчет остатка ТМЦ");
        alert.setContentText("Пожалуйста, выберите отчет остатка ТМЦ из таблицы");

        alert.showAndWait();
    }
}
