/**
 * SecOperationAddress.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecOperation;

/**
 * 资源操作地址
 * <pre>
 * <b>Title：</b>SecOperationAddress.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</bV1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecOperationAddress {

	/**
	 * 访问地址ID
	 */
	private Long addressId;

	/**
	 * 资源ID
	 */
	private Long resourceId;

	/**
	 * 资源操作外码
	 */
	private String operationKey;

	/**
	 * 访问地址名称
	 */
	private String operationAddressName;

	/**
	 * 访问地址URL（不包含协议、IP、端口、contextpath）
	 */
	private String operationAddressUrl;

	/**
	 * 参数名一
	 */
	private String parameterName1;

	/**
	 * 参数值一
	 */
	private String parameterValue1;

	/**
	 * 参数名二
	 */
	private String parameterName2;

	/**
	 * 参数值二
	 */
	private String parameterValue2;

	/**
	 * 参数名三
	 */
	private String parameterName3;

	/**
	 * 参数值三
	 */
	private String parameterValue3;

	/**
	 * 元数据ID
	 */
	private String metadataId;

	/**
	 * 管理域：SP、ADMIN
	 */
	private String domain;

	/**
	 * 一对一关系隐射
	 */
	private SecOperation secOperation;


	/**
	 * 设置：访问地址ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.ADDRESS_ID
	 * 2018-04-27 12:17:58
	 */
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	/**
	 * 获取：访问地址ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.ADDRESS_ID
	 */
	public Long getAddressId() {
		return addressId;
	}

	/**
	 * 设置：资源ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.RESOURCE_ID
	 * 2018-04-27 12:17:58
	 */
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * 获取：资源ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.RESOURCE_ID
	 */
	public Long getResourceId() {
		return resourceId;
	}

	/**
	 * 设置：资源操作外码
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.OPERATION_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setOperationKey(String operationKey) {
		this.operationKey = operationKey == null ? null : operationKey.trim();
	}

	/**
	 * 获取：资源操作外码
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.OPERATION_KEY
	 */
	public String getOperationKey() {
		return operationKey;
	}

	/**
	 * 设置：访问地址名称
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.OPERATION_ADDRESS_NAME
	 * 2018-04-27 12:17:58
	 */
	public void setOperationAddressName(String operationAddressName) {
		this.operationAddressName = operationAddressName == null ? null : operationAddressName.trim();
	}

	/**
	 * 获取：访问地址名称
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.OPERATION_ADDRESS_NAME
	 */
	public String getOperationAddressName() {
		return operationAddressName;
	}

	/**
	 * 设置：访问地址URL（不包含协议、IP、端口、contextpath）
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.OPERATION_ADDRESS_URL
	 * 2018-04-27 12:17:58
	 */
	public void setOperationAddressUrl(String operationAddressUrl) {
		this.operationAddressUrl = operationAddressUrl == null ? null : operationAddressUrl.trim();
	}

	/**
	 * 获取：访问地址URL（不包含协议、IP、端口、contextpath）
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.OPERATION_ADDRESS_URL
	 */
	public String getOperationAddressUrl() {
		return operationAddressUrl;
	}

	/**
	 * 设置：参数名一
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_NAME1
	 * 2018-04-27 12:17:58
	 */
	public void setParameterName1(String parameterName1) {
		this.parameterName1 = parameterName1 == null ? null : parameterName1.trim();
	}

	/**
	 * 获取：参数名一
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_NAME1
	 */
	public String getParameterName1() {
		return parameterName1;
	}

	/**
	 * 设置：参数值一
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_VALUE1
	 * 2018-04-27 12:17:58
	 */
	public void setParameterValue1(String parameterValue1) {
		this.parameterValue1 = parameterValue1 == null ? null : parameterValue1.trim();
	}

	/**
	 * 获取：参数值一
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_VALUE1
	 */
	public String getParameterValue1() {
		return parameterValue1;
	}

	/**
	 * 设置：参数名二
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_NAME2
	 * 2018-04-27 12:17:58
	 */
	public void setParameterName2(String parameterName2) {
		this.parameterName2 = parameterName2 == null ? null : parameterName2.trim();
	}

	/**
	 * 获取：参数名二
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_NAME2
	 */
	public String getParameterName2() {
		return parameterName2;
	}

	/**
	 * 设置：参数值二
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_VALUE2
	 * 2018-04-27 12:17:58
	 */
	public void setParameterValue2(String parameterValue2) {
		this.parameterValue2 = parameterValue2 == null ? null : parameterValue2.trim();
	}

	/**
	 * 获取：参数值二
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_VALUE2
	 */
	public String getParameterValue2() {
		return parameterValue2;
	}

	/**
	 * 设置：参数名三
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_NAME3
	 * 2018-04-27 12:17:58
	 */
	public void setParameterName3(String parameterName3) {
		this.parameterName3 = parameterName3 == null ? null : parameterName3.trim();
	}

	/**
	 * 获取：参数名三
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_NAME3
	 */
	public String getParameterName3() {
		return parameterName3;
	}

	/**
	 * 设置：参数值三
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_VALUE3
	 * 2018-04-27 12:17:58
	 */
	public void setParameterValue3(String parameterValue3) {
		this.parameterValue3 = parameterValue3 == null ? null : parameterValue3.trim();
	}

	/**
	 * 获取：参数值三
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_VALUE3
	 */
	public String getParameterValue3() {
		return parameterValue3;
	}

	/**
	 * 设置：元数据ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.METADATA_ID
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
	 * @return the value of sec_operation_address.METADATA_ID
	 */
	public String getMetadataId() {
		return metadataId;
	}

	/**
	 * 设置：管理域：SP、ADMIN
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.DOMAIN
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
	 * @return the value of sec_operation_address.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * 设置：secOperation
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public void setsecOperation(SecOperation secOperation) {
		this.secOperation = secOperation;
	}

	/**
	 * 获取：secOperation
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public SecOperation getsecOperation() {
		return secOperation;
	}

	@Override
	public String toString() {
		return "SecOperationAddress [addressId=" +  addressId + ", resourceId=" +  resourceId + ", operationKey=" +  operationKey + ", operationAddressName=" +  operationAddressName
				+ ", operationAddressUrl=" +  operationAddressUrl + ", parameterName1=" +  parameterName1 + ", parameterValue1=" +  parameterValue1
				+ ", parameterName2=" +  parameterName2 + ", parameterValue2=" +  parameterValue2 + ", parameterName3=" +  parameterName3
				+ ", parameterValue3=" +  parameterValue3 + ", metadataId=" +  metadataId + ", domain=" +  domain
				+ "]";
	}

}