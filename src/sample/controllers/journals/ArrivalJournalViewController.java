package sample.controllers.journals;

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
import sample.controllers.journals.edit.ArrivalJournalEditDialogController;
import sample.models.journals.ArrivalJournal;

public class ArrivalJournalViewController {

    @FXML
    private TableView<ArrivalJournal> arrivalJournalTable;
    @FXML
    private TableColumn<ArrivalJournal, String> numberColumn;
    @FXML
    private TableColumn<ArrivalJournal, String> dateColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label measureLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label notesLabel;

    private Stage primaryStage;

    private ObservableList<ArrivalJournal> arrivalJournalData = FXCollections.observableArrayList();

    public ArrivalJournalViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showArrivalJournalDetails(null);

        arrivalJournalTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showArrivalJournalDetails(newValue));
        arrivalJournalTable.setItems(arrivalJournalData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showArrivalJournalDetails(ArrivalJournal arrivalJournal) {
        if (arrivalJournal == null) {
            numberLabel.setText("");
            dateLabel.setText("");
            nameLabel.setText("");
            measureLabel.setText("");
            amountLabel.setText("");
            notesLabel.setText("");
        } else {
            numberLabel.setText(arrivalJournal.getNumber());
            dateLabel.setText(arrivalJournal.getDate());
            nameLabel.setText(arrivalJournal.getName());
            measureLabel.setText(arrivalJournal.getMeasure());
            amountLabel.setText(arrivalJournal.getAmount());
            notesLabel.setText(arrivalJournal.getNotes());
        }
    }

    @FXML
    public boolean showEditDialog(ArrivalJournal arrivalJournal) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/journals/edit/arrivalJournalEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать журнал прибытия");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        ArrivalJournalEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setArrivalJournal(arrivalJournal);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewArrivalJournal() throws Exception {
        ArrivalJournal arrivalJournal = new ArrivalJournal();
        boolean okClicked = showEditDialog(arrivalJournal);
        if (okClicked) {
            arrivalJournalData.add(arrivalJournal);
        }
    }

    @FXML
    public void handleEditArrivalJournal() throws Exception {
        ArrivalJournal selectedArrivalJournal = arrivalJournalTable.getSelectionModel().getSelectedItem();
        if (selectedArrivalJournal != null) {
            boolean okClicked = showEditDialog(selectedArrivalJournal);
            if (okClicked) {
                showArrivalJournalDetails(selectedArrivalJournal);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбран журнал прибытия");
            alert.setContentText("Пожалуйста, выберите журнал прибытия из таблицы");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleDeleteArrivalJournal() {
        int selectedIndex = arrivalJournalTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            arrivalJournalTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбран журнал прибытия");
            alert.setContentText("Пожалуйста, выберите журнал прибытия из таблицы");

            alert.showAndWait();
        }
    }
}
