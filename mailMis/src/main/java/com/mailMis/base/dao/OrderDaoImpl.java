package com.mailMis.base.dao;

import com.mailMis.bean.Order;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/** 
 * 创建时间：May 2, 2015 5:13:51 PM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明： 
 */
public class OrderDaoImpl{

	@PersistenceContext
	EntityManager manager;
	
	@Resource
	OrderDao orderDao;
	
	public boolean updateOrder(int pkid,String state){
		Order order = orderDao.findOrderByPkid(pkid);
		order.setState(state);
		manager.merge(order);
		return false;
	}
	
	public boolean saveOrder(Order order){
		manager.persist(order);
		return true;
	}
	
}
