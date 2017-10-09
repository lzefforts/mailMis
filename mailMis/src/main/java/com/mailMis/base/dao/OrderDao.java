package com.mailMis.base.dao;

import com.mailMis.bean.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


/** 
 * 创建时间：May 1, 2015 6:21:40 PM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明：  
 */
public interface OrderDao  extends PagingAndSortingRepository<Order,String>,
													  JpaSpecificationExecutor<Order>{
	
	//查询某个sysState下的所有Order
	List<Order> findOrderBySysStateOrderByCreateTimeDesc(PageRequest pageRequest, String sysState);
	//根据pkid查询Order
	Order findOrderByPkid(int pkid);
	//save使用JpaRepository中的save()方法
	//删除fact
	List<Order> removeByPkid(String[] id);
	//boolean deleteById(String[] id);
	
}
