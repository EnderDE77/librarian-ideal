package codes.bookstore.view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class SignUpView {
    public Scene signUpScene(){
        Pane pane = new Pane();
        return new Scene(pane,500,250);
    }
}
