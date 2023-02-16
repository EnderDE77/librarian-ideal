package bookstore.view.librarian;

import bookstore.models.Book;
import bookstore.models.people.Librarian;
import bookstore.texts.Warehouse;
import bookstore.view.starter.StarterView;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

import java.util.ArrayList;

public abstract class LibrarianView {
    public static Pane startScene(Librarian lib){
        Pane pane = new Pane();
        VBox inner = new VBox(50);
        inner.setPadding(new Insets(90));
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
        table.setMinWidth(800);
        ArrayList<Book> bill = new ArrayList<>();
        table.setItems(FXCollections.observableArrayList(bill));
        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setMinWidth(200);
        titleCol.setMaxWidth(200);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Book, String> ISBNCol = new TableColumn<>("ISBN");
        ISBNCol.setMinWidth(200);
        ISBNCol.setMaxWidth(200);
        ISBNCol.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        TableColumn<Book, Double> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(200);
        priceCol.setMaxWidth(200);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        TableColumn<Book,Integer> stockCol = new TableColumn<>("Stock");
        stockCol.setMinWidth(200);
        stockCol.setMaxWidth(200);
        stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        table.getColumns().addAll(titleCol,ISBNCol,priceCol,stockCol);
        mid.getChildren().add(table);
        HBox bott = new HBox(20);
        bott.setAlignment(Pos.CENTER);
        Label lbTotal = new Label("Total");
        Label lbPrice = new Label("0.00");
        Button btSell = new Button("Sell");
        btSell.setMinWidth(150);
        btSell.setMinHeight(70);
        Button btEnter= new Button("Enter");
        btEnter.setMinWidth(150);
        btEnter.setMinHeight(70);
        Button btExit = new Button("Exit");
        btExit.setMinWidth(150);
        btExit.setMinHeight(70);
        bott.getChildren().addAll(lbTotal,lbPrice,btEnter,btSell,btExit);
        inner.getChildren().addAll(top,mid,bott);
        btEnter.setOnAction(e->{
            boolean isEntered = Warehouse.enterBillBook(bill,tfTitle.getText(),tfISBN.getText(),tfAmount.getText());
            if(isEntered){
                table.setItems(FXCollections.observableArrayList(bill));
                lbPrice.setText(String.valueOf(Warehouse.getTotalBillPrice(bill)));
            }
            tfTitle.clear();
            tfISBN.clear();
            tfAmount.setText("1");
        });
        btSell.setOnAction(e->{
            boolean isSold = Warehouse.createBill(lib,bill);
            if(isSold){
                lbPrice.setText("0.00");
                bill.clear();
                table.setItems(FXCollections.observableArrayList(bill));
            }
        });
        btExit.setOnAction(e-> btExit.getScene().setRoot(StarterView.startScene()));
        return pane;
    }
}
