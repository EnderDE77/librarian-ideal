package codes.library.insider.people;

import java.util.Date;
public class Librarian{
    private String pass;
    private int ID;
    private String name;
    private Date bDay;
    private String PhoneNo;
    private String email;
    private double salary;
    private boolean canSell;
    /*TODO: Give the people permissions to do smth or not
    Perm1: selling
    Perm2: entering product
    Perm3: creating new book/category
     */
    public Librarian(String pass, int ID, String name, Date bDay, String phoneNo, String email, double salary, boolean canSell){
        setPass(pass);
        setName(name);
        setbDay(bDay);
        setPhoneNo(phoneNo);
        setEmail(email);
        setSalary(salary);
        setCanSell(canSell);
    }
    public int getID(){
        return this.ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getbDay() {
        return new Date(bDay.getTime());
    }
    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }
    public String getPhoneNo() {
        return PhoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getPass(){
        return this.pass;
    }
    public void setPass(String pass){
        this.pass = pass;
    }

    public boolean isCanSell() {
        return canSell;
    }

    public void setCanSell(boolean canSell) {
        this.canSell = canSell;
    }
}