package sample.controllers.journals;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Main;

public class JournalsRootLayoutController {

    private BorderPane journalsLayout;
    private Stage primaryStage;

    public JournalsRootLayoutController() {

    }

    @FXML
    public void initialize() {

    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setJournalsLayout(BorderPane journalsLayout) {
        this.journalsLayout = journalsLayout;
    }

    @FXML
    public void showArrivalJournals() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/journals/arrivalJournalView.fxml"));
        AnchorPane salesInvoices = (AnchorPane) loader.load();

        journalsLayout.setCenter(salesInvoices);
        ArrivalJournalViewController arrivalJournalViewController = loader.getController();
        arrivalJournalViewController.setPrimaryStage(primaryStage);
    }

    @FXML
    public void showConsumptionJournals() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/journals/consumptionJournalView.fxml"));
        AnchorPane salesInvoices = (AnchorPane) loader.load();

        journalsLayout.setCenter(salesInvoices);
        ConsumptionJournalViewController consumptionJournalViewController = loader.getController();
        consumptionJournalViewController.setPrimaryStage(primaryStage);
    }

    @FXML
    public void showCommonJournal() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/journals/commonJournalView.fxml"));
        AnchorPane salesInvoices = (AnchorPane) loader.load();

        journalsLayout.setCenter(salesInvoices);
        CommonJournalViewController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
    }
}
