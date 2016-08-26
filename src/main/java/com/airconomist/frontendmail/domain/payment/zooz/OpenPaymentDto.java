package com.airconomist.frontendmail.domain.payment.zooz;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class OpenPaymentDto {

    @JsonProperty
    private Double amount;

    private CurrencyCodeISO currencyCode;

    private double taxAmount;

    private Double taxPercentage;

    private String details;

    private String bookingId;

    private String userUuid;

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

    public String getUserUuid() {
        return userUuid;
    }
}
