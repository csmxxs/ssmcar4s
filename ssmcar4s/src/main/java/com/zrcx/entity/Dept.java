package com.zrcx.entity;

import java.util.Date;

public class Dept {
	private Long id;
	private String name;
	private String charger;
	private String contactTel;
	private Date createDate;
	private Integer delFlag;

	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharger() {
		return charger;
	}
	public void setCharger(String charger) {
		this.charger = charger;
	}
	public Dept() {
		super();	
	}
	@Override
	public String toString() {
		
		return "Dept [id=" + id +  ", name=" + name
				+ ", charger=" + charger + ", contact_tel=" + contactTel
				+ ", create_date=" + createDate +",del_flag="+delFlag+ "]";
	}

}
