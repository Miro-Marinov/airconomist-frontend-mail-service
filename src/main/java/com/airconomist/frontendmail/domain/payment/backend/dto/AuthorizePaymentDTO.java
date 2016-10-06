package com.airconomist.frontendmail.domain.payment.backend.dto;

/**
 * Created by ivaandreeva on 10/4/16.
 */
public class AuthorizePaymentDTO {
    private String paymentMethodToken;
    private String ccvNumber;
    private String userAgent;
    private String ipAddress;
    private PaymentMethodType paymentMethodType;

    public String getPaymentMethodToken() {
        return paymentMethodToken;
    }

    public void setPaymentMethodToken(String paymentMethodToken) {
        this.paymentMethodToken = paymentMethodToken;
    }

    public String getCcvNumber() {
        return ccvNumber;
    }

    public void setCcvNumber(String ccvNumber) {
        this.ccvNumber = ccvNumber;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public PaymentMethodType getPaymentMethodType() {
        return paymentMethodType;
    }
}
