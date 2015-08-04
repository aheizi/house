package com.aheizi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.aheizi.bean.House;
import com.aheizi.bean.HouseIn;
import com.aheizi.service.HouseInService;
import com.aheizi.service.HouseService;

public class MyHouseController extends MultiActionController{
	
	private HouseInService houseInService;
	private HouseService houseService;
	
	//跳转到我的发布
	public ModelAndView myHouse(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		String userName = request.getSession().getAttribute("userSession").toString();
		
		//根据UserID查出出租list
		List<House> houseOutList = houseService.findHouseByUserName(userName);
		model.put("houseOutList", houseOutList);
		
		//根据UserID查出求租list
		List<HouseIn> houseInList = houseInService.findHouseInByUserName(userName);
		model.put("houseInList", houseInList);
		
		return new ModelAndView("my_house_wdfb",model);
	}
	
	//跳转到我的收藏
	public ModelAndView wdsc(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		int userId = (Integer) request.getSession().getAttribute("userId");
		
		//根据UserID查出出租list
		List<House> collectHouseOutList = houseService.findCollectHouseOut(userId);
		model.put("collectHouseOutList", collectHouseOutList);
		
		//根据UserID查出求租list
		List<HouseIn> collectHouseInList = houseInService.findCollectHouseIn(userId);
		model.put("collectHouseInList", collectHouseInList);
		
		return new ModelAndView("my_house_wdsc",model);
	}

	public HouseInService getHouseInService() {
		return houseInService;
	}

	public void setHouseInService(HouseInService houseInService) {
		this.houseInService = houseInService;
	}

	public HouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
}
