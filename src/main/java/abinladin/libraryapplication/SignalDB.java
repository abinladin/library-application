package abinladin.libraryapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SignalDB {
    private static Connection con = null;
    public static Connection getConnection(){
        if (con != null) return con;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "abinladin", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
