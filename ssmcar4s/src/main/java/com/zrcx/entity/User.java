package com.zrcx.entity;

import java.util.Date;

import javax.management.loading.PrivateClassLoader;

/** 用户管理类 */
public class User {
	private Long id;
	private Integer deptId;//所属部门
	private String name;// 姓名
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entryDate;//入职时间
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;// 出生日期
	private Integer sex;// 性别
	private String username;// 用户名
	private String password;// 密码
	private Long loginFlag;// 状态(1无效2正常)
	private Long roleId;// 角色ID
	private String createDate;// 创建日期
	private String filePath;// 文件路径
	private Long applyState;// 申请状态
	private String salt;  
	private String credentialsSalt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(Long loginFlag) {
		this.loginFlag = loginFlag;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Long getApplyState() {
		return applyState;
	}
	public void setApplyState(Long applyState) {
		this.applyState = applyState;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCredentialsSalt() {
		return credentialsSalt;
	}
	public void setCredentialsSalt(String credentialsSalt) {
		this.credentialsSalt = credentialsSalt;
	}
    

}
