package com.zrcx.entity;

/**
 * 配件库存信息
 * 
 * @author JQS
 * 
 */
public class FittingsStock {
	private Long id;
	private Long fittingsId;
	private Integer count;
	private String remark;
	// 配件库存临时变量
	private String carstockname;
	private String carstockbrand;
	private String carstocktype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFittingsId() {
		return fittingsId;
	}

	public void setFittingsId(Long fittingsId) {
		this.fittingsId = fittingsId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCarstockname() {
		return carstockname;
	}

	public void setCarstockname(String carstockname) {
		this.carstockname = carstockname;
	}

	public String getCarstockbrand() {
		return carstockbrand;
	}

	public void setCarstockbrand(String carstockbrand) {
		this.carstockbrand = carstockbrand;
	}

	public String getCarstocktype() {
		return carstocktype;
	}
	public void setCarstocktype(String carstocktype) {
		this.carstocktype = carstocktype;
	}

	public FittingsStock(Long id, Long fittingsId, Integer count, String remark) {
		super();
		this.id = id;
		this.fittingsId = fittingsId;
		this.count = count;
		this.remark = remark;
	}
	public FittingsStock() {
		super();
	}

	@Override
	public String toString() {
		return "FittingsStock [id=" + id + ", fittingsId=" + fittingsId
				+ ", count=" + count + ", remark=" + remark + ", carstockname="
				+ carstockname + ", carstockbrand=" + carstockbrand
				+ ", carstocktype=" + carstocktype + "]";
	}

}
