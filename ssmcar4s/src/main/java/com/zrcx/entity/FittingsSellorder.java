package com.zrcx.entity;

import java.util.Date;

/**
 * 配件信息表
 * @author JQS
 *
 */
public class FittingsSellorder {
	private Long id;
	private int fittingsId;//配件Id
	private int customerId;//客户ID	
	private String salesman;//销售人员
	private int sellPrice;//实际单价
	private int count;//数量
	private Date outDate;//提货日期
	private Date sellDate;//销售日期
	private Long outState;//提货状态
	private int total;//总价
	private String remark;
	//临时属性
	private String fittingsname;//配件名称
	private String fittingsbrand;//配件品牌
	private String customername;//客户名称
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getFittingsId() {
		return fittingsId;
	}
	public void setFittingsId(int fittingsId) {
		this.fittingsId = fittingsId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	public Long getOutState() {
		return outState;
	}
	public void setOutState(Long outState) {
		this.outState = outState;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getFittingsname() {
		return fittingsname;
	}
	public void setFittingsname(String fittingsname) {
		this.fittingsname = fittingsname;
	}
	public String getFittingsbrand() {
		return fittingsbrand;
	}
	public void setFittingsbrand(String fittingsbrand) {
		this.fittingsbrand = fittingsbrand;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "FittingsSellorder [id=" + id + ", fittingsId=" + fittingsId
				+ ", customerId=" + customerId + ", salesman=" + salesman
				+ ", sellPrice=" + sellPrice + ", count=" + count
				+ ", outDate=" + outDate + ", sellDate=" + sellDate
				+ ", outState=" + outState + ", total=" + total
				+ ", fittingsname=" + fittingsname + ", fittingsbrand="
				+ fittingsbrand + ", customername=" + customername
				+ ", remark=" + remark + "]";
	}
	
}
