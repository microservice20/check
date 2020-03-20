package com.authanticater.server.Authaticator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthaticatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthaticatorApplication.class, args);
	}

}
