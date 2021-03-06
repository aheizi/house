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
	public String saveHouse(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		House house = new House();
		super.bind(request, house);
		
		//保存到数据库
		houseService.saveHouse(house);
		
		return "redirect:index";
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
		List<House> houseList = houseService.searchHouse(provinces,city,country,rentStart,rentEnd,room,hireWay);
		//符合要求的房屋信息
		model.put("houseList",houseList);
		
		//回显
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
		
		int houseId = Integer.parseInt(request.getParameter("id"));
		
		House houseDtail = houseService.findHouseById(houseId);
		model.put("houseDtail", houseDtail);
		
		//判断该用户是否收藏该房屋信息(参数：用户id、houseInId)
		if(request.getSession().getAttribute("userId") == null){
			//用户未登陆，isCollect为0
			model.put("isCollect", "0");
		}else{
			int userId = (Integer) request.getSession().getAttribute("userId");
			//用户是否收藏
			if(!houseService.isCollectHouseOut(houseId, userId)){
				//用户已经登录，但是未收藏
				model.put("isCollect", "0");
			}else{
				//用户已经登陆，并且已经收藏
				model.put("isCollect", "1");
			}
		}
		
		ModelAndView view = new ModelAndView("houseDtail",model);
		
		return view;
	}
	
	/**
	 * 收藏房屋求租信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView collectHouseOutDtail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		//houseIn 的id
		int houseId = Integer.parseInt(request.getParameter("houseOutId"));
		//userId
		int userId = (Integer) request.getSession().getAttribute("userId");
		
		//收藏
		houseService.collectHouseOut(houseId, userId);

		response.getWriter().println("");
		return null;
	}
	
	//删除出租房屋信息
	public String deleteHouseOut(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//houseIn 的id
		int houseOutId = Integer.parseInt(request.getParameter("houseOutId"));
		
		//删除
		houseService.deleteHouseOutById(houseOutId);

		//跳转到我的发布
		return "redirect:myHouse.do?action=myHouse";
	}
	
	//取消收藏
	public String cancelCollectHouseOut(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//houseIn 的id
		int houseOutId = Integer.parseInt(request.getParameter("houseOutId"));
		//userId
		int userId = (Integer) request.getSession().getAttribute("userId");
		
		//取消收藏
		houseService.cancelCollectHouseOut(userId, houseOutId);

		//跳转到我的收藏
		return "redirect:myHouse.do?action=wdsc";
	}
	
	//待审核的信息
	public ModelAndView managerHouseOut(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//查找所有未审核的出租房屋信息
		List<House> noCheckHouseOutList = houseService.findNoCheckHouseOut();
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("noCheckHouseOutList", noCheckHouseOutList);

		return new ModelAndView("manager_out",model);
	}
	
	//审核
	public String managerCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//得到状态
		int state = Integer.parseInt(request.getParameter("state"));
		//得到id
		int houseOutId = Integer.parseInt(request.getParameter("id"));
		
		//更新数据库
		houseService.updateHouseOutState(houseOutId, state);

		return "redirect:house.do?action=managerHouseOut";
	}
	
	public HouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	
}
