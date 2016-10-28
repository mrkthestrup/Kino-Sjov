package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Presenter.DBConnection;
import sample.model.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class EditController {


    @FXML    private TextField titelTextedit;
    @FXML    private TextField durationTextedit;
    @FXML    private TextField ticketPriceTextedit;
    @FXML    private TextField lincensPriceTextedit;
    @FXML    private TextArea descriptionAreaedit;
    @FXML    private ComboBox<String> genreComboedit;
    @FXML    private ComboBox<String> ratingComboedit;


    private Stage dialogStage;
    private Film film;
    private boolean okClicked = true;

    @FXML
    private void initialize() {
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setFilm(Film film) {
        this.film = film;

        titelTextedit.setText(film.getTitel());
        durationTextedit.setText(film.getDuration());
        ticketPriceTextedit.setText(String.valueOf(film.getTicketPrice()));
        lincensPriceTextedit.setText(String.valueOf(film.getLicensPrice()));
        descriptionAreaedit.setText(film.getDescription());
        genreComboedit.setValue(film.getGenre());
        ratingComboedit.setValue(film.getRating());

    }

    @FXML
    private void handleOK()throws  Exception{
        Connection conn;
        PreparedStatement ps;

        try {
            if(isInputValid()){
                String titel = titelTextedit.getText();
                String duration = film.setDuration(durationTextedit.getText());
                int licensPrice = film.setLicensPrice(Integer.parseInt(lincensPriceTextedit.getText()));
                int ticketPrice = film.setTicketPrice(Integer.parseInt(ticketPriceTextedit.getText()));
                String genre = film.setGenre(genreComboedit.getValue());
                String rating = film.setRating(ratingComboedit.getValue());
                String decription = film.setDescription(descriptionAreaedit.getText());

                conn = DBConnection.getConnection();
                //You cant change the film title!
                String sql = "update film set Film_title = '"+titel+"', Description = '"+ decription+"', Ticket_price = '"+ ticketPrice+"', Duration ='"+ duration+"', Genre ='"+ genre+"', Rating ='"+ rating+"', License_price ='"+ licensPrice+"' WHERE Film_title = '"+titel+"'";

                ps = conn.prepareStatement(sql);
                ps.execute();

                okClicked = true;
                dialogStage.close();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid(){
        String errorMessage = "";

        if(titelTextedit.getText() == null || titelTextedit.getText().length() == 0){
            errorMessage += "no valid titel!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;

        }

    }


}

