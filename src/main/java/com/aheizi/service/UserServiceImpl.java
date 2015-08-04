package com.aheizi.service;

import java.util.List;

import com.aheizi.bean.User;
import com.aheizi.dao.UserDao;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	public void updatePassword(String userName, String password) {
		userDao.updatePassword(userName, password);
	}
	
	public User getManagerByUserName(String userName) {
		return userDao.getManagerByUserName(userName);
	}
	
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
	
	public void saveManager(String managerName, String managerPassword) {
		userDao.saveManager(managerName, managerPassword);
	}

	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
