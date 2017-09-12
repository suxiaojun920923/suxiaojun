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
	
	//@RequestMapping �ѵ�ǰ�ķ���ӳ�䵽�ƶ�URL
	//value String[] ӳ�������
	//params String[] ӳ�䵱ǰ�����б�������Ĳ�����key
	//method RequestMethod ���� �޶����ʵ�ǰ����������ʽ
	//path �޶����ʵ�ǰ������·�� /aaa/*.hehe
	
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
			User user=new User(i+1,"����"+(i+1),"a111");
			userList.add(user);
		}
		session.setAttribute("userList", userList);
		return "redirect:/index.jsp";
		//��ͼǰ���/ �Ӹ�Ŀ¼���� http://localhost:8080/spreingweb01/
	}
}
