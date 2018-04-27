/**
 * SecOperation.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecResources;

/**
 * 资源操作
 * <pre>
 * <b>Title：</b>SecOperation.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecOperation {

	/**
	 * 资源操作主键
	 */
	private Long operationId;

	/**
	 * 资源主键
	 */
	private Long resourceId;

	/**
	 * 操作关键字
	 */
	private String operationKey;

	/**
	 * 操作名称
	 */
	private String operationName;

	/**
	 * 操作描述
	 */
	private String operationDesc;

	/**
	 * 依赖操作KEY
	 */
	private String dependKey;

	/**
	 * 被依赖操作KEY
	 */
	private String dependByKey;

	/**
	 * 元数据ID
	 */
	private String metadataId;

	/**
	 * 管理域：SP、ADMIN
	 */
	private String domain;

	/**
	 * 操作的顺序
	 */
	private Integer orderKey;

	/**
	 * 一对一关系隐射
	 */
	private SecResources secResources;


	/**
	 * 设置：资源操作主键
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.OPERATION_ID
	 * 2018-04-27 12:17:58
	 */
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}

	/**
	 * 获取：资源操作主键
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.OPERATION_ID
	 */
	public Long getOperationId() {
		return operationId;
	}

	/**
	 * 设置：资源主键
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.RESOURCE_ID
	 * 2018-04-27 12:17:58
	 */
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * 获取：资源主键
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.RESOURCE_ID
	 */
	public Long getResourceId() {
		return resourceId;
	}

	/**
	 * 设置：操作关键字
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.OPERATION_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setOperationKey(String operationKey) {
		this.operationKey = operationKey == null ? null : operationKey.trim();
	}

	/**
	 * 获取：操作关键字
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.OPERATION_KEY
	 */
	public String getOperationKey() {
		return operationKey;
	}

	/**
	 * 设置：操作名称
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.OPERATION_NAME
	 * 2018-04-27 12:17:58
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName == null ? null : operationName.trim();
	}

	/**
	 * 获取：操作名称
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.OPERATION_NAME
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * 设置：操作描述
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.OPERATION_DESC
	 * 2018-04-27 12:17:58
	 */
	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc == null ? null : operationDesc.trim();
	}

	/**
	 * 获取：操作描述
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.OPERATION_DESC
	 */
	public String getOperationDesc() {
		return operationDesc;
	}

	/**
	 * 设置：依赖操作KEY
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.DEPEND_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setDependKey(String dependKey) {
		this.dependKey = dependKey == null ? null : dependKey.trim();
	}

	/**
	 * 获取：依赖操作KEY
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.DEPEND_KEY
	 */
	public String getDependKey() {
		return dependKey;
	}

	/**
	 * 设置：被依赖操作KEY
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.DEPEND_BY_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setDependByKey(String dependByKey) {
		this.dependByKey = dependByKey == null ? null : dependByKey.trim();
	}

	/**
	 * 获取：被依赖操作KEY
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.DEPEND_BY_KEY
	 */
	public String getDependByKey() {
		return dependByKey;
	}

	/**
	 * 设置：元数据ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.METADATA_ID
	 * 2018-04-27 12:17:58
	 */
	public void setMetadataId(String metadataId) {
		this.metadataId = metadataId == null ? null : metadataId.trim();
	}

	/**
	 * 获取：元数据ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.METADATA_ID
	 */
	public String getMetadataId() {
		return metadataId;
	}

	/**
	 * 设置：管理域：SP、ADMIN
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.DOMAIN
	 * 2018-04-27 12:17:58
	 */
	public void setDomain(String domain) {
		this.domain = domain == null ? null : domain.trim();
	}

	/**
	 * 获取：管理域：SP、ADMIN
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * 设置：操作的顺序
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.ORDER_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setOrderKey(Integer orderKey) {
		this.orderKey = orderKey;
	}

	/**
	 * 获取：操作的顺序
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.ORDER_KEY
	 */
	public Integer getOrderKey() {
		return orderKey;
	}

	/**
	 * 设置：secResources
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public void setsecResources(SecResources secResources) {
		this.secResources = secResources;
	}

	/**
	 * 获取：secResources
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public SecResources getsecResources() {
		return secResources;
	}

	@Override
	public String toString() {
		return "SecOperation [operationId=" +  operationId + ", resourceId=" +  resourceId + ", operationKey=" +  operationKey + ", operationName=" +  operationName
				+ ", operationDesc=" +  operationDesc + ", dependKey=" +  dependKey + ", dependByKey=" +  dependByKey
				+ ", metadataId=" +  metadataId + ", domain=" +  domain + ", orderKey=" +  orderKey
				+ "]";
	}

}