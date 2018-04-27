/**
 * SecResources.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecResourceCategory;

/**
 * 资源
 * <pre>
 * <b>Title：</b>SecResources.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecResources {

	/**
	 * 资源ID
	 */
	private Long resourceId;

	/**
	 * 资源外码
	 */
	private String resourceKey;

	/**
	 * 资源名称
	 */
	private String resourceName;

	/**
	 * 资源描述
	 */
	private String resourceDesc;

	/**
	 * 资源分类ID
	 */
	private Long categoryId;

	/**
	 * 鉴权类型(AUTH：鉴权，UNAUTH：不鉴权，LOGIN_AUTH：登录鉴权)
	 */
	private String authType;

	/**
	 * 元数据ID
	 */
	private String metadataId;

	/**
	 * 管理域：SP、ADMIN
	 */
	private String domain;

	/**
	 * 资源的顺序
	 */
	private Integer orderKey;

	/**
	 * 一对一关系隐射
	 */
	private SecResourceCategory secResourceCategory;


	/**
	 * 设置：资源ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.RESOURCE_ID
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
	 * @return the value of sec_resources.RESOURCE_ID
	 */
	public Long getResourceId() {
		return resourceId;
	}

	/**
	 * 设置：资源外码
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.RESOURCE_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setResourceKey(String resourceKey) {
		this.resourceKey = resourceKey == null ? null : resourceKey.trim();
	}

	/**
	 * 获取：资源外码
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.RESOURCE_KEY
	 */
	public String getResourceKey() {
		return resourceKey;
	}

	/**
	 * 设置：资源名称
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.RESOURCE_NAME
	 * 2018-04-27 12:17:59
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName == null ? null : resourceName.trim();
	}

	/**
	 * 获取：资源名称
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.RESOURCE_NAME
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * 设置：资源描述
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.RESOURCE_DESC
	 * 2018-04-27 12:17:59
	 */
	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc == null ? null : resourceDesc.trim();
	}

	/**
	 * 获取：资源描述
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.RESOURCE_DESC
	 */
	public String getResourceDesc() {
		return resourceDesc;
	}

	/**
	 * 设置：资源分类ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.CATEGORY_ID
	 * 2018-04-27 12:17:59
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 获取：资源分类ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.CATEGORY_ID
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * 设置：鉴权类型(AUTH：鉴权，UNAUTH：不鉴权，LOGIN_AUTH：登录鉴权)
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.AUTH_TYPE
	 * 2018-04-27 12:17:59
	 */
	public void setAuthType(String authType) {
		this.authType = authType == null ? null : authType.trim();
	}

	/**
	 * 获取：鉴权类型(AUTH：鉴权，UNAUTH：不鉴权，LOGIN_AUTH：登录鉴权)
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.AUTH_TYPE
	 */
	public String getAuthType() {
		return authType;
	}

	/**
	 * 设置：元数据ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.METADATA_ID
	 * 2018-04-27 12:17:59
	 */
	public void setMetadataId(String metadataId) {
		this.metadataId = metadataId == null ? null : metadataId.trim();
	}

	/**
	 * 获取：元数据ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.METADATA_ID
	 */
	public String getMetadataId() {
		return metadataId;
	}

	/**
	 * 设置：管理域：SP、ADMIN
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.DOMAIN
	 * 2018-04-27 12:17:59
	 */
	public void setDomain(String domain) {
		this.domain = domain == null ? null : domain.trim();
	}

	/**
	 * 获取：管理域：SP、ADMIN
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * 设置：资源的顺序
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.ORDER_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setOrderKey(Integer orderKey) {
		this.orderKey = orderKey;
	}

	/**
	 * 获取：资源的顺序
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.ORDER_KEY
	 */
	public Integer getOrderKey() {
		return orderKey;
	}

	/**
	 * 设置：secResourceCategory
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public void setsecResourceCategory(SecResourceCategory secResourceCategory) {
		this.secResourceCategory = secResourceCategory;
	}

	/**
	 * 获取：secResourceCategory
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public SecResourceCategory getsecResourceCategory() {
		return secResourceCategory;
	}

	@Override
	public String toString() {
		return "SecResources [resourceId=" +  resourceId + ", resourceKey=" +  resourceKey + ", resourceName=" +  resourceName + ", resourceDesc=" +  resourceDesc
				+ ", categoryId=" +  categoryId + ", authType=" +  authType + ", metadataId=" +  metadataId
				+ ", domain=" +  domain + ", orderKey=" +  orderKey + "]";
	}

}