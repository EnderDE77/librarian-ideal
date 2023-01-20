package codes.library.texts;

import codes.library.insider.Book;
import codes.library.insider.Bill;
import codes.library.insider.people.Librarian;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
//TODO: add the amount of bills to WHE and use it as a STATIC value
public abstract class Warehouse {
    private static ArrayList<Librarian> people;
    private static ArrayList<Book> books;
    private static ArrayList<Bill> bills;
    public void ready() {
        try {
            File whe = new File("WHE.txt");
            File libs = new File("people/librarians.txt");
            File mans = new File("people/managers.txt");
            File adms = new File("people/administrators.txt");
            File boks = new File("books.txt");
            Scanner input = new Scanner(libs);
            for (; input.hasNext(); ) {
                String lib = input.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}