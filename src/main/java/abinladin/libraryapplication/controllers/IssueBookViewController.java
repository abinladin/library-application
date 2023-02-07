package abinladin.libraryapplication.controllers;

import abinladin.libraryapplication.SignalDB;
import abinladin.libraryapplication.entities.Book;
import abinladin.libraryapplication.entities.Student;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class IssueBookViewController {

    public DatePicker setDueDate;
    public TextField issueViewBookISBN;
    public TextField issueViewBookTitle;
    public TextField studentInput;
    public Button issueButton;
    public TextArea issueBookOutput;

    @FXML
    public void createCheckout(){

        //Search for Book

        String bookISBN = issueViewBookISBN.getText();
        String bookTitle = issueViewBookTitle.getText();
        String studentID = studentInput.getText();

        try {
            if (bookTitle.equals("")) {
                ResultSet rs = SignalDB.query("select isbn from books");
                while (rs.next()) System.out.println(rs.getString(1));

                rs = SignalDB.query("select title from books where isbn=" + bookISBN);
                while (rs.next()) bookTitle = rs.getString(1);
                issueViewBookTitle.setText(bookTitle);

                System.out.println(bookTitle);

            } else if (bookISBN.equals("")){
                ResultSet rs = SignalDB.query("select title from books");
                while(rs.next()) System.out.println(rs.getString(1));

                rs = SignalDB.query("select isbn from books where title=\"" + bookTitle + "\"");
                while(rs.next()) bookISBN = rs.getString(1);
                issueViewBookISBN.setText(bookISBN);
            }


            LocalDate dueDate = setDueDate.getValue();
            studentID = studentInput.getText();
            LocalDate todayDate = LocalDate.now();

            Student student = new Student();
            Book book = new Book();

            book.setISBN(bookISBN);
            student.setId(studentID);

            SignalDB.execute(String.format("insert into checkouts values(\"%s\", \"%s\", \"%s\",\"%s\")", student.getId(), book.getISBN(), Date.valueOf(todayDate),Date.valueOf(dueDate)));

            String feedback = "Today's date: " + todayDate.toString() +"\n" + "Due date: " + dueDate.toString();
            issueBookOutput.setText(feedback);

        } catch (SQLException e){
            e.printStackTrace();
        }






    }

}
