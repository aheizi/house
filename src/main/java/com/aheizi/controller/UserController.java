package com.aheizi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.aheizi.bean.User;
import com.aheizi.service.UserService;

public class UserController extends MultiActionController{
	
	private UserService userService;
	
	/**
	 * 新建用户
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		//封装user
		User user = new User();
		super.bind(request, user);
		request.getSession().setAttribute("userSession", user.getUserName());
		
		//将userID加入到session
		request.getSession().setAttribute("userId", user.getId());
		
		//保存用户到数据库
		userService.saveUser(user);
		
		//传递地区信息和用户信息（用户信息不用传）
		return new ModelAndView("index").addObject("msg", "Hello World!");
	}
	
	/**
	 * 保存管理员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String saveManager(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		//获取用户名
		String managerName = request.getParameter("managerName");
		//获取密码
		String managerPassword = request.getParameter("managerPassword");
		
		//保存到数据库
		userService.saveManager(managerName, managerPassword);
		
		//传递地区信息和用户信息（用户信息不用传）
		return "redirect:user.do?action=managerUser";
	}
	
	/**
	 * 门户网站登陆
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
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
		//将userID加入到session
		request.getSession().setAttribute("userId", user.getId());
		//返回index
		response.getWriter().println("");
		return null;
	}
	
	/**
	 * 登出
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView logout(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//移除session
		request.getSession().removeAttribute("userSession");
		
		//返回index
		return new ModelAndView("index");
	}
	
	/**
	 * 检查userName是否已经注册
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView checkUserName(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//获取userName
		String userName = request.getParameter("userName");
		
		//检查userName是否已经被注册
		User user = userService.getUserByUserName(userName);
		
		//如果用户已经注册
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
	
	/**
	 * 个人资料
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView grzl(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		//在session中获取UserId
		String userName =  (String) request.getSession().getAttribute("userSession");
		
		//获取整个user
		User user = userService.getUserByUserName(userName);
		model.put("user", user);
		
		//转发到
		ModelAndView view = new ModelAndView("my_house_grzl",model);
		
		return view;
	}
	
	/**
	 * 个人资料修改
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String grzl_edit(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		//封装user
		User user = new User();
		super.bind(request, user);
		
		//更新数据
		userService.updateUser(user);
		model.put("user", user);
		
		return "redirect:user.do?action=grzl";
	}
	
	public ModelAndView grzlPasswordAjax(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		String userName = (String) request.getSession().getAttribute("userSession");
		//检查密码是否匹配  ajax 方式
		User user = userService.getUserByUserName(userName);
		
		System.out.println(oldPassword);
		System.out.println(user.getPassword());
		
		if(!oldPassword.equals(user.getPassword())){
			response.setStatus(500);
			response.getWriter().println("");
			return null;
		}
		
		//更新密码
		userService.updatePassword(userName, newPassword);
		
		return null;
	}
	
	/**
	 * 管理系统登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView managerLogin(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		System.out.println(userName);
		System.out.println("password=========" + password);
		
		//检查密码是否匹配  ajax 方式
		User user = userService.getManagerByUserName(userName);
		
		if(user == null || !password.equals(user.getPassword())){
			System.out.println("rorry");
			response.setStatus(500);
			response.getWriter().println("");
			return null;
		}
		
		//登陆成功，将该用户加入到session
		request.getSession().setAttribute("managerName", user.getUserName());
		//将userID加入到session
		request.getSession().setAttribute("managerId", user.getId());
		//将userType加入到session
		request.getSession().setAttribute("userType", user.getType());
		//返回index
		response.getWriter().println("");
		return null;
	}
	
	/**
	 * 管理员退出登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView managerLogout(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//移除session
		request.getSession().removeAttribute("managerName");
		
		//返回index
		return new ModelAndView("manager_login");
	}
	
	/**
	 * 用户管理
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView managerUser(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//查找管理员和用户
		List<User> userList = userService.getAllUser();
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("userList", userList);
		
		//返回index
		return new ModelAndView("manager_user", model);
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
