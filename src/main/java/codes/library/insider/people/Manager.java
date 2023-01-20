package codes.library.insider.people;

import java.util.Date;
public class Manager extends Librarian{
    private boolean canEnter;
    public Manager(String pass, int ID, String name, Date bDay, String phoneNo, String email, double salary, boolean canSell, boolean canEnter){
        super(pass,ID,name,bDay,phoneNo,email,salary,canSell);
        setCanEnter(this.canEnter);
    }

    public boolean isCanEnter() {
        return canEnter;
    }

    public void setCanEnter(boolean canEnter) {
        this.canEnter = canEnter;
    }
}
