package com.hellojava.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hellojava.spring.business.IUserService;
import com.hellojava.spring.entity.User;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	public UserController() {
		System.out.println("userController");
	}
	
	@RequestMapping("/loginHandler")
	public String loginHandler(User user) {
		boolean bool=userService.checkUser(user);
		return bool?"redirect:/loadAll":"error";
	}
}
