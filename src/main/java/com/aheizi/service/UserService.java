package com.aheizi.service;

import java.util.List;

import com.aheizi.bean.User;

public interface UserService {
	//保存用户
	public void saveUser(User user);
	
	//根据名字查找用户
	public User getUserByUserName(String userName);
	
	//更新用户资料
	public void updateUser(User user);
	
	//更新密码
	public void updatePassword(String userName, String password);
	
	//查找 管理员
	public User getManagerByUserName(String userName);
	
	//查找管理员和用户
	public List<User> getAllUser();
	
	//保存管理员
	public void saveManager(String managerName, String managerPassword);
}
