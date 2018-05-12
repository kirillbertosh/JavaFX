package sample.controllers.invoices.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.invoices.SalesInvoice;

public class SalesInvoiceEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField dateField;
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

    private Stage dialogStage;
    private SalesInvoice salesInvoice;
    private boolean okClicked = false;

    public SalesInvoiceEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public void setSalesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
        numberField.setText(salesInvoice.getNumber());
        dateField.setText(salesInvoice.getDate());
        nameField.setText(salesInvoice.getName());
        measureField.setText(salesInvoice.getMeasure());
        amountField.setText(salesInvoice.getAmount());
        withoutDiscountPriceField.setText(salesInvoice.getPriceWithoutDiscount());
        discountField.setText(salesInvoice.getDiscount());
        addedValueTaxField.setText(salesInvoice.getAddedValueTax());
        addedValueTaxSumField.setText(salesInvoice.getSumAddedValueTax());
        totalPriceField.setText(salesInvoice.getTotalPrice());
    }

    @FXML
    public void handleCancel() {
        dialogStage.close();
    }

    @FXML
    public void okClicked() {
        salesInvoice.setNumber(numberField.getText());
        salesInvoice.setDate(dateField.getText());
        salesInvoice.setName(nameField.getText());
        salesInvoice.setMeasure(measureField.getText());
        salesInvoice.setAmount(amountField.getText());
        salesInvoice.setPriceWithoutDiscount(withoutDiscountPriceField.getText());
        salesInvoice.setDiscount(discountField.getText());
        salesInvoice.setAddedValueTax(addedValueTaxField.getText());
        salesInvoice.setSumAddedValueTax(addedValueTaxSumField.getText());
        salesInvoice.setTotalPrice(totalPriceField.getText());

        okClicked = true;
        dialogStage.close();
    }
}
