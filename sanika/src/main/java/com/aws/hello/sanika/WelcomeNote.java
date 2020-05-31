package com.aws.hello.sanika;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeNote {
    
	@RequestMapping("/welcome")
	public String getuserDetails() {
		return "hello this is second  message running next time";
	}

}
