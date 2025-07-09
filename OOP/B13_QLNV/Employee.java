package OOP.B13_QLNV;

import java.util.List;

public abstract class Employee {
    private String ID;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private Employee_type employeeType;
    private static int employee_count = 0;
    List<Certificate> certificates;
    enum Employee_type {
        Experience, Fresher , Intern
    }
    public Employee(String id, String fullName, String birthDay, String phone, String email, Employee_type employeeType, List<Certificate> certificates) {
        this.ID = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        employee_count++;
        this.certificates = certificates;
    }
    public String getID() {
        return ID;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Employee_type getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(Employee_type employeeType) {
        this.employeeType = employeeType;
    }
    public static int getEmployeeCount() {
        return employee_count;
    }

    public abstract void ShowInfo();
}
