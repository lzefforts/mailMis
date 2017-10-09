package com.mailMis.service;

import com.mailMis.bean.Order;
import com.mailMis.vo.SearchParamVo;
import org.springframework.data.domain.Page;


/** 
 * 创建时间：May 1, 2015 6:30:02 PM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明：  
 */
public interface OrderService {

	boolean saveOrder(Order order);

	Page<Order> findAllOrder(int pageNumber, int pageSize, SearchParamVo searchParamVo);
}
