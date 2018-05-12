package sample.controllers.directory.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.directory.ProductGroup;
import sample.models.directory.Storage;

public class ProductGroupEditDialogController {

    @FXML
    private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField parentGroupField;

    private Stage dialogStage;
    private ProductGroup productGroup;
    private boolean okClicked = false;

    public ProductGroupEditDialogController() {

    }

    @FXML
    public void initialize() {

    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    @FXML
    public void okClicked() {
        productGroup.setNumber(numberField.getText());
        productGroup.setName(nameField.getText());
        productGroup.setParentGroup(parentGroupField.getText());

        okClicked = true;
        dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    public void handleCancel() {
        dialogStage.close();
    }
}
