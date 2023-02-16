package bookstore.view;

import bookstore.models.people.Manager;
import bookstore.texts.Warehouse;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class NewCatAuthView {
    public static Pane startScene(Manager man){
        Pane pane = new Pane();
        Label lbCategory = new Label("Category");
        Label lbAuthor = new Label("Author");
        Label lbCSuccess = new Label("");
        Label lbASuccess = new Label("");
        Button btNewCategory = new Button("Add Category");
        btNewCategory.setMinHeight(70);
        btNewCategory.setMinWidth(150);
        Button btNewAuthor = new Button("Add Author");
        btNewAuthor.setMinHeight(70);
        btNewAuthor.setMinWidth(150);
        Button btBack = new Button("Back");
        btBack.setMinHeight(70);
        btBack.setMinWidth(150);
        TextField tfCategory = new TextField();
        TextField tfAuthor = new TextField();
        GridPane material = new GridPane();
        material.setHgap(60);
        material.setVgap(40);
        material.add(lbCategory,0,0);
        material.add(tfCategory,1,0);
        material.add(btNewCategory,2,0);
        material.add(lbCSuccess,3,0);
        material.add(lbAuthor,0,1);
        material.add(tfAuthor,1,1);
        material.add(btNewAuthor,2,1);
        material.add(lbASuccess,3,1);
        material.setAlignment(Pos.CENTER);
        HBox low = new HBox();
        low.setAlignment(Pos.CENTER);
        low.getChildren().add(btBack);
        VBox setting = new VBox(50);
        setting.setPadding(new Insets(200,0,0,210));
        setting.getChildren().addAll(material,low);
        pane.getChildren().add(setting);
        btNewCategory.setOnAction(e->{
            boolean isCreated = Warehouse.createCategory(tfCategory.getText());
            if(isCreated){
                lbCSuccess.setText("New Category Added");
            }
            else{
                lbCSuccess.setText("Failed");
            }
            tfCategory.clear();
        });
        btNewAuthor.setOnAction(e->{
            boolean isCreated = Warehouse.createAuthor(tfAuthor.getText());
            if(isCreated){
                lbASuccess.setText("New Author Added");
            }
            else{
                lbASuccess.setText("Failed");
            }
            tfAuthor.clear();
        });
        btBack.setOnAction(e->btBack.getScene().setRoot(AddBooksView.startScene(man)));
        return pane;
    }
}
