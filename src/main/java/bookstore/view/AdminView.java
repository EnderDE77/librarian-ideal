package bookstore.view;

import bookstore.models.people.Admin;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public abstract class AdminView {
    public static Pane startScene(Admin admin){
        FlowPane pane = new FlowPane();
        //TODO: think on how to get total income and statistics, maybe add some manager buttons your choice, oh yea and find a way to alter users or straight up delete them. the bin IO is done mostly so the rest is doable
        Button btShowFinance = new Button("Show Finance");
        pane.getChildren().addAll(btShowFinance);
        return pane;
    }
}
