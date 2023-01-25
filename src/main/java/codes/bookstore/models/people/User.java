package codes.bookstore.models.people;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {
    private String username;
    private String pass;
    private int ID;
    private String name;
    private Date bDay;
    private String PhoneNo;
    private String email;
    private double salary;
    private AccessLevel accessLevel;

    public User(String username, String pass, int id, String name, Date bDay, String phoneNo, String email, double salary,AccessLevel accessLevel) {
        this.username = username;
        this.pass = pass;
        this.ID = id;
        this.name = name;
        this.bDay = bDay;
        this.PhoneNo = phoneNo;
        this.email = email;
        this.salary = salary;
        this.accessLevel = accessLevel;
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
        return bDay;
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
    @Override
    public String toString() {
        Calendar time = Calendar.getInstance();
        time.setTime(bDay);
        return getUsername()+" "+getPass()+" "+getID()+" "+getName()+" "+time.get(Calendar.YEAR)+" "+getPhoneNo()+" "+getSalary()+" "+getAccessLevel().toString();
    }
}
