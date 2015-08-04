package com.aheizi.service;

import java.util.List;

import com.aheizi.bean.HouseIn;

public interface HouseInService {
	//保存求租房屋信息
	public void saveHouseIn(HouseIn houseIn);
	
	//根据条件查找房屋
	public List<HouseIn> searchHouseIn(String provinces, String city, String country,int rentStart,int rentEnd,String hireWay);
	
	//根据ID查找求租房屋
	public HouseIn findHouseInById(int houseInId);
	
	//收藏求租信息
	public void collectHouseIn(int houseInId, int userId);
	
	//判断该用户是否收藏该求租房屋信息
	public boolean isCollectHouseOut(int hosueInId, int userId);
	
	//根据该用户的ID查找发表的求租信息
	public List<HouseIn> findHouseInByUserName(String userName);
	
	//根据id删除房屋信息
	public void deleteHouseInById(int houseInId);
	
	//查找用户收藏的求租房屋信息
	public List<HouseIn> findCollectHouseIn(int userId);
	
	//取消收藏求租房信息
	public void cancelCollectHouseIn(int userId, int houseInId);
	
	//查找未审核的求租房屋信息
	public List<HouseIn> findNoCheckHouseIn();
	
	//查找审核通过的求租房屋信息
	public List<HouseIn> findCheckHouseIn();
	
	//更新审核状态
	public void updateHouseInState(int houseInId, int state);
	
	//查找求租房默认显示
	public List<HouseIn> findIndexHouseIn();
}
