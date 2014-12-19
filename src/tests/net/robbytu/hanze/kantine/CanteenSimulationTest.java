package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import org.junit.Test;

/**
 * (Filename)
 * <p/>
 * (Description)
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 07-12-14
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class CanteenSimulationTest {
    @Test
    public void testSimulation() {
        CanteenSimulation simulation = new CanteenSimulation();
        simulation.simulate(10);
    }
}
