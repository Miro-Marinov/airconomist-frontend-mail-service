package com.airconomist.frontendmail.endpoint;

import com.airconomist.frontendmail.domain.email.EmailDto;
import com.airconomist.frontendmail.domain.email.EventsResponseDto;
import com.airconomist.frontendmail.service.EventfulServiceConnector;
import com.airconomist.frontendmail.service.dto.PreferenceRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Miroslav on 7/4/2016.
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EventfulServiceConnector eventfulServiceConnector;

    @RequestMapping(value = "/send",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<EventsResponseDto> sendEmail(@RequestBody PreferenceRequestDTO prefDto) {
        return eventfulServiceConnector.sendBulkAndGetOptionalList(Arrays.asList(prefDto, prefDto)).get();
    }

    @RequestMapping(value = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EmailDto ping() {
        return new EmailDto("green", "red", "violet");
    }
}
