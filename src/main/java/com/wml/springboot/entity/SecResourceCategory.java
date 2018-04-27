/**
 * SecResourceCategory.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecResourceCategory;

/**
 * 资源分类
 * <pre>
 * <b>Title：</b>SecResourceCategory.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecResourceCategory {

	/**
	 * 资源分类ID
	 */
	private Long categoryId;

	/**
	 * 上级资源分类ID
	 */
	private Long parentId;

	/**
	 * 资源分类名称
	 */
	private String categoryName;

	/**
	 * 资源分类描述
	 */
	private String categoryDesc;

	/**
	 * 元数据ID
	 */
	private String metadataId;

	/**
	 * 资源分类外码
	 */
	private String categoryKey;

	/**
	 * 管理域：SP、ADMIN
	 */
	private String domain;

	/**
	 * 资源分类的顺序
	 */
	private Integer orderKey;

	/**
	 * 一对一关系隐射
	 */
	private SecResourceCategory secResourceCategoryParentId;


	/**
	 * 设置：资源分类ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.CATEGORY_ID
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
	 * @return the value of sec_resource_category.CATEGORY_ID
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * 设置：上级资源分类ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.PARENT_ID
	 * 2018-04-27 12:17:59
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取：上级资源分类ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resource_category.PARENT_ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置：资源分类名称
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.CATEGORY_NAME
	 * 2018-04-27 12:17:59
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}

	/**
	 * 获取：资源分类名称
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resource_category.CATEGORY_NAME
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * 设置：资源分类描述
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.CATEGORY_DESC
	 * 2018-04-27 12:17:59
	 */
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc == null ? null : categoryDesc.trim();
	}

	/**
	 * 获取：资源分类描述
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resource_category.CATEGORY_DESC
	 */
	public String getCategoryDesc() {
		return categoryDesc;
	}

	/**
	 * 设置：元数据ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.METADATA_ID
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
	 * @return the value of sec_resource_category.METADATA_ID
	 */
	public String getMetadataId() {
		return metadataId;
	}

	/**
	 * 设置：资源分类外码
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.CATEGORY_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey == null ? null : categoryKey.trim();
	}

	/**
	 * 获取：资源分类外码
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resource_category.CATEGORY_KEY
	 */
	public String getCategoryKey() {
		return categoryKey;
	}

	/**
	 * 设置：管理域：SP、ADMIN
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.DOMAIN
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
	 * @return the value of sec_resource_category.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * 设置：资源分类的顺序
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_resource_category.ORDER_KEY
	 * 2018-04-27 12:17:59
	 */
	public void setOrderKey(Integer orderKey) {
		this.orderKey = orderKey;
	}

	/**
	 * 获取：资源分类的顺序
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:59
	 * @return the value of sec_resource_category.ORDER_KEY
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
	public void setsecResourceCategoryParentId(SecResourceCategory secResourceCategoryParentId) {
		this.secResourceCategoryParentId = secResourceCategoryParentId;
	}

	/**
	 * 获取：secResourceCategoryParentId
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