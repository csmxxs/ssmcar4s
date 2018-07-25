package com.zrcx.entity;
import java.util.Date;
/**
 * 汽车信息
 * @author JQS
 *
 */
public class Car {
	private Long id;
	private String brand;//品牌
	private String series;//车系
	private int type;//类型
	private	String volume;//排量
	private String color;//颜色
	private String proPlace;//产地
	private double price;//指导价
	private int delFlag;//删除标记
	private String remark;//备注
	private Date createDate;//上市日期
	private String filePath;//图片
	private Integer supplierId;//供应商
	
	
	
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getProPlace() {
		return proPlace;
	}
	public void setProPlace(String proPlace) {
		this.proPlace = proPlace;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", series=" + series
				+ ", type=" + type + ", volume=" + volume + ", color=" + color
				+ ", proPlace=" + proPlace + ", price=" + price + ", delFlag="
				+ delFlag + ", remark=" + remark + ", createDate=" + createDate
				+ ", filepath=" + filePath + "]";
	}
	
}
