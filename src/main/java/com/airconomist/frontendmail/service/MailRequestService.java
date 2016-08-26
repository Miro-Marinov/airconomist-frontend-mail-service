package com.airconomist.frontendmail.service;

import com.airconomist.frontendmail.domain.email.EmailDto;
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
public class MailRequestService extends AbstractMqClientConfig {

    @Autowired
    MqClient mqClient;

    public void publishEmailRequest(EmailDto emailDto) {
        mqClient.sendMessage(new TopicExchange(RabbitConstants.EMAIL_EXCHANGE),
                RabbitConstants.EMAIL_QUEUE,
                RabbitConstants.EMAIL_KEY,
                emailDto);
    }
}
