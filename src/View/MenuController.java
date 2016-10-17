package View;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML private Button logAfButton;
    @FXML private Button adminstrationButton;
    @FXML private Button reservationButton;

    ChangeSceneTo changeSceneTo = new ChangeSceneTo();


    public void logud() throws Exception{
        changeSceneTo.changeToScene("/View/login.fxml","Login");
        logAfButton.getScene().getWindow().hide();
    }

    public void amninstrationButton(){

    }
}
