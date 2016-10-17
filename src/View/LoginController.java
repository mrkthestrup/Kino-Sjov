package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

    @FXML private PasswordField password;
    @FXML private Button loginButton;
    @FXML private TextField username;
    @FXML private Label checkLoginLabel;

    ChangeSceneTo changeSceneTo = new ChangeSceneTo();

    // Scene ændringer
    public void changeSceneToMenu () throws Exception {
        changeSceneTo.changeToScene("/View/menu.fxml", "Menu");
        //ellers kommer der bare flere vinduer op!
        loginButton.getScene().getWindow().hide();
    }

    // login metode
    //skal laves bedre, men pt funger den!
    public void login() throws Exception {
        // defaultButton="true" inde i Fxml(ved button oplysningerne) filen for at enter virker, når du har tastet username og password ind

        if (username.getText().equals("admin") || password.getText().equals("admin")) {
            loginButton.setDefaultButton(true);
            checkLoginLabel.setText("Du er nu logget ind!");
            changeSceneToMenu();
        } else {
            username.clear();
            password.clear();
            checkLoginLabel.setText("Forkert username eller password, prøv igen");
        }

    }




}
