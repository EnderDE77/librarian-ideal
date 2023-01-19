package codes.library.insider;

import java.util.Date;
public class Librarian{
    private String pass;
    private int ID;
    private String name;
    private Date bDay;
    private String PhoneNo;
    private String email;
    private double salary;
    private AccessLevel accessLevel;
    public Librarian(String pass,int ID,String name,Date bDay,String phoneNo,String email, double salary){
        setPass(pass);
        setName(name);
        setbDay(bDay);
        setPhoneNo(phoneNo);
        setEmail(email);
        setSalary(salary);
        setAccessLevel(accessLevel);
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
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
    public String getPass(){
        return this.pass;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
}