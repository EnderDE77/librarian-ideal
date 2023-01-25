package codes.bookstore.view;

import codes.bookstore.models.Book;
import codes.bookstore.models.people.Librarian;
import codes.bookstore.texts.Warehouse;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public abstract class SellingView {
    public static Scene startScene(Librarian lib){
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
        table.setItems(FXCollections.observableArrayList(Warehouse.getBooks()));
        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        TableColumn<Book, String> ISBNCol = new TableColumn<>("ISBN");
        ISBNCol.setCellValueFactory(new PropertyValueFactory<Book,String>("ISBN"));
        TableColumn<Book, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<Book,Double>("sellingPrice"));
        table.getColumns().addAll(titleCol,ISBNCol,priceCol);
        mid.getChildren().add(table);
        HBox bott = new HBox(20);
        bott.setAlignment(Pos.CENTER);
        Label lbTotal = new Label("Total");
        Label lbPrice = new Label("");
        Button btSell = new Button("Sell");
        Button btEnter= new Button("Enter");
        Button btExit = new Button("Exit");
        bott.getChildren().addAll(lbTotal,lbPrice,btEnter,btSell,btExit);
        inner.getChildren().addAll(top,mid,bott);
        return new Scene(pane,700,550);
    }
}
