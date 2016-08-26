package com.airconomist.frontendmail.domain.payment.zooz;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class UpdatePaymentDto {
    @JsonProperty
    private String paymentToken;

    @JsonProperty
    private Double amount;

    @JsonProperty
    private CurrencyCodeISO currencyCode;

    @JsonProperty
    private double taxAmount;

    @JsonProperty
    private Double taxPercentage;

    @JsonProperty
    private String details;

    @JsonProperty
    private String bookingId;

    public CurrencyCodeISO getCurrencyCode() {
        return currencyCode;
    }

    public Double getAmount() {
        return amount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public String getDetails() {
        return details;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }
}
