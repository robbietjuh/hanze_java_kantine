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

    /**
     * Adds a new person in line, gives them a Tray and the requested Articles
     */
    public void addInLine(Person personInLine, String[] articleNames) {
        // Check wether a canteen supply has been set
        if(this.getCanteenSupply() == null) return;

        // Pick the articles from the supply
        for(String articleName : articleNames) {
            Article pickedArticle = this.getCanteenSupply().getArticle(articleName);
            if(pickedArticle != null) personInLine.getTray().addArticle(pickedArticle);
        }

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

}
