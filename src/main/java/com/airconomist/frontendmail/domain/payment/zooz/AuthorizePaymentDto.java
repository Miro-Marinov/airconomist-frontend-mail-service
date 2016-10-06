package com.airconomist.frontendmail.domain.payment.zooz;

import com.zooz.common.client.ecomm.beans.enums.PaymentMethodType;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class AuthorizePaymentDto {

    private String paymentToken;

    private String transactionId;

    private PaymentMethodType paymentMethodType;

    private String paymentMethodToken;

    private String ccvNumber;

    private boolean use3dSecure;

    private String redirectUrl;

    private String userAgent;

    private String userIpAddress;

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }

    public String getPaymentMethodToken() {
        return paymentMethodToken;
    }

    public String getCcvNumber() {
        return ccvNumber;
    }

    public boolean isUse3dSecure() {
        return use3dSecure;
    }

    public PaymentMethodType getPaymentMethodType() {
        return paymentMethodType;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getUserIpAddress() {
        return userIpAddress;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setUserIpAddress(String userIpAddress) {
        this.userIpAddress = userIpAddress;
    }
}
