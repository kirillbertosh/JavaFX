package sample.controllers.reports;

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
import sample.controllers.reports.edit.ExpenditureDynamicReportEditDialogController;
import sample.models.reports.ExpenditureDynamicReport;

public class ExpenditureDynamicReportViewController {

    @FXML
    private TableView<ExpenditureDynamicReport> expenditureDynamicReportTable;
    @FXML
    private TableColumn<ExpenditureDynamicReport, String> numberColumn;
    @FXML
    private TableColumn<ExpenditureDynamicReport, String> nameColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label measureLabel;
    @FXML
    private Label startBalanceLabel;
    @FXML
    private Label arrivedLabel;
    @FXML
    private Label departedLabel;
    @FXML
    private Label monthLabel;
    @FXML
    private Label endBalanceLabel;

    private Stage primaryStage;

    private ObservableList<ExpenditureDynamicReport> expenditureDynamicReportData = FXCollections.observableArrayList();

    public ExpenditureDynamicReportViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showExpenditureDynamicReportDetails(null);

        expenditureDynamicReportTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showExpenditureDynamicReportDetails(newValue));
        expenditureDynamicReportTable.setItems(expenditureDynamicReportData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showExpenditureDynamicReportDetails(ExpenditureDynamicReport expenditureDynamicReport) {
        if (expenditureDynamicReport == null) {
            numberLabel.setText("");
            nameLabel.setText("");
            measureLabel.setText("");
            startBalanceLabel.setText("");
            arrivedLabel.setText("");
            departedLabel.setText("");
            monthLabel.setText("");
            endBalanceLabel.setText("");
        } else {
            numberLabel.setText(expenditureDynamicReport.getNumber());
            nameLabel.setText(expenditureDynamicReport.getName());
            measureLabel.setText(expenditureDynamicReport.getMeasure());
            startBalanceLabel.setText(expenditureDynamicReport.getStartMonthBalance());
            arrivedLabel.setText(expenditureDynamicReport.getArrivedDuringMonth());
            departedLabel.setText(expenditureDynamicReport.getDepartedDuringMonth());
            monthLabel.setText(expenditureDynamicReport.getMonth());
            endBalanceLabel.setText(expenditureDynamicReport.getEndMonthBalance());
        }
    }

    @FXML
    public boolean showEditDialog(ExpenditureDynamicReport expenditureDynamicReport) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/reports/edit/expenditureDynamicReportEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать динамику расхода ТМЦ");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        ExpenditureDynamicReportEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setExpenditureDynamicReport(expenditureDynamicReport);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewExpenditureDynamicReport() throws Exception {
        ExpenditureDynamicReport expenditureDynamicReport = new ExpenditureDynamicReport();
        boolean okClicked = showEditDialog(expenditureDynamicReport);
        if (okClicked) {
            expenditureDynamicReportData.add(expenditureDynamicReport);
        }
    }

    @FXML
    public void handleEditExpenditureDynamicReport() throws Exception {
        ExpenditureDynamicReport selectedExpenditureDynamicReport =
                expenditureDynamicReportTable.
                        getSelectionModel().
                        getSelectedItem();
        if (selectedExpenditureDynamicReport != null) {
            boolean okClicked = showEditDialog(selectedExpenditureDynamicReport);
            if (okClicked) {
                showExpenditureDynamicReportDetails(selectedExpenditureDynamicReport);
            }

        } else {
            showAlert();
        }
    }

    @FXML
    public void handleDeleteExpenditureDynamicReport() {
        int selectedIndex = expenditureDynamicReportTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            expenditureDynamicReportTable.getItems().remove(selectedIndex);
        } else {
            showAlert();
        }
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(primaryStage);
        alert.setTitle("Ничего не выбранно");
        alert.setHeaderText("Не выбрана динамика расхода ТМЦ");
        alert.setContentText("Пожалуйста, выберите динамику расхода ТМЦ из таблицы");

        alert.showAndWait();
    }
}
