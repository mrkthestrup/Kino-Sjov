package View;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ReservationController {

    @FXML private ComboBox<?> showCB;
    @FXML private Label warninglabel;
    @FXML private Label headerLabel;
    @FXML private Button reserveButton;
    @FXML private Button backButton;
    @FXML private ComboBox<?> movieCB;

    // -------------------- Skifter scene
    ChangeSceneTo changeSceneTo = new ChangeSceneTo();

    public void toMenuScene2() throws Exception{
        changeSceneTo.changeToScene("/View/menu.fxml", "Menu side");
        backButton.getScene().getWindow().hide();
    }

    //------------------ Scene Slut
}
