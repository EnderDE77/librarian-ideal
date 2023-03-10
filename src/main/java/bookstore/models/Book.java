package bookstore.models;

import bookstore.models.attributes.Author;
import bookstore.models.attributes.Category;
import javafx.beans.property.*;

import java.io.Serial;
import java.io.Serializable;

public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 58008;
    private transient StringProperty title;
    private String titleP;
    private Author author;
    private Category category;
    private transient StringProperty ISBN;
    private String ISBNP;
    private transient StringProperty supplier;
    private String supplierP;
    private transient DoubleProperty purchasedPrice;
    private Double purchasedPriceP;
    private transient DoubleProperty sellingPrice;
    private Double sellingPriceP;
    private transient IntegerProperty stock;
    private Integer stockP;

    public Book(String title, Author author, Category category, String ISBN, String supplier,double purchasedPrice, double sellingPrice, int stock) {
        this.titleP = title;
        this.author = author;
        this.category = category;
        this.ISBNP = ISBN;
        this.supplierP = supplier;
        this.purchasedPriceP = purchasedPrice;
        this.sellingPriceP = sellingPrice;
        this.stockP = stock;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.setAuthor(author);
    }

    public String getTitle() {
        if(this.title == null)setTitle(titleP);
        return title.get();
    }


    public void setTitle(String title) {
        this.title = new SimpleStringProperty(title);
        this.titleP = title;
    }

    public Category getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category.setCategory(category);
    }

    public String getISBN() {
        if(this.ISBN == null)setISBN(ISBNP);
        return ISBN.get();
    }


    public void setISBN(String ISBN) {
        this.ISBN = new SimpleStringProperty(ISBN);
        this.ISBNP = ISBN;
    }

    public String getSupplier() {
        if(this.supplier == null)setSupplier(supplierP);
        return supplier.get();
    }

    public void setSupplier(String supplier) {
        this.supplier = new SimpleStringProperty(supplier);
        this.supplierP = supplier;
    }

    public double getPurchasedPrice() {
        if(this.purchasedPrice == null)setPurchasedPrice(purchasedPriceP);
        return purchasedPrice.get();
    }


    public void setPurchasedPrice(double purchasedPrice) {
        this.purchasedPrice = new SimpleDoubleProperty(purchasedPrice);
        this.purchasedPriceP = purchasedPrice;
    }

    public double getSellingPrice() {
        if(this.sellingPrice == null)setSellingPrice(sellingPriceP);
        return sellingPrice.get();
    }


    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = new SimpleDoubleProperty(sellingPrice);
        this.sellingPriceP = sellingPrice;
    }

    public int getStock() {
        if(this.stock == null)setStock(stockP);
        return stock.get();
    }


    public void setStock(int stock) {
        this.stock = new SimpleIntegerProperty(stock);
        this.stockP = stock;
    }
    @Override
    public String toString() {
        return getTitle()+" "+getISBN()+" "+getAuthor()+" "+getSellingPrice();
    }

}
