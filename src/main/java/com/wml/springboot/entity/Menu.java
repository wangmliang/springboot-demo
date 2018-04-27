/**
 * Menu.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;



/**
 * �˵�
 * <pre>
 * <b>Title��</b>Menu.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class Menu {

	/**
	 * �˵�ID
	 */
	private Long menuId;

	/**
	 * �˵�����
	 */
	private String menuName;

	/**
	 * �˵�����
	 */
	private String menuKey;

	/**
	 * ���˵�ID
	 */
	private Long parentId;

	/**
	 * ͼ��Url
	 */
	private String imageUrl;

	/**
	 * ��ԴURL
	 */
	private String url;

	/**
	 * �˵�˳��
	 */
	private String menuOrder;

	/**
	 * ��ϵͳ����
	 */
	private String subsystem;

	/**
	 * �˵�������admin��sp��
	 */
	private String domain;


	/**
	 * ���ã��˵�ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.MENU_ID
	 * 2018-04-27 12:17:58
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * ��ȡ���˵�ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.MENU_ID
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * ���ã��˵�����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.MENU_NAME
	 * 2018-04-27 12:17:58
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}

	/**
	 * ��ȡ���˵�����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.MENU_NAME
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * ���ã��˵�����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.MENU_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey == null ? null : menuKey.trim();
	}

	/**
	 * ��ȡ���˵�����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.MENU_KEY
	 */
	public String getMenuKey() {
		return menuKey;
	}

	/**
	 * ���ã����˵�ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.PARENT_ID
	 * 2018-04-27 12:17:58
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * ��ȡ�����˵�ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.PARENT_ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * ���ã�ͼ��Url
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.IMAGE_URL
	 * 2018-04-27 12:17:58
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl == null ? null : imageUrl.trim();
	}

	/**
	 * ��ȡ��ͼ��Url
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.IMAGE_URL
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * ���ã���ԴURL
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.URL
	 * 2018-04-27 12:17:58
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/**
	 * ��ȡ����ԴURL
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * ���ã��˵�˳��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.MENU_ORDER
	 * 2018-04-27 12:17:58
	 */
	public void setMenuOrder(String menuOrder) {
		this.menuOrder = menuOrder == null ? null : menuOrder.trim();
	}

	/**
	 * ��ȡ���˵�˳��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.MENU_ORDER
	 */
	public String getMenuOrder() {
		return menuOrder;
	}

	/**
	 * ���ã���ϵͳ����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.SUBSYSTEM
	 * 2018-04-27 12:17:58
	 */
	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem == null ? null : subsystem.trim();
	}

	/**
	 * ��ȡ����ϵͳ����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.SUBSYSTEM
	 */
	public String getSubsystem() {
		return subsystem;
	}

	/**
	 * ���ã��˵�������admin��sp��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.DOMAIN
	 * 2018-04-27 12:17:58
	 */
	public void setDomain(String domain) {
		this.domain = domain == null ? null : domain.trim();
	}

	/**
	 * ��ȡ���˵�������admin��sp��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}


	@Override
	public String toString() {
		return "Menu [menuId=" +  menuId + ", menuName=" +  menuName + ", menuKey=" +  menuKey + ", parentId=" +  parentId
				+ ", imageUrl=" +  imageUrl + ", url=" +  url + ", menuOrder=" +  menuOrder
				+ ", subsystem=" +  subsystem + ", domain=" +  domain + "]";
	}

}