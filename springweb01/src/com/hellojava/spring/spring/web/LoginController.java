package com.hellojava.spring.spring.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hellojava.spring.spring.entity.User;

@Controller
public class LoginController {
	
	//@RequestMapping 把当前的方法映射到制定URL
	//value String[] 映射的请求
	//params String[] 映射当前请求中必须包含的参数的key
	//method RequestMethod 类型 限定访问当前方法的请求方式
	//path 限定访问当前方法的路径 /aaa/*.hehe
	
	@RequestMapping(path= {"/aaa/*.hehe","/aaa/login"})
	public String loginHandler(@RequestParam(name="uname",required=false,defaultValue="admin")String userName,@RequestParam(name="upwd",required=false,defaultValue="a1")String userPwd) {
		System.out.println("hello"+userName+"---"+userPwd);
		return "redirect:/loadAll";
	}
	
	@RequestMapping("/loadAll")
	public String loadAll(HttpSession session) {
		System.out.println("loadAll");
		List<User> userList=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User user=new User(i+1,"张三"+(i+1),"a111");
			userList.add(user);
		}
		session.setAttribute("userList", userList);
		return "redirect:/index.jsp";
		//视图前添加/ 从根目录出发 http://localhost:8080/spreingweb01/
	}
}
