package abinladin.libraryapplication.entities;

import java.time.LocalDate;
import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private LocalDate publicationDate;
    private String publisher;
    private String edition;
    private String ISBN;
    private Format format;
    private Department department;

    public Book() {

    }

    public Book(String title, String author, LocalDate publicationDate, String publisher, String edition, String isbn, Format format) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
        this.edition = edition;
        this.ISBN = isbn;
        this.format = format;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public int setAuthor(String author) {
        if(author.isEmpty()){
            System.out.println("Author Field cannot be empty");
            return 1;
        }
        this.author = author;
        return 0;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getISBN() {
        return ISBN;
    }

    public int setISBN(String ISBN) {
        ISBN.replace("-", "");
        if(ISBN.matches("[0-9]+")){

            this.ISBN = ISBN;
            return 0;
        }
        System.out.println("ISBN must be a 13 digit number");
        return 1;
    }

    public Format getFormat() {
        return format;
    }

    public int setFormat(Format format) {
        if(format == null){
            System.out.println("Format cannot be empty");
            return 1;
        }
        this.format = format;
        return 0;
    }

    public String toString(){
        return  "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "PublicationDate: " + publicationDate + "\n" +
                "Publisher: " + publisher + "\n" +
                "Edition:" + edition;
    }

    public Department getDepartment() {
        return department;
    }

    public int setDepartment(Department department) {
        if(department == null){
            System.out.println("Department cannot be empty");
            return 1;
        }
        this.department = department;
        return 0;
    }
}