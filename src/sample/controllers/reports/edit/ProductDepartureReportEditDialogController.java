package sample.controllers.reports.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.reports.ProductDepartureReport;

public class ProductDepartureReportEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField measureField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField amountField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField totalField;
    @FXML
    private TextField notesField;

    private Stage dialogStage;
    private ProductDepartureReport productDepartureReport;
    private boolean okClicked = false;

    public ProductDepartureReportEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setProductDepartureReport(ProductDepartureReport productDepartureReport) {
        this.productDepartureReport = productDepartureReport;
        numberField.setText(productDepartureReport.getNumber());
        measureField.setText(productDepartureReport.getMeasure());
        nameField.setText(productDepartureReport.getName());
        amountField.setText(productDepartureReport.getAmount());
        notesField.setText(productDepartureReport.getNotes());
        priceField.setText(productDepartureReport.getPrice());
        dateField.setText(productDepartureReport.getDate());
        totalField.setText(productDepartureReport.getTotal());
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
        productDepartureReport.setNumber(numberField.getText());
        productDepartureReport.setMeasure(measureField.getText());
        productDepartureReport.setName(nameField.getText());
        productDepartureReport.setAmount(amountField.getText());
        productDepartureReport.setNotes(notesField.getText());
        productDepartureReport.setPrice(priceField.getText());
        productDepartureReport.setDate(dateField.getText());
        productDepartureReport.setTotal(totalField.getText());

        okClicked = true;
        dialogStage.close();
    }
}
