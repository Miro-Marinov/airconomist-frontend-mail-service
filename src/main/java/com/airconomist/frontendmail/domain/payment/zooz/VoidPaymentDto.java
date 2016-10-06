package com.airconomist.frontendmail.domain.payment.zooz;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class VoidPaymentDto {
    private String paymentToken;

    private String transactionId;

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
