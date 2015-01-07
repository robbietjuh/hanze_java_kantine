package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

/**
 * DebitcardPaymentMethod
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 06-01-15
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class DebitcardPaymentMethod extends PaymentMethod {

    private double creditLimit;

    /**
     * Sets the credit limit for this debit card
     * @param limit Limit in euros
     */
    public void setCreditLimit(double limit) {
        this.creditLimit = limit;
    }

    /**
     * Perform a payment
     * @param due Amount due
     * @return Wether or not the payment succeeded
     */
    @Override
    public void pay(double due) throws TooLittleMoneyException
    {
        // Check wether we can afford this...
        if(due <= (this.balance + this.creditLimit)) {
            this.balance -= due;
        }

        // Seems like we can't
        throw new TooLittleMoneyException();
    }

}
