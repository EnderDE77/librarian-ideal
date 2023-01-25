package codes.bookstore;

import codes.bookstore.models.people.Librarian;
import codes.bookstore.view.SellingView;
import codes.bookstore.view.StarterView;
import javafx.application.Application;
import javafx.stage.Stage;
import codes.bookstore.texts.Warehouse;

public class Main extends Application{
    @Override
    public void start(Stage stage){
        stage.setTitle("Enter");
        stage.setScene(SellingView.startScene((Librarian) Warehouse.getUsers().get(0)));
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args){
       Warehouse.ready();
       Application.launch(args);
       Warehouse.finish();
    }
}