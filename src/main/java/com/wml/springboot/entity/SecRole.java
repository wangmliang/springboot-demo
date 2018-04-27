/**
 * SecRole.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;

import java.util.Date;


/**
 * 角色
 * <pre>
 * <b>Title：</b>SecRole.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecRole {

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色描述
	 */
	private String roleDesc;

	/**
	 * 角色创建者
	 */
	private String createUser;

	/**
	 * 角色创建时间
	 */
	private Date createDate;

	/**
	 * 是否允许修改 1：允许 0: 不充许 缺省=1
	 */
	private Integer canModify;

	/**
	 * 角色最后修改时间
	 */
	private Date lastUpdateDate;

	/**
	 * 角色外码
	 */
	private String roleKey;

	/**
	 * 自动分配(0:不自动分配；1：自动分配给所有注册成员)
	 */
	private Integer autoAssign;

	/**
	 * 是否在界面上可见(0：不可见；1：可见)
	 */
	private Integer visible;


	/**
	 * 设置：角色ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.ROLE_ID
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
	 * @return the value of sec_role.ROLE_ID
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 设置：角色名称
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.ROLE_NAME
	 * 2018-04-27 12:17:59
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	/**
	 * 获取：角色名称
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.ROLE_NAME
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置：角色描述
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.ROLE_DESC
	 * 2018-04-27 12:17:59
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc == null ? null : roleDesc.trim();
	}

	/**
	 * 获取：角色描述
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.ROLE_DESC
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * 设置：角色创建者
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.CREATE_USER
	 * 2018-04-27 12:17:59
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * 获取：角色创建者
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.CREATE_USER
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * 设置：角色创建时间
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.CREATE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取：角色创建时间
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.CREATE_DATE
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置：是否允许修改 1：允许 0: 不充许 缺省=1
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.CAN_MODIFY
	 * 2018-04-27 12:17:59
	 */
	public void setCanModify(Integer canModify) {
		this.canModify = canModify;
	}

	/**
	 * 获取：是否允许修改 1：允许 0: 不充许 缺省=1
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.CAN_MODIFY
	 */
	public Integer getCanModify() {
		return canModify;
	}

	/**
	 * 设置：角色最后修改时间
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.LAST_UPDATE_DATE
	 * 2018-04-27 12:17:59
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * 获取：角色最后修改时间
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.LAST_UPDATE_DATE
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * 设置：角色外码
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.ROLE_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey == null ? null : roleKey.trim();
	}

	/**
	 * 获取：角色外码
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.ROLE_KEY
	 */
	public String getRoleKey() {
		return roleKey;
	}

	/**
	 * 设置：自动分配(0:不自动分配；1：自动分配给所有注册成员)
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.AUTO_ASSIGN
	 * 2018-04-27 12:17:59
	 */
	public void setAutoAssign(Integer autoAssign) {
		this.autoAssign = autoAssign;
	}

	/**
	 * 获取：自动分配(0:不自动分配；1：自动分配给所有注册成员)
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_role.AUTO_ASSIGN
	 */
	public Integer getAutoAssign() {
		return autoAssign;
	}

	/**
	 * 设置：是否在界面上可见(0：不可见；1：可见)
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_role.visible
	 * 2018-04-27 12:17:59
	 */
	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	/**
	 * 获取：是否在界面上可见(0：不可见；1：可见)
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