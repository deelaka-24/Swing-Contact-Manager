package model;

public class Contact {
    private String id;
    private String name;
    private String phoneNumber;
    private String companyName;
    private double salary;
    private String birthday;

    public Contact(String id, String name, String phoneNumber, String companyName, double salary, String birthday) {
        setId(id);
        setName(name);
        setPhoneNumber(phoneNumber);
        setCompanyName(companyName);
        setSalary(salary);
        setBirthday(birthday);
    }

    // ---------------------- SETTERS --------------------------
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    // ---------------------- GETTERS --------------------------
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getBirthday() {
        return this.birthday;
    }
}