package codes.bookstore.models;
//TODO: Create class Book with the values and constructors
public class Book {
    private String title;
    private String author;
    private int noOfPages;
    private String category;
    private String ISBN;
    private String supplier;
    private double purchasedPrice;
    private double sellingPrice;
    private int stock;

    public Book(String title, String author, int noOfPages, String category, String isbn, String supplier, double purchasedPrice, double sellingPrice, int stock) {
        this.title = title;
        this.author = author;
        this.noOfPages = noOfPages;
        this.category = category;
        ISBN = isbn;
        this.supplier = supplier;
        this.purchasedPrice = purchasedPrice;
        this.sellingPrice = sellingPrice;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    @Override
    public String toString() {
        return getTitle()+" "+getISBN()+" "+getAuthor()+" "+getSellingPrice();
    }
}
