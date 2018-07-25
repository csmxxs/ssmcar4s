package com.zrcx.entity;
/**
 * 整车库存信息
 * @author JQS
 *
 */
public class CarStock {
	private Long id;
	private Long carId;//汽车id
	private Integer count;//汽车库存，低于10辆时报警
	private String remark;//备注
	//整车库存临时变量
	private String carbrand;
	private String carseries;
	private int cartype;
	private String carvolume;
	private String carcolor;
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
	public String getCarbrand() {
		return carbrand;
	}
	public void setCarbrand(String carbrand) {
		this.carbrand = carbrand;
	}
	public String getCarseries() {
		return carseries;
	}
	public void setCarseries(String carseries) {
		this.carseries = carseries;
	}
	public int getCartype() {
		return cartype;
	}
	public void setCartype(int cartype) {
		this.cartype = cartype;
	}
	public String getCarvolume() {
		return carvolume;
	}
	public void setCarvolume(String carvolume) {
		this.carvolume = carvolume;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	@Override
	public String toString() {
		return "CarStock [id=" + id + ", carId=" + carId + ", count=" + count
				+ ", remark=" + remark + ", carbrand=" + carbrand
				+ ", carseries=" + carseries + ", cartype=" + cartype
				+ ", carvolume=" + carvolume + ", carcolor=" + carcolor + "]";
	}


}
