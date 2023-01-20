package codes.library.visual;

import codes.library.insider.people.Librarian;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class Selling {
    public static Scene sellScene(Librarian lib){
        Pane pane = new Pane();

        return new Scene(pane,1000,1000);
    }
}
