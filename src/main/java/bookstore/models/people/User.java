package bookstore.models.people;

import javafx.beans.property.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {
    private transient StringProperty username;
    private String usernameP;
    private transient StringProperty pass;
    private String passP;
    private transient IntegerProperty ID;
    private Integer IDP;
    private transient StringProperty name;
    private String nameP;
    private Date bDay;
    private transient StringProperty phoneNo;
    private String phoneNoP;
    private transient StringProperty email;
    private String emailP;
    private transient DoubleProperty salary;
    private Double salaryP;
    private AccessLevel accessLevel;

    public User(String username, String pass, int id, String name, Date bDay, String phoneNo, String email, double salary,AccessLevel accessLevel) {
        this.usernameP = username;
        setUsername(username);
        this.passP = pass;
        setPass(pass);
        this.IDP = id;
        setID(id);
        this.nameP = name;
        setName(name);
        this.bDay = bDay;
        this.phoneNoP = phoneNo;
        setPhoneNo(phoneNo);
        this.emailP = email;
        setEmail(email);
        this.salaryP = salary;
        setSalary(salary);
        this.accessLevel = accessLevel;
    }
    public int getID(){
        if(this.ID == null)setID(IDP);
        return this.ID.get();
    }
    public void setID(int ID){
        this.ID = new SimpleIntegerProperty(ID);
        this.IDP = ID;
    }
    public String getName() {
        if(this.name == null)setName(nameP);
        return name.get();
    }
    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
        this.nameP = name;
    }
    public Date getbDay() {
        return bDay;
    }
    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }
    public String getPhoneNo() {
        if(this.phoneNo == null)setPhoneNo(phoneNoP);
        return phoneNo.get();
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = new SimpleStringProperty(phoneNo);
        this.phoneNoP = phoneNo;
    }
    public String getEmail() {
        if(this.email == null)setEmail(emailP);
        return email.get();
    }
    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
        this.emailP = email;
    }
    public double getSalary() {
        if(this.salary == null)setSalary(salaryP);
        return salary.get();
    }
    public void setSalary(double salary) {
        this.salary = new SimpleDoubleProperty(salary);
        this.salaryP = salary;
    }
    public String getPass(){
        if(this.pass == null)setPass(passP);
        return this.pass.get();
    }
    public void setPass(String pass){
        this.pass = new SimpleStringProperty(pass);
        this.passP = pass;
    }
    public String getUsername() {
        if(this.username == null)setUsername(usernameP);
        return this.username.get();
    }
    public void setUsername(String username) {
        this.username = new SimpleStringProperty(username);
        this.usernameP = username;
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
