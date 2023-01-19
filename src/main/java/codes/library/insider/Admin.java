package codes.library.insider;

import java.util.Date;

public class Admin extends Manager{
    public Admin(String pass, int ID, String name, Date bDay, String phoneNo, String email, double salary){
        super(pass,ID,name,bDay,phoneNo,email,salary);
    }
}
