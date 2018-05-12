package sample.controllers.directory;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Main;

public class DirectoryRootLayoutController {

    private BorderPane directoryLayout;
    private Stage primaryStage;

    public DirectoryRootLayoutController() {

    }

    @FXML
    public void initialize() {

    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setDirectoryLayout(BorderPane directoryLayout) {
        this.directoryLayout = directoryLayout;
    }

    @FXML
    public void showCounterpartiesView() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/directory/contractorsView.fxml"));
        AnchorPane counterpartiesLayout = (AnchorPane) loader.load();

        directoryLayout.setCenter(counterpartiesLayout);
        ContractorsViewController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
    }

    @FXML
    public void showMeasuresView() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/directory/measuresView.fxml"));
        AnchorPane measureLayout = (AnchorPane) loader.load();

        directoryLayout.setCenter(measureLayout);
        MeasuresViewController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
    }

    @FXML
    public void showProductGroupView() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/directory/productGroupView.fxml"));
        AnchorPane productGroupLayout = (AnchorPane) loader.load();

        directoryLayout.setCenter(productGroupLayout);
        ProductGroupViewController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
    }

    @FXML
    public void showStorageView() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/directory/storageView.fxml"));
        AnchorPane storageLayout = (AnchorPane) loader.load();

        directoryLayout.setCenter(storageLayout);
        StorageViewController storageViewController = loader.getController();
        storageViewController.setPrimaryStage(primaryStage);
    }
}
