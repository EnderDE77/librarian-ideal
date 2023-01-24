package codes.bookstore.insider.people;

import java.util.Date;
public class Librarian extends User{

    public Librarian(String username, String pass, int id, String name, Date bDay, String phoneNo, String email, double salary){
        super(username, pass, id, name, bDay, phoneNo, email, salary);

    }
}