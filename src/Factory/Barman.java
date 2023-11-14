package Factory;

import java.util.Date;

public class Barman implements Employee {
    private int ID;
    private String name;
    private String address;
    private Date hireDate;
    private long phoneNumber;

    public Barman(int ID, String name, String address, Date hireDate, long phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.hireDate = hireDate;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public Date getHireDate() {
        return hireDate;
    }

    @Override
    public long getPhoneNumber() {
        return phoneNumber;
    }
}
