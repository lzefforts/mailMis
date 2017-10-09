package com.mailMis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/** 
 * 创建时间：May 1, 2015 7:59:11 AM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明：  
 */
@Controller
public class IndexController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String toIndex(){
		return "index";
	}

}
