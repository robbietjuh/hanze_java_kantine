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
        double[] temp = new double[7];
        for(int i = 0; i < 7; i++)
        {
            int j = 0;
            while(j <= (sales.length/7) && i + (7 * j) < sales.length)
            {
                temp[i] += sales[i + (7 * j)];
                j++;
            }
        }
        return temp;
    }


}
