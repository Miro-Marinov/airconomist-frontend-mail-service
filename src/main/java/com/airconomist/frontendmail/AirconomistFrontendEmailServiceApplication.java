package com.airconomist.frontendmail;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableRabbit
public class AirconomistFrontendEmailServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AirconomistFrontendEmailServiceApplication.class, args);
		System.out.println("Registered beans: ");
		for (String bean : ctx.getBeanDefinitionNames()) {
			System.out.println(bean);
		}
	}
}
