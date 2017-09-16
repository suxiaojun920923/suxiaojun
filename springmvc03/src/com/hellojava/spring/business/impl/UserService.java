package com.hellojava.spring.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellojava.spring.business.IUserService;
import com.hellojava.spring.dao.IUserDao;
import com.hellojava.spring.entity.User;

@Service("userService")
public class UserService implements IUserService{
	@Autowired
	private IUserDao userDao;
	
	public UserService() {
		System.out.println("userService");
	}
	
	@Override
	public boolean checkUser(User user) {
		User u=userDao.loadUser(user);
		return u!=null?true:false;
	}

}
