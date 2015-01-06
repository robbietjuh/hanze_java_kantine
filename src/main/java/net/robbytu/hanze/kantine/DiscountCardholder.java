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

    public double getDiscountPercentage();
    public boolean hasDiscountLimit();
    public double getDiscountLimit();

}
