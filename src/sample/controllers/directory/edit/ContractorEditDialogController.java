package sample.controllers.directory.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.directory.Contractor;

public class ContractorEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;

    private Stage dialogStage;
    private Contractor contractor;
    private boolean okClicked = false;

    public ContractorEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
        numberField.setText(contractor.getNumber());
        nameField.setText(contractor.getName());
        phoneField.setText(contractor.getPhone());
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
        contractor.setNumber(numberField.getText());
        contractor.setName(nameField.getText());
        contractor.setPhone(phoneField.getText());

        okClicked = true;
        dialogStage.close();
    }
}
