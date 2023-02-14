package bookstore;

import bookstore.models.people.Manager;
import bookstore.view.AddBooksView;
import bookstore.view.BookStockView;
import bookstore.view.ManagerView;
import bookstore.view.StarterView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import bookstore.texts.Warehouse;

public class MainTest extends Application{
    @Override
    public void start(Stage stage){
        stage.setTitle("Enter");
        Scene scene = new Scene(AddBooksView.startScene(),1000,750);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args){
        Warehouse.ready();
        Application.launch(args);
        Warehouse.finish();
    }
}