package com.airconomist.frontendmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class AirconomistFrontendEmailServiceApplication {

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AirconomistFrontendEmailServiceApplication.class, args);
	}
}
