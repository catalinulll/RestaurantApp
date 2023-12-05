package Factory;

import java.util.Date;

public class EmployeeFactory {
    public static Employee createEmployee(int ID, String name, String address, Date hireDate, String phoneNumber, EmployeeType employeeType) {
        return new Employee(ID, name, address, hireDate, phoneNumber, employeeType);
    }
}
