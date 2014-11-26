package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */


/**
 * Article
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 18-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class Article {

    private String name;
    private double price;

    /**
     * Initializes a new instance of the Article class
     * without any parameters
     */
    public Article()
    {

    }

    /**
     * Initializes a new instance of the Article class
     * @param articleName Name of the article
     * @param articlePrice Pricing of the article
     */
    public Article(String articleName, double articlePrice) {
        this.name = articleName;
        this.price = articlePrice;
    }

    /**
     * Sets the name of article
     * @param name Name of the article
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the article
     * @param price Price of the article
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the article's name
     * @return Name of the article
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the article's price
     * @return Price of the article
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Prints details about this article into stdout
     */
    public void printInfo() {
        System.out.println(String.format("This article was named '%s' and costs € %.2f",
                this.getName(), this.getPrice()));
    }
}
