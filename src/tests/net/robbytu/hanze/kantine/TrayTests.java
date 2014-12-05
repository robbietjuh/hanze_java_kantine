package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * TrayTests
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 28-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class TrayTests {

    @Test
    public void testTray() {
        // Create some test objects
        Tray tray = new Tray();
        Article banana = new Article("Banana", 2.50);
        Article apple = new Article("Apple", 3.01);

        // Put items onto the tray
        tray.addArticle(banana);
        tray.addArticle(apple);

        // Test the getIterator method
        Iterator<Article> testIterator =  tray.getArticleIterator();
    }
}
