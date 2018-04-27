/**
 * SecStaffDepartmentRole.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;



/**
 * 成员组织角色关联表
 * <pre>
 * <b>Title：</b>SecStaffDepartmentRole.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecStaffDepartmentRole {

	/**
	 * 成员ID
	 */
	private Long staffId;

	/**
	 * 组织ID
	 */
	private Long departmentId;

	/**
	 * 角色ID
	 */
	private Long roleId;


	/**
	 * 设置：成员ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff_department_role.STAFF_ID
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
	 * @return the value of sec_staff_department_role.STAFF_ID
	 */
	public Long getStaffId() {
		return staffId;
	}

	/**
	 * 设置：组织ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff_department_role.DEPARTMENT_ID
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
	 * @return the value of sec_staff_department_role.DEPARTMENT_ID
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * 设置：角色ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff_department_role.ROLE_ID
	 * 2018-04-27 12:17:59
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取：角色ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_staff_department_role.ROLE_ID
	 */
	public Long getRoleId() {
		return roleId;
	}


	@Override
	public String toString() {
		return "SecStaffDepartmentRole [staffId=" +  staffId + ", departmentId=" +  departmentId + ", roleId=" +  roleId + "]";
	}

}