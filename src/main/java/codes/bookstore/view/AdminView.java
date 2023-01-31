package codes.bookstore.view;

import codes.bookstore.models.people.Admin;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public abstract class AdminView {
    public static Pane startScene(Admin admin){
        FlowPane pane = new FlowPane();
        Button btShowFinance = new Button("Show Finance");
        pane.getChildren().addAll(btShowFinance);
        return pane;
    }
}
