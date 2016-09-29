package com.airconomist.frontendmail.endpoint;

import com.airconomist.rabbitmq.config.core.MqClient;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.airconomist.rabbitmq.config.RabbitConstants.*;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
@RestController
@RequestMapping("/meta")
public class MetaDataEndpoint {

    @Autowired
    private MqClient mqClient;

    @RequestMapping(value = "/airports/all",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void getAllAirports() {
        mqClient.sendAndReceiveResponse(METADATA_EXCHANGE, METADATA_AIRPORTS_QUEUE, METADATA_AIRPORTS_GET_ALL_KEY, null, new TypeReference<List<String>>() {});
    }
}