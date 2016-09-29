package com.airconomist.frontendmail.config;

import com.airconomist.rabbitmq.config.configuration.AbstractMqClientConfig;
import com.airconomist.rabbitmq.config.errorhandlers.IRPCErrorHandler;
import com.airconomist.rabbitmq.config.errorinterceptors.DefaultErrorInterceptor;
import com.airconomist.rabbitmq.config.errorinterceptors.IRPCErrorInterceptor;
import org.springframework.context.annotation.Configuration;

import static com.airconomist.rabbitmq.config.errorinterceptors.RPCErrorInterceptorUtils.getRoot;

/**
 * @author Miroslav Marinov <mirobomarinov@gmail.com>.
 */
@Configuration
public class RabbitConfig extends AbstractMqClientConfig {
    @Override
    protected IRPCErrorInterceptor errorResponseInterceptor() {
        return new DefaultErrorInterceptor();
    }

    @Override
    protected IRPCErrorHandler errorResponseHandler() {
        return (x) -> {
            throw new RuntimeException("Exception occured during remote call", getRoot(x).getException());
        };
    }
}
