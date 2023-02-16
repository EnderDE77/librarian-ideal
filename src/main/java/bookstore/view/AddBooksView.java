package bookstore.view;

import bookstore.models.attributes.Author;
import bookstore.models.attributes.Category;
import bookstore.models.people.Manager;
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
    public static Pane startScene(Manager man){
        Pane pane = new Pane();
        GridPane material = new GridPane();
        material.setHgap(25);
        material.setVgap(25);
        Label lbTitle = new Label("Title");
        TextField tfTitle = new TextField();
        Label lbISBN = new Label("ISBN");
        TextField tfISBN = new TextField();
        Label lbAuthor = new Label("Author");
        ComboBox<Author> cbAuthor = new ComboBox<>();
        cbAuthor.setItems(FXCollections.observableArrayList(Warehouse.getAuthors()));
        Label lbCategory = new Label("Category");
        ComboBox<Category> cbCategory = new ComboBox<>();
        cbCategory.setItems(FXCollections.observableArrayList(Warehouse.getCategories()));
        Label lbPurchasedPrice = new Label("Purchased Price");
        TextField tfPurchasedPrice = new TextField();
        Label lbSellingPrice = new Label("Selling Price");
        TextField tfSellingPrice = new TextField();
        Label lbSupplier = new Label("Supplier");
        TextField tfSupplier = new TextField();
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
        material.add(lbSupplier,0,3);
        material.add(tfSupplier,1,3);
        material.setAlignment(Pos.CENTER);
        HBox buttons = new HBox(30);
        buttons.getChildren().addAll(btNewBook,btNewCatAuth,btBack);
        buttons.setAlignment(Pos.CENTER);
        Label lbSuccess = new Label("");
        lbSuccess.setAlignment(Pos.CENTER);
        VBox setting = new VBox(80);
        setting.setPadding(new Insets(200,0,0,220));
        setting.getChildren().addAll(material,lbSuccess,buttons);
        pane.getChildren().add(setting);
        btBack.setOnAction(e->btBack.getScene().setRoot(BookStockView.startScene(man)));
        btNewBook.setOnAction(e->{
            boolean isCreated = Warehouse.createBook(tfTitle.getText(),cbAuthor.getValue(),cbCategory.getValue(),tfISBN.getText(),tfSupplier.getText(),tfPurchasedPrice.getText(),tfSellingPrice.getText());
            if(isCreated){
                lbSuccess.setText("New Book added");
            }
            else{
                lbSuccess.setText("Failed");
            }
            tfISBN.clear();
            tfTitle.clear();
            tfSupplier.clear();
            tfPurchasedPrice.clear();
            tfSellingPrice.clear();
        });
        btNewCatAuth.setOnAction(e->btNewCatAuth.getScene().setRoot(NewCatAuthView.startScene(man)));
        return pane;
    }
}
