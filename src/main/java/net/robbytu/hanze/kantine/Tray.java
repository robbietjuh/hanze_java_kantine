package net.robbytu.hanze.kantine;

import java.util.*;

/**
 * Created by Dylan on 26-11-2014.
 */
public class Tray {
    private Stack<Article> articles;
    /**
     * Initializes a new Tray instance
     */
    public Tray() {
        this.articles = new Stack<Article>();
    }

    /**
     * Adds new Article to the Tray
     * @param article Article object to add
     */
    public void addArticle(Article article) {
        this.articles.push(article);
    }

    /**
     * Returns the amount of articles on the tray
     * @return The amount of articles on the tray
     */
    public int getAmountOfArticles() {
        return this.articles.size();
    }

    /**
     * Calculates the grand total price of the items on this tray
     * @return Grand total price
     */
    public double getGrandTotal() {
        double grandtotal = 0;
        for(Article article : this.articles)
        {
            grandtotal += article.getPrice();
        }
        return grandtotal;
    }
}