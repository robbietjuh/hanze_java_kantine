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

    private static final String[] DAYS_PER_WEEK = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday "};

    /**
     * Initializes a new instance of the CanteenSimulation class
     */
    public CanteenSimulation() {
        this.canteen = new Canteen();
        this.random = new Random();

        int[] quantities = this.getRandomArray(AMOUNT_OF_ARTICLES, MIN_ARTICLES_PER_TYPE, MAX_ARTICLES_PER_TYPE);
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
        int salesQuantities[] = new int[days];
        double salesVolumes[] = new double[days];

        for(int currentDay = 0; currentDay < days; currentDay ++) {
            // Let a random amount of people in
            int peopleToLetIn = this.getRandomValue(MIN_PERSONS_PER_DAY, MAX_PERSONS_PER_DAY);
            for(int amountOfPeopleLetIn = 0; amountOfPeopleLetIn < peopleToLetIn; amountOfPeopleLetIn++) {
                // Let a random type of person in
                int typeOfPerson = this.getRandomValue(1, 100);

                if(typeOfPerson == 1) this.simulatePersonEntry("canteenEmployee");
                if(typeOfPerson > 1 && typeOfPerson <= 89) this.simulatePersonEntry("student");
                if(typeOfPerson > 89) this.simulatePersonEntry("teacher");
            }

            // Process people in line
            this.canteen.processCheckoutLine();

            // Print today's profits
            int amountOfArticles = this.canteen.getCashRegister().getAmountOfArticles();
            double amountOfMoney = this.canteen.getCashRegister().getAmountOfMoney();

            System.out.println(String.format("On day %d, %d articles were sold, resulting in a sales volume of %.2f euros",
                                             currentDay + 1, amountOfArticles, amountOfMoney));

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
        System.out.println("  * Average quantity:   " + Math.round(Administration.calculateAverageQuantity(salesQuantities)));
        System.out.println("  * Average sales:      " + String.format("%.2f euros", Administration.calculateAverageSales(salesVolumes)));
        System.out.println("  * Average sales per day of the week: ");

        double[] salesPerDay = Administration.calculateDaySale(salesVolumes);
        for(int day = 0; day < salesPerDay.length; day++)
            System.out.println(String.format("      %s: %.2f euros", DAYS_PER_WEEK[day], salesPerDay[day]));
    }

    /**
     * Creates a person complying with the specified type, puts some items onto their
     * tray and adds it in line.
     * @param typeOfPerson The type of person. Should be one of "student", "teacher" or "canteenEmployee".
     */
    private void simulatePersonEntry(String typeOfPerson) {
        Person person = null;

        if(typeOfPerson.equalsIgnoreCase("student")) person = new Student();
        else if(typeOfPerson.equalsIgnoreCase("teacher")) person = new Teacher();
        else if(typeOfPerson.equalsIgnoreCase("canteenEmployee")) person = new CanteenEmployee();

        if(person != null) {
            person.setTray(new Tray());

            int amountOfArticlesToPutOnTray = this.getRandomValue(MIN_ARTICLES_PER_PERSON, MAX_ARTICLES_PER_PERSON);
            int[] articlesToPutOnTray = getRandomArray(amountOfArticlesToPutOnTray, 0, AMOUNT_OF_ARTICLES-1);
            String[] articles = this.getArticleNames(articlesToPutOnTray);

            this.canteen.addInLine(person, articles);
            System.out.println(person.toString());
        }
    }

}
