package com.authanticater.server.Authaticator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuUtility {

	@Autowired
	private static LoadBalancerClient loadBalancer;

	public static WebClient getwebClient(String baseUrl) {
		WebClient owebClient = WebClient.create(baseUrl);
		return owebClient;
	}

	public  String getendPointURL(String appName) {
		System.out.println("Application Name >>>>>>"+appName);
		System.out.println("Application Name in Upper >>>>>>"+appName.toUpperCase());
		ServiceInstance serviceInstance = loadBalancer.choose(appName);
		System.out.println("Service Register >>>>>>"+appName.toUpperCase());  
		return serviceInstance.getUri().toString();
	}
}
