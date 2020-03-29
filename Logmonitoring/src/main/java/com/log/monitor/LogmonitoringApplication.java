package com.log.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class LogmonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogmonitoringApplication.class, args);
	}

}
