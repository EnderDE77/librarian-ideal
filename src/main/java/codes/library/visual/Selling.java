package codes.library.visual;

import codes.library.insider.people.Librarian;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public abstract class Selling {
    public static Scene sellScene(Librarian lib){
        BorderPane pane = new BorderPane();
        HBox top = new HBox(15);
        GridPane center = new GridPane();
        HBox bottom = new HBox(50);
        return new Scene(pane,1000,1000);
    }
}
