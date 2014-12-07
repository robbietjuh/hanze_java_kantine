package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * CanteenTests
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 28-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class CanteenTests {

    @Test
    public void testCanteen() {
        // Create a new canteen and set everything up
        Canteen canteen = new Canteen();
        CanteenSupply supply = new CanteenSupply(new String[] { "Apple", "Banana", "Bread" },  // Article names
                                                 new double[] { 2.50,    3.50,     3.00    },  // Article prices
                                                 new int[]    { 5,       2,        10      }); // Article quantities
        canteen.setCanteenSupply(supply);

        // Reset the cash register and check out 1 person
        canteen.getCashRegister().resetRegister();
        Person person = new Person();
        person.setTray(new Tray());
        canteen.addInLine(person, new String[]{ "Apple", "Banana" });
        canteen.processCheckoutLine();

        // Check that it works
        assertThat("The amount of money in the cash register is equal to 6.00",
                   canteen.getCashRegister().getAmountOfMoney(), equalTo(6.00));

        assertThat("The amount of articles that passed the cash register is equal to 2",
                   canteen.getCashRegister().getAmountOfArticles(), equalTo(2));

        // Add two more people in line and check them out
        Person person1 = new Person();
        Person person2 = new Person();

        person1.setTray(new Tray());
        person2.setTray(new Tray());

        canteen.addInLine(person1, new String[]{ "Apple", "Banana" });
        canteen.addInLine(person2, new String[]{ "Bread", "Apple" });

        canteen.processCheckoutLine();

        // Check that their purchases were added to the cash register
        assertThat("The amount of money in the cash register is equal to 17.50",
                   canteen.getCashRegister().getAmountOfMoney(), equalTo(17.50));

        assertThat("The amount of articles that passed the cash register is equal to 6",
                   canteen.getCashRegister().getAmountOfArticles(), equalTo(6));

        // Reset the cash register
        canteen.getCashRegister().resetRegister();

        // Check that the counters were reset
        assertThat("The cash register was reset",
                   canteen.getCashRegister().getAmountOfArticles(), equalTo(0));

        assertThat("The cash register was reset",
                   canteen.getCashRegister().getAmountOfMoney(), equalTo(0.0));
    }
}
