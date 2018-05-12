package sample.controllers.directory.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.directory.Storage;

public class StorageEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;

    private Stage dialogStage;
    private Storage storage;
    private boolean okClicked = false;

    public StorageEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
        numberField.setText(storage.getNumber());
        nameField.setText(storage.getName());
        addressField.setText(storage.getAddress());
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
        storage.setNumber(numberField.getText());
        storage.setName(nameField.getText());
        storage.setAddress(addressField.getText());

        okClicked = true;
        dialogStage.close();
    }
}
