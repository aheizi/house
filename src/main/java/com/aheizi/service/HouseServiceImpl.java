package com.aheizi.service;

import com.aheizi.bean.House;
import com.aheizi.dao.HouseDao;

public class HouseServiceImpl implements HouseService{
	
	private HouseDao houseDao;
	
	//保存房屋信息
	public void saveHouse(House house) {
		houseDao.saveHouse(house);
	}

	public HouseDao getHouseDao() {
		return houseDao;
	}

	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}
	
}
