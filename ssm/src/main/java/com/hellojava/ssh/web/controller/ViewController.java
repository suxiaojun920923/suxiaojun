package com.hellojava.ssh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ViewController {
	public ViewController() {
		System.out.println("ViewController");
	}
	@RequestMapping("/login")
	public String loginView() {
		return "login";
	}
	
	@RequestMapping("loginHandler")
	public String loginHandler(String userName,String userPwd) {
		System.out.println(userName);
		System.out.println(userPwd);
		return "index";
	}
}
