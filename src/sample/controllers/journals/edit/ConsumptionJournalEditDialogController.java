package sample.controllers.journals.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.journals.ConsumptionJournal;

public class ConsumptionJournalEditDialogController {

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
    private ConsumptionJournal consumptionJournal;
    private boolean okClicked = false;

    public ConsumptionJournalEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setConsumptionJournal(ConsumptionJournal consumptionJournal) {
        this.consumptionJournal = consumptionJournal;
        numberField.setText(consumptionJournal.getNumber());
        dateField.setText(consumptionJournal.getDate());
        measureField.setText(consumptionJournal.getMeasure());
        nameField.setText(consumptionJournal.getName());
        amountField.setText(consumptionJournal.getAmount());
        notesField.setText(consumptionJournal.getNotes());
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
        consumptionJournal.setNumber(numberField.getText());
        consumptionJournal.setDate(dateField.getText());
        consumptionJournal.setMeasure(measureField.getText());
        consumptionJournal.setName(nameField.getText());
        consumptionJournal.setAmount(amountField.getText());
        consumptionJournal.setNotes(notesField.getText());

        okClicked = true;
        dialogStage.close();
    }
}
