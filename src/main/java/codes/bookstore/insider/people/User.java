package codes.bookstore.insider.people;

import java.io.Serializable;
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

    public User(String username, String pass, int id, String name, Date bDay, String phoneNo, String email, double salary) {
        this.username = username;
        this.pass = pass;
        this.ID = id;
        this.name = name;
        this.bDay = bDay;
        this.PhoneNo = phoneNo;
        this.email = email;
        this.salary = salary;
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

    @Override
    public String toString() {
        return getName()+" "+getID()+" "+getPhoneNo()+" "+getPass();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
