package bookstore.view.admin;

import bookstore.models.people.AccessLevel;
import bookstore.models.people.Admin;
import bookstore.models.people.User;
import bookstore.texts.Warehouse;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public abstract class EmployeeChartView {
    public static Pane startScene(Admin adm){
        Pane pane = new Pane();
        HBox top = new HBox(70);
        VBox filt = new VBox(20);
        Pane center = new Pane();
        HBox bottom = new HBox(50);
        Label lbName = new Label("Name");
        TextField tfName = new TextField();
        Button btFilter = new Button("Filter");
        btFilter.setMinWidth(150);
        btFilter.setMinHeight(70);
        filt.getChildren().addAll(lbName,tfName);
        top.getChildren().addAll(filt,btFilter);
        TableView<User> tvStocks = new TableView<>();
        tvStocks.setMinWidth(800);
        tvStocks.setMinHeight(400);
        AtomicReference<ArrayList<User>> employeeList = new AtomicReference<>(new ArrayList<>());
        for(User x:Warehouse.getUsers()){
            if(x.getAccessLevel() != AccessLevel.ADMIN){
                employeeList.get().add(x);
            }
        }
        tvStocks.setItems(FXCollections.observableArrayList(employeeList.get()));
        TableColumn<User,String> tcName = new TableColumn<>("Name");
        tcName.setMaxWidth(150);
        tcName.setMinWidth(150);
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<User,String> tcUser = new TableColumn<>("Username");
        tcUser.setMaxWidth(150);
        tcUser.setMinWidth(150);
        tcUser.setCellValueFactory(new PropertyValueFactory<>("username"));
        TableColumn<User,Double> tcSalary = new TableColumn<>("Salary");
        tcSalary.setMaxWidth(100);
        tcSalary.setMinWidth(100);
        tcSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        TableColumn<User,String> tcBDay = new TableColumn<>("Birthday");
        tcBDay.setMaxWidth(100);
        tcBDay.setMinWidth(100);
        tcBDay.setCellValueFactory(c-> new SimpleStringProperty(Warehouse.showDate(c.getValue().getbDay())));
        TableColumn<User,String> tcPhoneNo = new TableColumn<>("Phone number");
        tcPhoneNo.setMaxWidth(100);
        tcPhoneNo.setMinWidth(100);
        tcPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        TableColumn<User,String> tcEmail = new TableColumn<>("Email");
        tcEmail.setMaxWidth(100);
        tcEmail.setMinWidth(100);
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<User,String> tcLevel = new TableColumn<>("Level");
        tcLevel.setMaxWidth(100);
        tcLevel.setMinWidth(100);
        tcLevel.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getAccessLevel().toString()));
        tvStocks.getColumns().addAll(tcName,tcUser,tcEmail,tcPhoneNo,tcSalary,tcBDay,tcLevel);
        center.getChildren().add(tvStocks);
        Button btDelete = new Button("Delete Employee(s)");
        btDelete.setMinWidth(150);
        btDelete.setMinHeight(70);
        Button btNewEmp = new Button("New Employee");
        btNewEmp.setMinWidth(150);
        btNewEmp.setMinHeight(70);
        Button btBack = new Button("Back");
        btBack.setMinWidth(150);
        btBack.setMinHeight(70);
        Button btEdit = new Button("Edit Employee");
        btEdit.setMinWidth(150);
        btEdit.setMinHeight(70);
        bottom.getChildren().addAll(btNewEmp,btDelete,btBack,btEdit);
        bottom.setAlignment(Pos.BASELINE_LEFT);
        VBox looks = new VBox(50);
        looks.setPadding(new Insets(50,0,0,80));
        looks.getChildren().addAll(top,center,bottom);
        pane.getChildren().add(looks);
        looks.setAlignment(Pos.CENTER);
        btBack.setOnAction(e-> btBack.getScene().setRoot(AdminView.startScene(adm)));
        btFilter.setOnAction(e->{
            employeeList.set(Warehouse.filterEmployees(tfName.getText()));
            tvStocks.setItems(FXCollections.observableArrayList(employeeList.get()));
        });
        btDelete.setOnAction(e->{
            employeeList.set(Warehouse.deleteEmployees(tvStocks.getSelectionModel().getSelectedItems()));
                tvStocks.setItems(FXCollections.observableArrayList(employeeList.get()));
        });
        btNewEmp.setOnAction(e->btNewEmp.getScene().setRoot(SignUpView.startScene(adm)));
        btEdit.setOnAction(e->{
            if(tvStocks.getSelectionModel().getSelectedItems().size() != 0){
                btEdit.getScene().setRoot(EditEmployeeView.startScene(adm,tvStocks.getSelectionModel().getSelectedItems().get(0)));
            }
        });
        return pane;
    }
}
