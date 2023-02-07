package abinladin.libraryapplication.controllers;

import abinladin.libraryapplication.entities.Book;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class IssueBookViewController {

    public TableView<Book> bookTable;
    public TableColumn<Book, String> bookTableColISBN;
    public TableColumn<Book, String> bookTableColTitle;
    public TableColumn<Book, String> bookTableColAuthor;
    public TableColumn<Book, String> bookTableColPublisher;



}
