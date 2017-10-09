package com.mailMis.base.dao;

import com.mailMis.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 创建时间：Apr 30, 2015 2:22:13 PM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明:使用spring data jpa,继承自JpaRepository,无需对dao进行实现
 */
public interface BaseDao extends JpaRepository<User,String>{
	//登陆验证
	User findUserByUsernameAndPassword(String username, String password);

	@Modifying
	@Query("update User as c set c.password = ?2 where c.username=?1")
	int updatePasswordByUserName(String userName, String password);
}
