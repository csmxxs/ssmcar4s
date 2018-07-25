package com.zrcx.entity;

import java.util.Date;

/**
 * 供应商信息表
 * @author JQS
 *
 */

public class Supplier {
	private Long id;
	private String name;//供应商姓名
	private String contacts;//联系人姓名
	private String contactTel;//联系电话
	private String bankName;//开户银行
	private String bankAccount;//银行账号
	private int delFlag;//删除标记
	private String remark;//备注
	private Date createDate;//创建日期
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
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
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
		return "Supplier [id=" + id + ", name=" + name + ", contacts="
				+ contacts + ", contactTel=" + contactTel + ", bankName="
				+ bankName + ", bankAccount=" + bankAccount + ", delFlag="
				+ delFlag + ", remark=" + remark + ", createDate=" + createDate
				+ "]";
	}
	
	
}
