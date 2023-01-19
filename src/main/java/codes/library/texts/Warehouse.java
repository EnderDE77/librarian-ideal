package codes.library.texts;

import codes.library.insider.Book;
import codes.library.insider.Bill;
import codes.library.insider.Librarian;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
                try (Scanner in = new Scanner(lib)) {
                    people.add(new Librarian(in.next(), in.nextInt(), in.next(), new Date(in.next()), in.next(), in.next(), in.nextDouble()));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}