package abinladin.libraryapplication.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import abinladin.libraryapplication.SignalDB;
import abinladin.libraryapplication.entities.Book;
import abinladin.libraryapplication.entities.Department;
import abinladin.libraryapplication.entities.Format;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddBookViewController {

    private ArrayList<Book> bookArrayList = new ArrayList<Book>();
    
    public TextField titleField;
    public TextField authorField;
    public DatePicker publicationDate;
    public TextField publisher;
    public TextField edition;
    public TextField ISBN;

    public ChoiceBox<String> format;
    public ChoiceBox<String> department;
    public Button submit;

    @FXML
    private void fillButtonFormat(){
        format.setItems(FXCollections.observableArrayList("Hardcover", "Softcover", "Audiobook", "Ebook"));
    }

    @FXML
    private void fillButtonDepartment(){
        department.setItems(FXCollections.observableArrayList("Computer Science", "Business Administration", "International Relations", "Other"));
    }

    @FXML
    private void buttonAddBook(){

        boolean errorFlag = false;

        Book book = new Book();

        if(book.setTitle(titleField.getText()) != 0) errorFlag = true;
        System.out.println("book: " + book.getTitle());

        if(book.setAuthor(authorField.getText()) != 0) errorFlag = true;
        System.out.println("author: " + book.getAuthor());

        if(book.setPublicationDate(publicationDate.getValue()) != 0) errorFlag = true;
        System.out.println("PublicationDate: " + book.getPublicationDate());

        if(book.setPublisher(publisher.getText()) != 0) errorFlag = true;
        System.out.println("Publisher: " + book.getPublisher());

        if(book.setEdition(edition.getText()) != 0) errorFlag = true;
        System.out.println("Edition: " + book.getEdition());

        if (book.setISBN(ISBN.getText()) != 0) errorFlag = true;
        System.out.println("ISBN: " + book.getEdition());

        if(book.setFormat(Format.valueOf(format.getValue())) != 0) errorFlag = true;
        System.out.println("Format: " + book.getFormat());

        if(book.setDepartment(Department.valueOf(department.getValue().replace(" ", "_"))) !=0) errorFlag = true;
        System.out.println("Department: " + book.getDepartment());


        if (errorFlag == false) {
            bookArrayList.add(book);

            ResultSet authorset = SignalDB.query("select * from authors;");
            ResultSet bookSet = SignalDB.query("select isbn from books");

            // Logic to avoid entering duplicate primary keys

            boolean authorExistsFlag = false;
            boolean bookExistsFlag = false;

            try {
                while (authorset.next()) {
                    if (!authorset.isBeforeFirst() || !bookSet.isBeforeFirst()) {
                        String foo = authorset.getString(1);
                        String bar = bookSet.getString(1);
                    }
                    if (authorset.getString(1).equals(book.getAuthor())){
                        authorExistsFlag = true;
                    }
                    if (bookSet.getString(1).equals(book.getISBN())){
                        bookExistsFlag = true;
                    }
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            if (!authorExistsFlag) {
                SignalDB.execute(String.format("insert into authors values(\"%s\")", book.getAuthor()));
            }
            if (!bookExistsFlag){
                SignalDB.execute(String.format("insert into books values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");", book.getISBN(), book.getTitle(), book.getPublisher(), Date.valueOf(book.getPublicationDate()).toString(), book.getEdition(), book.getFormat().toString(), book.getDepartment().toString()));
            }

            SignalDB.execute(String.format("insert into book_author values(\"%s\", \"%s\")", book.getISBN(), book.getAuthor()));

        } else {
            Alert errormsg = new Alert(Alert.AlertType.ERROR);
            errormsg.setTitle("Error Dialog");
            errormsg.setHeaderText("Book not added");
            errormsg.setContentText("There was an error adding your book to the system. Please ensure all fields were entered correctly.");

            errormsg.show();
        }

        titleField.clear();
        authorField.clear();
        publisher.clear();
        edition.clear();
        ISBN.clear();
        format.setValue(null);
        department.setValue(null);

        publicationDate.setValue(null);
        publicationDate.setPromptText("Publication Date");

    }

    @FXML
    private void printStoredBooks(){
        int i = 1;
        System.out.println("=====================================");
        System.out.println("           BOOKS IN DATABASE         ");
        System.out.println("=====================================");
        for (Book e: bookArrayList) {
            System.out.println("Entry: " + i++);
            System.out.println(e);
        }
    }


}
