package com.zrcx.entity;

import java.util.Date;

/**
 * 配件信息表
 * @author JQS
 *
 */
public class Fittings {
	private Long id;
	private String name;//配件名称
	private String brand;//品牌
	private Integer unit;//单位
	private double price;//单价
	private String type;//型号
	private Date createDate;
	private Integer delFlag;
	private String remark;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Fittings [id=" + id + ", name=" + name + ", brand=" + brand
				+ ", unit=" + unit + ", price=" + price + ", type=" + type
				+ ", createDate=" + createDate + ", delFlag=" + delFlag
				+ ", remark=" + remark + "]";
	}
	
	
}
