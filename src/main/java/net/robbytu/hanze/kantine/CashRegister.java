package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import java.util.Iterator;

/**
 * CashRegister
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 26-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class CashRegister {
    private CheckoutLine line;
    private int amountOfArticles;
    private double amountOfMoney;
    private Person person;

    /**
     * Initializes a new instance of the CashRegister class
     * @param line Corresponding CheckoutLine
     */
    public CashRegister(CheckoutLine line) {
        this.line = line;

        this.resetRegister();
    }

    /**
     * Do a checkout for specified person
     * @param person Person to check out
     */
    public void checkout(Person person) {
        this.person = person;
        this.setAmountOfArticles();
        this.setAmountOfMoney();
    }

    /**
     * Sets Amount Of Articles
     */
    public void setAmountOfArticles()
    {
        Iterator<Article> articlesIterator = this.person.getTray().getArticleIterator();
        while(articlesIterator.hasNext())
        {
            this.amountOfArticles++;
            articlesIterator.next();
        }
    }
    /**
     * Returns the amount of articles that have passed the register since the last reset
     * @return Amount of articles that have have passed the register
     */
    public int getAmountOfArticles() {
        return this.amountOfArticles;
    }

    /**
     * Sets Amount Of Money
     */
    public void setAmountOfMoney()
    {
        Iterator<Article> articlesIterator = this.person.getTray().getArticleIterator();
        while(articlesIterator.hasNext())
        {
            this.amountOfMoney += articlesIterator.next().getPrice();
        }
    }

    /**
     * Returns the amount of money in the register since the last reset
     * @return Amount of money in the register
     */
    public double getAmountOfMoney() {

        return this.amountOfMoney;
    }

    /**
     * Resets all counters
     */
    public void resetRegister() {
        this.amountOfArticles = 0;
        this.amountOfMoney = 0;
    }
}
