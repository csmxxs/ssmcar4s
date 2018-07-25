package com.zrcx.entity;

import java.util.Date;

/**
 * 配件订货单信息表
 * @author JQS
 *
 */
public class FittingsInorder {
	private Long id;
	private Integer fittingsId;
	private Integer supplierId;
	private Integer inPrice;
	private Integer count;
	private Integer total;
	private Date createDate;
	private Date inDate;
	private Integer inState;
	private String remark;
	private Integer delFlag;
	
	//临时属性
	private String fittingsName;//配件名称
	private String fittingsbrand;//品牌
	private String supplierName;//供应商
	

	public String getFittingsName() {
		return fittingsName;
	}
	public void setFittingsName(String fittingsName) {
		this.fittingsName = fittingsName;
	}
	public String getFittingsbrand() {
		return fittingsbrand;
	}
	public void setFittingsbrand(String fittingsbrand) {
		this.fittingsbrand = fittingsbrand;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getFittingsId() {
		return fittingsId;
	}
	public void setFittingsId(Integer fittingsId) {
		this.fittingsId = fittingsId;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
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
	@Override
	public String toString() {
		return "FittingsInorder [id=" + id + ", fittingsId=" + fittingsId
				+ ", supplierId=" + supplierId + ", inPrice=" + inPrice
				+ ", count=" + count + ", total=" + total + ", createDate="
				+ createDate + ", inDate=" + inDate + ", inState=" + inState
				+ ", remark=" + remark + ", delFlag=" + delFlag
				+ ", fittingsName=" + fittingsName + ", fittingsbrand="
				+ fittingsbrand + ", supplierName=" + supplierName + "]";
	}

}
