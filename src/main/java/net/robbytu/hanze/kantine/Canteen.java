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

    public Canteen() {
        this.checkoutLine = new CheckoutLine();
        this.cashRegister = new CashRegister(this.checkoutLine);
    }

    public void addInLine() {
        // Create new person and assign tray
        Person personInLine = new Person();
        personInLine.setTray(new Tray());

        // Add articles onto the person's tray
        personInLine.addArticle(new Article("Banana", 1.00));
        personInLine.addArticle(new Article("Sandwitch", 2.50));

        // Put person in line
        this.checkoutLine.addPerson(personInLine);
    }

}
