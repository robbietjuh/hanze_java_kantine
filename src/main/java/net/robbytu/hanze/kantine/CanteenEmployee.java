package net.robbytu.hanze.kantine;

import java.util.Random;

/**
 * Created by Dylan on 12-12-2014.
 */
public class CanteenEmployee extends Person
{
    private int employeeNumber;
    private boolean canUseCashRegister;

    /**
     * Initializes a new instance of the CanteenEmployee class
     * without any parameters
     */
    public CanteenEmployee()
    {
        Random random = new Random();

        this.employeeNumber = random.nextInt(9999 - 1000) + 1000;
        this.canUseCashRegister = (random.nextInt(2) == 0);
    }

    public CanteenEmployee(int employeeNumber, boolean canUseCashRegister,  int bsn, String firstname, String lastname, int day, int month, int year, char gender)
    {
        super();

        this.setBsn(bsn);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setBirthdate(day, month, year);
        this.setGender(gender);

        this.employeeNumber = employeeNumber;
        this.canUseCashRegister = canUseCashRegister;
    }

    public int getEmployeeNumber()
    {
        return this.employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber)
    {
        this.employeeNumber = employeeNumber;
    }

    public boolean getCanUseCashRegister()
    {
        return this.canUseCashRegister;
    }

    public void setCanUseCashRegister(boolean canUseCashRegister)
    {
        this.canUseCashRegister = canUseCashRegister;
    }

    /**
     * This method overrides the method in Person
     * and prints employeeNumber and canUseCashRegister
     */
    @Override
    public void printDetails()
    {
        System.out.println("Details for the canteen employee with employeenumber: " + this.employeeNumber);
        System.out.println("This employee " + (canUseCashRegister ? "is" : "is not") + " allowed to operate the cash register.");
    }
}
