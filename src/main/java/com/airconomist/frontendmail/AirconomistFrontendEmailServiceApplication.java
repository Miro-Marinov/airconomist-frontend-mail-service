package com.airconomist.frontendmail;

import com.airconomist.frontendmail.service.MailRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AirconomistFrontendEmailServiceApplication {

	@Autowired
	MailRequestService mailRequestService;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AirconomistFrontendEmailServiceApplication.class, args);
		System.out.println("Registered beans: ");
		for (String bean : ctx.getBeanDefinitionNames()) {
			System.out.println(bean);
		}
	}
}
