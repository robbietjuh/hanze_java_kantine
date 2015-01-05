package net.robbytu.hanze.kantine;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Dylan on 12-12-2014.
 */
public class AdministrationTests
{
    @Test
    public void testAverageQuantity()
    {
        double averageQuantity = Administration.calculateAverageQuantity(new int[]{45, 56, 34, 39, 40, 31});

        assertThat("The average quantity matches",
                   averageQuantity, equalTo(40.833333333333336));
    }

    @Test
    public void testAverageSales()
    {
        double averageQuantity = Administration.calculateAverageSales(new double[]{567.70, 498.25, 458.90});

        assertThat("The average sales matches",
                averageQuantity, equalTo(508.2833333333333));
    }

}
