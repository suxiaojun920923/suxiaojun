package com.hellojava.ssm.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellojava.ssm.business.IUserService;
import com.hellojava.ssm.dao.IUserDao;
import com.hellojava.ssm.entity.User;

@Service("userService")
public class UserService implements IUserService{
	@Autowired
	private IUserDao userDao;
	@Override
	public boolean checkUser(User user) {
		User u=userDao.loadUser(user);
		return u!=null?true:false;
	}

}
