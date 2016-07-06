package com.airconomist.frontendmail.service;

import com.airconomist.frontendmail.endpoint.EmailDto;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

/**
 * Created by Miroslav on 7/1/2016.
 */
@Service
public class MailRequestService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitAdmin rabbitAdmin;

    public void publishEmailRequest(EmailDto emailDto, MediaType mediaType) {
        Queue queue = new Queue("email_queue");
        rabbitAdmin.declareQueue(queue);
        TopicExchange exchange = new TopicExchange("email_exchange");
        rabbitAdmin.declareExchange(exchange);
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("email_key"));
        rabbitTemplate.convertAndSend("email_exchange", "email_key", emailDto.toString());
    }
}
