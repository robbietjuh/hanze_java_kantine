package net.robbytu.hanze.kantine;/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * PaymentTests
 *
 * @author R. de Vries <r.devries@robbytu.net>
 * @version 1.0.0
 * @date 06-01-15
 * @copyright 2014 RobbytuProjects
 * @license MIT License
 */
public class PaymentTests {

    @Test(expected = TooLittleMoneyException.class)
    public void testCashPaymentsWithLowBalance() throws TooLittleMoneyException {
        // Initialize a new cash payment provider
        CashPaymentMethod cashPayment = new CashPaymentMethod();
        cashPayment.setBalance(10.0);

        // Check some payments
        cashPayment.pay(15.00);
    }

    @Test
    public void testCashPayments()  {
        // Initialize a new cash payment provider
        CashPaymentMethod cashPayment = new CashPaymentMethod();
        cashPayment.setBalance(10.0);

        // Check some payments
        try {
            cashPayment.pay(5.00);
            assert true;
        }
        catch(Exception ignored) {
            assert false;
        }
    }

    @Test(expected = TooLittleMoneyException.class)
    public void testDebitcardPaymentsWithLowBalance() throws TooLittleMoneyException {
        // Initialize a new debitcard payment provider
        DebitcardPaymentMethod debitcard = new DebitcardPaymentMethod();
        debitcard.setBalance(10.0);
        debitcard.setCreditLimit(10.0);

        // Check some payments
        debitcard.pay(25.00);
    }

    @Test
    public void testDebitcardPayments()  {
        // Initialize a new debitcard payment provider
        DebitcardPaymentMethod debitcard = new DebitcardPaymentMethod();
        debitcard.setBalance(10.0);
        debitcard.setCreditLimit(10.0);

        // Check some payments
        try {
            debitcard.pay(5.00);
            assert true;
        }
        catch(Exception ignored) {
            assert false;
        }
    }
}
