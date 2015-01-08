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

    private static final int MIN_PERSONS_PER_DAY = 50;
    private static final int MAX_PERSONS_PER_DAY = 100;

    private static final int MIN_ARTICLES_PER_PERSON = 1;
    private static final int MAX_ARTICLES_PER_PERSON = 4;

    private static final String[] DAYS_PER_WEEK = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday",
                                                                 "Friday", "Saturday", "Sunday "};

    private static final boolean DEBUG = Main.DEBUG;

    private static String[] initialArticleNames;

    /**
     * Initializes a new instance of the CanteenSimulation class
     */
    public CanteenSimulation(String[] articleNames, double[] articlePrices, int[] articleQtys) {
        this.canteen = new Canteen();
        this.random = new Random();

        this.supply = new CanteenSupply(articleNames, articlePrices, articleQtys);
        this.canteen.setCanteenSupply(this.supply);

        initialArticleNames = articleNames;
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
            articles[index] = initialArticleNames[indexes[index]];

        return articles;
    }

    /**
     * Simulates the canteen's activity
     * @param days Amount of days to simulate
     */
    public void simulate(int days) {
        int salesQuantities[] = new int[days];
        double salesVolumes[] = new double[days];

        for(int currentDay = 0; currentDay < days; currentDay ++) {
            // Let a random amount of people in
            int peopleToLetIn = this.getRandomValue(MIN_PERSONS_PER_DAY, MAX_PERSONS_PER_DAY);
            for(int amountOfPeopleLetIn = 0; amountOfPeopleLetIn < peopleToLetIn; amountOfPeopleLetIn++) {
                this.simulatePersonEntry(this.generateRandomPerson());
            }

            // Process people in line
            this.canteen.processCheckoutLine();

            // Print today's profits
            int amountOfArticles = this.canteen.getCashRegister().getAmountOfArticles();
            double amountOfMoney = this.canteen.getCashRegister().getAmountOfMoney();
            int succesfulTransactions = this.canteen.getCashRegister().getAmountOfSuccesfulCheckouts();

            System.out.printf("On day %d we had %d customers, of which %d (~%.0f%%) succesfully bought " +
                              "something, resulting in %d articles being sold with a total sales " +
                              "volume of %.2f euros\n",

                              currentDay + 1, peopleToLetIn, succesfulTransactions,
                              ((float)succesfulTransactions / (float)peopleToLetIn) * 100.0,
                              amountOfArticles, amountOfMoney);

            // Save information
            salesQuantities[currentDay] = amountOfArticles;
            salesVolumes[currentDay] = amountOfMoney;

            // Reset the cash register for 'tomorrow' ;-)
            this.canteen.getCashRegister().resetRegister();
        }

        // Print statistics
        System.out.println();
        System.out.println(" ---- ");
        System.out.println();
        System.out.printf("  * Average quantity:   %d\n", Math.round(Administration.calculateAverageQuantity(salesQuantities)));
        System.out.printf("  * Average sales:      %.2f euros\n", Administration.calculateAverageSales(salesVolumes));
        System.out.println("  * Average sales per day of the week: ");

        double[] salesPerDay = Administration.calculateDaySale(salesVolumes);
        for(int day = 0; day < salesPerDay.length; day++)
            System.out.printf("      %s: %.2f euros\n", DAYS_PER_WEEK[day], salesPerDay[day]);
    }

    /**
     * Generates a random type of person
     * @return A random type of person
     */
    private Person generateRandomPerson() {
        Person person = null;
        int typeOfPerson = this.getRandomValue(1, 100);

        if(typeOfPerson == 1) person = new CanteenEmployee();
        if(typeOfPerson > 1 && typeOfPerson <= 89) person = new Student();
        if(typeOfPerson > 89) person = new Teacher();

        return person;
    }

    /**
     * Puts some items onto the person's tray and adds it in line.
     * @param person The person to use
     */
    private void simulatePersonEntry(Person person) {
        person.setTray(new Tray());

        int amountOfArticlesToPutOnTray = this.getRandomValue(MIN_ARTICLES_PER_PERSON, MAX_ARTICLES_PER_PERSON);
        int[] articlesToPutOnTray = getRandomArray(amountOfArticlesToPutOnTray, 0, initialArticleNames.length-1);
        String[] articles = this.getArticleNames(articlesToPutOnTray);

        this.canteen.addInLine(person, articles);

        if(DEBUG) System.out.println(person.toString());
    }

}
