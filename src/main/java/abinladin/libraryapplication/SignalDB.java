package abinladin.libraryapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SignalDB {
    private static SignalDB instance = new SignalDB();
    private SignalDB(){};
    private static Connection con = null;
    public static void execute(String query){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "abinladin", "");
            con.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
