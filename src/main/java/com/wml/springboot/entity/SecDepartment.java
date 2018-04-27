/**
 * SecDepartment.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;

import java.util.Date;

import com.wml.springboot.entity.SecDepartment;

/**
 * ��֯
 * <pre>
 * <b>Title��</b>SecDepartment.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecDepartment {

	/**
	 * ��֯ID
	 */
	private Long departmentId;

	/**
	 * ��֯����
	 */
	private String departmentName;

	/**
	 * ��֯����
	 */
	private String departmentDesc;

	/**
	 * ������֯
	 */
	private Long parentId;

	/**
	 * ��֯���ʼ�
	 */
	private String email;

	/**
	 * ��֯��ַ
	 */
	private String address;

	/**
	 * �Ƿ���Դ����¼���֯
	 */
	private String addSub;

	/**
	 * ��֯������
	 */
	private String createUser;

	/**
	 * ��֯����ʱ��
	 */
	private Date createDate;

	/**
	 * ��֯����޸�ʱ��
	 */
	private Date lastUpdateDate;

	/**
	 * ������SP��SYS_ADMIN
	 */
	private String domain;

	/**
	 * һ��һ��ϵ����
	 */
	private SecDepartment secDepartmentParentId;


	/**
	 * ���ã���֯ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.DEPARTMENT_ID
	 * 2018-04-27 12:17:58
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * ��ȡ����֯ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.DEPARTMENT_ID
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * ���ã���֯����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.DEPARTMENT_NAME
	 * 2018-04-27 12:17:58
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName == null ? null : departmentName.trim();
	}

	/**
	 * ��ȡ����֯����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.DEPARTMENT_NAME
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * ���ã���֯����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.DEPARTMENT_DESC
	 * 2018-04-27 12:17:58
	 */
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc == null ? null : departmentDesc.trim();
	}

	/**
	 * ��ȡ����֯����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.DEPARTMENT_DESC
	 */
	public String getDepartmentDesc() {
		return departmentDesc;
	}

	/**
	 * ���ã�������֯
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.PARENT_ID
	 * 2018-04-27 12:17:58
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * ��ȡ��������֯
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.PARENT_ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * ���ã���֯���ʼ�
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.EMAIL
	 * 2018-04-27 12:17:58
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * ��ȡ����֯���ʼ�
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.EMAIL
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * ���ã���֯��ַ
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.ADDRESS
	 * 2018-04-27 12:17:58
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * ��ȡ����֯��ַ
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.ADDRESS
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * ���ã��Ƿ���Դ����¼���֯
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.ADD_SUB
	 * 2018-04-27 12:17:58
	 */
	public void setAddSub(String addSub) {
		this.addSub = addSub == null ? null : addSub.trim();
	}

	/**
	 * ��ȡ���Ƿ���Դ����¼���֯
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.ADD_SUB
	 */
	public String getAddSub() {
		return addSub;
	}

	/**
	 * ���ã���֯������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.CREATE_USER
	 * 2018-04-27 12:17:58
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * ��ȡ����֯������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.CREATE_USER
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * ���ã���֯����ʱ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.CREATE_DATE
	 * 2018-04-27 12:17:58
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * ��ȡ����֯����ʱ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.CREATE_DATE
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * ���ã���֯����޸�ʱ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.LAST_UPDATE_DATE
	 * 2018-04-27 12:17:58
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * ��ȡ����֯����޸�ʱ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.LAST_UPDATE_DATE
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * ���ã�������SP��SYS_ADMIN
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.DOMAIN
	 * 2018-04-27 12:17:58
	 */
	public void setDomain(String domain) {
		this.domain = domain == null ? null : domain.trim();
	}

	/**
	 * ��ȡ��������SP��SYS_ADMIN
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * ���ã�secDepartment
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public void setsecDepartmentParentId(SecDepartment secDepartmentParentId) {
		this.secDepartmentParentId = secDepartmentParentId;
	}

	/**
	 * ��ȡ��secDepartmentParentId
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public SecDepartment getsecDepartmentParentId() {
		return secDepartmentParentId;
	}

	@Override
	public String toString() {
		return "SecDepartment [departmentId=" +  departmentId + ", departmentName=" +  departmentName + ", departmentDesc=" +  departmentDesc + ", parentId=" +  parentId
				+ ", email=" +  email + ", address=" +  address + ", addSub=" +  addSub
				+ ", createUser=" +  createUser + ", createDate=" +  createDate + ", lastUpdateDate=" +  lastUpdateDate
				+ ", domain=" +  domain + "]";
	}

}