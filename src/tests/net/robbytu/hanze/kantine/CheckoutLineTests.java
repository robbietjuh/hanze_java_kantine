package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * CheckoutLineTests
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 28-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class CheckoutLineTests {

    @Test
    public void testFirstPersonInLine() {
        CheckoutLine checkoutLine = new CheckoutLine();
        Person personRobert = new Person(1234, "Robert", "de Vries", 11, 10, 1996, 'M');
        Person personDylan = new Person(1234, "Dylan", "Vos", 11, 10, 1996, 'M');

        checkoutLine.addPerson(personRobert);
        checkoutLine.addPerson(personDylan);

        assertThat("There are people in line",
                   checkoutLine.isPersonInLine(), equalTo(true));

        assertThat("Robert is the first person in line",
                   checkoutLine.getFirstPersonInLine(), equalTo(personRobert));

        assertThat("Dylan is now the first person in line",
                   checkoutLine.getFirstPersonInLine(), equalTo(personDylan));

        assertThat("There are no more people in line",
                   checkoutLine.isPersonInLine(), equalTo(false));

    }
}
