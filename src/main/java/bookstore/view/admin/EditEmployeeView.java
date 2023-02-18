package bookstore.view.admin;

import bookstore.models.people.AccessLevel;
import bookstore.models.people.Admin;
import bookstore.models.people.User;
import bookstore.texts.Warehouse;
import bookstore.view.starter.StarterView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Calendar;

public abstract class EditEmployeeView {
    public static Pane startScene(Admin adm, User usr){
        Pane pane = new VBox(20);

        GridPane name = new GridPane();
        Label lbName = new Label("Name");
        TextField tfName = new TextField(usr.getName());
        name.add(lbName,0,0);
        name.add(tfName,0,1);
        name.setAlignment(Pos.CENTER);

        GridPane username = new GridPane();
        Label lbUser = new Label("Username");
        TextField tfUser = new TextField(usr.getUsername());
        username.add(lbUser,0,0);
        username.add(tfUser,0,1);
        username.setAlignment(Pos.CENTER);

        GridPane pass = new GridPane();
        Label lbPass = new Label("Password");
        TextField tfPass = new TextField(usr.getPass());
        pass.add(lbPass,0,0);
        pass.add(tfPass,0,1);
        pass.setAlignment(Pos.CENTER);

        GridPane confPass = new GridPane();
        Label lbConfPass = new Label("Confirm Password");
        PasswordField tfConfPass = new PasswordField();
        confPass.add(lbConfPass,0,0);
        confPass.add(tfConfPass,0,1);
        confPass.setAlignment(Pos.CENTER);

        Calendar time = Calendar.getInstance();
        time.setTime(usr.getbDay());
        GridPane bDay = new GridPane();
        Label lbBDay = new Label("Birthday");
        TextField tfBDay = new TextField(time.get(Calendar.DAY_OF_MONTH)+"/"+time.get(Calendar.MONTH)+"/"+time.get(Calendar.YEAR));
        bDay.add(lbBDay,0,0);
        bDay.add(tfBDay,0,1);
        bDay.setAlignment(Pos.CENTER);

        GridPane eMail = new GridPane();
        Label lbEMail = new Label("E-mail");
        TextField tfEmail = new TextField(usr.getEmail());
        eMail.add(lbEMail,0,0);
        eMail.add(tfEmail,0,1);
        eMail.setAlignment(Pos.CENTER);

        GridPane phoneNo = new GridPane();
        Label lbPhoneNo = new Label("Phone Number");
        TextField tfPhoneNo = new TextField(usr.getPhoneNo());
        phoneNo.add(lbPhoneNo,0,0);
        phoneNo.add(tfPhoneNo,0,1);
        phoneNo.setAlignment(Pos.CENTER);

        GridPane salary = new GridPane();
        Label lbSalary = new Label("Salary");
        TextField tfSalary = new TextField(String.valueOf(usr.getSalary()));
        salary.add(lbSalary,0,0);
        salary.add(tfSalary,0,1);
        salary.setAlignment(Pos.CENTER);

        GridPane bts = new GridPane();
        bts.setHgap(20);
        Button btLogIn = new Button("Back");
        btLogIn.setMinWidth(150);
        btLogIn.setMinHeight(70);
        Button btSignUp = new Button("Edit");
        btSignUp.setMinWidth(150);
        btSignUp.setMinHeight(70);
        bts.add(btLogIn,0,0);
        bts.add(btSignUp,1,0);
        bts.setAlignment(Pos.BOTTOM_CENTER);

        HBox test = new HBox();
        Label txt = new Label("");
        test.setAlignment(Pos.CENTER);
        test.getChildren().add(txt);

        pane.getChildren().addAll(name,bDay,phoneNo,username,eMail,pass,confPass,salary,bts,test);
        pane.setPadding(new Insets(80, 15, 25, 15));

        btSignUp.setOnAction(e->{
            String isSignedIn = Warehouse.editUser(usr,tfUser.getText(),tfPass.getText(),tfName.getText(),tfBDay.getText(),tfEmail.getText(),tfPhoneNo.getText(),tfConfPass.getText(),tfSalary.getText());
            txt.setText(isSignedIn);
        });
        btLogIn.setOnAction(e-> btLogIn.getScene().setRoot(EmployeeChartView.startScene(adm)));

        return pane;
    }
}
