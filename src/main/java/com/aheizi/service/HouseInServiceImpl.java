package com.aheizi.service;

import java.util.List;

import com.aheizi.bean.HouseIn;
import com.aheizi.dao.HouseInDao;

public class HouseInServiceImpl implements HouseInService{

	private HouseInDao houseInDao;
	
	@Override
	public void saveHouseIn(HouseIn houseIn) {
		houseInDao.saveHouseIn(houseIn);
	}

	@Override
	public List<HouseIn> searchHouseIn(String provinces, String city, String country, int rentStart,
			int rentEnd, String hireWay) {
		return houseInDao.searchHouseIn(provinces, city, country, rentStart, rentEnd, hireWay);
	}

	@Override
	public HouseIn findHouseInById(int houseInId) {
		return houseInDao.findHouseInById(houseInId);
	}
	
	@Override
	public void collectHouseIn(int houseInId, int userId) {
		houseInDao.collectHouseIn(houseInId, userId);
	}

	@Override
	public boolean isCollectHouseOut(int hosueInId, int userId) {
		return houseInDao.isCollectHouseOut(hosueInId, userId);
	}
	
	@Override
	public List<HouseIn> findHouseInByUserName(String userName) {
		return houseInDao.findHouseInByUserName(userName);
	}
	
	@Override
	public void deleteHouseInById(int houseInId) {
		houseInDao.deleteHouseInById(houseInId);
	}
	
	@Override
	public List<HouseIn> findCollectHouseIn(int userId) {
		return houseInDao.findCollectHouseIn(userId);
	}
	
	@Override
	public void cancelCollectHouseIn(int userId, int houseInId) {
		houseInDao.cancelCollectHouseIn(userId, houseInId);
	}
	
	@Override
	public List<HouseIn> findNoCheckHouseIn() {
		return houseInDao.findNoCheckHouseIn();
	}

	@Override
	public List<HouseIn> findCheckHouseIn() {
		return houseInDao.findCheckHouseIn();
	}

	public void updateHouseInState(int houseInId, int state) {
		houseInDao.updateHouseInState(houseInId, state);
	}
	
	public List<HouseIn> findIndexHouseIn() {
		return houseInDao.findIndexHouseIn();
	}

	
	public HouseInDao getHouseInDao() {
		return houseInDao;
	}

	public void setHouseInDao(HouseInDao houseInDao) {
		this.houseInDao = houseInDao;
	}

	
}
