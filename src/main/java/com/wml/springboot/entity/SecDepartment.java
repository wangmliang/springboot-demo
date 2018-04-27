/**
 * SecDepartment.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;

import java.util.Date;

import com.wml.springboot.entity.SecDepartment;

/**
 * 组织
 * <pre>
 * <b>Title：</b>SecDepartment.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecDepartment {

	/**
	 * 组织ID
	 */
	private Long departmentId;

	/**
	 * 组织名称
	 */
	private String departmentName;

	/**
	 * 组织描述
	 */
	private String departmentDesc;

	/**
	 * 父级组织
	 */
	private Long parentId;

	/**
	 * 组织的邮件
	 */
	private String email;

	/**
	 * 组织地址
	 */
	private String address;

	/**
	 * 是否可以创建下级组织
	 */
	private String addSub;

	/**
	 * 组织创建者
	 */
	private String createUser;

	/**
	 * 组织创建时间
	 */
	private Date createDate;

	/**
	 * 组织最后修改时间
	 */
	private Date lastUpdateDate;

	/**
	 * 管理域：SP、SYS_ADMIN
	 */
	private String domain;

	/**
	 * 一对一关系隐射
	 */
	private SecDepartment secDepartmentParentId;


	/**
	 * 设置：组织ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.DEPARTMENT_ID
	 * 2018-04-27 12:17:58
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * 获取：组织ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.DEPARTMENT_ID
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * 设置：组织名称
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.DEPARTMENT_NAME
	 * 2018-04-27 12:17:58
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName == null ? null : departmentName.trim();
	}

	/**
	 * 获取：组织名称
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.DEPARTMENT_NAME
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 设置：组织描述
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.DEPARTMENT_DESC
	 * 2018-04-27 12:17:58
	 */
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc == null ? null : departmentDesc.trim();
	}

	/**
	 * 获取：组织描述
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.DEPARTMENT_DESC
	 */
	public String getDepartmentDesc() {
		return departmentDesc;
	}

	/**
	 * 设置：父级组织
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.PARENT_ID
	 * 2018-04-27 12:17:58
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取：父级组织
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.PARENT_ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置：组织的邮件
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.EMAIL
	 * 2018-04-27 12:17:58
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * 获取：组织的邮件
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.EMAIL
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置：组织地址
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.ADDRESS
	 * 2018-04-27 12:17:58
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * 获取：组织地址
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.ADDRESS
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置：是否可以创建下级组织
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.ADD_SUB
	 * 2018-04-27 12:17:58
	 */
	public void setAddSub(String addSub) {
		this.addSub = addSub == null ? null : addSub.trim();
	}

	/**
	 * 获取：是否可以创建下级组织
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.ADD_SUB
	 */
	public String getAddSub() {
		return addSub;
	}

	/**
	 * 设置：组织创建者
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.CREATE_USER
	 * 2018-04-27 12:17:58
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * 获取：组织创建者
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.CREATE_USER
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * 设置：组织创建时间
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.CREATE_DATE
	 * 2018-04-27 12:17:58
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取：组织创建时间
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.CREATE_DATE
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置：组织最后修改时间
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.LAST_UPDATE_DATE
	 * 2018-04-27 12:17:58
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * 获取：组织最后修改时间
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.LAST_UPDATE_DATE
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * 设置：管理域：SP、SYS_ADMIN
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department.DOMAIN
	 * 2018-04-27 12:17:58
	 */
	public void setDomain(String domain) {
		this.domain = domain == null ? null : domain.trim();
	}

	/**
	 * 获取：管理域：SP、SYS_ADMIN
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * 设置：secDepartment
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public void setsecDepartmentParentId(SecDepartment secDepartmentParentId) {
		this.secDepartmentParentId = secDepartmentParentId;
	}

	/**
	 * 获取：secDepartmentParentId
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