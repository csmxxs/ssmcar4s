package com.zrcx.entity;

import java.util.Date;

public class Feedback {
	private Long id;
	private String title;
	private String info;
	private Integer customerId;
	private Date createDate;
	//创建临时属性
	private String customername;
	private String customertel;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomertel() {
		return customertel;
	}
	public void setCustomertel(String customertel) {
		this.customertel = customertel;
	}
	@Override
	public String toString() {
		return "Dict [id=" + id + ", title=" + title + ", info=" + info
				+ ", customerId=" + customerId + ", create_date=" + createDate 
				+",customername="+customername+",customertel="+customertel+ "]";
	}

}
