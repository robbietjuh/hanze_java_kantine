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

    public Iterator<Article> getArticleIterator()
    {
        Iterator<Article> ArticleIterator = articles.iterator();
        return  ArticleIterator;
    }
}