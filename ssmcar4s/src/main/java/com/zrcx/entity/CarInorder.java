package com.zrcx.entity;

import java.util.Date;

/** 整车进货单类 */
public class CarInorder {
	private Long id;
	private Long carId;
	private Long supplierId;
	private Integer inPrice;
	private Integer count;
	private Integer total;
	private Date createDate;
	private Date inDate;
	private Integer inState;
	private String remark;
	private Integer delFlag;
	//临时属性
	private String carName;//品牌
	private String carSeries;//车系
	private String supplierName;//供应商
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public Integer getInPrice() {
		return inPrice;
	}
	public void setInPrice(Integer inPrice) {
		this.inPrice = inPrice;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Integer getInState() {
		return inState;
	}
	public void setInState(Integer inState) {
		this.inState = inState;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarSeries() {
		return carSeries;
	}
	public void setCarSeries(String carSeries) {
		this.carSeries = carSeries;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	@Override
	public String toString() {
		return "CarInorder [id=" + id + ", carId=" + carId + ", supplierId="
				+ supplierId + ", inPrice=" + inPrice + ", count=" + count
				+ ", total=" + total + ", createDate=" + createDate
				+ ", inDate=" + inDate + ", inState=" + inState + ", remark="
				+ remark + ", delFlag=" + delFlag + ", carName=" + carName
				+ ", carSeries=" + carSeries + ", supplierName=" + supplierName
				+ "]";
	}
	

}
