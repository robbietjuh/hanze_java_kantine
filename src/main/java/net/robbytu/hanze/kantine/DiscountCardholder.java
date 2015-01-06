package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

/**
 * DiscountCardholder
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 06-01-15
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public interface DiscountCardholder {

    /**
     * Returns the discount percentage this person gets
     * @return Discount percentage
     */
    public double getDiscountPercentage();

    /**
     * Returns wether there is a limit for the discount being given
     * @return Wether there is a limit
     */
    public boolean hasDiscountLimit();

    /**
     * Returns the limit set for the discount in euros
     * @return Limit in euros
     */
    public double getDiscountLimit();

}
