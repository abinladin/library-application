module abinladin.libraryapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens abinladin.libraryapplication to javafx.fxml;
    exports abinladin.libraryapplication;
}