package com.capT;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyContoller {

	@RequestMapping("/hii")
	public String takeRequest()
	{
		return "hiipage.jsp";
	}
	@RequestMapping("/login")
	public String login()
	{
		return "login.jsp";
	}
	@RequestMapping("/logout")
	public String logout()
	{
		return "logout.jsp";
	}
}
