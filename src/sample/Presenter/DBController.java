package sample.Presenter;

import sample.model.Film;
import sample.view.AdminController;
import java.sql.Connection;

import java.sql.ResultSet;

public class DBController {
    Connection conn;

    public void readInfoToFilm(){
        AdminController.filmObservableList.clear();

        try{
            conn = DBConnection.getConnection();

            String sql = "Select Film_title, Description, Ticket_price, Duration, Genre, Rating, License_price, Ticket_Sold,  Timestamp from Film";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()){
                AdminController.filmObservableList.add(new Film(
                        rs.getString("Film_title"),
                        rs.getString("Description"),
                        rs.getInt("Ticket_price"),
                        rs.getString("Duration"),
                        rs.getString("Genre"),
                        rs.getString("Rating"),
                        rs.getInt("License_price"),
                        rs.getInt("Ticket_Sold"),
                        rs.getDate("Timestamp")));
            }
            rs.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }





}
