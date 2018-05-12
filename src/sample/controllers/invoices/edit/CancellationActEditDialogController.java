package sample.controllers.invoices.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.invoices.CancellationAct;

public class CancellationActEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField actDateField;
    @FXML
    private TextField inputDateField;
    @FXML
    private TextField cancellationDateField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField measureField;
    @FXML
    private TextField amountField;
    @FXML
    private TextField notesField;

    private Stage dialogStage;
    private CancellationAct cancellationAct;
    private boolean okClicked = false;

    public CancellationActEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setCancellationAct(CancellationAct cancellationAct) {
        this.cancellationAct = cancellationAct;
        numberField.setText(cancellationAct.getNumber());
        actDateField.setText(cancellationAct.getActDate());
        inputDateField.setText(cancellationAct.getInputDate());
        cancellationDateField.setText(cancellationAct.getCancellationDate());
        nameField.setText(cancellationAct.getName());
        measureField.setText(cancellationAct.getMeasure());
        amountField.setText(cancellationAct.getAmount());
        notesField.setText(cancellationAct.getNotes());
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
        cancellationAct.setNumber(numberField.getText());
        cancellationAct.setActDate(actDateField.getText());
        cancellationAct.setInputDate(inputDateField.getText());
        cancellationAct.setCancellationDate(cancellationDateField.getText());
        cancellationAct.setName(nameField.getText());
        cancellationAct.setMeasure(measureField.getText());
        cancellationAct.setAmount(amountField.getText());
        cancellationAct.setNotes(notesField.getText());

        okClicked = true;
        dialogStage.close();
    }
}
