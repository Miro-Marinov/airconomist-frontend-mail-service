package com.airconomist.frontendmail.domain.payment.zooz;

import com.zooz.common.client.ecomm.beans.InvoiceItem;

import java.util.List;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class OpenPaymentDto {

    private Double amount;

    private CurrencyCodeISO currencyCode;

    private double taxAmount;

    private Double taxPercentage;

    private String details;

    private String transactionId;

    private String userUuid;

    private List<InvoiceItem> invoiceItems;

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

    public String getTransactionId() {
        return transactionId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }
}
