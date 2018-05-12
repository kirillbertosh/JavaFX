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
import sample.controllers.directory.edit.StorageEditDialogController;
import sample.models.directory.Storage;

public class StorageViewController {

    @FXML
    private TableView<Storage> storageTable;
    @FXML
    private TableColumn<Storage, String> numberColumn;
    @FXML
    private TableColumn<Storage, String> nameColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label addressLabel;

    private Stage primaryStage;

    private ObservableList<Storage> storageData = FXCollections.observableArrayList();

    public StorageViewController() {

    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showStorageDetails(Storage storage) {
        if (storage == null) {
            numberLabel.setText("");
            nameLabel.setText("");
            addressLabel.setText("");
        } else {
            numberLabel.setText(storage.getNumber());
            nameLabel.setText(storage.getName());
            addressLabel.setText(storage.getAddress());
        }
    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showStorageDetails(null);

        storageTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStorageDetails(newValue));
        storageTable.setItems(storageData);
    }

    @FXML
    public void handleDeleteStorage() {
        int selectedIndex = storageTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            storageTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбран склад");
            alert.setContentText("Пожалуйста, выберите склад из таблицы");

            alert.showAndWait();
        }
    }

    @FXML
    public boolean showEditDialog(Storage storage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/directory/edit/storageEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать место хранения");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        StorageEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setStorage(storage);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewStorage() throws Exception {
        Storage storage = new Storage();
        boolean okClicked = showEditDialog(storage);
        if (okClicked) {
            storageData.add(storage);
        }
    }

    @FXML
    public void handleEditStorage() throws Exception {
        Storage selectedStorage = storageTable.getSelectionModel().getSelectedItem();
        if (selectedStorage != null) {
            boolean okClicked = showEditDialog(selectedStorage);
            if (okClicked) {
                showStorageDetails(selectedStorage);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбран склад");
            alert.setContentText("Пожалуйста, выберите склад из таблицы");

            alert.showAndWait();
        }
    }
}
