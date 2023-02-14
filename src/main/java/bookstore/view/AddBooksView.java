package bookstore.view;

import bookstore.models.attributes.Author;
import bookstore.models.attributes.Category;
import bookstore.texts.Warehouse;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public abstract class AddBooksView {
    public static Pane startScene(){
        Pane pane = new Pane();
        GridPane material = new GridPane();
        material.setHgap(25);
        material.setVgap(25);
        Label lbTitle = new Label("Title");
        lbTitle.setAlignment(Pos.BASELINE_CENTER);
        TextField tfTitle = new TextField();
        Label lbISBN = new Label("ISBN");
        lbISBN.setAlignment(Pos.BASELINE_CENTER);
        TextField tfISBN = new TextField();
        Label lbAuthor = new Label("Author");
        lbAuthor.setAlignment(Pos.BASELINE_CENTER);
        ComboBox<Author> cbAuthor = new ComboBox<>();
        cbAuthor.setItems(FXCollections.observableArrayList(Warehouse.getAuthors()));
        Label lbCategory = new Label("Category");
        lbCategory.setAlignment(Pos.BASELINE_CENTER);
        ComboBox<Category> cbCategory = new ComboBox<>();
        cbCategory.setItems(FXCollections.observableArrayList(Warehouse.getCategories()));
        Label lbPurchasedPrice = new Label("Purchased Price");
        lbPurchasedPrice.setAlignment(Pos.BASELINE_CENTER);
        TextField tfPurchasedPrice = new TextField();
        Label lbSellingPrice = new Label("Selling Price");
        lbSellingPrice.setAlignment(Pos.BASELINE_CENTER);
        TextField tfSellingPrice = new TextField();
        Button btNewBook = new Button("Add New Book");
        btNewBook.setMinWidth(150);
        btNewBook.setMinHeight(70);
        Button btBack = new Button("Back");
        btBack.setMinWidth(150);
        btBack.setMinHeight(70);
        Button btNewCatAuth = new Button("New Category/Author");
        btNewCatAuth.setMinWidth(150);
        btNewCatAuth.setMinHeight(70);
        material.add(lbTitle,0,0);
        material.add(tfTitle,1,0);
        material.add(lbISBN,2,0);
        material.add(tfISBN,3,0);
        material.add(lbAuthor,0,1);
        material.add(cbAuthor,1,1);
        material.add(lbCategory,2,1);
        material.add(cbCategory,3,1);
        material.add(lbPurchasedPrice,0,2);
        material.add(tfPurchasedPrice,1,2);
        material.add(lbSellingPrice,2,2);
        material.add(tfSellingPrice,3,2);
        material.setAlignment(Pos.CENTER);
        HBox buttons = new HBox(30);
        buttons.getChildren().addAll(btNewBook,btNewCatAuth,btBack);
        buttons.setAlignment(Pos.CENTER);
        VBox setting = new VBox(50);
        setting.setPadding(new Insets(200,0,0,220));
        setting.getChildren().addAll(material,buttons);
        pane.getChildren().add(setting);
        btBack.setOnAction(e->btBack.getScene().setRoot(BookStockView.startScene()));
        btNewBook.setOnAction(e->{});
        btNewCatAuth.setOnAction(e->btNewCatAuth.getScene().setRoot(NewCatAuthView.startScene()));
        return pane;
    }
}
