/**
 * SecResourceCategory.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecResourceCategory;

/**
 * ��Դ����
 * <pre>
 * <b>Title��</b>SecResourceCategory.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecResourceCategory {

	/**
	 * ��Դ����ID
	 */
	private Long categoryId;

	/**
	 * �ϼ���Դ����ID
	 */
	private Long parentId;

	/**
	 * ��Դ��������
	 */
	private String categoryName;

	/**
	 * ��Դ��������
	 */
	private String categoryDesc;

	/**
	 * Ԫ����ID
	 */
	private String metadataId;

	/**
	 * ��Դ��������
	 */
	private String categoryKey;

	/**
	 * ������SP��ADMIN
	 */
	private String domain;

	/**
	 * ��Դ�����˳��
	 */
	private Integer orderKey;

	/**
	 * һ��һ��ϵ����
	 */
	private SecResourceCategory secResourceCategoryParentId;


	/**
	 * ���ã���Դ����ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.CATEGORY_ID
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
	 * @return the value of sec_resource_category.CATEGORY_ID
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * ���ã��ϼ���Դ����ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.PARENT_ID
	 * 2018-04-27 12:17:59
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * ��ȡ���ϼ���Դ����ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resource_category.PARENT_ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * ���ã���Դ��������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.CATEGORY_NAME
	 * 2018-04-27 12:17:59
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}

	/**
	 * ��ȡ����Դ��������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resource_category.CATEGORY_NAME
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * ���ã���Դ��������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.CATEGORY_DESC
	 * 2018-04-27 12:17:59
	 */
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc == null ? null : categoryDesc.trim();
	}

	/**
	 * ��ȡ����Դ��������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resource_category.CATEGORY_DESC
	 */
	public String getCategoryDesc() {
		return categoryDesc;
	}

	/**
	 * ���ã�Ԫ����ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.METADATA_ID
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
	 * @return the value of sec_resource_category.METADATA_ID
	 */
	public String getMetadataId() {
		return metadataId;
	}

	/**
	 * ���ã���Դ��������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.CATEGORY_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey == null ? null : categoryKey.trim();
	}

	/**
	 * ��ȡ����Դ��������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resource_category.CATEGORY_KEY
	 */
	public String getCategoryKey() {
		return categoryKey;
	}

	/**
	 * ���ã�������SP��ADMIN
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.DOMAIN
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
	 * @return the value of sec_resource_category.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * ���ã���Դ�����˳��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.ORDER_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setOrderKey(Integer orderKey) {
		this.orderKey = orderKey;
	}

	/**
	 * ��ȡ����Դ�����˳��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resource_category.ORDER_KEY
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
	public void setsecResourceCategoryParentId(SecResourceCategory secResourceCategoryParentId) {
		this.secResourceCategoryParentId = secResourceCategoryParentId;
	}

	/**
	 * ��ȡ��secResourceCategoryParentId
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 */
	public SecResourceCategory getsecResourceCategoryParentId() {
		return secResourceCategoryParentId;
	}

	@Override
	public String toString() {
		return "SecResourceCategory [categoryId=" +  categoryId + ", parentId=" +  parentId + ", categoryName=" +  categoryName + ", categoryDesc=" +  categoryDesc
				+ ", metadataId=" +  metadataId + ", categoryKey=" +  categoryKey + ", domain=" +  domain
				+ ", orderKey=" +  orderKey + "]";
	}

}