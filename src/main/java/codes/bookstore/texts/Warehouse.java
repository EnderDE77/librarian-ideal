package codes.bookstore.texts;

import codes.bookstore.insider.Book;
import codes.bookstore.insider.Bill;
import codes.bookstore.insider.people.Librarian;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
//TODO: add the amount of bills to WHE and use it as a STATIC value
public abstract class Warehouse {
    private static ArrayList<Librarian> librarians = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();
    public static void ready() {
        try {
            //File whe = new File("src/main/java/codes/library/texts/WHE.txt");
            File libs = new File("src/main/java/codes/library/texts/people/librarians.txt");
           // File mans = new File("src/main/java/codes/library/texts/people/managers.txt");
           // File adms = new File("src/main/java/codes/library/texts/people/administrators.txt");
           // File boks = new File("src/main/java/codes/library/texts/books.txt");
            Scanner input = new Scanner(libs);
            for (; input.hasNext(); ) {
                String lib = input.nextLine();
                Scanner in = new Scanner(lib);
                //librarians.add(new Librarian(in.next(),in.nextInt(),in.next(),new Date(in.next()),in.next(),in.next(),in.nextDouble(),in.nextBoolean()));
                System.out.println(librarians.get(0));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

}