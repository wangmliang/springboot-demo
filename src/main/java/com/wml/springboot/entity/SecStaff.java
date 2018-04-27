/**
 * SecStaff.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;

import java.util.Date;

import com.wml.springboot.entity.SecDepartment;

/**
 * 成员
 * <pre>
 * <b>Title：</b>SecStaff.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecStaff {

	/**
	 * 成员ID
	 */
	private Long staffId;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 组织ID
	 */
	private Long departmentId;

	/**
	 * 成员姓名
	 */
	private String realName;

	/**
	 * 密码（经过加密）
	 */
	private String password;

	/**
	 * 成员状态
	 */
	private String status;

	/**
	 * 性别：MALE-男性；FEMALE-女性；
	 */
	private String sex;

	/**
	 * 电话
	 */
	private String telephone;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 邮件地址
	 */
	private String email;

	/**
	 * 成员创建者
	 */
	private String createUser;

	/**
	 * 成员创建时间
	 */
	private Date createDate;

	/**
	 * 成员帐号过期时间
	 */
	private Date expireDate;

	/**
	 * 成员最后修改时间
	 */
	private Date lastUpdateDate;

	/**
	 * 密码失效时间
	 */
	private Date passwordExpireDate;

	/**
	 * 用户锁定时间
	 */
	private Date lockDate;

	/**
	 * 成员所在城市（参见CITY表）
	 */
	private Integer cityId;

	/**
	 * 一对一关系隐射
	 */
	private SecDepartment secDepartment;


	/**
	 * 设置：成员ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.STAFF_ID
	 * 2018-04-27 12:17:59
	 */
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	/**
	 * 获取：成员ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.STAFF_ID
	 */
	public Long getStaffId() {
		return staffId;
	}

	/**
	 * 设置：登录名
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.LOGIN_NAME
	 * 2018-04-27 12:17:59
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	/**
	 * 获取：登录名
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.LOGIN_NAME
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置：组织ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.DEPARTMENT_ID
	 * 2018-04-27 12:17:59
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * 获取：组织ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.DEPARTMENT_ID
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * 设置：成员姓名
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.REAL_NAME
	 * 2018-04-27 12:17:59
	 */
	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}

	/**
	 * 获取：成员姓名
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.REAL_NAME
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * 设置：密码（经过加密）
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.PASSWORD
	 * 2018-04-27 12:17:59
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * 获取：密码（经过加密）
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.PASSWORD
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置：成员状态
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.STATUS
	 * 2018-04-27 12:17:59
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * 获取：成员状态
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.STATUS
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置：性别：MALE-男性；FEMALE-女性；
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.SEX
	 * 2018-04-27 12:17:59
	 */
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	/**
	 * 获取：性别：MALE-男性；FEMALE-女性；
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.SEX
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置：电话
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.TELEPHONE
	 * 2018-04-27 12:17:59
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	/**
	 * 获取：电话
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.TELEPHONE
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 设置：手机号码
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.MOBILE
	 * 2018-04-27 12:17:59
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	/**
	 * 获取：手机号码
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.MOBILE
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置：邮件地址
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.EMAIL
	 * 2018-04-27 12:17:59
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * 获取：邮件地址
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.EMAIL
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置：成员创建者
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.CREATE_USER
	 * 2018-04-27 12:17:59
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * 获取：成员创建者
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.CREATE_USER
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * 设置：成员创建时间
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.CREATE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取：成员创建时间
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.CREATE_DATE
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置：成员帐号过期时间
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.EXPIRE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * 获取：成员帐号过期时间
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.EXPIRE_DATE
	 */
	public Date getExpireDate() {
		return expireDate;
	}

	/**
	 * 设置：成员最后修改时间
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.LAST_UPDATE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * 获取：成员最后修改时间
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.LAST_UPDATE_DATE
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * 设置：密码失效时间
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.PASSWORD_EXPIRE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setPasswordExpireDate(Date passwordExpireDate) {
		this.passwordExpireDate = passwordExpireDate;
	}

	/**
	 * 获取：密码失效时间
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.PASSWORD_EXPIRE_DATE
	 */
	public Date getPasswordExpireDate() {
		return passwordExpireDate;
	}

	/**
	 * 设置：用户锁定时间
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.LOCK_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}

	/**
	 * 获取：用户锁定时间
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.LOCK_DATE
	 */
	public Date getLockDate() {
		return lockDate;
	}

	/**
	 * 设置：成员所在城市（参见CITY表）
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.CITY_ID
	 * 2018-04-27 12:17:59
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * 获取：成员所在城市（参见CITY表）
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.CITY_ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * 设置：secDepartment
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public void setsecDepartment(SecDepartment secDepartment) {
		this.secDepartment = secDepartment;
	}

	/**
	 * 获取：secDepartment
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public SecDepartment getsecDepartment() {
		return secDepartment;
	}

	@Override
	public String toString() {
		return "SecStaff [staffId=" +  staffId + ", loginName=" +  loginName + ", departmentId=" +  departmentId + ", realName=" +  realName
				+ ", password=" +  password + ", status=" +  status + ", sex=" +  sex
				+ ", telephone=" +  telephone + ", mobile=" +  mobile + ", email=" +  email
				+ ", createUser=" +  createUser + ", createDate=" +  createDate + ", expireDate=" +  expireDate
				+ ", lastUpdateDate=" +  lastUpdateDate + ", passwordExpireDate=" +  passwordExpireDate + ", lockDate=" +  lockDate
				+ ", cityId=" +  cityId + "]";
	}

}