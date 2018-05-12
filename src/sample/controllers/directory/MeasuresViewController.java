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
import sample.controllers.directory.edit.MeasureEditDialogController;
import sample.controllers.directory.edit.ProductGroupEditDialogController;
import sample.models.directory.Measure;

public class MeasuresViewController {

    @FXML
    private TableView<Measure> measureTable;
    @FXML
    private TableColumn<Measure, String> nameColumn;
    @FXML
    private TableColumn<Measure, String> abbreviationColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label abbreviationLabel;

    private Stage primaryStage;

    private ObservableList<Measure> measureData = FXCollections.observableArrayList();

    public MeasuresViewController() {

    }

    @FXML
    public void initialize() {
        abbreviationColumn.setCellValueFactory(cellData -> cellData.getValue().abbreviationProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showMeasureDetails(null);

        measureTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMeasureDetails(newValue));
        measureTable.setItems(measureData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showMeasureDetails(Measure measure) {
        if (measure == null) {
            nameLabel.setText("");
            abbreviationLabel.setText("");
        } else {
            nameLabel.setText(measure.getName());
            abbreviationLabel.setText(measure.getAbbreviation());
        }
    }

    @FXML
    public void handleDeleteProductGroup() {
        int selectedIndex = measureTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            measureTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбрана единица измерения");
            alert.setContentText("Пожалуйста, выберите единицу измерения из таблицы");

            alert.showAndWait();
        }
    }

    @FXML
    public boolean showEditDialog(Measure measure) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/directory/edit/measureEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать единицу измерения");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        MeasureEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setMeasure(measure);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewProductGroup() throws Exception {
        Measure measure = new Measure();
        boolean okClicked = showEditDialog(measure);
        if (okClicked) {
            measureData.add(measure);
        }
    }

    @FXML
    public void handleEditProductGroup() throws Exception {
        Measure selectedProductGroup = measureTable.getSelectionModel().getSelectedItem();
        if (selectedProductGroup != null) {
            boolean okClicked = showEditDialog(selectedProductGroup);
            if (okClicked) {
                showMeasureDetails(selectedProductGroup);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбрана единица измерения");
            alert.setContentText("Пожалуйста, выберите единицу измерения из таблицы");

            alert.showAndWait();
        }
    }
}
