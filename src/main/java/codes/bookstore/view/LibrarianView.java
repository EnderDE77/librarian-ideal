package codes.bookstore.view;

import codes.bookstore.models.Book;
import codes.bookstore.models.people.Librarian;
import codes.bookstore.texts.Warehouse;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public abstract class LibrarianView {
    public static Pane startScene(Librarian lib){
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
        table.setMinWidth(900);
        table.setMaxWidth(900);
        table.setItems(FXCollections.observableArrayList(Warehouse.getBooks()));
        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setMinWidth(300);
        titleCol.setMaxWidth(300);
        titleCol.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        TableColumn<Book, String> ISBNCol = new TableColumn<>("ISBN");
        ISBNCol.setMinWidth(300);
        ISBNCol.setMaxWidth(300);
        ISBNCol.setCellValueFactory(new PropertyValueFactory<Book,String>("ISBN"));
        TableColumn<Book, Double> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(300);
        priceCol.setMaxWidth(300);
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
        btEnter.setOnAction(e->{});
        btSell.setOnAction(e->{});
        btExit.setOnAction(e->{
            btExit.getScene().setRoot(StarterView.startScene());
        });
        return pane;
    }
}
