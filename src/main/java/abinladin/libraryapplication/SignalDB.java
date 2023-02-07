package abinladin.libraryapplication;

import java.sql.*;

public class SignalDB {
    /*
    * Singleton class that serves as the interface to the MySQL database
    *
    */
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

    public static ResultSet query(String query){
        ResultSet rs = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "abinladin", "");
            PreparedStatement pst = con.prepareStatement(query);
            rs = pst.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return rs;
    }

}
