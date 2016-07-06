package com.airconomist.frontendmail.endpoint;

import com.airconomist.frontendmail.service.MailRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Miroslav on 7/4/2016.
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    MailRequestService mailRequestService;

    @RequestMapping(value = "/send",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EmailDto sendEmail(@RequestBody EmailDto emailDto) {
        mailRequestService.publishEmailRequest(emailDto, MediaType.TEXT_HTML);
        return emailDto;
    }

    @RequestMapping(value = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EmailDto sendEmail() {
        return new EmailDto("green", "red");
    }
}
