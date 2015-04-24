package com.aheizi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.aheizi.bean.User;
import com.aheizi.service.UserService;

public class UserController extends MultiActionController{
	
	private UserService userService;
	
	public ModelAndView saveUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//封装user
		User user = new User();
		super.bind(request, user);
		
		/*user.setUserName(userName);
		user.setPassword("121212");
		user.setEmail("aheizi@outook.com");
		user.setType("normal");*/
		
		request.getSession().setAttribute("userName", user.getUserName());
		
		System.out.println("username=================" + request.getSession().getAttribute("userName"));
		
		
		
		//保存用户到数据库
		userService.saveUser(user);
		
		//传递地区信息和用户信息（用户信息不用传）
		return new ModelAndView("index").addObject("msg", "Hello World!");
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
