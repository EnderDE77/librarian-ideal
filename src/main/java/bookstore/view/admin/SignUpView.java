package bookstore.view.admin;

import bookstore.models.people.AccessLevel;
import bookstore.models.people.Admin;
import bookstore.texts.Warehouse;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class SignUpView {
    public static Pane startScene(Admin adm){
        Pane pane = new VBox(20);

        GridPane name = new GridPane();
        Label lbName = new Label("Name");
        TextField tfName = new TextField();
        name.add(lbName,0,0);
        name.add(tfName,0,1);
        name.setAlignment(Pos.CENTER);

        GridPane username = new GridPane();
        Label lbUser = new Label("Username");
        TextField tfUser = new TextField();
        username.add(lbUser,0,0);
        username.add(tfUser,0,1);
        username.setAlignment(Pos.CENTER);

        GridPane pass = new GridPane();
        Label lbPass = new Label("Password");
        PasswordField tfPass = new PasswordField();
        pass.add(lbPass,0,0);
        pass.add(tfPass,0,1);
        pass.setAlignment(Pos.CENTER);

        GridPane confPass = new GridPane();
        Label lbConfPass = new Label("Confirm Password");
        PasswordField tfConfPass = new PasswordField();
        confPass.add(lbConfPass,0,0);
        confPass.add(tfConfPass,0,1);
        confPass.setAlignment(Pos.CENTER);

        GridPane bDay = new GridPane();
        Label lbBDay = new Label("Birthday");
        TextField tfBDay = new TextField("DD/MM/YYYY");
        bDay.add(lbBDay,0,0);
        bDay.add(tfBDay,0,1);
        bDay.setAlignment(Pos.CENTER);

        GridPane eMail = new GridPane();
        Label lbEMail = new Label("E-mail");
        TextField tfEmail = new TextField();
        eMail.add(lbEMail,0,0);
        eMail.add(tfEmail,0,1);
        eMail.setAlignment(Pos.CENTER);

        GridPane phoneNo = new GridPane();
        Label lbPhoneNo = new Label("Phone Number");
        TextField tfPhoneNo = new TextField();
        phoneNo.add(lbPhoneNo,0,0);
        phoneNo.add(tfPhoneNo,0,1);
        phoneNo.setAlignment(Pos.CENTER);

        GridPane accessLvl = new GridPane();
        accessLvl.setHgap(10);
        accessLvl.setVgap(20);
        Label lbLib = new Label("Librarian");
        RadioButton rbLib = new RadioButton();
        Label lbMan = new Label("Manager");
        RadioButton rbMan = new RadioButton();
        Label lbAdm = new Label("Administrator");
        RadioButton rbAdm = new RadioButton();
        ToggleGroup tgAccLvl = new ToggleGroup();
        rbLib.setToggleGroup(tgAccLvl);
        rbMan.setToggleGroup(tgAccLvl);
        rbAdm.setToggleGroup(tgAccLvl);
        rbLib.setSelected(true);
        accessLvl.add(lbLib,0,0);
        accessLvl.add(rbLib,1,0);
        accessLvl.add(lbMan,0,1);
        accessLvl.add(rbMan,1,1);
        accessLvl.add(lbAdm,0,2);
        accessLvl.add(rbAdm,1,2);
        accessLvl.setAlignment(Pos.CENTER);

        GridPane bts = new GridPane();
        bts.setHgap(20);
        Button btLogIn = new Button("Back");
        btLogIn.setMinWidth(150);
        btLogIn.setMinHeight(70);
        Button btSignUp = new Button("Create Employee");
        btSignUp.setMinWidth(150);
        btSignUp.setMinHeight(70);
        bts.add(btLogIn,0,0);
        bts.add(btSignUp,1,0);
        bts.setAlignment(Pos.BOTTOM_CENTER);

        HBox test = new HBox();
        Label txt = new Label("");
        test.setAlignment(Pos.CENTER);
        test.getChildren().add(txt);

        pane.getChildren().addAll(name,bDay,phoneNo,username,accessLvl,eMail,pass,confPass,bts,test);
        pane.setPadding(new Insets(80, 15, 25, 15));

        btSignUp.setOnAction(e->{
            AccessLevel a;
            if(rbMan.isSelected()){
                a = AccessLevel.MANAGER;
            }
            else if(rbAdm.isSelected()){
                a = AccessLevel.ADMIN;
            }
            else{
                a = AccessLevel.LIBRARIAN;
            }
            String isSignedIn = Warehouse.createUser(tfUser.getText(),tfPass.getText(),tfName.getText(),tfBDay.getText(),tfEmail.getText(),tfPhoneNo.getText(),a,tfConfPass.getText());
            tfEmail.clear();
            tfName.clear();
            tfBDay.clear();
            tfConfPass.clear();
            tfPhoneNo.clear();
            tfPass.clear();
            tfUser.clear();
            txt.setText(isSignedIn);
        });
        btLogIn.setOnAction(e-> btLogIn.getScene().setRoot(EmployeeChartView.startScene(adm)));

        return pane;
    }
}
