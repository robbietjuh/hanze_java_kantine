package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

/**
 * PaymentMethod
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 06-01-15
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public abstract class PaymentMethod {

    protected double balance;

    /**
     * Sets the balance for this payment method
     * @param balance The balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Perform a payment
     * @param due Amount due
     * @return Wether or not the payment succeeded
     */
    public abstract boolean pay(double due);
}
