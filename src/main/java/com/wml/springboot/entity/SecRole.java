/**
 * SecRole.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;

import java.util.Date;


/**
 * ��ɫ
 * <pre>
 * <b>Title��</b>SecRole.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecRole {

	/**
	 * ��ɫID
	 */
	private Long roleId;

	/**
	 * ��ɫ����
	 */
	private String roleName;

	/**
	 * ��ɫ����
	 */
	private String roleDesc;

	/**
	 * ��ɫ������
	 */
	private String createUser;

	/**
	 * ��ɫ����ʱ��
	 */
	private Date createDate;

	/**
	 * �Ƿ������޸� 1������ 0: ������ ȱʡ=1
	 */
	private Integer canModify;

	/**
	 * ��ɫ����޸�ʱ��
	 */
	private Date lastUpdateDate;

	/**
	 * ��ɫ����
	 */
	private String roleKey;

	/**
	 * �Զ�����(0:���Զ����䣻1���Զ����������ע���Ա)
	 */
	private Integer autoAssign;

	/**
	 * �Ƿ��ڽ����Ͽɼ�(0�����ɼ���1���ɼ�)
	 */
	private Integer visible;


	/**
	 * ���ã���ɫID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.ROLE_ID
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
	 * @return the value of sec_role.ROLE_ID
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * ���ã���ɫ����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.ROLE_NAME
	 * 2018-04-27 12:17:59
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	/**
	 * ��ȡ����ɫ����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.ROLE_NAME
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * ���ã���ɫ����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.ROLE_DESC
	 * 2018-04-27 12:17:59
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc == null ? null : roleDesc.trim();
	}

	/**
	 * ��ȡ����ɫ����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.ROLE_DESC
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * ���ã���ɫ������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.CREATE_USER
	 * 2018-04-27 12:17:59
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * ��ȡ����ɫ������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.CREATE_USER
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * ���ã���ɫ����ʱ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.CREATE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * ��ȡ����ɫ����ʱ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.CREATE_DATE
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * ���ã��Ƿ������޸� 1������ 0: ������ ȱʡ=1
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.CAN_MODIFY
	 * 2018-04-27 12:17:59
	 */
	public void setCanModify(Integer canModify) {
		this.canModify = canModify;
	}

	/**
	 * ��ȡ���Ƿ������޸� 1������ 0: ������ ȱʡ=1
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.CAN_MODIFY
	 */
	public Integer getCanModify() {
		return canModify;
	}

	/**
	 * ���ã���ɫ����޸�ʱ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.LAST_UPDATE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * ��ȡ����ɫ����޸�ʱ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.LAST_UPDATE_DATE
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * ���ã���ɫ����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.ROLE_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey == null ? null : roleKey.trim();
	}

	/**
	 * ��ȡ����ɫ����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.ROLE_KEY
	 */
	public String getRoleKey() {
		return roleKey;
	}

	/**
	 * ���ã��Զ�����(0:���Զ����䣻1���Զ����������ע���Ա)
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.AUTO_ASSIGN
	 * 2018-04-27 12:17:59
	 */
	public void setAutoAssign(Integer autoAssign) {
		this.autoAssign = autoAssign;
	}

	/**
	 * ��ȡ���Զ�����(0:���Զ����䣻1���Զ����������ע���Ա)
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.AUTO_ASSIGN
	 */
	public Integer getAutoAssign() {
		return autoAssign;
	}

	/**
	 * ���ã��Ƿ��ڽ����Ͽɼ�(0�����ɼ���1���ɼ�)
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.visible
	 * 2018-04-27 12:17:59
	 */
	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	/**
	 * ��ȡ���Ƿ��ڽ����Ͽɼ�(0�����ɼ���1���ɼ�)
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.visible
	 */
	public Integer getVisible() {
		return visible;
	}


	@Override
	public String toString() {
		return "SecRole [roleId=" +  roleId + ", roleName=" +  roleName + ", roleDesc=" +  roleDesc + ", createUser=" +  createUser
				+ ", createDate=" +  createDate + ", canModify=" +  canModify + ", lastUpdateDate=" +  lastUpdateDate
				+ ", roleKey=" +  roleKey + ", autoAssign=" +  autoAssign + ", visible=" +  visible
				+ "]";
	}

}