/**
 * SecStaffDepartmentRole.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;



/**
 * ��Ա��֯��ɫ������
 * <pre>
 * <b>Title��</b>SecStaffDepartmentRole.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecStaffDepartmentRole {

	/**
	 * ��ԱID
	 */
	private Long staffId;

	/**
	 * ��֯ID
	 */
	private Long departmentId;

	/**
	 * ��ɫID
	 */
	private Long roleId;


	/**
	 * ���ã���ԱID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff_department_role.STAFF_ID
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
	 * @return the value of sec_staff_department_role.STAFF_ID
	 */
	public Long getStaffId() {
		return staffId;
	}

	/**
	 * ���ã���֯ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff_department_role.DEPARTMENT_ID
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
	 * @return the value of sec_staff_department_role.DEPARTMENT_ID
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * ���ã���ɫID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_staff_department_role.ROLE_ID
	 * 2018-04-27 12:17:59
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * ��ȡ����ɫID
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