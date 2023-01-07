module abinladin.libraryapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens abinladin.libraryapplication to javafx.fxml;
    exports abinladin.libraryapplication;
}