package View;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML private Button logAfButton;
    @FXML private Button adminstrationButton;
    @FXML private Button reservationButton;
    @FXML private Button kundeInformationButton;
    @FXML private Button forestillingButton;


    // -------------------- Skifter scene
    ChangeSceneTo changeSceneTo = new ChangeSceneTo();
    public void logud() throws Exception{
        changeSceneTo.changeToScene("/View/login.fxml","Login");
        logAfButton.getScene().getWindow().hide();
    }

    public void toAdminScene() throws Exception {
        changeSceneTo.changeToScene("/View/admin.fxml","Admin");
        adminstrationButton.getScene().getWindow().hide();
    }

    public void toReservationScene() throws Exception{
        changeSceneTo.changeToScene("/View/reservation.fxml", "Reservation side");
        reservationButton.getScene().getWindow().hide();
    }

    public void toKundeInformationScene() throws Exception{
        changeSceneTo.changeToScene(" ", "Kunde Information" );
        kundeInformationButton.getScene().getWindow().hide();
    }

    public void toforestillingScene() throws  Exception{
        changeSceneTo.changeToScene("/View/addMovieToDB.fxml ", "Forestilling side");
        forestillingButton.getScene().getWindow().hide();
    }
    //------------------ Scene Slut



}
