package bookstore.view.admin;

import bookstore.models.Bill;
import bookstore.models.people.Admin;
import bookstore.texts.Warehouse;
import bookstore.view.starter.StarterView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class AdminView {
    public static Pane startScene(Admin adm){
        Pane pane = new Pane();
        HBox top = new HBox(100);
        VBox vbSDate = new VBox(20);
        Label lbSDate = new Label("Starting date");
        TextField tfSDate = new TextField("DD/MM/YYYY");
        vbSDate.getChildren().addAll(lbSDate,tfSDate);
        VBox vbEDate = new VBox(20);
        Label lbEDate = new Label("Ending date");
        TextField tfEDate = new TextField("DD/MM/YYYY");
        vbEDate.getChildren().addAll(lbEDate,tfEDate);
        Button btFilter = new Button("Filter");
        btFilter.setMinHeight(70);
        btFilter.setMinWidth(150);
        top.setAlignment(Pos.CENTER);
        top.getChildren().addAll(vbSDate,btFilter,vbEDate);
        VBox mid = new VBox(50);
        mid.setAlignment(Pos.CENTER);
        HBox topping = new HBox(150);
        topping.setAlignment(Pos.CENTER);
        double revenue=0,costs=0,profit=0;
        for(Bill x: Warehouse.getBills()){
            if(x.isSelling())revenue+=x.getTotalPrice();
            else costs+=x.getTotalPrice();
        }
        profit = revenue-costs;
        Label lbRevenue = new Label("Revenue: "+revenue);
        Label lbCosts = new Label("Costs: "+costs);
        Label lbProfit = new Label("Profit "+profit);
        lbProfit.setAlignment(Pos.CENTER);
        topping.getChildren().addAll(lbRevenue,lbCosts);
        mid.getChildren().addAll(topping,lbProfit);
        HBox bott = new HBox(50);
        Button btLogOut = new Button("Log out");
        btLogOut.setMinWidth(150);
        btLogOut.setMinHeight(70);
        Button btEmployees = new Button("Employees");
        btEmployees.setMinWidth(150);
        btEmployees.setMinHeight(70);
        bott.getChildren().addAll(btEmployees,btLogOut);
        bott.setAlignment(Pos.CENTER);
        VBox setting= new VBox(100);
        setting.setPadding(new Insets(150,0,0,170));
        setting.getChildren().addAll(top,mid,bott);
        pane.getChildren().add(setting);
        btLogOut.setOnAction(e->btLogOut.getScene().setRoot(StarterView.startScene()));
        btEmployees.setOnAction(e->btEmployees.getScene().setRoot(EmployeeChartView.startScene(adm)));
        btFilter.setOnAction(e->{
            double[] rcp = Warehouse.getIncome(tfEDate.getText(),tfSDate.getText());
            lbRevenue.setText("Revenue: "+rcp[0]);
            lbCosts.setText("Costs: "+rcp[1]);
            lbProfit.setText("Profit: "+rcp[2]);
        });
        return pane;
    }
}
