package bookstore.view.manager;

import bookstore.models.Bill;
import bookstore.models.people.AccessLevel;
import bookstore.models.people.Librarian;
import bookstore.models.people.Manager;
import bookstore.models.people.User;
import bookstore.texts.Warehouse;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public abstract class StatisticsView {
    public static Pane startScene(Manager man){
        Pane pane = new Pane();
        HBox top = new HBox(70);
        VBox sDate = new VBox(30);
        Label lbSDate = new Label("Starting date");
        TextField tfSDate = new TextField("DD/MM/YYYY");
        sDate.getChildren().addAll(lbSDate,tfSDate);
        VBox eDate = new VBox(30);
        Label lbEDate = new Label("Starting date");
        TextField tfEDate = new TextField("DD/MM/YYYY");
        eDate.getChildren().addAll(lbEDate,tfEDate);
        Button btFilter = new Button("Filter");
        btFilter.setMinHeight(70);
        btFilter.setMinWidth(150);
        top.getChildren().addAll(sDate,btFilter,eDate);
        top.setAlignment(Pos.CENTER);
        Pane mid = new Pane();
        TableView<Librarian> tvTimeStats = new TableView<>();
        ArrayList<Librarian> material = new ArrayList<>();
        for(User x:Warehouse.getUsers()){
            if(x.getAccessLevel()== AccessLevel.LIBRARIAN)material.add((Librarian) x);
        }
        ArrayList<Bill> filtered = new ArrayList<>();
        for(Bill x: Warehouse.getBills()){
            if(x.isSelling())filtered.add(x);
        }
        tvTimeStats.setItems(FXCollections.observableArrayList(material));
        tvTimeStats.setMinHeight(490);
        tvTimeStats.setMinWidth(880);
        TableColumn<Librarian,String> tcName = new TableColumn<>("Name");
        tcName.setMaxWidth(220);
        tcName.setMinWidth(220);
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Librarian,Integer> tcNoOfTotalBillsSold = new TableColumn<>("Bills sold");
        tcNoOfTotalBillsSold.setMaxWidth(220);
        tcNoOfTotalBillsSold.setMinWidth(220);
        tcNoOfTotalBillsSold.setCellValueFactory(C ->{
            int cnt = 0;
            for(Bill x: filtered){
                if(x.getSellingUser().getID() == C.getValue().getID())cnt++;
            }
            return new SimpleIntegerProperty(cnt).asObject();
        });
        TableColumn<Librarian,Double> tcTotalMoney = new TableColumn<>("Money made");
        tcTotalMoney.setMaxWidth(220);
        tcTotalMoney.setMinWidth(220);
        tcTotalMoney.setCellValueFactory(C ->{
            double cnt = 0;
            for(Bill x: filtered){
                if(x.getSellingUser().getID() == C.getValue().getID())cnt+=x.getTotalPrice();
            }
            return new SimpleDoubleProperty(cnt).asObject();
        });
        TableColumn<Librarian,Integer> tcBooksSold = new TableColumn<>("Books sold");
        tcBooksSold.setMaxWidth(220);
        tcBooksSold.setMinWidth(220);
        tcBooksSold.setCellValueFactory(C ->{
            int cnt = 0;
            for(Bill x: filtered){
                if(x.getSellingUser().getID() == C.getValue().getID())cnt+=x.getSellingBooks().size();
            }
            return new SimpleIntegerProperty(cnt).asObject();
        });
        tvTimeStats.getColumns().addAll(tcName,tcNoOfTotalBillsSold,tcBooksSold,tcTotalMoney);
        mid.getChildren().add(tvTimeStats);
        HBox bott = new HBox(40);
        Button btBack = new Button("Back");
        btBack.setMinHeight(70);
        btBack.setMinWidth(150);
        bott.setAlignment(Pos.CENTER);
        bott.getChildren().addAll(btBack);
        VBox setting = new VBox(50);
        setting.setPadding(new Insets(0,0,0,70));
        setting.getChildren().addAll(top,mid,bott);
        pane.getChildren().add(setting);
        btBack.setOnAction(e->btBack.getScene().setRoot(ManagerView.startScene(man)));
        btFilter.setOnAction(e->{
            filtered.clear();
            for(Bill x:Warehouse.filterLibs(tfSDate.getText(),tfEDate.getText())){
                filtered.add(x);
            }
            tcTotalMoney.setCellValueFactory(C ->{
                double cnt = 0;
                for(Bill x: filtered){
                    if(x.getSellingUser().getID() == C.getValue().getID())cnt+=x.getTotalPrice();
                }
                return new SimpleDoubleProperty(cnt).asObject();
            });
            tcBooksSold.setCellValueFactory(C ->{
                int cnt = 0;
                for(Bill x: filtered){
                    if(x.getSellingUser().getID() == C.getValue().getID())cnt+=x.getSellingBooks().size();
                }
                return new SimpleIntegerProperty(cnt).asObject();
            });
            tcNoOfTotalBillsSold.setCellValueFactory(C ->{
                int cnt = 0;
                for(Bill x: filtered){
                    if(x.getSellingUser().getID() == C.getValue().getID())cnt++;
                }
                return new SimpleIntegerProperty(cnt).asObject();
            });
    });
        return pane;
    }
}
