package com.airconomist.frontendmail.domain.payment.zooz;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class GetCustomerTokenDto {

    private CurrencyCodeISO currencyCode;

    private String customerLoginID;

    private String customerLoginName;

    public CurrencyCodeISO getCurrencyCode() {
        return currencyCode;
    }

    public String getCustomerLoginID() {
        return customerLoginID;
    }

    public String getCustomerLoginName() {
        return customerLoginName;
    }
}
