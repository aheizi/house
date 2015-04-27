package com.aheizi.service;

import com.aheizi.bean.User;

public interface UserService {
	//保存用户
	public void saveUser(User user);
	
	//根据名字查找用户
	public User getUserByUserName(String userName);
}
