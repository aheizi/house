package com.aheizi.service;

import com.aheizi.bean.User;
import com.aheizi.dao.UserDao;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
