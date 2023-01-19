package codes.library;

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
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(50, 15, 25, 15));


        HBox top = new HBox();
        TextField txtField = new TextField();
        top.setAlignment(Pos.CENTER);
        top.getChildren().add(txtField);

        HBox bottom = new HBox();
        Button btEnter = new Button("Enter");
        bottom.getChildren().add(btEnter);
        bottom.setAlignment(Pos.CENTER);

        pane.setTop(top);
        pane.setBottom(bottom);

        btEnter.setOnAction(e->{
            //Librarian whose = Warehouse.search(txtField.getCharacters().toString(),Warehouse.getPeople());
           // stage.setScene(Visuals.displayScene(whose));
        });

        Scene scene = new Scene(pane,500,250);
        stage.setTitle("Enter");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args){
       // Warehouse.ready();
        Application.launch(args);
    }
}