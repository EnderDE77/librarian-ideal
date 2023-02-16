package bookstore.models.attributes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serial;
import java.io.Serializable;

public class Author implements Serializable {
    @Serial
    private static final long serialVersionUID = 2048;
    private transient StringProperty author;
    private String authorP;
    public Author(String author){
        this.authorP = author;
        setAuthor(author);
    }

    public String getAuthor() {
        if(this.author == null)setAuthor(authorP);
        return this.author.get();
    }


    public void setAuthor(String author) {
        this.author = new SimpleStringProperty(author);
        this.authorP = author;
    }
    @Override
    public String toString() {
        return this.getAuthor();
    }
}
