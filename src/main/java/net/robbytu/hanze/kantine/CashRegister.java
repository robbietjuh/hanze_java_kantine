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
    private static final boolean DEBUG = Main.DEBUG;

    private int amountOfArticles;
    private double amountOfMoney;
    private int amountOfSuccesfulCheckouts;

    /**
     * Initializes a new instance of the CashRegister class
     */
    public CashRegister() {
        this.resetRegister();
    }

    /**
     * Do a checkout for specified person
     * @param person Person to check out
     */
    public void checkout(Person person) {
        // Set up an initial environment
        Iterator<Article> articlesIterator = person.getTray().getArticleIterator();
        double amountOfMoneyDue = 0;
        int amountOfArticlesDue = 0;

        // Loop through all articles and calculate the price
        while(articlesIterator.hasNext()) {
            amountOfMoneyDue += articlesIterator.next().getPrice();
            amountOfArticlesDue ++;
        }

        // Check wether this person gets a discount. If so, re-calculate amount due
        if(person instanceof DiscountCardholder) {
            DiscountCardholder discountCardholder = (DiscountCardholder) person;

            double discountLimit = discountCardholder.getDiscountLimit();
            double discountInEur = amountOfMoneyDue * (discountCardholder.getDiscountPercentage() / 100);

            if(discountCardholder.hasDiscountLimit() && discountInEur > discountLimit)
                discountInEur = discountLimit;

            amountOfMoneyDue -= discountInEur;
        }

        /* Ask for a payment provider and try to withdraw the amount due:
         *
         *   -   If the payment fails, cancel the checkout
         *   +   If the payment succeeds, calculate our new gross and sales
         */
        try {
            person.getPaymentMethod().pay(amountOfMoneyDue);
            this.amountOfMoney += amountOfMoneyDue;
            this.amountOfArticles += amountOfArticlesDue;
            this.amountOfSuccesfulCheckouts++;
        }
        catch (TooLittleMoneyException e) {
            if(DEBUG)
                System.out.printf("Unsuccesful checkout: %s %s did not have enough money.\n",
                                  person.getFirstname(), person.getLastname());
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
     * Returns the amount of money in the register since the last reset
     * @return Amount of money in the register
     */
    public double getAmountOfMoney() {
        return this.amountOfMoney;
    }

    /**
     * Returns the amount of succesful checkouts since the last reset
     * @return Amount of succesful checkouts
     */
    public int getAmountOfSuccesfulCheckouts() {
        return this.amountOfSuccesfulCheckouts;
    }

    /**
     * Resets all counters
     */
    public void resetRegister() {
        this.amountOfArticles = 0;
        this.amountOfMoney = 0;
        this.amountOfSuccesfulCheckouts = 0;
    }
}
