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

    @Test
    public void testCashPayments() {
        // Initialize a new cash payment provider
        CashPaymentMethod cashPayment = new CashPaymentMethod();
        cashPayment.setBalance(20.0);

        // Check some payments
        assertThat("Because our balance should be 20 euros, we can buy something that costs 5 euros",
                   cashPayment.pay(5.00), equalTo(true));

        assertThat("Because our balance should be 15 euros, we cannot buy something that costs 19 euros",
                cashPayment.pay(19.00), equalTo(false));

        assertThat("Because our balance should be 15 euros, we can buy something that costs 15 euros",
                cashPayment.pay(15.00), equalTo(true));
    }

    @Test
    public void testDebitPayments() {
        // Initialize a new cash payment provider
        DebitcardPaymentMethod debitPayment = new DebitcardPaymentMethod();
        debitPayment.setBalance(20.0);
        debitPayment.setCreditLimit(10.0);

        // Check some payments
        assertThat("Because our balance should be 30 euros, we can buy something that costs 5 euros",
                debitPayment.pay(5.00), equalTo(true));

        assertThat("Because our balance should be 25 euros, we cannot buy something that costs 29 euros",
                debitPayment.pay(29.00), equalTo(false));

        assertThat("Because our balance should be 25 euros, we can buy something that costs 25 euros",
                debitPayment.pay(25.00), equalTo(true));
    }
}
