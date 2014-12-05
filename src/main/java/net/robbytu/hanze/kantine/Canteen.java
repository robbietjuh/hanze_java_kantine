package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

/**
 * Canteen
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 26-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class Canteen {

    private CheckoutLine checkoutLine;
    private CashRegister cashRegister;
    private CanteenSupply canteenSupply;

    /**
     * Initializes a new instance of the Canteen class
     */
    public Canteen() {
        this.checkoutLine = new CheckoutLine();
        this.cashRegister = new CashRegister(this.checkoutLine);
    }

    /**
     * Adds a new person in line, gives them a Tray and two Articles
     */
    public void addInLine() {
        // Create new person and assign tray
        Person personInLine = new Person();
        personInLine.setTray(new Tray());

        // Add articles onto the person's tray
        personInLine.getTray().addArticle(new Article("Banana", 1.00));
        personInLine.getTray().addArticle(new Article("Sandwitch", 2.50));

        // Put person in line
        this.checkoutLine.addPerson(personInLine);
    }

    /**
     * Processes the check out line
     */
    public void processCheckoutLine() {
        while(this.checkoutLine.isPersonInLine()) {
            Person personToProcess = this.checkoutLine.getFirstPersonInLine();
            this.cashRegister.checkout(personToProcess);
        }
    }

    /**
     * Returns the CashRegister
     * @return the CashRegister
     */
    public CashRegister getCashRegister()
    {
        return this.cashRegister;
    }

    /**
     * Returns the CanteenSupply
     * @return the CanteenSupply
     */
    public CanteenSupply getCanteenSupply()
    {
        return this.canteenSupply;
    }

    /**
     * Sets the CanteenSupple
     * @param canteenSupply A CanteenSupply
     */
    public void setCanteenSupply(CanteenSupply canteenSupply)
    {
        this.canteenSupply = canteenSupply;
    }

}
