package sample.controllers.reports.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.reports.ExpenditureDynamicReport;

public class ExpenditureDynamicReportEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField measureField;
    @FXML
    private TextField startBalanceField;
    @FXML
    private TextField arrivedField;
    @FXML
    private TextField departedField;
    @FXML
    private TextField monthField;
    @FXML
    private TextField endBalanceField;

    private Stage dialogStage;
    private ExpenditureDynamicReport expenditureDynamicReport;
    private boolean okClicked = false;

    public ExpenditureDynamicReportEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setExpenditureDynamicReport(ExpenditureDynamicReport expenditureDynamicReport) {
        this.expenditureDynamicReport = expenditureDynamicReport;
        numberField.setText(expenditureDynamicReport.getNumber());
        measureField.setText(expenditureDynamicReport.getMeasure());
        nameField.setText(expenditureDynamicReport.getName());
        startBalanceField.setText(expenditureDynamicReport.getStartMonthBalance());
        arrivedField.setText(expenditureDynamicReport.getArrivedDuringMonth());
        departedField.setText(expenditureDynamicReport.getDepartedDuringMonth());
        monthField.setText(expenditureDynamicReport.getMonth());
        endBalanceField.setText(expenditureDynamicReport.getEndMonthBalance());
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
        expenditureDynamicReport.setNumber(numberField.getText());
        expenditureDynamicReport.setMeasure(measureField.getText());
        expenditureDynamicReport.setName(nameField.getText());
        expenditureDynamicReport.setStartMonthBalance(startBalanceField.getText());
        expenditureDynamicReport.setArrivedDuringMonth(arrivedField.getText());
        expenditureDynamicReport.setDepartedDuringMonth(departedField.getText());
        expenditureDynamicReport.setMonth(monthField.getText());
        expenditureDynamicReport.setEndMonthBalance(endBalanceField.getText());

        okClicked = true;
        dialogStage.close();
    }
}
