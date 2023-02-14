package bookstore.view;

import bookstore.models.Book;
import bookstore.models.people.Manager;
import bookstore.texts.Warehouse;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public abstract class ManagerView {
    public static Pane startScene(Manager man){
        Pane pane = new BorderPane();
        VBox left = new VBox(20);
        Button btAddBooks = new Button("Add Books");
        btAddBooks.setMinWidth(100);
        btAddBooks.setMinHeight(50);
        Button btBookStock = new Button("Book Stock");
        btBookStock.setMinWidth(100);
        btBookStock.setMinHeight(50);
        Button btLogOut = new Button("Log Out");
        btLogOut.setMinWidth(100);
        btLogOut.setMinHeight(50);
        Button btStatistics = new Button("Show\nStatistics");
        btStatistics.setMinWidth(100);
        btStatistics.setMinHeight(50);
        left.getChildren().addAll(btAddBooks,btBookStock,btLogOut,btStatistics);
        ArrayList<Book> u5 = new ArrayList<>();
        left.setLayoutX(25);
        left.setLayoutY(45);
        Pane center = new Pane();
        for(Book x : Warehouse.getBooks()){
            if(x.getStock()<=5){
                u5.add(x);
            }
        }
        TableView<Book> tvU5 = new TableView<>();
        tvU5.setMinWidth(660);
        tvU5.setItems(FXCollections.observableArrayList(u5));
        TableColumn<Book,String> bISBN = new TableColumn<>("ISBN");
        bISBN.setMaxWidth(220);
        bISBN.setMinWidth(220);
        bISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        TableColumn<Book,String> bName = new TableColumn<>("Title");
        bName.setMaxWidth(220);
        bName.setMinWidth(220);
        bName.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Book,Integer> bStock = new TableColumn<>("Stock");
        bStock.setMaxWidth(220);
        bStock.setMinWidth(220);
        bStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tvU5.getColumns().addAll(bISBN,bName,bStock);
        center.getChildren().add(tvU5);
        pane.getChildren().addAll(left,center);
        center.setLayoutX(150);
        btBookStock.setOnAction(e->btBookStock.getScene().setRoot(BookStockView.startScene()));
        btAddBooks.setOnAction(e->btAddBooks.getScene().setRoot(AddBooksView.startScene()));
        btLogOut.setOnAction(e->btLogOut.getScene().setRoot(StarterView.startScene()));
        btStatistics.setOnAction(e->btStatistics.getScene().setRoot(StatisticsView.startScene()));
        return pane;
    }
}
