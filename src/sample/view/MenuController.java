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

    MainApp mainApp = new MainApp();

    // -------------------- Skifter scene
    @FXML
    public void toAdminScene() {
        mainApp.showAdmin();
    }
    // -------------------- Slut scene


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }






}
