package sample.controllers.reports.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.reports.ProductBalanceReport;

public class ProductBalanceReportEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField measureField;
    @FXML
    private TextField amountField;
    @FXML
    private TextField storageField;
    @FXML
    private TextField notesField;

    private Stage dialogStage;
    private ProductBalanceReport productBalanceReport;
    private boolean okClicked = false;

    public ProductBalanceReportEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setProductBalanceReport(ProductBalanceReport productBalanceReport) {
        this.productBalanceReport = productBalanceReport;
        numberField.setText(productBalanceReport.getNumber());
        measureField.setText(productBalanceReport.getMeasure());
        nameField.setText(productBalanceReport.getName());
        amountField.setText(productBalanceReport.getAmountInStorage());
        storageField.setText(productBalanceReport.getStorage());
        notesField.setText(productBalanceReport.getNotes());
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
        productBalanceReport.setNumber(numberField.getText());
        productBalanceReport.setMeasure(measureField.getText());
        productBalanceReport.setName(nameField.getText());
        productBalanceReport.setAmountInStorage(amountField.getText());
        productBalanceReport.setStorage(storageField.getText());
        productBalanceReport.setNotes(notesField.getText());

        okClicked = true;
        dialogStage.close();
    }
}
