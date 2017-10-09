package com.mailMis.service;
/** 
 * 创建时间：Apr 30, 2015 7:19:17 PM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明：  
 */
public interface BaseService {
	
	boolean ValidateLogin(String userName, String passWord);
	
	boolean createUser(String userName, String passWord);

	boolean updateUser(String userName,String oldPwd,String newPwd);
}
