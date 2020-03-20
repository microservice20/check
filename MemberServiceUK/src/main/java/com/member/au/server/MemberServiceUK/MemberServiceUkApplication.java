package com.member.au.server.MemberServiceUK;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.member.au.server.MemberServiceUK.Controller.Member;

@SpringBootApplication
@EnableDiscoveryClient
public class MemberServiceUkApplication {

	public static List<Member> oMemober = null;

	@PostConstruct
	public void init() {
		oMemober = new ArrayList<Member>();
		oMemober.add(new Member("UKuserOne", "UKuserOne", "UKuserOne", 35));
		oMemober.add(new Member("UKuserTwo", "UKuserTwo", "UKuserOne", 36));
		oMemober.add(new Member("UKuserThree", "UKuserThree", "UKuserOne", 37));
	}

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceUkApplication.class, args);
	}

}
