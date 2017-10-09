package com.mailMis.controller;

import com.alibaba.fastjson.JSON;
import com.mailMis.bean.Order;
import com.mailMis.common.PageTool;
import com.mailMis.service.OrderService;
import com.mailMis.vo.SearchParamVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


/** 
 * 创建时间：May 1, 2015 7:59:11 AM  
 * 项目名称：mailMis
 * @author miaomiao  
 * @version 1.0   
 * 类说明：  
 */
@Controller
public class OrderController {

	private Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;
	
	@ResponseBody
	@RequestMapping(value="/findAll.htm",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String findAll(@RequestParam int pageSize,
							@RequestParam(required = false) int pageNumber,
							@RequestParam String kUserName,
							@RequestParam String kPhone) throws IOException{
		PageTool pageTool = new PageTool();
		SearchParamVo searchParamVo = buildParamVo(kUserName, kPhone);
		Page<Order> pages = orderService.findAllOrder(pageNumber,pageSize,searchParamVo);
		pageTool.setTotal(Long.valueOf(pages.getTotalElements()).intValue());
		pageTool.setRows(pages.getContent());
		String json = JSON.toJSONString(pageTool);
		LOGGER.info("返回前端的json数据为:{}",json);
		return json;
	}

	@ResponseBody
	@RequestMapping(value="saveOrder.htm",method=RequestMethod.POST)
	public void addOrder(Order order) throws IOException{
		orderService.saveOrder(order);
	}

	private SearchParamVo buildParamVo(String kUserName, String kPhone){
		SearchParamVo searchParamVo = new SearchParamVo();
		searchParamVo.setkUserName(kUserName);
		searchParamVo.setkPhone(kPhone);
		return searchParamVo;
	}

}
