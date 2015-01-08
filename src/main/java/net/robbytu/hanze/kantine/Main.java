package net.robbytu.hanze.kantine;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dylan on 7-1-2015.
 */
public class Main
{
    private static final String APP_VERSION = "1.0 stable";
    private static final String APP_VCS = "git";

    private static CanteenSimulation canteenSimulation;
    private static ArrayList<Article> articles;

    /**
     * Main entry point for the application
     * @param args Command-line arguments
     */
    public static void main(String[] args)
    {
        // Print a welcome header
        printWelcome();

        // Initialize placeholder variables
        boolean addProduct = true;
        ArrayList<String> initialArticleNames = new ArrayList<String>();
        ArrayList<Double> initialArticlePrices = new ArrayList<Double>();
        ArrayList<Integer> initialArticleQtys = new ArrayList<Integer>();

        // Loop for as long as the user wants to add new products
        while(addProduct) {
            System.out.println();
            System.out.println("Please input details for the article to add:");

            initialArticleNames.add((String) getUserInput("Article name", "string"));
            initialArticlePrices.add((Double) getUserInput("Article price", "double"));
            initialArticleQtys.add((Integer) getUserInput("Article quantity", "int"));

            addProduct = (Boolean) getUserInput("Add another article", "Y/N");
        }

        int amountOfDaysToSimulate = ((Integer)getUserInput("Amount of days to simulate", "int")).intValue();

        // Now pass everything on to the canteen simulator
        String[] articleNames = new String[initialArticleNames.size()];
        double[] articlePrices = new double[initialArticlePrices.size()];
        int[] articleQtys = new int[initialArticleQtys.size()];

        for(int i = 0; i < initialArticleNames.size(); i++) {
            articleNames[i] = initialArticleNames.get(i).toString();
            articlePrices[i] = initialArticlePrices.get(i).doubleValue();
            articleQtys[i] = initialArticleQtys.get(i).intValue();
        }

        canteenSimulation = new CanteenSimulation(articleNames, articlePrices, articleQtys);
        canteenSimulation.simulate(amountOfDaysToSimulate);
    }

    /**
     * Prints the question and tries to get a valid input back from the user
     * @param question Question to ask
     * @param inputType Type of input you want back. One of: double, int, string, Y/N
     * @return User's input in the form of @see inputType. Invalid inputTypes will trigger a null-value to be returned.
     */
    private static Object getUserInput(String question, String inputType) {
        // Print the question to the screen
        System.out.print(question + " [" + inputType + "]: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        // Try to get validated input from the user
        try {
            if(inputType.equals("double")) return scanner.nextDouble();
            else if(inputType.equals("int")) return scanner.nextInt();
            else if(inputType.equals("string")) return scanner.next();
            else if(inputType.equals("Y/N")) {
                String input = scanner.next();
                if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) return (input.equalsIgnoreCase("y"));
                else throw new Exception("Wrong input!");
            }
            else return null;
        }
        catch(Exception ignored) {
            return getUserInput(question, inputType);
        }
    }

    private static void printWelcome() {
        System.out.println("Hanze Kantine Simulator");
        System.out.println("Version " + APP_VERSION + " [" + APP_VCS + "]");
    }

}
