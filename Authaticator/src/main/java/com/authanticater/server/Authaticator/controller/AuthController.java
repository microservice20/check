package com.authanticater.server.Authaticator.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@RequestMapping(value = "/getMemberDetails", method = RequestMethod.GET)
	public Flux<Member> getmemberDetails() {
		WebClient oWebClient = AuUtility.getwebClient(new AuUtility().getendPointURL("MemberServiceAU"));
		return oWebClient.get().uri(AuthanticateConstants.GET_USERS).retrieve().bodyToFlux(Member.class);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public @ResponseBody Mono<String> deleteUser(@RequestBody Member oMember) {
		WebClient oWebClient = AuUtility.getwebClient(new AuUtility().getendPointURL("MemberServiceAU"));

		return oWebClient.post().uri(AuthanticateConstants.DELETE_USERS).syncBody(oMember).retrieve().bodyToMono(String.class);
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public @ResponseBody Mono<String> addUser(@RequestBody Member oMember) {
		WebClient oWebClient = AuUtility.getwebClient(new AuUtility().getendPointURL("MemberServiceAU"));
		return oWebClient.post().uri(AuthanticateConstants.ADD_USER).syncBody(oMember).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class);
	}

}
