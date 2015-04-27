package com.aheizi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.aheizi.bean.House;
import com.aheizi.service.HouseService;

public class HouseController extends MultiActionController{
	private HouseService houseService;
	
	public ModelAndView saveHouse(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		House house = new House();
		super.bind(request, house);
		
		System.out.println("house===============" + house.getPublishDate());
		
		//保存到数据库
		houseService.saveHouse(house);
		
		System.out.println("保存成功");
		
		return new ModelAndView("index");
	}

	public HouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	
}
