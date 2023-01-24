package codes.bookstore;

import codes.bookstore.visual.StarterView;
import javafx.application.Application;
import javafx.stage.Stage;
import codes.bookstore.texts.Warehouse;

public class Main extends Application{
    @Override
    public void start(Stage stage){
        stage.setTitle("Enter");
        stage.setScene(StarterView.startScene());
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args){
       Warehouse.ready();
       Application.launch(args);
    }
}