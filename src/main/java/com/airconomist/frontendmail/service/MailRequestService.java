package com.airconomist.frontendmail.service;

import com.airconomist.frontendmail.domain.EmailDto;
import com.airconomist.rabbitmq.config.AbstractMqClientConfig;
import com.airconomist.rabbitmq.config.MqClient;
import com.airconomist.rabbitmq.config.RabbitConstants;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

/**
 * Created by Miroslav on 7/1/2016.
 */
@Service
@Import(AbstractMqClientConfig.class)
public class MailRequestService {

    @Autowired
    MqClient mqClient;

    public void publishEmailRequest(EmailDto emailDto) {
        mqClient.sendMessage(new TopicExchange(RabbitConstants.EMAIL_EXCHANGE_NAME),
                RabbitConstants.EMAIL_QUEUE_NAME,
                RabbitConstants.EMAIL_KEY_NAME,
                emailDto);
    }
}
