package bookstore.models.attributes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serial;
import java.io.Serializable;

public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1984;
    private StringProperty category;
    private String categoryP;
    public Category(String category){
        this.categoryP = category;
        setCategory(category);
    }

    public String getCategory() {
        if(this.category == null)setCategory(categoryP);
        return this.category.get();
    }
    public void setCategory(String author) {
        this.category = new SimpleStringProperty(author);
        this.categoryP = author;
    }
}
