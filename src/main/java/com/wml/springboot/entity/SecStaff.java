/**
 * SecStaff.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;

import java.util.Date;

import com.wml.springboot.entity.SecDepartment;

/**
 * ��Ա
 * <pre>
 * <b>Title��</b>SecStaff.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecStaff {

	/**
	 * ��ԱID
	 */
	private Long staffId;

	/**
	 * ��¼��
	 */
	private String loginName;

	/**
	 * ��֯ID
	 */
	private Long departmentId;

	/**
	 * ��Ա����
	 */
	private String realName;

	/**
	 * ���루�������ܣ�
	 */
	private String password;

	/**
	 * ��Ա״̬
	 */
	private String status;

	/**
	 * �Ա�MALE-���ԣ�FEMALE-Ů�ԣ�
	 */
	private String sex;

	/**
	 * �绰
	 */
	private String telephone;

	/**
	 * �ֻ�����
	 */
	private String mobile;

	/**
	 * �ʼ���ַ
	 */
	private String email;

	/**
	 * ��Ա������
	 */
	private String createUser;

	/**
	 * ��Ա����ʱ��
	 */
	private Date createDate;

	/**
	 * ��Ա�ʺŹ���ʱ��
	 */
	private Date expireDate;

	/**
	 * ��Ա����޸�ʱ��
	 */
	private Date lastUpdateDate;

	/**
	 * ����ʧЧʱ��
	 */
	private Date passwordExpireDate;

	/**
	 * �û�����ʱ��
	 */
	private Date lockDate;

	/**
	 * ��Ա���ڳ��У��μ�CITY��
	 */
	private Integer cityId;

	/**
	 * һ��һ��ϵ����
	 */
	private SecDepartment secDepartment;


	/**
	 * ���ã���ԱID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.STAFF_ID
	 * 2018-04-27 12:17:59
	 */
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	/**
	 * ��ȡ����ԱID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.STAFF_ID
	 */
	public Long getStaffId() {
		return staffId;
	}

	/**
	 * ���ã���¼��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.LOGIN_NAME
	 * 2018-04-27 12:17:59
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	/**
	 * ��ȡ����¼��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.LOGIN_NAME
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * ���ã���֯ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.DEPARTMENT_ID
	 * 2018-04-27 12:17:59
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * ��ȡ����֯ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.DEPARTMENT_ID
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * ���ã���Ա����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.REAL_NAME
	 * 2018-04-27 12:17:59
	 */
	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}

	/**
	 * ��ȡ����Ա����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.REAL_NAME
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * ���ã����루�������ܣ�
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.PASSWORD
	 * 2018-04-27 12:17:59
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * ��ȡ�����루�������ܣ�
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.PASSWORD
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ���ã���Ա״̬
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.STATUS
	 * 2018-04-27 12:17:59
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * ��ȡ����Ա״̬
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.STATUS
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ���ã��Ա�MALE-���ԣ�FEMALE-Ů�ԣ�
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.SEX
	 * 2018-04-27 12:17:59
	 */
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	/**
	 * ��ȡ���Ա�MALE-���ԣ�FEMALE-Ů�ԣ�
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.SEX
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * ���ã��绰
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.TELEPHONE
	 * 2018-04-27 12:17:59
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	/**
	 * ��ȡ���绰
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.TELEPHONE
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * ���ã��ֻ�����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.MOBILE
	 * 2018-04-27 12:17:59
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	/**
	 * ��ȡ���ֻ�����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.MOBILE
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * ���ã��ʼ���ַ
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.EMAIL
	 * 2018-04-27 12:17:59
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * ��ȡ���ʼ���ַ
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.EMAIL
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * ���ã���Ա������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.CREATE_USER
	 * 2018-04-27 12:17:59
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * ��ȡ����Ա������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.CREATE_USER
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * ���ã���Ա����ʱ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.CREATE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * ��ȡ����Ա����ʱ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.CREATE_DATE
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * ���ã���Ա�ʺŹ���ʱ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.EXPIRE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * ��ȡ����Ա�ʺŹ���ʱ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.EXPIRE_DATE
	 */
	public Date getExpireDate() {
		return expireDate;
	}

	/**
	 * ���ã���Ա����޸�ʱ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.LAST_UPDATE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * ��ȡ����Ա����޸�ʱ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.LAST_UPDATE_DATE
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * ���ã�����ʧЧʱ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.PASSWORD_EXPIRE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setPasswordExpireDate(Date passwordExpireDate) {
		this.passwordExpireDate = passwordExpireDate;
	}

	/**
	 * ��ȡ������ʧЧʱ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.PASSWORD_EXPIRE_DATE
	 */
	public Date getPasswordExpireDate() {
		return passwordExpireDate;
	}

	/**
	 * ���ã��û�����ʱ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.LOCK_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}

	/**
	 * ��ȡ���û�����ʱ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.LOCK_DATE
	 */
	public Date getLockDate() {
		return lockDate;
	}

	/**
	 * ���ã���Ա���ڳ��У��μ�CITY��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff.CITY_ID
	 * 2018-04-27 12:17:59
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * ��ȡ����Ա���ڳ��У��μ�CITY��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff.CITY_ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * ���ã�secDepartment
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public void setsecDepartment(SecDepartment secDepartment) {
		this.secDepartment = secDepartment;
	}

	/**
	 * ��ȡ��secDepartment
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