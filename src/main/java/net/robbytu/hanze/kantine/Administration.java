package net.robbytu.hanze.kantine;

/**
 * Created by Dylan on 12-12-2014.
 */
public class Administration
{

    private static final int days_in_week = 7;

    private Administration()
    {

    }


    /**
     * this method calculates the average value of the int
     * array quantity
     * @param quantity
     * @return the average
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
     * This method calculates the average value of the double array
     * sales
     * @param sales
     * @return the average
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
     * This method calculates the day sale
     * @param sales
     * @return array (7 elements) with day sales
     */
    public static double[] calculateDaySale(double[] sales)
    {
        double[] temp = new double[days_in_week];
        for(int i = 0; i < days_in_week; i++)
        {
            int j = 0;
            while(j <= (sales.length/days_in_week) && i + (days_in_week * j) < sales.length)
            {
                temp[i] += sales[i + (days_in_week * j)];
                j++;
            }
        }
        return temp;
    }


}
