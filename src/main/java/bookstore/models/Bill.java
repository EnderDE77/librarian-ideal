package bookstore.models;

import bookstore.models.people.User;
import bookstore.texts.Warehouse;
import javafx.beans.property.*;

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
    private final User sellingUser;
    private ArrayList<Book> sellingBooks;
    private final Date dateOfTransaction;
    private transient DoubleProperty totalPrice;
    private Double totalPriceP;
    private transient BooleanProperty selling;
    private Boolean sellingP;
    public Bill(int billID,User sellingLibrarian, ArrayList<Book> sellingBooks,boolean selling) {
        this.sellingP = selling;
        this.billIDP = billID;
        this.sellingUser = sellingLibrarian;
        this.sellingBooks = new ArrayList<>();
        this.sellingBooks.addAll(sellingBooks);
        this.dateOfTransaction = new Date();
        setTotalPrice(0.0);
        if (selling) {
            for (Book x : sellingBooks) {
                Warehouse.getBooks().get(Warehouse.getBooks().indexOf(x)).setStock(Warehouse.getBooks().get(Warehouse.getBooks().indexOf(x)).getStock()-1);
                setTotalPrice(getTotalPrice() + x.getSellingPrice());
            }
        }
        else{
            for (Book x : sellingBooks) {
                Warehouse.getBooks().get(Warehouse.getBooks().indexOf(x)).setStock(Warehouse.getBooks().get(Warehouse.getBooks().indexOf(x)).getStock()+1);
                setTotalPrice(getTotalPrice() + x.getPurchasedPrice());
            }
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

    private void setTotalPrice(double totalPrice) {
        this.totalPrice = new SimpleDoubleProperty(totalPrice);
        this.totalPriceP = totalPrice;
    }
    public ArrayList<Book> getSellingBooks(){
        return sellingBooks;
    }

    public int getBillID() {
        if(this.billID == null)setBillID(billIDP);
        return this.billID.get();
    }
    public void setSelling(boolean selling){
        this.selling = new SimpleBooleanProperty(selling);
        this.sellingP = selling;
    }
    public boolean isSelling(){
        if(this.selling == null)setSelling(sellingP);
        return this.selling.get();
    }
    public User getSellingUser(){
        return this.sellingUser;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    @Override
    public String toString() {
        Calendar time = Calendar.getInstance();
        time.setTime(dateOfTransaction);
        StringBuilder bill = new StringBuilder();
        bill.append("Bill number "+this.getBillID()+"\n");
        bill.append("Date "+time.get(Calendar.DAY_OF_MONTH)+"/"+time.get(Calendar.MONTH)+"/"+time.get(Calendar.YEAR)+"/"+"\n");
        for(Book x:getSellingBooks()){
            bill.append(x.toString()+"\n");
        }
        bill.append("Total price: "+this.getTotalPrice()+"\n");
        bill.append("Librarian name: "+sellingUser.getName());
        return bill.toString();
    }

}
