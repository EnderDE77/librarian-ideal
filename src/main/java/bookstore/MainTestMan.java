package bookstore;

import bookstore.models.people.Librarian;
import bookstore.models.people.Manager;
import bookstore.texts.Warehouse;
import bookstore.view.LibrarianView;
import bookstore.view.ManagerView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTestMan extends Application{
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