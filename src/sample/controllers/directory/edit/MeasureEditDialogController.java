package sample.controllers.directory.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.directory.Measure;

public class MeasureEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField abbreviationField;

    private Stage dialogStage;
    private Measure measure;
    private boolean okClicked = false;

    public MeasureEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
        nameField.setText(measure.getName());
        abbreviationField.setText(measure.getAbbreviation());
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    public void okClicked() {
        measure.setName(nameField.getText());
        measure.setAbbreviation(abbreviationField.getText());

        okClicked = true;
        dialogStage.close();
    }

    @FXML
    public void handleCancel() {
        dialogStage.close();
    }
}
