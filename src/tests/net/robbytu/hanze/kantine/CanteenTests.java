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
        // Create a new canteen, reset the cash register and check out 1 person
        Canteen canteen = new Canteen();

        canteen.resetCashRegister();
        canteen.addInLine();
        canteen.processCheckoutLine();

        // Check that it works
        assertThat("The amount of money in the cash register is equal to 3.50",
                   canteen.getAmountOfMoneyInCashRegister(), equalTo(3.50));

        assertThat("The amount of articles that passed the cash register is equal to 2",
                   canteen.getAmountOfArticles(), equalTo(2));

        // Add two more people in line and check them out
        canteen.addInLine();
        canteen.addInLine();
        canteen.processCheckoutLine();

        // Check that their purchases were added to the cash register
        assertThat("The amount of money in the cash register is equal to 10.50",
                   canteen.getAmountOfMoneyInCashRegister(), equalTo(10.50));

        assertThat("The amount of articles that passed the cash register is equal to 6",
                   canteen.getAmountOfArticles(), equalTo(6));

        // Reset the cash register
        canteen.resetCashRegister();

        // Check that the counters were reset
        assertThat("The cash register was reset",
                   canteen.getAmountOfArticles(), equalTo(0));

        assertThat("The cash register was reset",
                   canteen.getAmountOfMoneyInCashRegister(), equalTo(0.0));
    }
}
