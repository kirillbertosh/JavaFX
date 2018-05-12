package sample.controllers.invoices;

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
import sample.controllers.invoices.edit.SalesInvoiceEditDialogController;
import sample.models.invoices.SalesInvoice;

public class SalesInvoiceViewController {

    @FXML
    private TableView<SalesInvoice> salesInvoiceTable;
    @FXML
    private TableColumn<SalesInvoice, String> numberColumn;
    @FXML
    private TableColumn<SalesInvoice, String> dateColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label measureLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label priceWithoutDiscountLabel;
    @FXML
    private Label discountLabel;
    @FXML
    private Label addedValueTaxLabel;
    @FXML
    private Label addedSumValueTaxLabel;
    @FXML
    private Label totalPriceLabel;

    private Stage primaryStage;

    private ObservableList<SalesInvoice> salesInvoiceData = FXCollections.observableArrayList();

    public SalesInvoiceViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showSalesInvoiceDetails(null);

        salesInvoiceTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSalesInvoiceDetails(newValue));
        salesInvoiceTable.setItems(salesInvoiceData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showSalesInvoiceDetails(SalesInvoice salesInvoice) {
        if (salesInvoice != null) {
            numberLabel.setText(salesInvoice.getNumber());
            dateLabel.setText(salesInvoice.getDate());
            nameLabel.setText(salesInvoice.getName());
            measureLabel.setText(salesInvoice.getMeasure());
            amountLabel.setText(salesInvoice.getAmount());
            priceWithoutDiscountLabel.setText(salesInvoice.getPriceWithoutDiscount());
            discountLabel.setText(salesInvoice.getDiscount());
            addedValueTaxLabel.setText(salesInvoice.getAddedValueTax());
            addedSumValueTaxLabel.setText(salesInvoice.getSumAddedValueTax());
            totalPriceLabel.setText(salesInvoice.getTotalPrice());
        } else {
            numberLabel.setText("");
            dateLabel.setText("");
            nameLabel.setText("");
            measureLabel.setText("");
            amountLabel.setText("");
            priceWithoutDiscountLabel.setText("");
            discountLabel.setText("");
            addedValueTaxLabel.setText("");
            addedSumValueTaxLabel.setText("");
            totalPriceLabel.setText("");
        }
    }

    @FXML
    public boolean showEditDialog(SalesInvoice salesInvoice) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/edit/salesInvoiceEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать приемную накладную");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        SalesInvoiceEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setSalesInvoice(salesInvoice);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewSalesInvoice() throws Exception {
        SalesInvoice salesInvoice = new SalesInvoice();
        boolean okClicked = showEditDialog(salesInvoice);
        if (okClicked) {
            salesInvoiceData.add(salesInvoice);
        }
    }

    @FXML
    public void handleEditSalesInvoice() throws Exception {
        SalesInvoice selectedSalesInvoice = salesInvoiceTable.getSelectionModel().getSelectedItem();
        if (selectedSalesInvoice != null) {
            boolean okClicked = showEditDialog(selectedSalesInvoice);
            if (okClicked) {
                showSalesInvoiceDetails(selectedSalesInvoice);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбрана расходная накладная");
            alert.setContentText("Пожалуйста, выберите расходную накладную из таблицы");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleDeleteSalesInvoice() {
        int selectedIndex = salesInvoiceTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            salesInvoiceTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбрана расходная накладная");
            alert.setContentText("Пожалуйста, выберите расходную накладную из таблицы");

            alert.showAndWait();
        }
    }
}
