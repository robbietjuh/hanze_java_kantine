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
        super();

        Random random = new Random();

        this.employeeNumber = random.nextInt(9999 - 1000) + 1000;
        this.canUseCashRegister = (random.nextInt(2) == 0);
    }

    /**
     * Initializes a new instance of the CanteenEmployee class with specified properties
     * @param employeeNumber Unique ID for this employee
     * @param canUseCashRegister Wether or not this employee is allowed to use the cash register
     * @param bsn National security number
     * @param firstname First name
     * @param lastname Last name
     * @param day Birthdate -- day
     * @param month Birthdate -- month
     * @param year Birthdate -- year
     * @param gender Gender
     */
    public CanteenEmployee(int employeeNumber, boolean canUseCashRegister,  int bsn, String firstname,
                           String lastname, int day, int month, int year, char gender) {
        super(bsn, firstname, lastname, day, month, year, gender);

        this.employeeNumber = employeeNumber;
        this.canUseCashRegister = canUseCashRegister;
    }

    public int getEmployeeNumber() {
        return this.employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public boolean getCanUseCashRegister() {
        return this.canUseCashRegister;
    }

    public void setCanUseCashRegister(boolean canUseCashRegister) {
        this.canUseCashRegister = canUseCashRegister;
    }

    /**
     * This method overrides the method in Person
     * and prints employeeNumber and canUseCashRegister
     */
    @Override
    public void printDetails() {
        System.out.println("Details for the canteen employee with employeenumber: " + this.employeeNumber);
        System.out.println("This employee " + (canUseCashRegister ? "is" : "is not") + " allowed to operate the cash register.");
    }
}
