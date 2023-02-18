package bookstore.texts;

import bookstore.models.Book;
import bookstore.models.Bill;
import bookstore.models.attributes.Author;
import bookstore.models.attributes.Category;
import bookstore.models.people.*;
import javafx.collections.ObservableList;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public abstract class Warehouse {
    private static int noOfBills;
    private static int noOfBobs;
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
            out = new FileInputStream(fWHE);
            objOut = new ObjectInputStream(out);
            authors = (ArrayList<Author>) objOut.readObject();
            categories = (ArrayList<Category>) objOut.readObject();
            out = new FileInputStream(fUsers);
            objOut = new ObjectInputStream(out);
            users = (ArrayList<User>) objOut.readObject();
            out = new FileInputStream(fBooks);
            objOut = new ObjectInputStream(out);
            books = (ArrayList<Book>) objOut.readObject();
            out = new FileInputStream(fBills);
            objOut = new ObjectInputStream(out);
            bills = (ArrayList<Bill>) objOut.readObject();
            out.close();
            objOut.close();
            for(Bill x: getBills()){
                if(x.isSelling())noOfBills++;
                else noOfBobs++;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
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
    public static User searchUser(String username,String pass){
        for(User x: getUsers()){
            if(x.getUsername().equals(username)&&x.getPass().equals(pass)){
                return x;
            }
        }
        return null;
    }

    public static String createUser(String username, String pass, String name, String bDay, String email,String phoneNo, AccessLevel accessLevel,String confPass){
        if(!bDay.matches("\\d{2}/\\d{2}/\\d{4}"))return "Wrong date format";
        if(!(searchUser(username,pass) == null))return "User already exists";
        if(!email.matches("\\w+@\\w+\\.\\w+\\.?\\w*"))return "Wrong email format";
        if(!pass.equals(confPass))return "check confirm password";
        if(!phoneNo.matches("06[6-9]\\d{7}"))return "Wrong phone number format";
        if(username.length()==0||pass.length()==0||name.length()==0)return "Empty spaces";
        try {
        switch(accessLevel){
            case LIBRARIAN -> users.add(new Librarian(username,pass,users.size()+1000,name,dateFor.parse(bDay),phoneNo,email,20000));
            case   MANAGER -> users.add(new Manager  (username,pass,users.size()+1000,name,dateFor.parse(bDay),phoneNo,email,40000));
            case     ADMIN -> users.add(new Admin    (username,pass,users.size()+1000,name,dateFor.parse(bDay),phoneNo,email,80000));
            }
        } catch (ParseException e) {
            return "Wrong date format";
        }
        return "User created successfully";
    }
    public static Book searchBook(String title, String ISBN) {
        for(Book x:getBooks()){
            if(x.getISBN().equals(ISBN)||x.getTitle().equals(title))
                return x;
        }
        return null;
    }
    public static boolean enterBillBook(ArrayList<Book> bill,String title,String ISBN,String amount){
        Book adder = searchBook(title,ISBN);
        if(adder == null) return false;
        if(!amount.matches("\\d+"))return false;
        if(Integer.parseInt(amount) > adder.getStock())return false;
        for(int i=0;i<Integer.parseInt(amount);i++){
            bill.add(adder);
        }
        return true;
    }
    public static boolean enterBobBook(ArrayList<Book> bill,String title,String ISBN,String amount){
        Book adder = searchBook(title,ISBN);
        if(adder == null) return false;
        if(!amount.matches("\\d+"))return false;
        for(int i=0;i<Integer.parseInt(amount);i++){
            bill.add(adder);
        }
        return true;
    }
    public static double getTotalBillPrice(ArrayList<Book> bill){
        double sum = 0;
        for(Book x:bill){
            sum+=x.getSellingPrice();
        }
        return sum;
    }
    public static double getTotalBobPrice(ArrayList<Book> bill){
        double sum = 0;
        for(Book x:bill){
            sum+=x.getPurchasedPrice();
        }
        return sum;
    }


    public static boolean createBill(Librarian lib, ArrayList<Book> bill) {
        if(bill.size()==0)return false;
        String order = "src/main/java/bookstore/texts/bills/Bill"+(noOfBills+1)+".txt";
        File fOrder = new File(order);
        try {
            if(!fOrder.createNewFile())return false;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        Bill billy = new Bill(noOfBills+1,lib,bill,true);
        try(PrintWriter out = new PrintWriter(fOrder)) {
            out.println(billy);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return false;
        }
        bills.add(billy);
        noOfBills++;
        return true;
    }

    public static boolean createCategory(String newCat) {
        if(newCat.length()==0)return false;
        for(Category x:getCategories()){
            if(newCat.equals(x.getCategory()))return false;
        }
        categories.add(new Category(newCat));
        return true;
    }

    public static boolean createAuthor(String newAuth) {
        if(newAuth.length()==0)return false;
        for(Author x:getAuthors()){
            if(newAuth.equals(x.getAuthor()))return false;
        }
        authors.add(new Author(newAuth));
        return true;
    }

    public static boolean createBob(Manager man, ArrayList<Book> bob) {
        if(bob.size()==0)return false;
        Bill bobby = new Bill(noOfBobs+1,man,bob,false);
        bills.add(bobby);
        return true;
    }

    public static boolean createBook(String title, Author author, Category category, String isbn, String supplier, String purchasedPriceS, String sellingPriceS) {
        if(searchBook(title,isbn) != null)return false;
        if(author.getAuthor().length() == 0)return false;
        if(category.getCategory().length() == 0)return false;
        if(supplier.length() == 0)return false;
        if(!isbn.matches("\\d{13}"))return false;
        double purchasedPr,sellingPr;
        try{
            purchasedPr = Double.parseDouble(purchasedPriceS);
            sellingPr = Double.parseDouble(sellingPriceS);
        } catch (NumberFormatException e) {
            return false;
        }
        books.add(new Book(title,author,category,isbn,supplier,purchasedPr,sellingPr,0));
        return true;
    }

    public static ArrayList<Book> filterBook(String ISBN, String title, Author author, Category category) {
        ArrayList<Book> tmp = new ArrayList<>();
        if(author == null||category == null) return tmp;
        for(Book x:getBooks()){
            if(x.getISBN().equals(ISBN)||x.getTitle().equals(title)||x.getAuthor().equals(author.getAuthor())||x.getCategory().equals(category.getCategory()))tmp.add(x);
        }
        return tmp;
    }

    public static ArrayList<Book> deleteBooks(ObservableList<Book> selectedItems) {
        ArrayList<Book> tmp = getBooks();
        for(Book x:selectedItems){
            for(Book y:getBooks()){
                if(x.getISBN().equals(y.getISBN())){
                    tmp.remove(x);
                }
            }
        }
        return tmp;
    }

    public static boolean editBook(Book book,String title, Author author, Category category, String isbn, String supplier, String purchasedPriceS, String sellingPriceS) {
        if(author.getAuthor().length() == 0)return false;
        if(category.getCategory().length() == 0)return false;
        if(supplier.length() == 0)return false;
        if(!isbn.matches("\\d{13}"))return false;
        double purchasedPr,sellingPr;
        try{
            purchasedPr = Double.parseDouble(purchasedPriceS);
            sellingPr = Double.parseDouble(sellingPriceS);
        } catch (NumberFormatException e) {
            return false;
        }
        book.setTitle(title);
        book.setAuthor(author.getAuthor());
        book.setCategory(category.getCategory());
        book.setISBN(isbn);
        book.setSupplier(supplier);
        book.setPurchasedPrice(purchasedPr);
        book.setSellingPrice(sellingPr);
        getBooks().set(getBooks().indexOf(book),book);
        return true;
    }

    public static ArrayList<Bill> filterLibs(String sDate, String eDate){
        ArrayList<Bill> tmp = new ArrayList<>();
        for(Bill x: getBills()){
            if(x.isSelling())
                tmp.add(x);
        }
        long iSDate,iEDate,iBDate;
        try {
            iSDate = dateFor.parse(sDate).getTime();
            iEDate = dateFor.parse(eDate).getTime();
        } catch (ParseException e) {
            System.out.println("This shit wrong mate");
            return tmp;
        }
        tmp.clear();
        for(Bill x:getBills()){
            iBDate = x.getDateOfTransaction().getTime();
            if(iBDate <= iEDate && iBDate >= iSDate)
                tmp.add(x);
        }
        return tmp;
    }

    public static ArrayList<User> filterEmployees(String name) {
        ArrayList<User> tmp = new ArrayList<>();
        for(User x:getUsers()){
            if(x.getAccessLevel() != AccessLevel.ADMIN && x.getName().matches(".*"+name+".*"))tmp.add(x);
        }
        return tmp;
    }

    public static ArrayList<User> deleteEmployees(ObservableList<User> selectedItems) {
        ArrayList<User> tmp = new ArrayList<>();
        for(User x:users){
            for(User y:selectedItems){
                if(x.getID() != y.getID()){
                    tmp.add(x);
                }
            }
        }
        users = tmp;
        return getUsers();
    }

    public static String editUser(User user, String username, String pass, String name, String bDay, String email, String phoneNo, String confPass, String salary) {
        if(!bDay.matches("\\d{2}/\\d{2}/\\d{4}"))return "Wrong date format";
        if(!(searchUser(username,pass) == null))return "User already exists";
        if(!email.matches("\\w+@\\w+\\.\\w+\\.?\\w*"))return "Wrong email format";
        if(!pass.equals(confPass))return "check confirm password";
        if(!phoneNo.matches("06[6-9]\\d{7}"))return "Wrong phone number format";
        if(username.length()==0||pass.length()==0||name.length()==0)return "Empty spaces";
        int index=0;
        double nSalary;
        for(User x:getUsers()){
            if(x.getID() == user.getID())break;
            index++;
        }
        Date dBDay;
        try{
            nSalary = Double.parseDouble(salary);
            dBDay =dateFor.parse(bDay);
        }catch (ParseException e){
            return "Wrong date format";
        }catch (NumberFormatException e){
            return "Wrong salary format";
        }
            user.setName(name);
            user.setUsername(username);
            user.setPass(pass);
            user.setName(name);
            user.setEmail(email);
            user.setPhoneNo(phoneNo);
            user.setbDay(dBDay);
            user.setSalary(nSalary);
            getUsers().set(index,user);
        return "User successfully edited";
    }

    public static double[] getIncome(String sSDate, String sEDate) {
        double[] tmp = new double[3];
        double revenue = 0;
        double cost = 0;
        double profit = 0;
        double sumOfSalaries = 0;
        for(User x:getUsers()){
            sumOfSalaries+=x.getSalary();
        }
        Date SDate,EDate;
        try {
            SDate = dateFor.parse(sSDate);
            EDate = dateFor.parse(sEDate);
        }catch(ParseException e){
            return tmp;
        }
        Calendar cSDate = Calendar.getInstance();
        cSDate.setTime(SDate);
        Calendar cEDate = Calendar.getInstance();
        cEDate.setTime(EDate);
        int monthDiff = (cEDate.get(Calendar.YEAR)*12+cEDate.get(Calendar.MONTH))-(cSDate.get(Calendar.YEAR)*12+cSDate.get(Calendar.MONTH));
        for(Bill x:getBills()){
            long time = x.getDateOfTransaction().getTime();
            if(time<=EDate.getTime() && time>=SDate.getTime()){
                if(x.isSelling()){
                    for(Book y: x.getSellingBooks())cost += y.getPurchasedPrice();
                    revenue += x.getTotalPrice();
                }
                else{
                    cost += x.getTotalPrice();
                }
            }
        }
        cost += monthDiff*sumOfSalaries;
        profit = revenue - cost;
        tmp[0]=revenue;
        tmp[1]=cost;
        tmp[2]=profit;
        return tmp;
    }

    public static String showDate(Date date) {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        return time.get(Calendar.DAY_OF_MONTH)+"/"+time.get(Calendar.MONTH)+"/"+time.get(Calendar.YEAR);
    }
}