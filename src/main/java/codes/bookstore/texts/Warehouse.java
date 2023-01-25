package codes.bookstore.texts;

import codes.bookstore.models.Book;
import codes.bookstore.models.Bill;
import codes.bookstore.models.people.Admin;
import codes.bookstore.models.people.Librarian;
import codes.bookstore.models.people.Manager;
import codes.bookstore.models.people.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//TODO: add the amount of bills to WHE and use it as a STATIC value
public abstract class Warehouse {
    static int noOfBills;
    static SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();
    public static void ready() {
        try {
            File whe = new File("src/main/java/codes/bookstore/texts/WHE.txt");
            File libs = new File("src/main/java/codes/bookstore/texts/people/librarians.txt");
            File mans = new File("src/main/java/codes/bookstore/texts/people/managers.txt");
            File adms = new File("src/main/java/codes/bookstore/texts/people/administrators.txt");
            File boks = new File("src/main/java/codes/bookstore/texts/books.txt");
            Scanner input = new Scanner(libs),in;
            while(input.hasNext()){
                in = new Scanner(input.nextLine());
                Librarian u = new Librarian(in.next(),in.next(),in.nextInt(),in.next(),dateFor.parse(in.next()),in.next(),in.next(),in.nextDouble());
                users.add(u);
                System.out.println(u);
                in.close();
            }
            input.close();
            input = new Scanner(mans);
            while(input.hasNext()){
                in = new Scanner(input.nextLine());
                Manager u = new Manager(in.next(),in.next(),in.nextInt(),in.next(),dateFor.parse(in.next()),in.next(),in.next(),in.nextDouble());
                users.add(u);
                System.out.println(u);
                in.close();
            }
            input.close();
            input = new Scanner(adms);
            while(input.hasNext()){
                in = new Scanner(input.nextLine());
                Admin u = new Admin(in.next(),in.next(),in.nextInt(),in.next(),dateFor.parse(in.next()),in.next(),in.next(),in.nextDouble());
                users.add(u);
                System.out.println(u);
                in.close();
            }
            input.close();
            input = new Scanner(boks);
            while(input.hasNext()){
                in = new Scanner(input.nextLine());
                Book u = new Book(in.next(),in.next(),in.nextInt(),in.next(),in.next(),in.next(),in.nextDouble(),in.nextDouble(),in.nextInt());
                books.add(u);
                System.out.println(u);
                in.close();
            }
            input.close();
            //WHE program
            input = new Scanner(whe);
            noOfBills = input.nextInt();
            input.nextLine();
            while(input.hasNext()){
                in = new Scanner(input.nextLine());

                in.close();
            }
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
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

    public static void finish(){
    }
}