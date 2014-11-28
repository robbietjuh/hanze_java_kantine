package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * PersonTests
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 27-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class PersonTests {

    @Test
    public void testBirthdates() {
        Person person = new Person(1234, "Robert", "de Vries", 11, 10, 1996, 'M');

        assertThat("The set birthdate 11/10/1996 was considered valid",
                   person.getBirthdate(), equalTo("11/10/1996"));

        person.setBirthdate(0, 10, 1996);
        assertThat("The set birthdate 0/10/1996 is considered invalid and therefor not set",
                   person.getBirthdate(), equalTo("Unknown"));

        person.setBirthdate(29, 2, 2000);
        assertThat("The set birthdate is 29/02/2000 considered valid due to the fact the year 2000 was a leap year",
                   person.getBirthdate(), equalTo("29/2/2000"));

        person.setBirthdate(29, 2, 2001);
        assertThat("The set birthdate 29/02/2001 is not considered valid due to the fact the year 2001 was not a leap year",
                   person.getBirthdate(), equalTo("Unknown"));
    }

    @Test
    public void testGenders() {
        Person person = new Person(1234, "Robert", "de Vries", 11, 10, 1996, 'M');

        assertThat("The set gender M was considered valid",
                   person.getGender(), equalTo("Man"));

        person.setGender('W');
        assertThat("The set gender W was considered valid",
                   person.getGender(), equalTo("Woman"));

        person.setGender('D');
        assertThat("The set gender D was considered invalid and will return Unknown as gender",
                   person.getGender(), equalTo("Unknown"));

    }

    @Test
    public void testTray() {
        // Create some test objects
        Person person = new Person(1234, "Robert", "de Vries", 11, 10, 1996, 'M');
        Tray tray = new Tray();
        Article banana = new Article("Banana", 1.00);
        Article apple = new Article("Apple", 2.50);

        // Give the person a tray and put some items onto it
        person.setTray(tray);
        person.addArticle(banana);
        person.addArticle(apple);

        // Check wether the articles were added and gets calculated right
        assertThat("There are 2 articles on the tray; a banana and an apple",
                person.getAmountOfArticles(), equalTo(2));

        assertThat("The calculated grand total of the articles on the tray is 3.50",
                person.getGrandTotal(), equalTo(3.50));
    }

}
