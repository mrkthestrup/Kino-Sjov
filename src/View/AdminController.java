package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class AdminController {

    @FXML private HBox hbxTop;
    @FXML private HBox hboxBund;
    @FXML private Label headerLabel;
    @FXML private TableView<?> tableViewAdmin;
    @FXML private TableColumn<?, ?> ratingCol;
    @FXML private TableColumn<?, ?> titelCol;
    @FXML private TableColumn<?, ?> spilletSidenCol;
    @FXML private TableColumn<?, ?> solgteBilletterCol;
    @FXML private TableColumn<?, ?> spilletidCol;
    @FXML private TableColumn<?, ?> kategoriCol;
    @FXML private Button addFilmButton;
    @FXML private Button forestillingButton;
    @FXML private Button editButton;
    @FXML private Button backButton;
    @FXML private Button removeButton;

    // -------------------- Skifter scene
    ChangeSceneTo changeSceneTo = new ChangeSceneTo();

    public void toMenuScene() throws Exception{
        changeSceneTo.changeToScene("/View/menu.fxml", "Menu side");
        backButton.getScene().getWindow().hide();
    }
    public void toaddMovieScene() throws Exception{
        changeSceneTo.changeToScene("/View/addMovieToDB.fxml", "Add Movie side");
        addFilmButton.getScene().getWindow().hide();
    }


    public void toShowsScene() throws Exception{
        changeSceneTo.changeToScene("", "Add Movie side");
        forestillingButton.getScene().getWindow().hide();
    }
    //------------------ Scene Slut
}

