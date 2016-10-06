package com.airconomist.frontendmail.domain.payment.zooz;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class RefundPaymentDto {
    private String transactionId;



    public String getPaymentToken() {
        return paymentToken;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    private String paymentToken;

    private double amount;
    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }
}
