/**
 * SecDepartmentRole.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecDepartment;
import com.wml.springboot.entity.SecRole;

/**
 * 组织角色关联表
 * <pre>
 * <b>Title：</b>SecDepartmentRole.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecDepartmentRole {

	/**
	 * 组织ID
	 */
	private Long departmentId;

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 一对一关系隐射
	 */
	private SecDepartment secDepartment;

	/**
	 * 一对一关系隐射
	 */
	private SecRole secRole;


	/**
	 * 设置：组织ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department_role.DEPARTMENT_ID
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
	 * @return the value of sec_department_role.DEPARTMENT_ID
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * 设置：角色ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department_role.ROLE_ID
	 * 2018-04-27 12:17:58
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取：角色ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department_role.ROLE_ID
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 设置：secDepartment
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public void setsecDepartment(SecDepartment secDepartment) {
		this.secDepartment = secDepartment;
	}

	/**
	 * 获取：secDepartment
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public SecDepartment getsecDepartment() {
		return secDepartment;
	}
	/**
	 * 设置：secRole
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public void setsecRole(SecRole secRole) {
		this.secRole = secRole;
	}

	/**
	 * 获取：secRole
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public SecRole getsecRole() {
		return secRole;
	}

	@Override
	public String toString() {
		return "SecDepartmentRole [departmentId=" +  departmentId + ", roleId=" +  roleId + "]";
	}

}