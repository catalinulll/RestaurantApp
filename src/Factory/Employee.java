package Factory;

import java.util.Date;

public class Employee {
    private int ID;
    private String name;
    private String address;
    private Date hireDate;
    private String phoneNumber;
    private EmployeeType employeeType;

    public Employee(int ID, String name, String address, Date hireDate, String phoneNumber, EmployeeType employeeType) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.hireDate = hireDate;
        this.phoneNumber = phoneNumber;
        this.employeeType = employeeType;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
}
