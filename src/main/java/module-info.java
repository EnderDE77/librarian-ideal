module codes.library {
    requires javafx.controls;
    requires javafx.fxml;


    opens codes.bookstore to javafx.fxml;
    exports codes.bookstore;
}