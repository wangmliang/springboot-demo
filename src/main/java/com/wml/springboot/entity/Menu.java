/**
 * Menu.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;



/**
 * 菜单
 * <pre>
 * <b>Title：</b>Menu.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class Menu {

	/**
	 * 菜单ID
	 */
	private Long menuId;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 菜单外码
	 */
	private String menuKey;

	/**
	 * 父菜单ID
	 */
	private Long parentId;

	/**
	 * 图标Url
	 */
	private String imageUrl;

	/**
	 * 资源URL
	 */
	private String url;

	/**
	 * 菜单顺序
	 */
	private String menuOrder;

	/**
	 * 子系统名称
	 */
	private String subsystem;

	/**
	 * 菜单所属域（admin、sp）
	 */
	private String domain;


	/**
	 * 设置：菜单ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.MENU_ID
	 * 2018-04-27 12:17:58
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * 获取：菜单ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.MENU_ID
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * 设置：菜单名称
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.MENU_NAME
	 * 2018-04-27 12:17:58
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}

	/**
	 * 获取：菜单名称
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.MENU_NAME
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * 设置：菜单外码
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.MENU_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey == null ? null : menuKey.trim();
	}

	/**
	 * 获取：菜单外码
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.MENU_KEY
	 */
	public String getMenuKey() {
		return menuKey;
	}

	/**
	 * 设置：父菜单ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.PARENT_ID
	 * 2018-04-27 12:17:58
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取：父菜单ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.PARENT_ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置：图标Url
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.IMAGE_URL
	 * 2018-04-27 12:17:58
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl == null ? null : imageUrl.trim();
	}

	/**
	 * 获取：图标Url
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.IMAGE_URL
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * 设置：资源URL
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.URL
	 * 2018-04-27 12:17:58
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/**
	 * 获取：资源URL
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置：菜单顺序
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.MENU_ORDER
	 * 2018-04-27 12:17:58
	 */
	public void setMenuOrder(String menuOrder) {
		this.menuOrder = menuOrder == null ? null : menuOrder.trim();
	}

	/**
	 * 获取：菜单顺序
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.MENU_ORDER
	 */
	public String getMenuOrder() {
		return menuOrder;
	}

	/**
	 * 设置：子系统名称
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.SUBSYSTEM
	 * 2018-04-27 12:17:58
	 */
	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem == null ? null : subsystem.trim();
	}

	/**
	 * 获取：子系统名称
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of menu.SUBSYSTEM
	 */
	public String getSubsystem() {
		return subsystem;
	}

	/**
	 * 设置：菜单所属域（admin、sp）
	 * @author Miles
	 * @version V1.0
	 * @param id the value for menu.DOMAIN
	 * 2018-04-27 12:17:58
	 */
	public void setDomain(String domain) {
		this.domain = domain == null ? null : domain.trim();
	}

	/**
	 * 获取：菜单所属域（admin、sp）
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