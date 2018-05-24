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
import sample.controllers.journals.edit.CommonJournalEditDialogController;
import sample.models.journals.ArrivalJournal;
import sample.models.journals.CommonJournal;

public class CommonJournalViewController {

    @FXML
    private TableView<CommonJournal> commonJournalTable;
    @FXML
    private TableColumn<CommonJournal, String> numberColumn;
    @FXML
    private TableColumn<CommonJournal, String> dateColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label typeLabel;
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

    private ObservableList<CommonJournal> commonJournalData = FXCollections.observableArrayList();

    public CommonJournalViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showCommonJournalDetails(null);

        commonJournalTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showCommonJournalDetails(newValue));
        commonJournalTable.setItems(commonJournalData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showCommonJournalDetails(CommonJournal commonJournal) {
        if (commonJournal == null) {
            numberLabel.setText("");
            typeLabel.setText("");
            dateLabel.setText("");
            nameLabel.setText("");
            measureLabel.setText("");
            amountLabel.setText("");
            notesLabel.setText("");
        } else {
            numberLabel.setText(commonJournal.getNumber());
            typeLabel.setText(commonJournal.getType());
            dateLabel.setText(commonJournal.getDate());
            nameLabel.setText(commonJournal.getName());
            measureLabel.setText(commonJournal.getMeasure());
            amountLabel.setText(commonJournal.getAmount());
            notesLabel.setText(commonJournal.getNotes());
        }
    }

    @FXML
    public boolean showEditDialog(CommonJournal commonJournal) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/journals/edit/commonJournalEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать общий прибытия");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        CommonJournalEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setCommonJournal(commonJournal);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewCommonJournal() throws Exception {
        CommonJournal commonJournal = new CommonJournal();
        boolean okClicked = showEditDialog(commonJournal);
        if (okClicked) {
            commonJournalData.add(commonJournal);
        }
    }

    @FXML
    public void handleEditCommonJournal() throws Exception {
        CommonJournal selectedCommonJournal = commonJournalTable.getSelectionModel().getSelectedItem();
        if (selectedCommonJournal != null) {
            boolean okClicked = showEditDialog(selectedCommonJournal);
            if (okClicked) {
                showCommonJournalDetails(selectedCommonJournal);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбранна запись из общего журнала");
            alert.setContentText("Пожалуйста, выберите запись общего журнала из таблицы");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleDeleteCommonJournal() {
        int selectedIndex = commonJournalTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            commonJournalTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбранна запись из общего журнала");
            alert.setContentText("Пожалуйста, выберите запись общего журнала из таблицы");

            alert.showAndWait();
        }
    }
}
