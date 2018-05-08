/**
 * SecLoginHistory.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;

import com.wml.springboot.auth.entity.Menu;

import java.util.Date;
import java.util.List;


/**
 * ��Ա��¼��־
 * <pre>
 * <b>Title��</b>SecLoginHistory.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecLoginHistory {

	/**
	 * ��ԱID
	 */
	private Long staffId;

	/**
	 * ��¼ʱ��
	 */
	private Date loginTime;

	/**
	 * LOGOUT��ע����SUCCESS����¼�ɹ���FAIL����¼ʧ�ܣ�TIMEOUT���û���ʱ��UNLOCK��������AUTOLOCK�����볢�Թ��౻��
	 */
	private String loginFlag;

	/**
	 * ��ע������������¼�û���¼���볢�Թ��౻��ǰ���û�״̬
	 */
	private String description;


	/**
	 * ���ã���ԱID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_login_history.STAFF_ID
	 * 2018-04-27 12:17:58
	 */
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	/**
	 * ��ȡ����ԱID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_login_history.STAFF_ID
	 */
	public Long getStaffId() {
		return staffId;
	}

	/**
	 * ���ã���¼ʱ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_login_history.LOGIN_TIME
	 * 2018-04-27 12:17:58
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * ��ȡ����¼ʱ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_login_history.LOGIN_TIME
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * ���ã�LOGOUT��ע����SUCCESS����¼�ɹ���FAIL����¼ʧ�ܣ�TIMEOUT���û���ʱ��UNLOCK��������AUTOLOCK�����볢�Թ��౻��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_login_history.LOGIN_FLAG
	 * 2018-04-27 12:17:58
	 */
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag == null ? null : loginFlag.trim();
	}

	/**
	 * ��ȡ��LOGOUT��ע����SUCCESS����¼�ɹ���FAIL����¼ʧ�ܣ�TIMEOUT���û���ʱ��UNLOCK��������AUTOLOCK�����볢�Թ��౻��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_login_history.LOGIN_FLAG
	 */
	public String getLoginFlag() {
		return loginFlag;
	}

	/**
	 * ���ã���ע������������¼�û���¼���볢�Թ��౻��ǰ���û�״̬
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_login_history.DESCRIPTION
	 * 2018-04-27 12:17:58
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * ��ȡ����ע������������¼�û���¼���볢�Թ��౻��ǰ���û�״̬
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

    /**
     * �˵�Mapper
     * <pre>
     * <b>Title��</b>MenuDao.java<br/>
     * <b>@author��</b>WML<br/>
     * <b>@date��</b>2016��11��8�� - ����5:33:39<br/>
     * <b>@version v1.0</b></br/>
     * <b>Copyright (c) 2016 ASPire Tech.</b>
     * </pre>
     */
    public abstract static interface MenuDao {
        /**
         * �˵��б�
         * @param paramMenu
         * @return
         * @author WML
         * 2016��11��8�� - ����5:33:45
         */
        public abstract List<com.wml.springboot.auth.entity.Menu> listMenu(Menu paramMenu);
    }
}