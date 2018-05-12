package sample.controllers.invoices;

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
import sample.controllers.invoices.edit.CancellationActEditDialogController;
import sample.models.invoices.CancellationAct;

public class CancellationActViewController {

    @FXML
    private TableView<CancellationAct> cancellationActTable;
    @FXML
    private TableColumn<CancellationAct, String> numberColumn;
    @FXML
    private TableColumn<CancellationAct, String> dateColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label actDateLabel;
    @FXML
    private Label inputDateLabel;
    @FXML
    private Label cancellationDateLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label measureLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label notesLabel;

    private Stage primaryStage;

    private ObservableList<CancellationAct> cancellationActData = FXCollections.observableArrayList();

    public CancellationActViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showCancellationActDetails(null);

        cancellationActTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showCancellationActDetails(newValue));
        cancellationActTable.setItems(cancellationActData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showCancellationActDetails(CancellationAct cancellationAct) {
        if (cancellationAct == null) {
            numberLabel.setText("");
            actDateLabel.setText("");
            inputDateLabel.setText("");
            cancellationDateLabel.setText("");
            nameLabel.setText("");
            measureLabel.setText("");
            amountLabel.setText("");
            notesLabel.setText("");
        } else {
            numberLabel.setText(cancellationAct.getNumber());
            actDateLabel.setText(cancellationAct.getActDate());
            inputDateLabel.setText(cancellationAct.getInputDate());
            cancellationDateLabel.setText(cancellationAct.getCancellationDate());
            nameLabel.setText(cancellationAct.getName());
            measureLabel.setText(cancellationAct.getMeasure());
            amountLabel.setText(cancellationAct.getAmount());
            notesLabel.setText(cancellationAct.getNotes());
        }
    }

    @FXML
    public boolean showEditDialog(CancellationAct cancellationAct) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/invoices/edit/cancellationActEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать акт списания");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        CancellationActEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setCancellationAct(cancellationAct);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewCancellationAct() throws Exception {
        CancellationAct cancellationAct = new CancellationAct();
        boolean okClicked = showEditDialog(cancellationAct);
        if (okClicked) {
            cancellationActData.add(cancellationAct);
        }
    }

    @FXML
    public void handleEditCancellationAct() throws Exception {
        CancellationAct selectedCancellationAct = cancellationActTable.getSelectionModel().getSelectedItem();
        if (selectedCancellationAct != null) {
            boolean okClicked = showEditDialog(selectedCancellationAct);
            if (okClicked) {
                showCancellationActDetails(selectedCancellationAct);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбран акт списания");
            alert.setContentText("Пожалуйста, выберите акт списания из таблицы");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleDeleteCancellationAct() {
        int selectedIndex = cancellationActTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            cancellationActTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбран акт списания");
            alert.setContentText("Пожалуйста, выберите акт списания из таблицы");


            alert.showAndWait();
        }
    }
}
