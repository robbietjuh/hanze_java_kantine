package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/**
 * ArticleTests
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 28-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class ArticleTests {

    @Test
    public void testArticleDetails() {
        Article article = new Article("Banana", 5.00);

        assertThat("Article details are formatted correctly",
                   article.toString(), equalTo("This article was named 'Banana' and costs 5,00 euros"));
    }

}
