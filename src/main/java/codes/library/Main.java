package codes.library;

import codes.library.visual.Starter;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.geometry.*;
public class Main extends Application{
    @Override
    public void start(Stage stage){
        stage.setTitle("Enter");
        stage.setScene(Starter.startScene());
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args){
       // Warehouse.ready();
        Application.launch(args);
    }
}