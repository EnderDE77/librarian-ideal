package bookstore.models;

import bookstore.models.people.Librarian;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Bill implements Serializable {
    @Serial
    private static final long serialVersionUID = 77777;
    private transient IntegerProperty billID;
    private Integer billIDP;
    private final Librarian sellingLibrarian;
    private final ArrayList<Book> sellingBooks;
    private final Date dateOfTransaction;
    private transient DoubleProperty totalPrice;
    private Double totalPriceP;

    public Bill(int billID,Librarian sellingLibrarian, ArrayList<Book> sellingBooks) {
        this.billIDP = billID;
        setBillID(billID);
        this.sellingLibrarian = sellingLibrarian;
        this.sellingBooks = sellingBooks;
        this.dateOfTransaction = new Date();
        setTotalPrice(0.0);
        for(Book x:sellingBooks){
            x.setStock(x.getStock()-1);
            setTotalPrice(getTotalPrice()+x.getSellingPrice());
        }
    }
    private void setBillID(int billID){
        this.billID = new SimpleIntegerProperty(billID);
        this.billIDP = billID;
    }
    public double getTotalPrice(){
        if(this.totalPrice == null)setTotalPrice(totalPriceP);
        return this.totalPrice.get();
    }

    private void setTotalPrice(Double totalPrice) {
        this.totalPrice = new SimpleDoubleProperty(totalPrice);
        this.totalPriceP = totalPrice;
    }

    public int getBillID() {
        if(this.billID == null)setBillID(billIDP);
        return billID.get();
    }
    public void addBook(Book bookSold){
        sellingBooks.add(bookSold);
    }
    @Override
    public String toString() {
        Calendar time = Calendar.getInstance();
        time.setTime(dateOfTransaction);
        StringBuilder bill = new StringBuilder();
        bill.append("Bill number "+this.getBillID()+"\n");
        for(Book x:sellingBooks){
            bill.append(x.toString()+"\n");
        }
        bill.append("Total price: "+this.getTotalPrice()+"\n");
        bill.append("Librarian name: "+sellingLibrarian.getName());
        return bill.toString();
    }

}
