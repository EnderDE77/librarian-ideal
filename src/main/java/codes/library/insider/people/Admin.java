package codes.library.insider.people;

import java.util.Date;

public class Admin extends Manager{
    public Admin(String pass, int ID, String name, Date bDay, String phoneNo, String email, double salary,boolean canSell,boolean canEnter){
        super(pass,ID,name,bDay,phoneNo,email,salary,canSell,canEnter);
    }
}
