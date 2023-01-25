package codes.bookstore.models.people;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {
    private SimpleStringProperty username;
    private SimpleStringProperty pass;
    private SimpleIntegerProperty ID;
    private SimpleStringProperty name;
    private Date bDay;
    private SimpleStringProperty phoneNo;
    private SimpleStringProperty email;
    private SimpleDoubleProperty salary;
    private AccessLevel accessLevel;

    public User(String username, String pass, int id, String name, Date bDay, String phoneNo, String email, double salary,AccessLevel accessLevel) {
        this.username = new SimpleStringProperty(username);
        this.pass = new SimpleStringProperty(pass);
        this.ID = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.bDay = bDay;
        this.phoneNo = new SimpleStringProperty(phoneNo);
        this.email = new SimpleStringProperty(email);
        this.salary = new SimpleDoubleProperty(salary);
        this.accessLevel = accessLevel;
    }
    public int getID(){
        return this.ID.get();
    }
    public void setID(int ID){
        this.ID.set(ID);
    }
    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public Date getbDay() {
        return bDay;
    }
    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }
    public String getPhoneNo() {
        return phoneNo.get();
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo.set(phoneNo);
    }
    public String getEmail() {
        return email.get();
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    public double getSalary() {
        return salary.get();
    }
    public void setSalary(double salary) {
        this.salary.set(salary);
    }
    public String getPass(){
        return this.pass.get();
    }
    public void setPass(String pass){
        this.pass.set(pass);
    }
    public String getUsername() {
        return username.get();
    }
    public void setUsername(String username) {
        this.username.set(username);
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
