package bookstore.view.starter;

import bookstore.models.people.Admin;
import bookstore.models.people.Librarian;
import bookstore.models.people.Manager;
import bookstore.models.people.User;
import bookstore.texts.Warehouse;
import bookstore.view.admin.AdminView;
import bookstore.view.librarian.LibrarianView;
import bookstore.view.manager.ManagerView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class StarterView {
    public static Pane startScene(){
        Pane pane = new VBox(50);
        pane.setPadding(new Insets(120, 15, 25, 15));


        HBox top = new HBox(20);
        Label lbUser = new Label("Username");
        TextField tfUser = new TextField();
        top.setAlignment(Pos.CENTER);
        top.getChildren().addAll(lbUser,tfUser);

        HBox middle = new HBox(20);
        Label lbPass = new Label("Password");
        PasswordField tfPass = new PasswordField();
        middle.setAlignment(Pos.CENTER);
        middle.getChildren().addAll(lbPass,tfPass);

        HBox bottom = new HBox(20);
        Button btEnter = new Button("Enter");
        btEnter.setMinWidth(150);
        btEnter.setMinHeight(70);
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(btEnter);

        HBox test = new HBox();
        Label lbTest = new Label("");
        test.getChildren().add(lbTest);
        test.setAlignment(Pos.CENTER);

        pane.getChildren().addAll(top,middle,bottom,test);

        btEnter.setOnAction(e->{
            User whose = Warehouse.searchUser(tfUser.getText(),tfPass.getText());
            tfUser.clear();
            tfPass.clear();
            if(whose != null){
                switch(whose.getAccessLevel()){
                    case LIBRARIAN ->
                            btEnter.getScene().setRoot(LibrarianView.startScene((Librarian) whose));
                    case MANAGER ->
                            btEnter.getScene().setRoot(ManagerView.startScene((Manager) whose));
                    case ADMIN ->
                            btEnter.getScene().setRoot(AdminView.startScene((Admin) whose));
                }
            }
            else{
                lbTest.setText("User does not exist");
            }
        });
        return pane;
    }
}
