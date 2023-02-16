package bookstore;

import bookstore.models.people.Manager;
import bookstore.view.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import bookstore.texts.Warehouse;

public class MainTest extends Application{
    //TODO: Add books to the mix
    @Override
    public void start(Stage stage){
        stage.setTitle("Enter");
        Scene scene = new Scene(ManagerView.startScene((Manager) Warehouse.getUsers().get(0)),1000,750);
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