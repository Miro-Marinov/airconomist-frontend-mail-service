package com.airconomist.frontendmail.domain;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>
 */
public class EmailDto {

    public EmailDto() {

    }

    public EmailDto(String recipient, String body, String subject) {
        this.recipient = recipient;
        this.body = body;
        this.subject = subject;
    }

    String subject;

    String recipient;

    String body;

    public String getRecipient() {
        return recipient;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }


    @Override
    public String toString() {
        return "Subject: " + subject + ", Recipient: " + recipient + "Body: " + body;
    }
}
