module abinladin.libraryapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens abinladin.libraryapplication to javafx.fxml;
    exports abinladin.libraryapplication;
    exports abinladin.libraryapplication.entities;
    opens abinladin.libraryapplication.entities to javafx.fxml;
    exports abinladin.libraryapplication.controllers;
    opens abinladin.libraryapplication.controllers to javafx.fxml;
}