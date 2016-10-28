package sample.Presenter;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection(){
        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kea_kino?autoReconnect=true&useSSL=false","root","1234");

        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }
}
