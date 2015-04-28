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
	public List<House> searchHouse(String country, int rentStart, int rentEnd,
			int room, String hireWay) {
		return houseDao.searchHouse(country, rentStart, rentEnd, room, hireWay);
	}
	
	//根据ID查找house
	public House findHouseById(int houseId) {
		return houseDao.findHouseById(houseId);
	}

	public HouseDao getHouseDao() {
		return houseDao;
	}

	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}

	
}
