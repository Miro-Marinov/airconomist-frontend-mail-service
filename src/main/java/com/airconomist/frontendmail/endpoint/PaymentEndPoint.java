package com.airconomist.frontendmail.endpoint;


import com.airconomist.frontendmail.domain.payment.PaymentRequest;
import com.airconomist.frontendmail.domain.payment.zooz.*;
import com.airconomist.rabbitmq.config.MqClient;
import com.airconomist.rabbitmq.config.RabbitConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.zooz.common.client.ecomm.beans.responses.*;
import com.zooz.common.client.ecomm.beans.server.response.ZoozServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
@Api(description = "A controller intended for payment operations.")
@RestController
@RequestMapping("/payment")
public class PaymentEndPoint {

    @Autowired
    MqClient mqClient;

    @ApiOperation(value = "Performs a payment.")
    @RequestMapping(value = "/pay", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZoozServerResponse<CommitResponse> pay(@RequestBody PaymentRequest paymentRequest,
                                                  @RequestHeader(value = "User-Agent") String userAgent,
                                                  HttpServletRequest request) {
        paymentRequest.getAuthorizePaymentDto().setUserAgent(userAgent);
        paymentRequest.getAuthorizePaymentDto().setUserIpAddress(getIpAddress(request));
        return mqClient.sendAndReceiveResponse(RabbitConstants.PAYMENT_EXCHANGE,
                RabbitConstants.PAYMENT_PAY_QUEUE_NAME,
                RabbitConstants.PAYMENT_PAY_KEY_NAME,
                paymentRequest,
                new TypeReference<ZoozServerResponse<CommitResponse>>() {
                }).orElseGet(() -> null);
    }

    @ApiOperation(value = "Opens a single unique payment transaction for the customer.")
    @RequestMapping(value = "/open", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZoozServerResponse<OpenPaymentResponse> openPayment(@RequestBody OpenPaymentDto openPaymentDto) {
        return mqClient.sendAndReceiveResponse(RabbitConstants.PAYMENT_EXCHANGE,
                RabbitConstants.PAYMENT_OPEN_QUEUE_NAME,
                RabbitConstants.PAYMENT_OPEN_KEY_NAME,
                openPaymentDto,
                new TypeReference<ZoozServerResponse<OpenPaymentResponse>>() {
                }).orElseGet(() -> null);
    }

    @ApiOperation(value = "Authorize a payment (used to check if sufficient funds in the customer's account to perform that payment.")
    @RequestMapping(value = "/authorize", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZoozServerResponse<AuthorizeResponse> authorize(@RequestBody AuthorizePaymentDto authorizePaymentDto) {
        return mqClient.sendAndReceiveResponse(RabbitConstants.PAYMENT_EXCHANGE,
                RabbitConstants.PAYMENT_AUTHORIZE_QUEUE_NAME,
                RabbitConstants.PAYMENT_AUTHORIZE_KEY_NAME,
                authorizePaymentDto,
                new TypeReference<ZoozServerResponse<AuthorizeResponse>>() {
                }).orElseGet(() -> null);
    }

    @ApiOperation(value = "Gets a unique customer token. Used to subscribe payment methods (e.g. credit cards) for that customer without the intend of paying right away.")
    @RequestMapping(value = "/token", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZoozServerResponse<GetTokenResponse> getCustomerToken(@RequestBody GetCustomerTokenDto getCustomerTokenDto) {
        return mqClient.sendAndReceiveResponse(RabbitConstants.PAYMENT_EXCHANGE,
                RabbitConstants.PAYMENT_TOKEN_QUEUE_NAME,
                RabbitConstants.PAYMENT_TOKEN_KEY_NAME,
                getCustomerTokenDto,
                new TypeReference<ZoozServerResponse<GetTokenResponse>>() {
                }).orElseGet(() -> null);
    }

    @ApiOperation(value = "Commit a payment (funds transfer is performed).")
    @RequestMapping(value = "/commit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZoozServerResponse<CommitResponse> commit(@RequestBody CommitPaymentDto commitPaymentDto) {
        return mqClient.sendAndReceiveResponse(RabbitConstants.PAYMENT_EXCHANGE,
                RabbitConstants.PAYMENT_COMMIT_QUEUE_NAME,
                RabbitConstants.PAYMENT_COMMIT_KEY_NAME,
                commitPaymentDto,
                new TypeReference<ZoozServerResponse<CommitResponse>>() {
                }).orElseGet(() -> null);
    }

    @ApiOperation(value = "Update a payment.")
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZoozServerResponse<UpdateResponse> update(@RequestBody UpdatePaymentDto updatePaymentDto) {
        return mqClient.sendAndReceiveResponse(RabbitConstants.PAYMENT_EXCHANGE,
                RabbitConstants.PAYMENT_UPDATE_QUEUE_NAME,
                RabbitConstants.PAYMENT_UPDATE_KEY_NAME,
                updatePaymentDto,
                new TypeReference<ZoozServerResponse<UpdateResponse>>() {
                }).orElseGet(() -> null);
    }

    @ApiOperation(value = "Void a payment.")
    @RequestMapping(value = "/void", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZoozServerResponse<VoidResponse> voidPayment(@RequestBody VoidPaymentDto voidPaymentDto) {
        return mqClient.sendAndReceiveResponse(RabbitConstants.PAYMENT_EXCHANGE,
                RabbitConstants.PAYMENT_VOID_QUEUE_NAME,
                RabbitConstants.PAYMENT_VOID_QUEUE_NAME,
                voidPaymentDto,
                new TypeReference<ZoozServerResponse<VoidResponse>>() {
                }).orElseGet(() -> null);
    }

    @ApiOperation(value = "Void a payment.")
    @RequestMapping(value = "/refund", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ZoozServerResponse<RefundResponse> refundPayment(@RequestBody RefundPaymentDto refundPaymentDto) {
        return mqClient.sendAndReceiveResponse(RabbitConstants.PAYMENT_EXCHANGE,
                RabbitConstants.PAYMENT_REFUND_QUEUE_NAME,
                RabbitConstants.PAYMENT_REFUND_KEY_NAME,
                refundPaymentDto,
                new TypeReference<ZoozServerResponse<RefundResponse>>() {
                }).orElseGet(() -> null);
    }

    private static String getIpAddress(HttpServletRequest request) {
        String userIpAddress = request.getHeader("X-Forwarded-For");
        if (userIpAddress == null) {
            userIpAddress = request.getRemoteAddr();
        }
        return userIpAddress;
    }

}