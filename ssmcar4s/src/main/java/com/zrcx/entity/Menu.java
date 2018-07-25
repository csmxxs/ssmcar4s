package com.zrcx.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONString;
/**
 * 菜单信息
 * @author JQS
 *
 */
public class Menu implements Comparable<Menu>,JSONString,Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String url;
	private Long parentId;
	private int menuLevel;
	private Date createDate;
	private int useFlag;
	private int delFlag;
	//临时属性，标记菜单是否已经分配给某个角色
	private boolean checked;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public int getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(int useFlag) {
		this.useFlag = useFlag;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", url=" + url
				+ ", parentId=" + parentId + ", menuLevel=" + menuLevel
				+ ", createDate=" + createDate + ", useFlag=" + useFlag
				+ ", delFlag=" + delFlag + "]";
	}
	@Override
	public String toJSONString() {
		String json = "{id:" + this.id + ",pId:" + this.parentId + ",name:'"
				+ this.name + "',open:" + (this.menuLevel == 1 ? true : false)
				+ ",checked:" + this.checked + "}";
		return json;
	}

	@Override
	public int compareTo(Menu o) {
		if(this.id-o.id>0){
			return 1;
		}else if(this.id-o.id<0){
			return -1;
		}else{
			return 0;
		}
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}
