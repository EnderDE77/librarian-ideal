package bookstore.view.manager;

import bookstore.models.Book;
import bookstore.models.attributes.Author;
import bookstore.models.attributes.Category;
import bookstore.models.people.Manager;
import bookstore.texts.Warehouse;
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

public abstract class BookStockView {
    public static Pane startScene(Manager man){
        Pane pane = new Pane();
        HBox top = new HBox(70);
        VBox filt = new VBox(20);
        VBox filt2 = new VBox(20);
        VBox filt3 = new VBox(20);
        Pane center = new Pane();
        HBox bottom = new HBox(50);
        Label lbTitle = new Label("Title");
        TextField tfTitle = new TextField();
        Label lbISBN = new Label("ISBN");
        TextField tfISBN = new TextField();
        Button btFilter = new Button("Filter");
        btFilter.setMinWidth(150);
        btFilter.setMinHeight(70);
        ComboBox<Author> aths = new ComboBox<>();
        aths.setItems(FXCollections.observableArrayList(Warehouse.getAuthors()));
        ComboBox<Category> cats = new ComboBox<>();
        cats.setItems(FXCollections.observableArrayList(Warehouse.getCategories()));
        filt.getChildren().addAll(aths,cats);
        filt2.getChildren().addAll(lbTitle,tfTitle);
        filt3.getChildren().addAll(lbISBN,tfISBN);
        top.getChildren().addAll(filt2,filt3,btFilter,filt);
        TableView<Book> tvStocks = new TableView<>();
        tvStocks.setMinWidth(800);
        tvStocks.setMaxWidth(800);
        tvStocks.setMinHeight(400);
        AtomicReference<ArrayList<Book>> areMade = new AtomicReference<>(Warehouse.getBooks());
        tvStocks.setItems(FXCollections.observableArrayList(areMade.get()));
        TableColumn<Book,String> tcISBN = new TableColumn<>("ISBN");
        tcISBN.setMinWidth(160);
        tcISBN.setMaxWidth(160);
        tcISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        TableColumn<Book,String> tcName = new TableColumn<>("Name");
        tcName.setMinWidth(150);
        tcName.setMaxWidth(150);
        tcName.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Book,String> tcAuthor = new TableColumn<>("Author");
        tcAuthor.setMinWidth(140);
        tcAuthor.setMaxWidth(140);
        tcAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        TableColumn<Book,String> tcCategory = new TableColumn<>("Category");
        tcCategory.setMinWidth(100);
        tcCategory.setMaxWidth(100);
        tcCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn<Book,Double> tcPurchasedPrice = new TableColumn<>("P/P");
        tcPurchasedPrice.setMinWidth(100);
        tcPurchasedPrice.setMaxWidth(100);
        tcPurchasedPrice.setCellValueFactory(new PropertyValueFactory<>("purchasedPrice"));
        TableColumn<Book,Double> tcSellingPrice = new TableColumn<>("S/P");
        tcSellingPrice.setMinWidth(100);
        tcSellingPrice.setMaxWidth(100);
        tcSellingPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        TableColumn<Book,Integer> tcStock = new TableColumn<>("Stc");
        tcStock.setMinWidth(50);
        tcStock.setMaxWidth(50);
        tcStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tvStocks.getColumns().addAll(tcISBN,tcName,tcAuthor,tcCategory,tcPurchasedPrice,tcSellingPrice,tcStock);
        center.getChildren().add(tvStocks);
        Button btDelete = new Button("Delete Book(s)");
        btDelete.setMinWidth(150);
        btDelete.setMinHeight(70);
        Button btNewBook = new Button("New Book");
        btNewBook.setMinWidth(150);
        btNewBook.setMinHeight(70);
        Button btBack = new Button("Back");
        btBack.setMinWidth(150);
        btBack.setMinHeight(70);
        Button btEdit = new Button("Edit Book");
        btEdit.setMinWidth(150);
        btEdit.setMinHeight(70);
        bottom.getChildren().addAll(btNewBook,btDelete,btBack,btEdit);
        bottom.setAlignment(Pos.BASELINE_LEFT);
        VBox looks = new VBox(50);
        looks.setPadding(new Insets(50,0,0,80));
        looks.getChildren().addAll(top,center,bottom);
        pane.getChildren().add(looks);
        looks.setAlignment(Pos.CENTER);
        btBack.setOnAction(e-> btBack.getScene().setRoot(ManagerView.startScene(man)));
        btFilter.setOnAction(e->{
            areMade.set(Warehouse.filterBook(tfISBN.getText(), tfTitle.getText(), aths.getValue(), cats.getValue()));
            tvStocks.setItems(FXCollections.observableArrayList(areMade.get()));
        });
        btDelete.setOnAction(e->{
            areMade.set(Warehouse.deleteBooks(tvStocks.getSelectionModel().getSelectedItems()));
            tvStocks.setItems(FXCollections.observableArrayList(areMade.get()));
        });
        btNewBook.setOnAction(e->btNewBook.getScene().setRoot(AddBooksView.startScene(man)));
        btEdit.setOnAction(e->{
            if(tvStocks.getSelectionModel().getSelectedItems().size() != 0){
                btEdit.getScene().setRoot(BookEditView.startScene(man,tvStocks.getSelectionModel().getSelectedItems().get(0)));
            }
        });
        return pane;
    }
}
