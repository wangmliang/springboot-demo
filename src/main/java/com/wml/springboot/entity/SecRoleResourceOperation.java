/**
 * SecRoleResourceOperation.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecOperation;
import com.wml.springboot.entity.SecRole;

/**
 * 角色与资源操作
 * <pre>
 * <b>Title：</b>SecRoleResourceOperation.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecRoleResourceOperation {

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 资源ID
	 */
	private Long resourceId;

	/**
	 * 资源操作关键字
	 */
	private String operationKey;

	/**
	 * 一对一关系隐射
	 */
	private SecOperation secOperation;

	/**
	 * 一对一关系隐射
	 */
	private SecRole secRole;


	/**
	 * 设置：角色ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role_resource_operation.ROLE_ID
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
	 * @return the value of sec_role_resource_operation.ROLE_ID
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 设置：资源ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role_resource_operation.RESOURCE_ID
	 * 2018-04-27 12:17:59
	 */
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * 获取：资源ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role_resource_operation.RESOURCE_ID
	 */
	public Long getResourceId() {
		return resourceId;
	}

	/**
	 * 设置：资源操作关键字
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role_resource_operation.OPERATION_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setOperationKey(String operationKey) {
		this.operationKey = operationKey == null ? null : operationKey.trim();
	}

	/**
	 * 获取：资源操作关键字
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role_resource_operation.OPERATION_KEY
	 */
	public String getOperationKey() {
		return operationKey;
	}

	/**
	 * 设置：secOperation
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public void setsecOperation(SecOperation secOperation) {
		this.secOperation = secOperation;
	}

	/**
	 * 获取：secOperation
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public SecOperation getsecOperation() {
		return secOperation;
	}
	/**
	 * 设置：secRole
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public void setsecRole(SecRole secRole) {
		this.secRole = secRole;
	}

	/**
	 * 获取：secRole
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public SecRole getsecRole() {
		return secRole;
	}

	@Override
	public String toString() {
		return "SecRoleResourceOperation [roleId=" +  roleId + ", resourceId=" +  resourceId + ", operationKey=" +  operationKey + "]";
	}

}