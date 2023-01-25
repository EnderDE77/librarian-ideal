package codes.bookstore.models;

import codes.bookstore.models.people.Librarian;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Bill {
    private int billID;
    private Librarian sellingLibrarian;
    private ArrayList<Book> sellingBooks;
    private Date dateOfTransaction;
    private double totalPrice;

    public Bill(int billID,Librarian sellingLibrarian, ArrayList<Book> sellingBooks, Date dateOfTransaction) {
        this.billID = billID;
        this.sellingLibrarian = sellingLibrarian;
        this.sellingBooks = sellingBooks;
        this.dateOfTransaction = dateOfTransaction;
        this.totalPrice = totalPrice;
        for(Book x:sellingBooks){
            x.setStock(x.getStock()-1);
            totalPrice+=x.getSellingPrice();
        }
    }
    public double getTotalPrice(){
        return this.totalPrice;
    }

    public int getBillID() {
        return billID;
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
        bill.append("Total price: "+this.getTotalPrice());
        return bill.toString();
    }

}