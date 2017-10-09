package com.mailMis.service.impl;

import com.mailMis.base.dao.BaseDao;
import com.mailMis.base.dao.BaseDaoImpl;
import com.mailMis.bean.User;
import com.mailMis.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/** 
 * 创建时间：Apr 30, 2015 7:19:17 PM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明：  
 */
@Service("baseService")
public class BaseServiceImpl implements BaseService {
	
	@Resource
	BaseDao baseDao;

	@Resource
	BaseDaoImpl baseDaoImpl;

	
	//验证登陆
	@Transactional
	public boolean ValidateLogin(String userName,String passWord){
		User user = baseDao.findUserByUsernameAndPassword(userName, passWord);
		if(user != null)
			return true;
		return false;
	}
	
	//添加用户
	@Transactional
	public boolean createUser(String userName, String passWord) {
		if(ValidateLogin(userName,passWord))
			return false;
		User user = new User();
		user.setUsername(userName);
		user.setPassword(passWord);
		//userDao.save(user.getId());
		baseDao.save(user);
		return true;
	}

	@Override
	public boolean updateUser(String userName, String oldPwd, String newPwd) {
		User user = baseDao.findUserByUsernameAndPassword(userName, oldPwd);
		if(user == null)
			throw new RuntimeException("用户不存在");
		baseDaoImpl.updateUser(user);
		return true;
	}
}
