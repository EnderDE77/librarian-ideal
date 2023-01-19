module com.example.library {
    requires javafx.controls;
    requires javafx.fxml;


    opens codes.library to javafx.fxml;
    exports codes.library;
}