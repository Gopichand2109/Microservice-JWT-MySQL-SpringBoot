package com.appointment.microservice.AppointmentMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@ComponentScan("com.appointment.microservice")
@EntityScan("com.appointment.microservice.model")
@EnableJpaRepositories(basePackages="com.appointment.microservice.repository")

public class AppointmentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentMicroserviceApplication.class, args);
	}
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
