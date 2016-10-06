package com.airconomist.frontendmail.domain.payment.zooz;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class CommitPaymentDto {

    private String transactionId;

    private String paymentToken;

    private Double amount;

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}