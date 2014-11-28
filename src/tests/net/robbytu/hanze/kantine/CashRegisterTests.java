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
        CashRegister cashregister = new CashRegister(null);
        cashregister.resetRegister();

        Person person = new Person(1234, "Robert", "de Vries", 11, 10, 1996, 'M');
        person.setTray(new Tray());
        person.addArticle(new Article("Banana", 5.00));
        person.addArticle(new Article("Apple", 2.50));
        cashregister.checkout(person);

        assertThat("2 articles passed the cash register",
                   cashregister.getAmountOfArticles(), equalTo(2));

        assertThat("The amount of money in the cash register is equal to 7.50 EUR",
                   cashregister.getAmountOfMoney(), equalTo(7.50));
    }
}
