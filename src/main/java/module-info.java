module bookstore {
    requires javafx.controls;
    requires javafx.fxml;

    opens bookstore.models to javafx.base;
    opens bookstore.models.people to javafx.base;
    opens bookstore to javafx.fxml;
    exports bookstore;
}