package com.airconomist.frontendmail.endpoint;

import com.airconomist.frontendmail.domain.email.EmailDto;
import com.airconomist.frontendmail.service.EventfulServiceConnector;
import com.airconomist.frontendmail.service.MailRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    EventfulServiceConnector eventfulServiceConnector;

    @Autowired
    MailRequestService mailRequestService;

    @Autowired
    Environment environment;

    @RequestMapping(value = "/send",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void sendEmail(@RequestBody EmailDto emailDto) {
        System.out.println(environment.getProperty("airconomist.url"));
        mailRequestService.publishEmailRequest(emailDto);
    }

    @RequestMapping(value = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EmailDto ping() {
        return new EmailDto("green", "red", "violet");
    }
}
