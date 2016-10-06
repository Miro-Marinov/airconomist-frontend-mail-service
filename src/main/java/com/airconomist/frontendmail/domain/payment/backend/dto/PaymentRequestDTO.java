package com.airconomist.frontendmail.domain.payment.backend.dto;

/**
 * Created by ivaandreeva on 10/4/16.
 */
public class PaymentRequestDTO {
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
