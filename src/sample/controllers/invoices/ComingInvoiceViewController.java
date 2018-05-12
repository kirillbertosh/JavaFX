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
import sample.controllers.invoices.edit.ComingInvoiceEditDialogController;
import sample.models.invoices.ComingInvoice;

public class ComingInvoiceViewController {

    @FXML
    private TableView<ComingInvoice> comingInvoiceTable;
    @FXML
    private TableColumn<ComingInvoice, String> numberColumn;
    @FXML
    private TableColumn<ComingInvoice, String> dateColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label contractorLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label measureLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label withoutDiscountPriceLabel;
    @FXML
    private Label discountLabel;
    @FXML
    private Label addedValueTaxLabel;
    @FXML
    private Label addedValueTaxSumLabel;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private Label storageNumberLabel;

    private Stage primaryStage;

    private ObservableList<ComingInvoice> comingInvoiceData = FXCollections.observableArrayList();

    public ComingInvoiceViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showComingInvoiceDetails(null);

        comingInvoiceTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showComingInvoiceDetails(newValue));
        comingInvoiceTable.setItems(comingInvoiceData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showComingInvoiceDetails(ComingInvoice comingInvoice) {
        if (comingInvoice != null) {
            numberLabel.setText(comingInvoice.getNumber());
            dateLabel.setText(comingInvoice.getDate());
            contractorLabel.setText(comingInvoice.getContractor());
            nameLabel.setText(comingInvoice.getName());
            measureLabel.setText(comingInvoice.getMeasure());
            amountLabel.setText(comingInvoice.getAmount());
            withoutDiscountPriceLabel.setText(comingInvoice.getWithoutDiscountPrice());
            discountLabel.setText(comingInvoice.getDiscount());
            addedValueTaxLabel.setText(comingInvoice.getAddedValueTax());
            addedValueTaxSumLabel.setText(comingInvoice.getAddedValueTaxSum());
            totalPriceLabel.setText(comingInvoice.getTotalPrice());
            storageNumberLabel.setText(comingInvoice.getTotalPrice());
        } else {
            numberLabel.setText("");
            dateLabel.setText("");
            contractorLabel.setText("");
            nameLabel.setText("");
            measureLabel.setText("");
            amountLabel.setText("");
            withoutDiscountPriceLabel.setText("");
            discountLabel.setText("");
            addedValueTaxLabel.setText("");
            addedValueTaxSumLabel.setText("");
            totalPriceLabel.setText("");
            storageNumberLabel.setText("");
        }
    }

    @FXML
    public boolean showEditDialog(ComingInvoice comingInvoice) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/edit/comingInvoiceEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать приемную накладную");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        ComingInvoiceEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setComingInvoice(comingInvoice);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewComingInvoice() throws Exception {
        ComingInvoice comingInvoice = new ComingInvoice();
        boolean okClicked = showEditDialog(comingInvoice);
        if (okClicked) {
            comingInvoiceData.add(comingInvoice);
        }
    }

    @FXML
    public void handleEditComingInvoice() throws Exception {
        ComingInvoice selectedComingInvoice = comingInvoiceTable.getSelectionModel().getSelectedItem();
        if (selectedComingInvoice != null) {
            boolean okClicked = showEditDialog(selectedComingInvoice);
            if (okClicked) {
                showComingInvoiceDetails(selectedComingInvoice);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбрана приемная накладная");
            alert.setContentText("Пожалуйста, выберите приемную накладную из таблицы");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleDeleteComingInvoice() {
        int selectedIndex = comingInvoiceTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            comingInvoiceTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбрана приемная накладная");
            alert.setContentText("Пожалуйста, выберите приемную накладную из таблицы");

            alert.showAndWait();
        }
    }
}
