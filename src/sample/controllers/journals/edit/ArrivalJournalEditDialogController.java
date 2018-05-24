package sample.controllers.journals.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.journals.ArrivalJournal;

public class ArrivalJournalEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField measureField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField amountField;
    @FXML
    private TextField notesField;

    private Stage dialogStage;
    private ArrivalJournal arrivalJournal;
    private boolean okClicked = false;

    public ArrivalJournalEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setArrivalJournal(ArrivalJournal arrivalJournal) {
        this.arrivalJournal = arrivalJournal;
        numberField.setText(arrivalJournal.getNumber());
        dateField.setText(arrivalJournal.getDate());
        measureField.setText(arrivalJournal.getMeasure());
        nameField.setText(arrivalJournal.getName());
        amountField.setText(arrivalJournal.getAmount());
        notesField.setText(arrivalJournal.getNotes());
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
        arrivalJournal.setNumber(numberField.getText());
        arrivalJournal.setDate(dateField.getText());
        arrivalJournal.setMeasure(measureField.getText());
        arrivalJournal.setName(nameField.getText());
        arrivalJournal.setAmount(amountField.getText());
        arrivalJournal.setNotes(notesField.getText());

        okClicked = true;
        dialogStage.close();
    }

}
