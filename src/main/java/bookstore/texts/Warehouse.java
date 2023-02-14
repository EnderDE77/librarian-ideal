package bookstore.texts;

import bookstore.models.Book;
import bookstore.models.Bill;
import bookstore.models.attributes.Author;
import bookstore.models.attributes.Category;
import bookstore.models.people.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.out;

public abstract class Warehouse {
    private static final SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();
    private static ArrayList<Author> authors = new ArrayList<>();
    private static ArrayList<Category> categories = new ArrayList<>();
    private static final File fUsers = new File("src/main/java/bookstore/texts/bin/users.dat");
    private static final File fBooks = new File("src/main/java/bookstore/texts/bin/books.dat");
    private static final File fBills = new File("src/main/java/bookstore/texts/bin/bills.dat");
    private static final File fWHE = new File("src/main/java/bookstore/texts/bin/WHE.dat");
    public static void ready() {
        try {
            FileInputStream  out;
            ObjectInputStream objOut;
            out = new FileInputStream(fUsers);
            objOut = new ObjectInputStream(out);
            users = (ArrayList<User>) objOut.readObject();
            out = new FileInputStream(fBooks);
            objOut = new ObjectInputStream(out);
            books = (ArrayList<Book>) objOut.readObject();
            out = new FileInputStream(fBills);
            objOut = new ObjectInputStream(out);
            bills = (ArrayList<Bill>) objOut.readObject();
            out = new FileInputStream(fWHE);
            objOut = new ObjectInputStream(out);
            authors = (ArrayList<Author>) objOut.readObject();
            categories = (ArrayList<Category>) objOut.readObject();
            out.close();
            objOut.close();
        } catch (IOException | ClassNotFoundException e) {
            out.println(e);
        }
    }
    public static User searchUser(String username,String pass){
        for(User x: getUsers()){
            if(x.getUsername().equals(username)&&x.getPass().equals(pass)){
                return x;
            }
        }
        return null;
    }
    public static ArrayList<Book> getBooks(){
        return books;
    }
    public static ArrayList<User> getUsers(){
        return users;
    }
    public static ArrayList<Bill> getBills(){
        return bills;
    }
    public static ArrayList<Author> getAuthors() {
        return authors;
    }
    public static ArrayList<Category> getCategories(){
        return categories;
    }

    public static void finish(){
        try{
            FileOutputStream fOut;
            ObjectOutputStream oOut;
            fOut = new FileOutputStream(fUsers);
            oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(getUsers());
            fOut = new FileOutputStream(fBooks);
            oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(getBooks());
            fOut = new FileOutputStream(fBills);
            oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(getBills());
            fOut = new FileOutputStream(fWHE);
            oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(getAuthors());
            oOut.writeObject(getCategories());
            fOut.close();
            oOut.close();
         } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static boolean createUser(String username, String pass, String name, String bDay, String email,String phoneNo, AccessLevel accessLevel,String confPass){
        if(!bDay.matches("\\d{2}/\\d{2}/\\d{4}"))return false;
        if(!(searchUser(username,pass) == null))return false;
        if(!email.matches("\\w+@\\w+\\.\\w+"))return false;
        if(!pass.equals(confPass))return false;
        if(!phoneNo.matches("06[6-9]\\d{7}"))return false;
        if(username.length()==0||pass.length()==0||name.length()==0)return false;
        try {
        switch(accessLevel){
            case LIBRARIAN -> users.add(new Librarian(username,pass,users.size()+1000,name,dateFor.parse(bDay),phoneNo,email,20000));
            case   MANAGER -> users.add(new Manager  (username,pass,users.size()+1000,name,dateFor.parse(bDay),phoneNo,email,40000));
            case     ADMIN -> users.add(new Admin    (username,pass,users.size()+1000,name,dateFor.parse(bDay),phoneNo,email,80000));
            }
        } catch (ParseException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    public static Book searchBook(String title, String ISBN) {
        for(Book x:getBooks()){
            if(x.getISBN().equals(ISBN)||x.getTitle().equals(title))
                return x;
        }
        return null;
    }
    public static boolean enterBook(ArrayList<Book> bill,String title,String ISBN,String amount){
        Book adder = searchBook(title,ISBN);
        if(adder == null) return false;
        if(!amount.matches("\\d+"))return false;
        if(Integer.parseInt(amount) < adder.getStock())return false;
        for(int i=0;i<Integer.parseInt(amount);i++){
            bill.add(adder);
        }
        return true;
    }
    public static double getTotalPrice(ArrayList<Book> bill){
        double sum = 0;
        for(Book x:bill){
            sum+=x.getSellingPrice();
        }
        return sum;
    }

    public static boolean createBill(Librarian lib, ArrayList<Book> bill) {
        String order = "src/main/java/bookstore/texts/bills/Bill"+(bills.size()+1)+".txt";
        File fOrder = new File(order);
        try {
            if(!fOrder.createNewFile())return false;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        Bill billy = new Bill(bills.size()+1,lib,bill,true);
        try(PrintWriter out = new PrintWriter(fOrder)) {
            out.println(billy);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return false;
        }
        bills.add(billy);
        return true;
    }

}