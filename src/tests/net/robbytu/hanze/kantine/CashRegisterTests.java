package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * CashRegisterTests
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 28-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class CashRegisterTests {

    @Test
    public void testCheckout() {
        // Set up initial environment
        CashRegister cashregister = new CashRegister();
        cashregister.resetRegister();
        Tray tray;

        // Create a person and give it a tray
        Person person = new Person(1234, "Robert", "de Vries", 11, 10, 1996, 'M');
        person.setTray(new Tray());

        // Assign a wallet with 20 euros in it
        PaymentMethod wallet = new CashPaymentMethod();
        wallet.setBalance(20.0);
        person.setPaymentMethod(wallet);

        // Put some articles on the tray
        tray = person.getTray();
        tray.addArticle(new Article("Banana", 5.00));
        tray.addArticle(new Article("Apple", 2.50));

        // Checkout
        cashregister.checkout(person);

        assertThat("2 articles passed the cash register",
                   cashregister.getAmountOfArticles(), equalTo(2));

        assertThat("The amount of money in the cash register is equal to 7.50 EUR",
                   cashregister.getAmountOfMoney(), equalTo(7.50));

        // Now assign a product that's way too expensive
        tray.addArticle(new Article("Capybara", 85.00)); // Check out a capybara at http://kwieb.com !

        // Checkout
        cashregister.checkout(person);

        assertThat("Still 2 articles that have passed the cash register",
                   cashregister.getAmountOfArticles(), equalTo(2));

        assertThat("Still 7.50 euros in the cash register",
                   cashregister.getAmountOfMoney(), equalTo(7.50));
    }
}
