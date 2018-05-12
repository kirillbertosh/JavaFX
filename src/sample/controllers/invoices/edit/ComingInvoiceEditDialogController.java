package sample.controllers.invoices.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.invoices.ComingInvoice;

public class ComingInvoiceEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField contractorField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField measureField;
    @FXML
    private TextField amountField;
    @FXML
    private TextField withoutDiscountPriceField;
    @FXML
    private TextField discountField;
    @FXML
    private TextField addedValueTaxField;
    @FXML
    private TextField addedValueTaxSumField;
    @FXML
    private TextField totalPriceField;
    @FXML
    private TextField storageNumberField;

    private Stage dialogStage;
    private ComingInvoice comingInvoice;
    private boolean okClicked = false;

    public ComingInvoiceEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setComingInvoice(ComingInvoice comingInvoice) {
        this.comingInvoice = comingInvoice;
        numberField.setText(comingInvoice.getNumber());
        dateField.setText(comingInvoice.getDate());
        contractorField.setText(comingInvoice.getContractor());
        nameField.setText(comingInvoice.getName());
        measureField.setText(comingInvoice.getMeasure());
        amountField.setText(comingInvoice.getAmount());
        withoutDiscountPriceField.setText(comingInvoice.getWithoutDiscountPrice());
        discountField.setText(comingInvoice.getDiscount());
        addedValueTaxField.setText(comingInvoice.getAddedValueTax());
        addedValueTaxSumField.setText(comingInvoice.getAddedValueTaxSum());
        totalPriceField.setText(comingInvoice.getTotalPrice());
        storageNumberField.setText(comingInvoice.getStorageNumber());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    public void handleCancel() {
        dialogStage.close();
    }

    @FXML
    public void okClicked() {
        comingInvoice.setNumber(numberField.getText());
        comingInvoice.setDate(dateField.getText());
        comingInvoice.setContractor(contractorField.getText());
        comingInvoice.setName(nameField.getText());
        comingInvoice.setMeasure(measureField.getText());
        comingInvoice.setAmount(amountField.getText());
        comingInvoice.setWithoutDiscountPrice(withoutDiscountPriceField.getText());
        comingInvoice.setDiscount(discountField.getText());
        comingInvoice.setAddedValueTax(addedValueTaxField.getText());
        comingInvoice.setAddedValueTaxSum(addedValueTaxSumField.getText());
        comingInvoice.setTotalPrice(totalPriceField.getText());
        comingInvoice.setStorageNumber(storageNumberField.getText());

        okClicked = true;
        dialogStage.close();
    }
}
