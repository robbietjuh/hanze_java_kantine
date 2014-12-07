package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import java.util.Random;

/**
 * CanteenSimulation
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 26-11-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class CanteenSimulation {

    private Canteen canteen;
    private CanteenSupply supply;
    private Random random;

    private static final int AMOUNT_OF_ARTICLES = 4;
    private static final String[] ARTICLE_NAMES = new String[] {  "Coffee", "Peanut butter sandwich", "Cheese sandwich", "Apple juice"};
    private static final double[] ARTICLE_PRICES = new double[] { 1.50,     2.10,                     1.65,              1.65 };

    private static final int MIN_ARTICLES_PER_TYPE = 10000;
    private static final int MAX_ARTICLES_PER_TYPE = 20000;

    private static final int MIN_PERSONS_PER_DAY = 50;
    private static final int MAX_PERSONS_PER_DAY = 100;

    private static final int MIN_ARTICLES_PER_PERSON = 1;
    private static final int MAX_ARTICLES_PER_PERSON = 4;

    /**
     * Initializes a new instance of the CanteenSimulation class
     */
    public CanteenSimulation() {
        int[] quantities = this.getRandomArray(AMOUNT_OF_ARTICLES, MIN_ARTICLES_PER_TYPE, MAX_ARTICLES_PER_TYPE);

        this.canteen = new Canteen();
        this.random = new Random();
        this.supply = new CanteenSupply(ARTICLE_NAMES, ARTICLE_PRICES, quantities);

        this.canteen.setCanteenSupply(this.supply);
    }

    /**
     * Generates an array of random integers between the given min and max values
     * @param length Length of the array you want to generate
     * @param min Minimum
     * @param max Maximum
     * @return An array of random integers
     */
    private int[] getRandomArray(int length, int min, int max) {
        int[] temp = new int[length];

        for(int currentIndex = 0; currentIndex < length; currentIndex++)
            temp[currentIndex] = this.getRandomValue(min, max);

        return temp;
    }

    /**
     * Generates a random value in between the min and max values
     * @param min Minimum
     * @param max Maximum
     * @return A random integer
     */
    private int getRandomValue(int min, int max) {
        return this.random.nextInt(max - min + 1) + min;
    }

    /**
     * Gets article names for the given indexes
     * @param indexes The indexes to fetch info from in the ARTICLE_NAMES array
     * @return An array of article names
     */
    private String[] getArticleNames(int[] indexes) {
        String[] articles = new String[indexes.length];

        for(int index = 0; index < indexes.length; index++)
            articles[index] = ARTICLE_NAMES[indexes[index]];

        return articles;
    }

    /**
     * Simulates the canteen's activity
     * @param days Amount of days to simulate
     */
    public void simulate(int days) {
        for(int currentDay = 0; currentDay < days; currentDay ++) {
            // Add people in line
            for(int personToLetIn = 0; personToLetIn < currentDay + 10; personToLetIn ++)
                this.canteen.addInLine();

            // Process those people
            this.canteen.processCheckoutLine();

            // Print today's profits
            int amountOfArticles = this.canteen.getCashRegister().getAmountOfArticles();
            double amountOfMoney = this.canteen.getCashRegister().getAmountOfMoney();

            System.out.println(String.format("On day %d, %d articles were sold, resulting in a sales volume of € %.2f",
                                             currentDay + 1, amountOfArticles, amountOfMoney));

            // Reset the cash register for 'tomorrow' ;-)
            this.canteen.getCashRegister().resetRegister();
        }
    }

}
