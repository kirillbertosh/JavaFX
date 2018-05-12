package sample.controllers.directory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;
import sample.controllers.directory.edit.ContractorEditDialogController;
import sample.models.directory.Contractor;
import sample.models.directory.Storage;

public class ContractorsViewController {

    @FXML
    private TableView<Contractor> contractorTable;
    @FXML
    private TableColumn<Contractor, String> numberColumn;
    @FXML
    private TableColumn<Contractor, String> nameColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label phoneLabel;

    private ObservableList<Contractor> contractorData = FXCollections.observableArrayList();

    private Stage primaryStage;

    public ContractorsViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showContractorDetails(null);

        contractorTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showContractorDetails(newValue));
        contractorTable.setItems(contractorData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showContractorDetails(Contractor contractor) {
        if (contractor == null) {
            numberLabel.setText("");
            nameLabel.setText("");
            phoneLabel.setText("");
        } else {
            numberLabel.setText(contractor.getNumber());
            nameLabel.setText(contractor.getName());
            phoneLabel.setText(contractor.getPhone());
        }
    }

    @FXML
    public boolean showEditDialog(Contractor contractor) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/directory/edit/contractorEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать контрагента");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        ContractorEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setContractor(contractor);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewContractor() throws Exception {
        Contractor contractor = new Contractor();
        boolean okClicked = showEditDialog(contractor);
        if (okClicked) {
            contractorData.add(contractor);
        }
    }

    @FXML
    public void handleEditContractor() throws Exception {
        Contractor selectedContractor = contractorTable.getSelectionModel().getSelectedItem();
        if (selectedContractor != null) {
            boolean okClicked = showEditDialog(selectedContractor);
            if (okClicked) {
                showContractorDetails(selectedContractor);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбран контрагент");
            alert.setContentText("Пожалуйста, выберите контрагента из таблицы");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleDeleteContractor() {
        int selectedIndex = contractorTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            contractorTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбран контрагент");
            alert.setContentText("Пожалуйста, выберите контрагента из таблицы");

            alert.showAndWait();
        }
    }
}
