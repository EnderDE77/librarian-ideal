package codes.bookstore.view;

import codes.bookstore.models.people.Manager;
import javafx.scene.layout.Pane;

public abstract class ManagerView {
    public static Pane startScene(Manager man){
        Pane pane = new Pane();
        return pane;
    }
}
