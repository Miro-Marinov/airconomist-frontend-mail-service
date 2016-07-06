package com.airconomist.frontendmail.endpoint;

/**
 * Created by Miroslav on 7/4/2016.
 */
public class EmailDto {

    public EmailDto() {

    }

    public EmailDto(String toEmail, String body) {
        this.toEmail = toEmail;
        this.body = body;
    }

    String toEmail;

    String body;

    public String getToEmail() {
        return toEmail;
    }

    public String getBody() {
        return body;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
