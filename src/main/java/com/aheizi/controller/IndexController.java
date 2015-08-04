package com.aheizi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.aheizi.bean.House;
import com.aheizi.service.HouseService;

public class IndexController implements Controller{

	private HouseService houseService;
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
//		String area = GetIpAreaUtil.getIpArea(GetRemoteHost.getRemoteHost(request));
		
//		String area = GetIpAreaUtil.getIpArea("27.21.3.120");
		String area = "宜昌市";
		
		//将地区信息保存到session中
		request.getSession().setAttribute("area", area);
		model.put("city", area);
		
		//默认显示的信息（出租信息）
		List<House> indexHouseList = houseService.findIndexHouseList(); 
		model.put("houseList", indexHouseList);
		
		return new ModelAndView("index",model);
	}

	public HouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	
	
}
