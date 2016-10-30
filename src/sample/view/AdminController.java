package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.MainApp;
import sample.Presenter.DBController;
import sample.model.Film;

import java.util.Date;

public class AdminController {


    @FXML    private TableView<Film> tableViewAdmin;
    @FXML    private TableColumn<Film, String> ratingCol;
    @FXML    private TableColumn<Film, String> titelCol;
    @FXML    private TableColumn<Film, String> spilletSidenCol;
    @FXML    private TableColumn<Film, Integer> solgteBilletterCol;
    @FXML    private TableColumn<Film, Date> spilletidCol;
    @FXML    private TableColumn<Film, String> kategoriCol;
    @FXML private Label label;

    private MainApp mainApp;
    DBController dbController = new DBController();

    public static ObservableList<Film> filmObservableList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        dbController.readInfoToFilm();
        // Initialize the Film table with the two columns.
        titelCol.setCellValueFactory(e -> e.getValue().titelProperty());
        spilletSidenCol.setCellValueFactory(e -> e.getValue().durationProperty());
        kategoriCol.setCellValueFactory(e -> e.getValue().genreProperty());
        ratingCol.setCellValueFactory(e -> e.getValue().ratingProperty());
        spilletidCol.setCellValueFactory(new PropertyValueFactory<Film, Date>("timestamp"));
        solgteBilletterCol.setCellValueFactory(new PropertyValueFactory<Film, Integer>("ticketSold"));


        // Listen for selection changes and show the film details when changed.
        tableViewAdmin.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showFilmDetails(newValue));
        doubleClick();
    }

    //SCENE SKIFT
    @FXML
    public void toMenuScene(){
        mainApp.showMenu();
    }

    public void toaddMovie(){
        mainApp.showAddMovie();
    }
// -------------------- Scene slut


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Add observable list to the table
        tableViewAdmin.setItems(filmObservableList);
    }


    public void doubleClick(){
        //work with double click!
        tableViewAdmin.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2){
                    handleEditfilm();
                }
            }
        });
    }

    //Edit film!
    @FXML
    private void handleEditfilm() {
        Film selectedPerson = tableViewAdmin.getSelectionModel().getSelectedItem();

        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if(okClicked){
                showFilmDetails(selectedPerson);
            }
            } else {
                // Nothing selected.
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("No Selection");
                alert.setHeaderText("No film Selected");
                alert.setContentText("Please select a film in the table.");

                alert.showAndWait();
            }
    }

    //doesnt work with out!?
    private void showFilmDetails(Film selectedPerson) {
        if(selectedPerson != null){
            label.setText("");
        } else {
            label.setText("");
        }
    }



}

