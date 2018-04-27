/**
 * SecLoginHistory.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;

import java.util.Date;


/**
 * 成员登录日志
 * <pre>
 * <b>Title：</b>SecLoginHistory.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecLoginHistory {

	/**
	 * 成员ID
	 */
	private Long staffId;

	/**
	 * 登录时间
	 */
	private Date loginTime;

	/**
	 * LOGOUT：注销；SUCCESS：登录成功；FAIL：登录失败；TIMEOUT：用户超时；UNLOCK：解锁；AUTOLOCK：密码尝试过多被锁
	 */
	private String loginFlag;

	/**
	 * 备注，现在用来记录用户登录密码尝试过多被锁前的用户状态
	 */
	private String description;


	/**
	 * 设置：成员ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_login_history.STAFF_ID
	 * 2018-04-27 12:17:58
	 */
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	/**
	 * 获取：成员ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_login_history.STAFF_ID
	 */
	public Long getStaffId() {
		return staffId;
	}

	/**
	 * 设置：登录时间
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_login_history.LOGIN_TIME
	 * 2018-04-27 12:17:58
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * 获取：登录时间
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_login_history.LOGIN_TIME
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * 设置：LOGOUT：注销；SUCCESS：登录成功；FAIL：登录失败；TIMEOUT：用户超时；UNLOCK：解锁；AUTOLOCK：密码尝试过多被锁
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_login_history.LOGIN_FLAG
	 * 2018-04-27 12:17:58
	 */
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag == null ? null : loginFlag.trim();
	}

	/**
	 * 获取：LOGOUT：注销；SUCCESS：登录成功；FAIL：登录失败；TIMEOUT：用户超时；UNLOCK：解锁；AUTOLOCK：密码尝试过多被锁
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_login_history.LOGIN_FLAG
	 */
	public String getLoginFlag() {
		return loginFlag;
	}

	/**
	 * 设置：备注，现在用来记录用户登录密码尝试过多被锁前的用户状态
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_login_history.DESCRIPTION
	 * 2018-04-27 12:17:58
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * 获取：备注，现在用来记录用户登录密码尝试过多被锁前的用户状态
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_login_history.DESCRIPTION
	 */
	public String getDescription() {
		return description;
	}


	@Override
	public String toString() {
		return "SecLoginHistory [staffId=" +  staffId + ", loginTime=" +  loginTime + ", loginFlag=" +  loginFlag + ", description=" +  description
				+ "]";
	}

}