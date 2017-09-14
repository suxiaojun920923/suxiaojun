package com.hellojava.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.hellojava.business.IUserService;
import com.hellojava.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class UserServiceTest{
	@Autowired
	private IUserService userService;
	@Test
	public void testSayHello() {
		User user=new User();
		user.setUserName("admin");
		user.setUserPwd("a333");
		boolean bool=userService.checkUser(user);
		System.out.println(bool?"登陆成功":"登陆失败");
	}
}
