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
import sample.controllers.directory.edit.ProductGroupEditDialogController;
import sample.models.directory.ProductGroup;

public class ProductGroupViewController {

    @FXML
    private TableView<ProductGroup> productGroupTable;
    @FXML
    private TableColumn<ProductGroup, String> numberColumn;
    @FXML
    private TableColumn<ProductGroup, String> nameColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label parentGroupLabel;

    private Stage primaryStage;

    private ObservableList<ProductGroup> productGroupData = FXCollections.observableArrayList();

    public ProductGroupViewController() {

    }

    @FXML
    public void initialize() {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showProductGroupDetails(null);

        productGroupTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showProductGroupDetails(newValue));
        productGroupTable.setItems(productGroupData);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void showProductGroupDetails(ProductGroup productGroup) {
        if (productGroup == null) {
            numberLabel.setText("");
            nameLabel.setText("");
            parentGroupLabel.setText("");
        } else {
            numberLabel.setText(productGroup.getNumber());
            nameLabel.setText(productGroup.getName());
            parentGroupLabel.setText(productGroup.getParentGroup());
        }
    }

    @FXML
    public void handleDeleteProductGroup() {
        int selectedIndex = productGroupTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            productGroupTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбрана группа ТМЦ");
            alert.setContentText("Пожалуйста, выберите группу ТМЦ из таблицы");

            alert.showAndWait();
        }
    }

    @FXML
    public boolean showEditDialog(ProductGroup productGroup) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/directory/edit/productGroupEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактировать место хранения");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        ProductGroupEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setProductGroup(productGroup);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    @FXML
    public void handleNewProductGroup() throws Exception {
        ProductGroup productGroup = new ProductGroup();
        boolean okClicked = showEditDialog(productGroup);
        if (okClicked) {
            productGroupData.add(productGroup);
        }
    }

    @FXML
    public void handleEditProductGroup() throws Exception {
        ProductGroup selectedProductGroup = productGroupTable.getSelectionModel().getSelectedItem();
        if (selectedProductGroup != null) {
            boolean okClicked = showEditDialog(selectedProductGroup);
            if (okClicked) {
                showProductGroupDetails(selectedProductGroup);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Ничего не выбранно");
            alert.setHeaderText("Не выбрана группа ТМЦ");
            alert.setContentText("Пожалуйста, выберите группу ТМЦ из таблицы");

            alert.showAndWait();
        }
    }
}
