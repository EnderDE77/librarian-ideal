package bookstore.view;

import bookstore.models.people.Manager;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class ManagerView {
    public static Pane startScene(Manager man){
        Pane pane = new BorderPane();
        VBox left = new VBox(20);
        Button btAddBooks = new Button("Add Books");
        return pane;
    }
}
