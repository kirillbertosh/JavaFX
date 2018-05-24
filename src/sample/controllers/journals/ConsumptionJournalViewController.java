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
import sample.controllers.journals.edit.ConsumptionJournalEditDialogController;
import sample.models.journals.ConsumptionJournal;

public class ConsumptionJournalViewController {

    @FXML
    private TableView<ConsumptionJournal> consumptionJournalTable;
    @FXML
    private TableColumn<ConsumptionJournal, String> numberColumn;
    @FXML
    private TableColumn<ConsumptionJournal, String> dateColumn;

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

    private ObservableList<ConsumptionJournal> consumptionJournalData = FXCollections.observableArrayList();

    public ConsumptionJournalViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showConsumptionJournalDetails(null);

        consumptionJournalTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showConsumptionJournalDetails(newValue));
        consumptionJournalTable.setItems(consumptionJournalData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showConsumptionJournalDetails(ConsumptionJournal consumptionJournal) {
        if (consumptionJournal == null) {
            numberLabel.setText("");
            dateLabel.setText("");
            nameLabel.setText("");
            measureLabel.setText("");
            amountLabel.setText("");
            notesLabel.setText("");
        } else {
            numberLabel.setText(consumptionJournal.getNumber());
            dateLabel.setText(consumptionJournal.getDate());
            nameLabel.setText(consumptionJournal.getName());
            measureLabel.setText(consumptionJournal.getMeasure());
            amountLabel.setText(consumptionJournal.getAmount());
            notesLabel.setText(consumptionJournal.getNotes());
        }
    }

    @FXML
    public boolean showEditDialog(ConsumptionJournal consumptionJournal) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/journals/edit/consumptionJournalEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать журнал прибытия");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        ConsumptionJournalEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setConsumptionJournal(consumptionJournal);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewConsumptionJournal() throws Exception {
        ConsumptionJournal arrivalJournal = new ConsumptionJournal();
        boolean okClicked = showEditDialog(arrivalJournal);
        if (okClicked) {
            consumptionJournalData.add(arrivalJournal);
        }
    }

    @FXML
    public void handleEditConsumptionJournal() throws Exception {
        ConsumptionJournal selectedConsumptionJournal = consumptionJournalTable.getSelectionModel().getSelectedItem();
        if (selectedConsumptionJournal != null) {
            boolean okClicked = showEditDialog(selectedConsumptionJournal);
            if (okClicked) {
                showConsumptionJournalDetails(selectedConsumptionJournal);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбрана запись из журнала отбытия");
            alert.setContentText("Пожалуйста, выберите запись журнала отбытия из таблицы");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleDeleteConsumptionJournal() {
        int selectedIndex = consumptionJournalTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            consumptionJournalTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбрана запись из журнала отбытия");
            alert.setContentText("Пожалуйста, выберите запись журнала отбытия из таблицы");

            alert.showAndWait();
        }
    }
}
