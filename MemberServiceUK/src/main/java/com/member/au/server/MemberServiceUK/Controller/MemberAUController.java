package com.member.au.server.MemberServiceUK.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.member.au.server.MemberServiceUK.MemberServiceUkApplication;

@RestController
//@RequestMapping(value = "/uk")
public class MemberAUController {

	@RequestMapping(value = "/getMemberDetails", method = RequestMethod.GET)
	public @ResponseBody List<Member> getmemberDetails() {
		return MemberServiceUkApplication.oMemober;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String deleteUser(@RequestBody Member oMember) {
		String status = "Delted the user";

		if (MemberServiceUkApplication.oMemober.contains(oMember)) {
			MemberServiceUkApplication.oMemober.remove(oMember);
		} else {
			status = "User Does not exists";
		}
		return status;
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String addUser(@RequestBody Member oMember) {
		String status = "User Already Exists";

		if (!MemberServiceUkApplication.oMemober.contains(oMember)) {
			MemberServiceUkApplication.oMemober.add(oMember);
			status = "Ueser does not exists added";
		}
		return status;
	}

}
