package com.airconomist.frontendmail.domain.payment.backend.dto;

/**
 * Created by ivaandreeva on 10/4/16.
 */
public class OpenPaymentDTO {
    private Double amount;

    private String currencyCode;

    private String userUuid;

    private String transactionId;

    public OpenPaymentDTO() {
    }

    public OpenPaymentDTO(Double amount, String currencyCode, String userUuid, String transactionId) {
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.userUuid = userUuid;
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
