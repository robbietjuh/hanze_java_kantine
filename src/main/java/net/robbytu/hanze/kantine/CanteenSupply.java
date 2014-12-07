package net.robbytu.hanze.kantine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Dylan on 3-12-2014.
 */
public class CanteenSupply {

    // internal supply
    private HashMap<String, ArrayList<Article>> supply;


    /**
     * Constructor. The First paremet is a list with article names,
     * the second parameter is a list with prices and the third parameter
     * is a list with quantities. Watch out: the dimensions of the three arrays
     * have to be equal;
     */
    public CanteenSupply(String[] articlename, double[] price, int[] quantity) {
        supply = new HashMap<String, ArrayList<Article>>();
        for(int i = 0; i < articlename.length; i++)
        {
            ArrayList<Article> articles = new ArrayList<Article>();

            for(int j = 0; j < quantity[i]; j++)
                articles.add(new Article(articlename[i], price[i]));

            supply.put(articlename[i], articles);
        }
    }

    /*
     * Private methode to get the list of articles based on the name of the article
     * returns null if the article doesn't exist.
     */
    private ArrayList<Article> getArrayList(String productname) {
        return supply.get(productname);
    }

    /**
     * Private method to get one Article from the stack of articles.
     * Returns null of there are no Articles on the stack.
     */
    private Article getArticle(ArrayList<Article> stack) {
        if(stack == null) return null;
        if (stack.size() == 0) return null;
        else
        {
            Article article = stack.get(0);
            stack.remove(0);
            return article;
        }
    }

    /**
     * Public method to fetch an article by name. Returns null of the article is not available
     * @param name Name of the article
     * @return Article The Article object or null
     */
    public Article getArticle(String name) {
        return this.getArticle(this.getArrayList(name));
    }
}
