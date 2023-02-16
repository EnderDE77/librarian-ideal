package bookstore.view;

import bookstore.models.people.Admin;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public abstract class AdminView {
    //TODO: think how will Adnin look (most likely like Manager)
    public static Pane startScene(Admin admin){
        FlowPane pane = new FlowPane();
        Button btShowFinance = new Button("Show Finance");
        pane.getChildren().addAll(btShowFinance);
        return pane;
    }
}
