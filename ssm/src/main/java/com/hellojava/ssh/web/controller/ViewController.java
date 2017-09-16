package com.hellojava.ssh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hellojava.ssm.business.IUserService;
import com.hellojava.ssm.entity.User;
@Controller
public class ViewController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/login")
	public String loginView() {
		return "login";
	}
	
	@RequestMapping("/loginHandler")
	public String loginHandler(User user) {
		boolean bool=userService.checkUser(user);
		return bool?"redirect:/loadAll":"error";
	}

}
