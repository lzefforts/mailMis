package com.mailMis.service.impl;

import com.mailMis.base.dao.OrderDao;
import com.mailMis.base.dao.OrderDaoImpl;
import com.mailMis.bean.Order;
import com.mailMis.common.Constants;
import com.mailMis.common.DateTimeUtil;
import com.mailMis.service.OrderService;
import com.mailMis.vo.SearchParamVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.Date;


/** 
 * 创建时间：May 1, 2015 6:30:02 PM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明：  
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Resource
	OrderDao factDao;
	@Resource
	OrderDaoImpl factDaoImpl;
	
	@Transactional
	@Override
	public boolean saveOrder(Order order) {
		Date nowTime = new Date();
		order.setOrderNo(DateTimeUtil.getDate2String(DateTimeUtil.YYYYMMDDHHMMSS,nowTime));
		order.setCreateTime(nowTime);
		order.setCreator(order.getkUserName());
		order.setState(Constants.ORDER_STATUS_NEW);
		return factDaoImpl.saveOrder(order);
	}
	@Override
	public Page<Order> findAllOrder(int pageNumber,int pageSize,SearchParamVo searchParamVo) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.DESC,"createTime");
		Specification<Order> specification = new Specification<Order>() {
			@Override
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery,
										 CriteriaBuilder criteriaBuilder) {
				if(!StringUtils.isEmpty(searchParamVo.getkUserName())){
					Path<String> kUserName = root.get("kUserName");
					criteriaQuery.where(criteriaBuilder.like(kUserName,"%"+searchParamVo.getkUserName()+"%"));
				}
				if(!StringUtils.isEmpty(searchParamVo.getkPhone())){
					Path<String> kPhone = root.get("kPhone");
					criteriaQuery.where(criteriaBuilder.like(kPhone,"%"+searchParamVo.getkPhone()+"%"));
				}
				return null;
			}
		};
		Page<Order> pages = factDao.findAll(specification,request);
		return pages;
	}
	
}
