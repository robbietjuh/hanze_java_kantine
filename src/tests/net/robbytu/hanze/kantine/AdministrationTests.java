package net.robbytu.hanze.kantine;

import org.junit.Test;

/**
 * Created by Dylan on 12-12-2014.
 */
public class AdministrationTests
{
    @Test
    public void test()
    {
        Administration administration = new Administration();
        System.out.println("Test calculateAverageQuantity, results: " + administration.calculateAverageQuantity(new int[]{45, 56, 34, 39, 40, 31}));
        System.out.println("Test calculateAverageSales, results: " + administration.calculateAverageSales(new double[]{45, 56, 34, 39, 40, 31}));
    }

}
