package com.airconomist.frontendmail.config;

import com.airconomist.common.utils.EnvVarUtil;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Miroslav on 7/5/2016.
 */
@Configuration
public class RabbitConfig {

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(EnvVarUtil.getFromEnvOrSystemProperties("RABBIT_SERVER"));
        connectionFactory.setUsername(EnvVarUtil.getFromEnvOrSystemProperties("RABBIT_USER"));
        connectionFactory.setPassword(EnvVarUtil.getFromEnvOrSystemProperties("RABBIT_PASSWORD"));
        return connectionFactory;
    }

    @Bean
    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
