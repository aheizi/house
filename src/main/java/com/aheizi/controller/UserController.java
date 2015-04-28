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
		response.setCharacterEncoding("UTF-8");
		//封装user
		User user = new User();
		super.bind(request, user);
		request.getSession().setAttribute("userSession", user.getUserName());
		
		//保存用户到数据库
		userService.saveUser(user);
		
		//传递地区信息和用户信息（用户信息不用传）
		return new ModelAndView("index").addObject("msg", "Hello World!");
	}
	
	public ModelAndView login(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//检查密码是否匹配  ajax 方式
		User user = userService.getUserByUserName(userName);
		
		System.out.println(password);
		System.out.println(user.getPassword());
		
		
		if(user == null || !password.equals(user.getPassword())){
			response.setStatus(500);
			response.getWriter().println("用户名或密码错误");
			return null;
		}
		
		//登陆成功，将该用户加入到session
		request.getSession().setAttribute("userSession", user.getUserName());
		
		//返回index
		response.getWriter().println("");
		return null;
	}
	
	public ModelAndView logout(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//移除session
		request.getSession().removeAttribute("userSession");
		
		//返回index
		return new ModelAndView("index");
	}
	
	public ModelAndView checkUserName(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//获取userName
		String userName = request.getParameter("userName");
		
		//检查userName是否已经被注册
		User user = userService.getUserByUserName(userName);
		
		System.out.println(userName);
		
		//如果用户未绑定微信
		if(user != null){
			response.setStatus(500);
			response.getWriter().println("该用户名已经被注册");
			return null;
		}
		
		
		
		//登陆成功，将该用户加入到session
		request.getSession().setAttribute("userSession", userName);
		
		//返回index
		response.getWriter().println("");
		return null;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
