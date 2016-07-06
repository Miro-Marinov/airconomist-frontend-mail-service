package com.airconomist.frontendmail.config;

import org.apache.commons.lang3.StringUtils;
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
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(getFromEnvOrSystemProperties("RABBIT_SERVER"));
        connectionFactory.setUsername(getFromEnvOrSystemProperties("RABBIT_USER"));
        connectionFactory.setPassword(getFromEnvOrSystemProperties("RABBIT_PASSWORD"));
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

    public static String getFromEnvOrSystemProperties(String propName) {
        String propValue = System.getenv(propName);
        if(StringUtils.isBlank(propValue)) {
            propValue = System.getProperty(propName);
        }

        checkIfPresent(propName, propValue);
        return propValue;
    }

    public static void checkIfPresent(String propertyName, String propertyValue) {
        if (StringUtils.isBlank(propertyValue)) {
            throw new IllegalArgumentException("Please specify correct \'" + propertyName + "\' property.");
        }
    }
}
