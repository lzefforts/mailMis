package com.mailMis.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.mailMis.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;


/** 
 * 创建时间：May 1, 2015 7:59:11 AM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明：  
 */
@Controller
public class LoginController {

	private Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Resource
	private BaseService userService;

	@RequestMapping(value="/sys",method=RequestMethod.POST)
	public String toLogin(){
		return "login";
	}


	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public ModelAndView Login(@RequestParam String userName, @RequestParam String passWord, HttpSession httpSession){
		ModelAndView mav = new ModelAndView();
		if(userService.ValidateLogin(userName, passWord)){
			LOGGER.info("用户{}登录成功",userName);
			httpSession.setAttribute("userName",userName);
			mav.setViewName("manage");
			return mav;
//			return "manage";
		}
		LOGGER.info("用户{}登录失败",userName);
//		return "error";
		mav.setViewName("error");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value="/changePwd.htm",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String changePwd(@RequestParam String cUserName,
							@RequestParam String oldPwd,
							@RequestParam String newPwd){
		JSONObject jsonObject = new JSONObject();
		if(!userService.ValidateLogin(cUserName, oldPwd)){
			jsonObject.put("success",false);
			jsonObject.put("msg","用户不存在!请输入正确的用户名和原始密码!");
			return jsonObject.toJSONString();
		}
		userService.updateUser(cUserName, oldPwd, newPwd);
		jsonObject.put("success",true);
		jsonObject.put("msg","更新成功!");
		return jsonObject.toJSONString();
	}
	
}
