package bookstore.texts;

import bookstore.models.Book;
import bookstore.models.Bill;
import bookstore.models.people.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.out;

public abstract class Warehouse {
    private static SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();
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
            fOut.close();
            oOut.close();
         } catch (IOException e) {
            throw new RuntimeException(e);
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
        }
        return true;
    }
}