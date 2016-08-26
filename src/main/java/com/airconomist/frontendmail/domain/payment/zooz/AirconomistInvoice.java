package com.airconomist.frontendmail.domain.payment.zooz;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class AirconomistInvoice {
    /**
     * Invoice identifier for the transaction
     */
    @JsonProperty
    private String id;
    /**
     * Attach additional details to the invoice
     */
    @JsonProperty
    private String details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
