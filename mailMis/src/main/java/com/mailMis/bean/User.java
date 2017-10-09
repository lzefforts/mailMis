package com.mailMis.bean;

import javax.persistence.*;

/** 
 * 创建时间：Apr 30, 2015 1:32:59 PM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明：  
 */
@Entity(name = "User")
@Table(name="mailmis_user")
public class User{
	
	@Id
	//@GenericGenerator(name="idGenerator", strategy="uuid.hex")
//	@GeneratedValue(generator ="system-uuid") 
//	@GenericGenerator(name ="system-uuid", strategy ="uuid.hex")
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private String pkid;
	
	//@Column
	private String username;
	
	//@Column
	private String password;
	
	public String getPkid() {
		return pkid;
	}
	public void setPkid(String pkid) {
		this.pkid = pkid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}