package abinladin.libraryapplication.controllers;

import abinladin.libraryapplication.SignalDB;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveBookViewController {

    public Button removeBookButton;
    public Text bookFoundStatusIndicator;
    public TextField searchByTitleField;
    @FXML
    private void removeBookButtonPressed(){
        String bookTitle = bookFoundStatusIndicator.getText();

        ResultSet rs = SignalDB.query(String.format("select isbn from books where isbn=%s", searchByTitleField.getText()));

        try {
            while (rs.next()) {
                String currentEntry = rs.getString(1);
                if (searchByTitleField.getText().equals(currentEntry)){

                    System.out.println("book found");
                    SignalDB.execute(String.format("delete from book_author where book_id=(\"%s\");", currentEntry));
                    SignalDB.execute(String.format("delete from books where isbn=(\"%s\");", currentEntry));
                    System.out.println("book removed");
                    bookFoundStatusIndicator.setText(String.format("book \"%s\" was found and removed", currentEntry));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
