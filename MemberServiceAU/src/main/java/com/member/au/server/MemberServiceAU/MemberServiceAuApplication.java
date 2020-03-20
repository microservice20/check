package com.member.au.server.MemberServiceAU;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.member.au.server.MemberServiceAU.Controller.Member;

@SpringBootApplication
@EnableDiscoveryClient
public class MemberServiceAuApplication {

	public static List<Member> oMemober = null;

	@PostConstruct
	public void init() {
		oMemober = new ArrayList<Member>();
		oMemober.add(new Member("AUuserOne", "AUuserOne", "AUuserOne", 35));
		oMemober.add(new Member("AUuserTwo", "AUuserTwo", "AUuserOne", 36));
		oMemober.add(new Member("AUuserThree", "AUuserThree", "AUuserOne", 36));
	}

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceAuApplication.class, args);
	}

}
