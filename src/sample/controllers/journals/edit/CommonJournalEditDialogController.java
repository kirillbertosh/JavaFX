package sample.controllers.journals.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.journals.ArrivalJournal;
import sample.models.journals.CommonJournal;

public class CommonJournalEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField typeField;
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
    private CommonJournal commonJournal;
    private boolean okClicked = false;

    public CommonJournalEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setCommonJournal(CommonJournal commonJournal) {
        this.commonJournal = commonJournal;
        numberField.setText(commonJournal.getNumber());
        typeField.setText(commonJournal.getType());
        dateField.setText(commonJournal.getDate());
        measureField.setText(commonJournal.getMeasure());
        nameField.setText(commonJournal.getName());
        amountField.setText(commonJournal.getAmount());
        notesField.setText(commonJournal.getNotes());
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
        commonJournal.setNumber(numberField.getText());
        commonJournal.setType(typeField.getTypeSelector());
        commonJournal.setDate(dateField.getText());
        commonJournal.setMeasure(measureField.getText());
        commonJournal.setName(nameField.getText());
        commonJournal.setAmount(amountField.getText());
        commonJournal.setNotes(notesField.getText());

        okClicked = true;
        dialogStage.close();
    }
}
