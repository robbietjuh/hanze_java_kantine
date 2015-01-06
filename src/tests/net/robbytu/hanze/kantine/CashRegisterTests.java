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
    public void testNormalCheckout() {
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
    }

    @Test
    public void testExpensiveCheckout() {
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

        // Now assign a product that's way too expensive
        tray = person.getTray();
        tray.addArticle(new Article("Capybara", 85.00)); // Check out a capybara at http://kwieb.com !

        // Checkout
        cashregister.checkout(person);

        assertThat("No articles have passed the cash register",
                   cashregister.getAmountOfArticles(), equalTo(0));

        assertThat("There are 0 euros in the cash register",
                   cashregister.getAmountOfMoney(), equalTo(0.0));
    }

    @Test
    public void testDiscountWithLimitCheckout() {
        // Set up initial environment
        CashRegister cashregister = new CashRegister();
        cashregister.resetRegister();
        Tray tray;

        // Create a person and give it a tray -- in this case a teacher as we know they get discounts with limits
        Teacher person = new Teacher();
        person.setTray(new Tray());

        // Assign a wallet with 100 euros in it
        PaymentMethod wallet = new CashPaymentMethod();
        wallet.setBalance(100.0);
        person.setPaymentMethod(wallet);

        // Now assign a product
        tray = person.getTray();
        tray.addArticle(new Article("Banana", 100.00));

        // Checkout
        cashregister.checkout(person);

        assertThat("1 article passed the cash register",
                cashregister.getAmountOfArticles(), equalTo(1));

        assertThat("There are 99 euros in the cash register because of the discount limit of 1 euro",
                cashregister.getAmountOfMoney(), equalTo(99.0));
    }

    @Test
    public void testDiscountWithoutLimitCheckout() {
        // Set up initial environment
        CashRegister cashregister = new CashRegister();
        cashregister.resetRegister();
        Tray tray;

        // Create a person and give it a tray -- in this case a teacher as we know they get discounts without limits!
        CanteenEmployee person = new CanteenEmployee();
        person.setTray(new Tray());

        // Assign a wallet with 100 euros in it
        PaymentMethod wallet = new CashPaymentMethod();
        wallet.setBalance(100.0);
        person.setPaymentMethod(wallet);

        // Now assign a product
        tray = person.getTray();
        tray.addArticle(new Article("Banana", 100.00));

        // Checkout
        cashregister.checkout(person);

        assertThat("1 article passed the cash register",
                cashregister.getAmountOfArticles(), equalTo(1));

        assertThat("There are 65 euros in the cash register because of the discount of 35% percent without limits",
                cashregister.getAmountOfMoney(), equalTo(65.0));
    }
}
