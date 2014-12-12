package net.robbytu.hanze.kantine;

/**
 * Created by Dylan on 12-12-2014.
 */
public class Administration
{

    private Administration()
    {

    }


    /**
     * this methode calculates the average value of the int
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
     * This methode calculates the average value of the double array
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


}
