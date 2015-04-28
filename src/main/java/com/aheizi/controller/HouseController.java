package com.aheizi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.aheizi.bean.House;
import com.aheizi.service.HouseService;

public class HouseController extends MultiActionController{
	private HouseService houseService;
	
	/**
	 * 保存房屋信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveHouse(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		House house = new House();
		super.bind(request, house);
		
		//保存到数据库
		houseService.saveHouse(house);
		
		return new ModelAndView("index");
	}

	/**
	 * 根据条件查找房屋
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView searchHouse(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		request.setCharacterEncoding("UTF-8");
		
		String city = request.getParameter("city");
		String provinces = request.getParameter("provinces");
		String country = request.getParameter("country");
		String rent = request.getParameter("rent");
		int room = Integer.parseInt(request.getParameter("room"));
		String hireWay = request.getParameter("hireWay");
		
		int rentStart = 0;
		int rentEnd = 0;
		if(!rent.equals("no")){
			String[] rentStr = rent.split("-");
			rentStart = Integer.parseInt(rentStr[0]);
			rentEnd = Integer.parseInt(rentStr[1]);
		}
		
		//根据条件到数据库中查找
		List<House> houseList = houseService.searchHouse(country,rentStart,rentEnd,room,hireWay);
		
		model.put("houseList",houseList);
		model.put("city",city);
		model.put("provinces",provinces);
		model.put("country",country);
		model.put("rent", rent);
		model.put("room", room);
		model.put("hireWay", hireWay);
		
		ModelAndView view = new ModelAndView("index",model);
		
		return view;
	}
	
	/**
	 * 跳转到houseDtail
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView houseDtail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		request.setCharacterEncoding("UTF-8");
		
		String houseId = request.getParameter("id");
		
		House houseDtail = houseService.findHouseById(Integer.parseInt(houseId));
		
		model.put("houseDtail", houseDtail);
		
		ModelAndView view = new ModelAndView("houseDtail",model);
		
		return view;
	}
	
	public HouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	
}
