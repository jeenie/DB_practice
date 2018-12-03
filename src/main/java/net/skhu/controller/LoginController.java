package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	//Root 페이지, 서버실행시 첫 메인페이지
	@RequestMapping("/")
	public String index() {
		return "guest/index";
	}
	
	//로그인을 위한 페이지
	@RequestMapping("guest/login")
	public String login() {
		return "guest/login";
	}
}
