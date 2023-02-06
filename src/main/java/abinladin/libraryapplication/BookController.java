package abinladin.libraryapplication;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.sql.*;

public class BookController {

    private ArrayList<Book> bookArrayList = new ArrayList<Book>();
    
    public TextField titleField;
    public TextField authorField;
    public DatePicker publicationDate;
    public TextField publisher;
    public TextField edition;
    public TextField ISBN;

    public Button submit;


    @FXML
    private void buttonAddBook(){

        Book book = new Book();

        book.setTitle(titleField.getText());
        System.out.println("book: " + book.getTitle());

        book.setAuthor(authorField.getText());
        System.out.println("author: " + book.getAuthor());

        book.setPublicationDate(publicationDate.getValue());
        System.out.println("PublicationDate: " + book.getPublicationDate());

        book.setPublisher( publisher.getText());
        System.out.println("Publisher: " + book.getPublisher());

        book.setEdition(edition.getText());
        System.out.println("Edition: " + book.getEdition());

        bookArrayList.add(book);

        SignalDB.execute(String.format("insert into books values(\"%s\",\"%s\",\"%s\");", book.getTitle(), book.getAuthor(), book.getPublisher()));

        titleField.clear();
        authorField.clear();
        publisher.clear();
        edition.clear();
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
