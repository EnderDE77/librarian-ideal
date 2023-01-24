package codes.bookstore.insider.people;

import java.util.Date;

public class Admin extends User{
    public Admin(String username, String pass, int id, String name, Date bDay, String phoneNo, String email, double salary) {
        super(username, pass, id, name, bDay, phoneNo, email, salary);

    }
}
