package sample.controllers.journals;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.Main;

public class JournalsRootLayoutController {

    private BorderPane journalsLayout;

    public JournalsRootLayoutController() {

    }

    @FXML
    public void initialize() {

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
    }

    @FXML
    public void showConsumptionJournals() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/journals/consumptionJournalView.fxml"));
        AnchorPane salesInvoices = (AnchorPane) loader.load();

        journalsLayout.setCenter(salesInvoices);
    }

    @FXML
    public void showCommonJournal() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/journals/commonJournalView.fxml"));
        AnchorPane salesInvoices = (AnchorPane) loader.load();

        journalsLayout.setCenter(salesInvoices);
    }
}
