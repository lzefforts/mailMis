package com.mailMis.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * 创建时间：Apr 30, 2015 1:32:59 PM  
 * 项目名称：eduMis  
 * @author miaomiao  
 * @version 1.0   
 * 类说明：  
 */
@Entity
@Table(name="mailmis_order")
public class Order{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int pkid;
	
	@Column(name = "order_no")
	private String orderNo;
	
	@Column(name = "k_username")
	private String kUserName;
	
	@Column(name = "k_phone")
	private String kPhone;
	
	@Column(name = "k_address")
	private String kAddress;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "mail_no_cn")
	private String mailNoCn;
	
	@Column(name = "detail")
	private String detail;
	
	@Column(name = "weichatNo")
	private String weichatNo;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "creator")
	private String creator;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "sys_state")
	private String sysState = "1";

	public int getPkid() {
		return pkid;
	}

	public void setPkid(int pkid) {
		this.pkid = pkid;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getkUserName() {
		return kUserName;
	}

	public void setkUserName(String kUserName) {
		this.kUserName = kUserName;
	}

	public String getkPhone() {
		return kPhone;
	}

	public void setkPhone(String kPhone) {
		this.kPhone = kPhone;
	}

	public String getkAddress() {
		return kAddress;
	}

	public void setkAddress(String kAddress) {
		this.kAddress = kAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMailNoCn() {
		return mailNoCn;
	}

	public void setMailNoCn(String mailNoCn) {
		this.mailNoCn = mailNoCn;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getWeichatNo() {
		return weichatNo;
	}

	public void setWeichatNo(String weichatNo) {
		this.weichatNo = weichatNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSysState() {
		return sysState;
	}

	public void setSysState(String sysState) {
		this.sysState = sysState;
	}
	
	
	
}