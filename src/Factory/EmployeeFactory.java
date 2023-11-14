package Factory;

import java.util.Date;

public class EmployeeFactory {
    public static Employee createWaiter(int ID, String name, String address, Date hireDate, String phoneNumber) {
        return new Waiter(ID, name, address, hireDate, phoneNumber);
    }

    public static Employee createChef(int ID, String name, String address, Date hireDate, String phoneNumber) {
        return new Chef(ID, name, address, hireDate, phoneNumber);
    }

    public static Employee createBarman(int ID, String name, String address, Date hireDate, String phoneNumber) {
        return new Barman(ID, name, address, hireDate, phoneNumber);
    }
}