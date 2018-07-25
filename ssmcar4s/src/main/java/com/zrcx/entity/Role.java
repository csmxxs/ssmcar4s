package com.zrcx.entity;

import java.util.Date;
/**
 * 角色类
 * @author 
 */
public class Role {
	private Long id;
	private String name;
	private Date createDate;
	private int delFlag;
	private Long menuId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", createDate="
				+ createDate + ", delFlag=" + delFlag + "]";
	}
	
	
	
}

