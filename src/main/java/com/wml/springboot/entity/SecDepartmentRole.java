/**
 * SecDepartmentRole.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecDepartment;
import com.wml.springboot.entity.SecRole;

/**
 * ��֯��ɫ������
 * <pre>
 * <b>Title��</b>SecDepartmentRole.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecDepartmentRole {

	/**
	 * ��֯ID
	 */
	private Long departmentId;

	/**
	 * ��ɫID
	 */
	private Long roleId;

	/**
	 * һ��һ��ϵ����
	 */
	private SecDepartment secDepartment;

	/**
	 * һ��һ��ϵ����
	 */
	private SecRole secRole;


	/**
	 * ���ã���֯ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department_role.DEPARTMENT_ID
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
	 * @return the value of sec_department_role.DEPARTMENT_ID
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * ���ã���ɫID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_department_role.ROLE_ID
	 * 2018-04-27 12:17:58
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * ��ȡ����ɫID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_department_role.ROLE_ID
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * ���ã�secDepartment
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public void setsecDepartment(SecDepartment secDepartment) {
		this.secDepartment = secDepartment;
	}

	/**
	 * ��ȡ��secDepartment
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public SecDepartment getsecDepartment() {
		return secDepartment;
	}
	/**
	 * ���ã�secRole
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public void setsecRole(SecRole secRole) {
		this.secRole = secRole;
	}

	/**
	 * ��ȡ��secRole
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