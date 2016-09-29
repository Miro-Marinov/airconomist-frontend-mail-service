package com.airconomist.frontendmail.service;

import com.airconomist.frontendmail.domain.email.EmailDto;
import com.airconomist.rabbitmq.config.RabbitConstants;
import com.airconomist.rabbitmq.config.core.MqClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Miroslav on 7/1/2016.
 */
@Service
public class MailRequestService {

    @Autowired
    MqClient mqClient;

    public void publishEmailRequest(EmailDto emailDto) {
        mqClient.sendMessage(RabbitConstants.EMAIL_EXCHANGE,
                RabbitConstants.EMAIL_QUEUE,
                RabbitConstants.EMAIL_KEY,
                emailDto);
    }
}
