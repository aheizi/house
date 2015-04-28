package com.aheizi.dao;

import java.util.List;

import com.aheizi.bean.House;

public interface HouseDao{
	//保存房屋信息
	public void saveHouse(House house);
	
	//根据条件查找房屋信息
	public List<House> searchHouse(String country,int rentStart,int rentEnd,int room,String hireWay);
	
	//根据id查找房屋
	public House findHouseById(int houseId);
}
