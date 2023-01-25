package codes.bookstore.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

//TODO: Create class Book with the values and constructors
public class Book implements Serializable {
    private SimpleStringProperty title;
    private SimpleStringProperty author;
    private SimpleIntegerProperty noOfPages;
    private SimpleStringProperty category;
    private SimpleStringProperty ISBN;
    private SimpleStringProperty supplier;
    private SimpleDoubleProperty purchasedPrice;
    private SimpleDoubleProperty sellingPrice;
    private SimpleIntegerProperty stock;

    public Book(String title, String author, int noOfPages, String category, String isbn, String supplier, double purchasedPrice, double sellingPrice, int stock) {
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.noOfPages = new SimpleIntegerProperty(noOfPages);
        this.category = new SimpleStringProperty(category);
        this.ISBN = new SimpleStringProperty(isbn);
        this.supplier = new SimpleStringProperty(supplier);
        this.purchasedPrice = new SimpleDoubleProperty(purchasedPrice);
        this.sellingPrice = new SimpleDoubleProperty(sellingPrice);
        this.stock = new SimpleIntegerProperty(stock);
    }



    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getNoOfPages() {
        return noOfPages.get();
    }

    public SimpleIntegerProperty noOfPagesProperty() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages.set(noOfPages);
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getISBN() {
        return ISBN.get();
    }

    public SimpleStringProperty ISBNProperty() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN.set(ISBN);
    }

    public String getSupplier() {
        return supplier.get();
    }

    public SimpleStringProperty supplierProperty() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier.set(supplier);
    }

    public double getPurchasedPrice() {
        return purchasedPrice.get();
    }

    public SimpleDoubleProperty purchasedPriceProperty() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(double purchasedPrice) {
        this.purchasedPrice.set(purchasedPrice);
    }

    public double getSellingPrice() {
        return sellingPrice.get();
    }

    public SimpleDoubleProperty sellingPriceProperty() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice.set(sellingPrice);
    }

    public int getStock() {
        return stock.get();
    }

    public SimpleIntegerProperty stockProperty() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }
    @Override
    public String toString() {
        return getTitle()+" "+getISBN()+" "+getAuthor()+" "+getSellingPrice();
    }

}
