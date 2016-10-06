package com.airconomist.frontendmail.domain.payment.backend.dto;

/**
 * Created by ivaandreeva on 9/29/16.
 */
public class OpenAuthorizePaymentRequestDTO {
    private OpenPaymentDTO openPaymentDto;

    private AuthorizePaymentDTO authorizePaymentDto;

    public OpenAuthorizePaymentRequestDTO() {
    }

    public OpenAuthorizePaymentRequestDTO(OpenPaymentDTO openPaymentDto, AuthorizePaymentDTO authorizePaymentDto) {
        this.openPaymentDto = openPaymentDto;
        this.authorizePaymentDto = authorizePaymentDto;
    }

    public AuthorizePaymentDTO getAuthorizePaymentDto() {
        return authorizePaymentDto;
    }

    public OpenPaymentDTO getOpenPaymentDto() {
        return openPaymentDto;
    }
}
