package net.robbytu.hanze.kantine;

/**
 * Created by Dylan on 12-12-2014.
 */
public class Administration
{
    /**
     * Amount of days in one week
     */
    private static final int DAYS_IN_WEEK = 7;

    private Administration() {
    }

    /**
     * Calculates the average value of the quantities given
     * @param quantity An array of integers representing a quantity
     * @return Average quantity
     */
    public static double calculateAverageQuantity(int[] quantity)
    {
        double total = 0;
        for (int value : quantity)
        {
               total += value;
        }
        return (total / quantity.length);
    }

    /**
     * Calculates the average sale from the given sales
     * @param sales An array of doubles representing sales
     * @return Average sale
     */
    public static double calculateAverageSales(double[] sales)
    {
        double total = 0;
        for (double value : sales)
        {
            total += value;
        }
        return (total / sales.length);
    }

    /**
     * Calculates the amount of sales per day of the week
     * @param sales An array of sales
     * @return array Sales per day of the week, @see DAYS_IN_WEEK
     */
    public static double[] calculateDaySale(double[] sales)
    {
        double[] temp = new double[DAYS_IN_WEEK];
        for(int i = 0; i < DAYS_IN_WEEK; i++)
        {
            int j = 0;
            while(j <= (sales.length/DAYS_IN_WEEK) && i + (DAYS_IN_WEEK * j) < sales.length)
            {
                temp[i] += sales[i + (DAYS_IN_WEEK * j)];
                j++;
            }
        }
        return temp;
    }


}
