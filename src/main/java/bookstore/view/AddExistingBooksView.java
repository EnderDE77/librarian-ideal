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
        ArrayList<Book> bob = new ArrayList<>();
        table.setItems(FXCollections.observableArrayList(bob));
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
        priceCol.setCellValueFactory(new PropertyValueFactory<>("purchasedPrice"));
        TableColumn<Book,Integer> stockCol = new TableColumn<>("Stock");
        stockCol.setMinWidth(200);
        stockCol.setMaxWidth(200);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        table.getColumns().addAll(titleCol,ISBNCol,priceCol,stockCol);
        mid.getChildren().add(table);
        HBox bott = new HBox(20);
        bott.setAlignment(Pos.CENTER);
        Label lbTotal = new Label("Total");
        Label lbPrice = new Label("0.00");
        Button btSell = new Button("Buy");
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
            boolean isEntered = Warehouse.enterBobBook(bob,tfTitle.getText(),tfISBN.getText(),tfAmount.getText());
            if(isEntered){
                lbPrice.setText(String.valueOf(Warehouse.getTotalBobPrice(bob)));
                table.setItems(FXCollections.observableArrayList(bob));
            }
            tfTitle.clear();
            tfISBN.clear();
            tfAmount.setText("1");
        });
        btSell.setOnAction(e->{
            boolean isSold = Warehouse.createBob(man,bob);
            if(isSold){
                lbPrice.setText(String.valueOf(Warehouse.getTotalBobPrice(bob)));
                bob.clear();
                table.setItems(FXCollections.observableArrayList(bob));
            }
        });
        btExit.setOnAction(e-> btExit.getScene().setRoot(ManagerView.startScene(man)));
        return pane;
    }
}
