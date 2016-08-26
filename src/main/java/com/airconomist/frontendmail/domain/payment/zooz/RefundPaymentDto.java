package com.airconomist.frontendmail.domain.payment.zooz;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class RefundPaymentDto {
    private String paymentToken;

    private double amount;

    public String getPaymentToken() {
        return paymentToken;
    }

    public double getAmount() {
        return amount;
    }
}
