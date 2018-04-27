/**
 * SecRoleResourceOperation.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecOperation;
import com.wml.springboot.entity.SecRole;

/**
 * ��ɫ����Դ����
 * <pre>
 * <b>Title��</b>SecRoleResourceOperation.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecRoleResourceOperation {

	/**
	 * ��ɫID
	 */
	private Long roleId;

	/**
	 * ��ԴID
	 */
	private Long resourceId;

	/**
	 * ��Դ�����ؼ���
	 */
	private String operationKey;

	/**
	 * һ��һ��ϵ����
	 */
	private SecOperation secOperation;

	/**
	 * һ��һ��ϵ����
	 */
	private SecRole secRole;


	/**
	 * ���ã���ɫID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role_resource_operation.ROLE_ID
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
	 * @return the value of sec_role_resource_operation.ROLE_ID
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * ���ã���ԴID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role_resource_operation.RESOURCE_ID
	 * 2018-04-27 12:17:59
	 */
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * ��ȡ����ԴID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role_resource_operation.RESOURCE_ID
	 */
	public Long getResourceId() {
		return resourceId;
	}

	/**
	 * ���ã���Դ�����ؼ���
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role_resource_operation.OPERATION_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setOperationKey(String operationKey) {
		this.operationKey = operationKey == null ? null : operationKey.trim();
	}

	/**
	 * ��ȡ����Դ�����ؼ���
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role_resource_operation.OPERATION_KEY
	 */
	public String getOperationKey() {
		return operationKey;
	}

	/**
	 * ���ã�secOperation
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public void setsecOperation(SecOperation secOperation) {
		this.secOperation = secOperation;
	}

	/**
	 * ��ȡ��secOperation
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public SecOperation getsecOperation() {
		return secOperation;
	}
	/**
	 * ���ã�secRole
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public void setsecRole(SecRole secRole) {
		this.secRole = secRole;
	}

	/**
	 * ��ȡ��secRole
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