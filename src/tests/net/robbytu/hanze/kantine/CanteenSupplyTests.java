package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * CanteenSupplyTests
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 07-12-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class CanteenSupplyTests {
    @Test
    public void testGetArticle() {
        // Create a basic supplier
        CanteenSupply supply = new CanteenSupply(new String[] { "Apple", "Banana" },  // Article names
                                                 new double[] { 2.50,    3.00     },  // Prices
                                                 new int[]    { 1,       1        }); // Quantities

        // Fetch an article and test wether its attributes are correct
        Article generatedArticle = supply.getArticle("Apple");

        assertThat("The article's name is equal to Apple",
                   generatedArticle.getName(), equalTo("Apple"));

        assertThat("The article's price is equal to 2.50",
                   generatedArticle.getPrice(), equalTo(2.50));

        // Fetch an article and see if it is still in stock
        generatedArticle = supply.getArticle("Apple");

        assertThat("The article returned was null because it's out of stock",
                   generatedArticle, equalTo(null));

        // Fetch an article and see if it is still in stock
        generatedArticle = supply.getArticle("Banana");

        assertThat("The article's name is equal to Banana and was therefor still in stock",
                generatedArticle.getName(), equalTo("Banana"));
    }
}
