package bookstore;

import bookstore.view.starter.StarterView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import bookstore.texts.Warehouse;

public class Main extends Application{
    @Override
    public void start(Stage stage){
        stage.setTitle("Enter");
        Scene scene = new Scene(StarterView.startScene(),1000,750);
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