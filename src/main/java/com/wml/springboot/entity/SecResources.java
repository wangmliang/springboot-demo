/**
 * SecResources.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecResourceCategory;

/**
 * ��Դ
 * <pre>
 * <b>Title��</b>SecResources.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecResources {

	/**
	 * ��ԴID
	 */
	private Long resourceId;

	/**
	 * ��Դ����
	 */
	private String resourceKey;

	/**
	 * ��Դ����
	 */
	private String resourceName;

	/**
	 * ��Դ����
	 */
	private String resourceDesc;

	/**
	 * ��Դ����ID
	 */
	private Long categoryId;

	/**
	 * ��Ȩ����(AUTH����Ȩ��UNAUTH������Ȩ��LOGIN_AUTH����¼��Ȩ)
	 */
	private String authType;

	/**
	 * Ԫ����ID
	 */
	private String metadataId;

	/**
	 * ������SP��ADMIN
	 */
	private String domain;

	/**
	 * ��Դ��˳��
	 */
	private Integer orderKey;

	/**
	 * һ��һ��ϵ����
	 */
	private SecResourceCategory secResourceCategory;


	/**
	 * ���ã���ԴID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.RESOURCE_ID
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
	 * @return the value of sec_resources.RESOURCE_ID
	 */
	public Long getResourceId() {
		return resourceId;
	}

	/**
	 * ���ã���Դ����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.RESOURCE_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setResourceKey(String resourceKey) {
		this.resourceKey = resourceKey == null ? null : resourceKey.trim();
	}

	/**
	 * ��ȡ����Դ����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.RESOURCE_KEY
	 */
	public String getResourceKey() {
		return resourceKey;
	}

	/**
	 * ���ã���Դ����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.RESOURCE_NAME
	 * 2018-04-27 12:17:59
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName == null ? null : resourceName.trim();
	}

	/**
	 * ��ȡ����Դ����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.RESOURCE_NAME
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * ���ã���Դ����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.RESOURCE_DESC
	 * 2018-04-27 12:17:59
	 */
	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc == null ? null : resourceDesc.trim();
	}

	/**
	 * ��ȡ����Դ����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.RESOURCE_DESC
	 */
	public String getResourceDesc() {
		return resourceDesc;
	}

	/**
	 * ���ã���Դ����ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.CATEGORY_ID
	 * 2018-04-27 12:17:59
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * ��ȡ����Դ����ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.CATEGORY_ID
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * ���ã���Ȩ����(AUTH����Ȩ��UNAUTH������Ȩ��LOGIN_AUTH����¼��Ȩ)
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.AUTH_TYPE
	 * 2018-04-27 12:17:59
	 */
	public void setAuthType(String authType) {
		this.authType = authType == null ? null : authType.trim();
	}

	/**
	 * ��ȡ����Ȩ����(AUTH����Ȩ��UNAUTH������Ȩ��LOGIN_AUTH����¼��Ȩ)
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.AUTH_TYPE
	 */
	public String getAuthType() {
		return authType;
	}

	/**
	 * ���ã�Ԫ����ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.METADATA_ID
	 * 2018-04-27 12:17:59
	 */
	public void setMetadataId(String metadataId) {
		this.metadataId = metadataId == null ? null : metadataId.trim();
	}

	/**
	 * ��ȡ��Ԫ����ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.METADATA_ID
	 */
	public String getMetadataId() {
		return metadataId;
	}

	/**
	 * ���ã�������SP��ADMIN
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.DOMAIN
	 * 2018-04-27 12:17:59
	 */
	public void setDomain(String domain) {
		this.domain = domain == null ? null : domain.trim();
	}

	/**
	 * ��ȡ��������SP��ADMIN
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * ���ã���Դ��˳��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resources.ORDER_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setOrderKey(Integer orderKey) {
		this.orderKey = orderKey;
	}

	/**
	 * ��ȡ����Դ��˳��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resources.ORDER_KEY
	 */
	public Integer getOrderKey() {
		return orderKey;
	}

	/**
	 * ���ã�secResourceCategory
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public void setsecResourceCategory(SecResourceCategory secResourceCategory) {
		this.secResourceCategory = secResourceCategory;
	}

	/**
	 * ��ȡ��secResourceCategory
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