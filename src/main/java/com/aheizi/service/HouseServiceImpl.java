package com.aheizi.service;

import java.util.List;

import com.aheizi.bean.House;
import com.aheizi.dao.HouseDao;

public class HouseServiceImpl implements HouseService{
	
	private HouseDao houseDao;
	
	//保存房屋信息
	public void saveHouse(House house) {
		houseDao.saveHouse(house);
	}
	
	//根据条件查找房屋信息
	public List<House> searchHouse(String provinces, String city, String country, int rentStart, int rentEnd,
			int room, String hireWay) {
		return houseDao.searchHouse(provinces, city, country, rentStart, rentEnd, room, hireWay);
	}
	
	//根据ID查找house
	public House findHouseById(int houseId) {
		return houseDao.findHouseById(houseId);
	}

	//收藏出租房屋信息
	public void collectHouseOut(int houseOutId, int userId) {
		houseDao.collectHouseOut(houseOutId, userId);
	}
	
	//判断该用户是否收藏该出租房屋信息
	public boolean isCollectHouseOut(int hosueOutId, int userId) {
		return houseDao.isCollectHouseOut(hosueOutId, userId);
	}
	
	//根据UserID查找该用户发表的出租信息
	public List<House> findHouseByUserName(String userName) {
		return houseDao.findHouseByUserName(userName);
	}
	
	public void deleteHouseOutById(int houseOutId) {
		houseDao.deleteHouseOutById(houseOutId);
	}
	
	public List<House> findCollectHouseOut(int userId) {
		return houseDao.findCollectHouseOut(userId);
	}
	
	public void cancelCollectHouseOut(int userId, int houseOutId) {
		houseDao.cancelCollectHouseOut(userId, houseOutId);
	}
	
	public List<House> findNoCheckHouseOut() {
		return houseDao.findNoCheckHouseOut();
	}

	public List<House> findCheckHouseOut() {
		return houseDao.findCheckHouseOut();
	}
	
	public void updateHouseOutState(int houseOutId, int state) {
		houseDao.updateHouseOutState(houseOutId, state);
	}
	
	public List<House> findIndexHouseList() {
		return houseDao.findIndexHouseList();
	}
	
	public HouseDao getHouseDao() {
		return houseDao;
	}

	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}

}
