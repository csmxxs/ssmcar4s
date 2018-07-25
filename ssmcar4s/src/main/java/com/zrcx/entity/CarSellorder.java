package com.zrcx.entity;

import java.util.Date;

/**
 * 整车销售
 * @author JQS
 *
 */
public class CarSellorder {
	private Long id;
	private Long carId;//汽车ID
	private Long customerId;//客户ID
	private String salesman;//销售员
	private int count;
	private int total;
	private Date sellDate;//订单日期
	private Date outDate;//提车日期
	private int outState;//提货状态
	private String remark;
	private int sellPrice;//实际单价

	//临时变量
	private String carName;//汽车品牌
	private String carSeries;//汽车车系
	private String customerName;//客户名称
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
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public int getOutState() {
		return outState;
	}
	public void setOutState(int outState) {
		this.outState = outState;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCarSeries() {
		return carSeries;
	}
	public void setCarSeries(String carSeries) {
		this.carSeries = carSeries;
	}
	
	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	@Override
	public String toString() {
		return "CarSellorder [id=" + id + ", carId=" + carId + ", customerId="
				+ customerId + ", salesman=" + salesman + ", count=" + count
				+ ", total=" + total + ", sellDate=" + sellDate + ", outDate="
				+ outDate + ", outState=" + outState + ", remark=" + remark
				+ ", sellPrice=" + sellPrice + ", carName=" + carName
				+ ", carSeries=" + carSeries + ", customerName=" + customerName
				+ "]";
	}
	
}
