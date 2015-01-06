package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */


/**
 * Person
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 18-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class Person {
    private int bsn;
    private String firstname;
    private String lastname;
    private int day;
    private int month;
    private int year;
    private char gender;
    private Tray tray;
    private PaymentMethod paymentMethod;

    /**
     * Initializes a new instance of the Person class
     * without any parameters
     */
    public Person() {
        this.setGender('O');
        this.setBirthdate(0, 0, 0);
    }

    /**
     * Initializes a new instance of the Person class
     * @param bsn National security number
     * @param firstname First name
     * @param lastname Last name
     * @param day Birthdate -- day
     * @param month Birthdate -- month
     * @param year Birthdate -- year
     * @param gender Gender
     */
    public Person(int bsn, String firstname, String lastname, int day, int month, int year, char gender) {
        this.setBsn(bsn);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setBirthdate(day, month, year);
        this.setGender(gender);
    }

    /**
     * Sets the national security number (BSN)
     * @param bsn National security number (BSN)
     */
    public void setBsn(int bsn) {
        this.bsn = bsn;
    }

    /**
     * Sets the first name
     * @param firstname Voornaam
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Sets the last name
     * @param lastname Achternaam
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Checks wether the birthdate is valid
     * @param day The day, should be between 01 and 31
     * @param month The month, should be between 01 and 12
     * @param year The year, should be between 1900 and 2100
     * @return Wether the birthdate is valid
     */
    private boolean checkBirthdate(int day, int month, int year) {
        int[] dagen = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if(year < 1900 || year > 2100) return false;
        if(month < 1 || month > 12) return false;

        //Check if year is a leap year and the date is 29th of febuary
        if(((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month == 2 && day == 29) return  true;
        if(day < 1 || day > dagen[month - 1]) return false;

        return true;
    }

    /**
     * Sets the birthdate
     * @param day The day, should be between 01 and 31
     * @param month The month, should be between 01 and 12
     * @param year The year, should be between 1900 and 2100
     */
    public void setBirthdate(int day, int month, int year) {
        boolean isValid = this.checkBirthdate(day, month, year);

        this.day = (isValid) ? day : 0;
        this.month = (isValid) ? month : 0;
        this.year = (isValid) ? year : 0;
    }

    /**
     * Set a Tray to Person
     * @param tray A tray
     */
    public void setTray(Tray tray) {
        this.tray = tray;
    }


    /**
     * Sets the gender.
     * @param gender Gender. Should be one of 'M' or 'W'
     */
    public void setGender(char gender) {
        this.gender = (gender == 'M' || gender == 'W') ? gender : 'N';
    }

    /**
     * Sets the payment method
     * @param paymentMethod Payment method to use
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Returns the national security number (BSN)
     * @return National security number (BSN)
     */
    public int getBsn() {
        return this.bsn;
    }

    /**
     * Returns the first name
     * @return Voornaam
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * Returns the last name
     * @return Achternaam
     */
    public String getLastname() {
        return this.lastname;
    }

    /**
     * Returns a formatted birthdate
     * @return Birthdate
     */
    public String getBirthdate() {
        String formattedBirthdate = "Unknown";
        if(day != 0 && month != 0 && year != 0) formattedBirthdate = day + "/" + month + "/" + year;

        return formattedBirthdate;
    }

    /**
     * Returns the gender
     * @return Gender (M/V)
     */
    public String getGender() {
        if(this.gender == 'M') return "Man";
        else if(this.gender == 'W') return "Woman";
        else return "Unknown";
    }

    /**
     * Returns the tray
     * @return tray
     */
    public Tray getTray() {
        return this.tray;
    }

    /**
     * Returns the payment method associated with this person
     * @return Payment method
     */
    public PaymentMethod getPaymentMethod() {
        if(this.paymentMethod == null) {
            // TODO: There is no mention of giving people that come into our canteen a wallet or any initial balance.
            // They will get rejected at the checkout! To keep the canteen simulation from rejecting every single
            // person that tries to check out, we'll assign a default wallet here with a balance of 50 euros if no
            // wallet has been set for this person.

            PaymentMethod wallet = new CashPaymentMethod();
            wallet.setBalance(50.00);
            this.paymentMethod = wallet;
        }

        return this.paymentMethod;
    }

    /**
     * Returns details about this person
     * @return Details about this person
     */
    @Override
    public String toString() {
        return "Details for the person with national security number " + this.getBsn() + ":\n" +
               " * First name:    " + this.getFirstname() + "\n" +
               " * Last name:     " + this.getLastname() + "\n" +
               " * Birthdate:     " + this.getBirthdate() + "\n" +
               " * Gender:        " + this.getGender();
    }
}
