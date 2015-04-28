package com.aheizi.service;

import java.util.List;

import com.aheizi.bean.House;

public interface HouseService {
	//保存房屋信息
	public void saveHouse(House house);
	
	//根据条件查找房屋
	public List<House> searchHouse(String country,int rentStart,int rentEnd,int room,String hireWay);
	
	//根据id查找房屋
	public House findHouseById(int houseId);
}
