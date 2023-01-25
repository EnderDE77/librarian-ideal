package codes.bookstore.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public abstract class StarterView {
    public static Scene startScene(){
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

        return new Scene(pane,500,250);
    }
}
