package bookstore.view;

import bookstore.models.Book;
import bookstore.texts.Warehouse;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import bookstore.models.people.Manager;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public abstract class AddExistingBooksView {
    public static Pane startScene(Manager man){
        Pane pane = new Pane();
        VBox inner = new VBox(20);
        inner.setAlignment(Pos.CENTER);
        inner.setPadding(new Insets(20));
        pane.getChildren().add(inner);
        HBox top = new HBox(20);
        top.setAlignment(Pos.CENTER);
        Label lbISBN = new Label("ISBN");
        TextField tfISBN = new TextField();
        Label lbTitle = new Label("Title");
        TextField tfTitle = new TextField();
        Label lbAmount = new Label("Amount");
        TextField tfAmount = new TextField("1");
        top.getChildren().addAll(lbISBN,tfISBN,lbTitle,tfTitle,lbAmount,tfAmount);
        HBox mid = new HBox(20);
        mid.setAlignment(Pos.CENTER);
        TableView<Book> table = new TableView<>();
        table.setMinWidth(1000);
        table.setMaxWidth(1000);
        ArrayList<Book> bill = new ArrayList<>();
        table.setItems(FXCollections.observableArrayList(bill));
        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setMinWidth(250);
        titleCol.setMaxWidth(250);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Book, String> ISBNCol = new TableColumn<>("ISBN");
        ISBNCol.setMinWidth(250);
        ISBNCol.setMaxWidth(250);
        ISBNCol.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        TableColumn<Book, Double> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(250);
        priceCol.setMaxWidth(250);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("purchasedPrice"));
        TableColumn<Book,Integer> stockCol = new TableColumn<>("Stock");
        stockCol.setMinWidth(250);
        stockCol.setMaxWidth(250);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        table.getColumns().addAll(titleCol,ISBNCol,priceCol);
        mid.getChildren().add(table);
        HBox bott = new HBox(20);
        bott.setAlignment(Pos.CENTER);
        Label lbTotal = new Label("Total");
        Label lbPrice = new Label("0.00");
        Button btSell = new Button("Sell");
        Button btEnter= new Button("Enter");
        Button btExit = new Button("Exit");
        bott.getChildren().addAll(lbTotal,lbPrice,btEnter,btSell,btExit);
        inner.getChildren().addAll(top,mid,bott);
        btEnter.setOnAction(e->{
            boolean isEntered = Warehouse.enterBook(bill,tfTitle.getText(),tfISBN.getText(),tfAmount.getText());
            if(isEntered){
                lbPrice.setText(String.valueOf(Warehouse.getTotalBobPrice(bill)));
            }
            tfTitle.clear();
            tfISBN.clear();
            tfAmount.clear();
        });
        btSell.setOnAction(e->{
            boolean isSold = Warehouse.createBob(man,bill);
            if(isSold){
                lbPrice.setText("0");
                bill.clear();
            }
        });
        btExit.setOnAction(e-> btExit.getScene().setRoot(ManagerView.startScene(man)));
        return pane;
    }
}
