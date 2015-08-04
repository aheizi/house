package com.aheizi.service;

import java.util.List;

import com.aheizi.bean.House;

public interface HouseService {
	//保存房屋信息
	public void saveHouse(House house);
	
	//根据条件查找房屋
	public List<House> searchHouse(String provinces, String city, String country,int rentStart,int rentEnd,int room,String hireWay);
	
	//根据id查找房屋
	public House findHouseById(int houseId);
	
	//收藏出租房屋信息
	public void collectHouseOut(int houseOutId, int userId);
	
	//判断该用户是否收藏该出租房屋信息
	public boolean isCollectHouseOut(int hosueOutId, int userId);
	
	//根据该用户的ID查找发表的求租信息
	public List<House> findHouseByUserName(String userName);
	
	//根据id删除出租房屋信息
	public void deleteHouseOutById(int houseOutId);
	
	//查找用户收藏的出租房屋信息
	public List<House> findCollectHouseOut(int userId);
	
	//取消收藏出租房信息
	public void cancelCollectHouseOut(int userId, int houseOutId);
	
	//查找未审核的出租房屋信息
	public List<House> findNoCheckHouseOut();
	
	//查找审核通过的出租房屋信息
	public List<House> findCheckHouseOut();
	
	//更新审核状态
	public void updateHouseOutState(int houseOutId, int state);
	
	//主页显示houseList
	public List<House> findIndexHouseList();
}
