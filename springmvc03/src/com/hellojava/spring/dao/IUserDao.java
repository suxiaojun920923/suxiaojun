package com.hellojava.spring.dao;

import com.hellojava.spring.entity.User;

public interface IUserDao {
	public User loadUser(User user);
}
