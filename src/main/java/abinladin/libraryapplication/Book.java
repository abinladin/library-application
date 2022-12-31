package abinladin.libraryapplication;

import java.time.LocalDate;

enum Format {
    Hardback, Paperback, Audiobook, ebook;
}

public class Book {
    private String title;
    private String author;
    private LocalDate publicationDate;
    private String publisher;
    private String edition;
    private String ISBN;
    private Format format;

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

    public void setAuthor(String author) {
        this.author = author;
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

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public String toString(){
        return  "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "PublicationDate: " + publicationDate + "\n" +
                "Publisher: " + publisher + "\n" +
                "Edition:" + edition;
    }

}