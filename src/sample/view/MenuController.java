package sample.view;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.MainApp;

public class MenuController {

    @FXML private Button logAfButton;
    @FXML private Button adminstrationButton;
    @FXML private Button reservationButton;
    @FXML private Button kundeInformationButton;
    @FXML private Button forestillingButton;


    // -------------------- Skifter scene

    MainApp mainApp = new MainApp();

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void toAdminScene() {
        mainApp.showAdmin();

    }



}
