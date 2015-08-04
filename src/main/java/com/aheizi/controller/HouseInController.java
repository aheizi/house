package com.aheizi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.aheizi.bean.HouseIn;
import com.aheizi.service.HouseInService;

public class HouseInController extends MultiActionController{

	private HouseInService houseInService;
	
	/**
	 * 保存房屋信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String saveHouseIn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HouseIn houseIn = new HouseIn();
		super.bind(request, houseIn);
		
		//保存到数据库
		houseInService.saveHouseIn(houseIn);
		
		return "redirect:houseIn.do?action=indexHouseIn";
	}

	/**
	 * 根据条件查找房屋
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView searchHouseIn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		request.setCharacterEncoding("UTF-8");
		
		String city = request.getParameter("city");
		String provinces = request.getParameter("provinces");
		String country = request.getParameter("country");
		String rent = request.getParameter("rent");
		String hireWay = request.getParameter("hireWay");
		
		int rentStart = 0;
		int rentEnd = 0;
		if(!rent.equals("no")){
			String[] rentStr = rent.split("-");
			rentStart = Integer.parseInt(rentStr[0]);
			rentEnd = Integer.parseInt(rentStr[1]);
		}
		
		//根据条件到数据库中查找
		List<HouseIn> houseInList = houseInService.searchHouseIn(provinces,city,country,rentStart,rentEnd,hireWay);
		
		model.put("houseInList",houseInList);
		model.put("city",city);
		model.put("provinces",provinces);
		model.put("country",country);
		model.put("rent", rent);
		model.put("hireWay", hireWay);
		
		ModelAndView view = new ModelAndView("in_index",model);
		
		return view;
	}
	
	/**
	 * 跳转到houseInDtail
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView houseInDtail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		request.setCharacterEncoding("UTF-8");
		int houseInId = Integer.parseInt(request.getParameter("id"));
		
		//获取房屋详细信息
		HouseIn houseInDtail = houseInService.findHouseInById(houseInId);
		model.put("houseInDtail", houseInDtail);
		
		//判断该用户是否收藏该房屋信息(参数：用户id、houseInId)
		if(request.getSession().getAttribute("userId") == null){
			//用户未登陆，isCollect为0
			model.put("isCollect", "0");
		}else{
			int userId = (Integer) request.getSession().getAttribute("userId");
			//用户是否收藏
			if(!houseInService.isCollectHouseOut(houseInId, userId)){
				//用户已经登录，但是未收藏
				model.put("isCollect", "0");
			}else{
				//用户已经登陆，并且已经收藏
				model.put("isCollect", "1");
			}
		}
		
		ModelAndView view = new ModelAndView("houseInDtail",model);
		
		return view;
	}
	
	/**
	 * 收藏房屋求租信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView collectHouseInDtail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println(request.getParameter("houseInId"));
		//houseIn 的id
		int houseInId = Integer.parseInt(request.getParameter("houseInId"));
		//userId
		int userId = (Integer) request.getSession().getAttribute("userId");
		
		//收藏
		houseInService.collectHouseIn(houseInId, userId);

		response.getWriter().println("");
		return null;
	}

	//删除求租房屋信息
	public String deleteHouseIn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//houseIn 的id
		int houseInId = Integer.parseInt(request.getParameter("houseInId"));
		
		//删除
		houseInService.deleteHouseInById(houseInId);

		//跳转到我的发布
		return "redirect:myHouse.do?action=myHouse";
	}
	
	//取消收藏
	public String cancelCollectHouseIn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//houseIn 的id
		int houseInId = Integer.parseInt(request.getParameter("houseInId"));
		//userId
		int userId = (Integer) request.getSession().getAttribute("userId");
		
		//取消收藏
		houseInService.cancelCollectHouseIn(userId, houseInId);

		//跳转到我的收藏
		return "redirect:myHouse.do?action=wdsc";
	}
	
	//待审核的信息
	public ModelAndView managerHouseIn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//查找所有未审核的求租房屋信息
		List<HouseIn> noCheckHouseInList = houseInService.findNoCheckHouseIn();

		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("noCheckHouseInList", noCheckHouseInList);

		return new ModelAndView("manager_in",model);
	}
	
	//审核
	public String managerCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//得到状态
		int state = Integer.parseInt(request.getParameter("state"));
		//得到id
		int houseOutId = Integer.parseInt(request.getParameter("id"));
		
		//更新数据库
		houseInService.updateHouseInState(houseOutId, state);

		return "redirect:houseIn.do?action=managerHouseIn";
	}
	
	//转到HouseIn主页
	public ModelAndView indexHouseIn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//查找所有未审核的求租房屋信息
		List<HouseIn> indexHouseInList = houseInService.findIndexHouseIn();

		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("houseInList", indexHouseInList);

		return new ModelAndView("in_index",model);
	}
	
	public HouseInService getHouseInService() {
		return houseInService;
	}

	public void setHouseInService(HouseInService houseInService) {
		this.houseInService = houseInService;
	}
}
