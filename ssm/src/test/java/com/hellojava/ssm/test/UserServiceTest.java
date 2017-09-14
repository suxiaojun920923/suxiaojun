package com.hellojava.ssm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hellojava.ssm.business.IUserService;
import com.hellojava.ssm.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springbean.xml")
public class UserServiceTest {
	@Autowired
	private IUserService userService;
	@Test
	public void testCheckUser() {
		User user=new User();
		user.setUserName("admin");
		user.setUserPwd("a111");
		boolean bool=userService.checkUser(user);
		System.out.println(bool?"µÇÂ½³É¹¦":"µÇÂ½Ê§°Ü");
	}
}
