package com.airconomist.frontendmail.domain.payment;


import com.airconomist.frontendmail.domain.payment.zooz.AuthorizePaymentDto;
import com.airconomist.frontendmail.domain.payment.zooz.CommitPaymentDto;
import com.airconomist.frontendmail.domain.payment.zooz.OpenPaymentDto;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
public class PaymentRequest {

    private final OpenPaymentDto openPaymentDto;

    private final AuthorizePaymentDto authorizePaymentDto;

    private final CommitPaymentDto commitPaymentDto;

    public PaymentRequest(@JsonProperty("open") OpenPaymentDto openPaymentDto,
                          @JsonProperty("authorize") AuthorizePaymentDto authorizePaymentDto,
                          @JsonProperty("commit") CommitPaymentDto commitPaymentDto) {
        this.openPaymentDto = openPaymentDto;
        this.authorizePaymentDto = authorizePaymentDto;
        this.commitPaymentDto = commitPaymentDto;
    }

    public OpenPaymentDto getOpenPaymentDto() {
        return openPaymentDto;
    }

    public AuthorizePaymentDto getAuthorizePaymentDto() {
        return authorizePaymentDto;
    }

    public CommitPaymentDto getCommitPaymentDto() {
        return commitPaymentDto;
    }
}
