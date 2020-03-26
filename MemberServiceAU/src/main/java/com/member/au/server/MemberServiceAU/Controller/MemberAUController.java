package com.member.au.server.MemberServiceAU.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.member.au.server.MemberServiceAU.MemberServiceAuApplication;

@RestController
//@RequestMapping(value = "/au")
public class MemberAUController {

	@RequestMapping(value = "/getMemberDetails", method = RequestMethod.GET)
	public @ResponseBody List<Member> getmemberDetails() {
		return MemberServiceAuApplication.oMemober;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String deleteUser(@RequestBody Member oMember) {
		String status = "Delted the user";

		if (MemberServiceAuApplication.oMemober.contains(oMember)) {
			MemberServiceAuApplication.oMemober.remove(oMember);
		} else {
			status = "User Does not exists";
		}
		return status;
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String addUser(@RequestBody Member oMember) {
		String status = "User Already Exists";

		if (!MemberServiceAuApplication.oMemober.contains(oMember)) {
			MemberServiceAuApplication.oMemober.add(oMember);
			status = "Ueser does not exists added";
		}
		return status;
	}

}
