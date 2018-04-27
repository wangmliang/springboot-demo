/**
 * SecOperation.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecResources;

/**
 * ��Դ����
 * <pre>
 * <b>Title��</b>SecOperation.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecOperation {

	/**
	 * ��Դ��������
	 */
	private Long operationId;

	/**
	 * ��Դ����
	 */
	private Long resourceId;

	/**
	 * �����ؼ���
	 */
	private String operationKey;

	/**
	 * ��������
	 */
	private String operationName;

	/**
	 * ��������
	 */
	private String operationDesc;

	/**
	 * ��������KEY
	 */
	private String dependKey;

	/**
	 * ����������KEY
	 */
	private String dependByKey;

	/**
	 * Ԫ����ID
	 */
	private String metadataId;

	/**
	 * ������SP��ADMIN
	 */
	private String domain;

	/**
	 * ������˳��
	 */
	private Integer orderKey;

	/**
	 * һ��һ��ϵ����
	 */
	private SecResources secResources;


	/**
	 * ���ã���Դ��������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.OPERATION_ID
	 * 2018-04-27 12:17:58
	 */
	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}

	/**
	 * ��ȡ����Դ��������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.OPERATION_ID
	 */
	public Long getOperationId() {
		return operationId;
	}

	/**
	 * ���ã���Դ����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.RESOURCE_ID
	 * 2018-04-27 12:17:58
	 */
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * ��ȡ����Դ����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.RESOURCE_ID
	 */
	public Long getResourceId() {
		return resourceId;
	}

	/**
	 * ���ã������ؼ���
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.OPERATION_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setOperationKey(String operationKey) {
		this.operationKey = operationKey == null ? null : operationKey.trim();
	}

	/**
	 * ��ȡ�������ؼ���
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.OPERATION_KEY
	 */
	public String getOperationKey() {
		return operationKey;
	}

	/**
	 * ���ã���������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.OPERATION_NAME
	 * 2018-04-27 12:17:58
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName == null ? null : operationName.trim();
	}

	/**
	 * ��ȡ����������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.OPERATION_NAME
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * ���ã���������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.OPERATION_DESC
	 * 2018-04-27 12:17:58
	 */
	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc == null ? null : operationDesc.trim();
	}

	/**
	 * ��ȡ����������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.OPERATION_DESC
	 */
	public String getOperationDesc() {
		return operationDesc;
	}

	/**
	 * ���ã���������KEY
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.DEPEND_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setDependKey(String dependKey) {
		this.dependKey = dependKey == null ? null : dependKey.trim();
	}

	/**
	 * ��ȡ����������KEY
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.DEPEND_KEY
	 */
	public String getDependKey() {
		return dependKey;
	}

	/**
	 * ���ã�����������KEY
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.DEPEND_BY_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setDependByKey(String dependByKey) {
		this.dependByKey = dependByKey == null ? null : dependByKey.trim();
	}

	/**
	 * ��ȡ������������KEY
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.DEPEND_BY_KEY
	 */
	public String getDependByKey() {
		return dependByKey;
	}

	/**
	 * ���ã�Ԫ����ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.METADATA_ID
	 * 2018-04-27 12:17:58
	 */
	public void setMetadataId(String metadataId) {
		this.metadataId = metadataId == null ? null : metadataId.trim();
	}

	/**
	 * ��ȡ��Ԫ����ID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.METADATA_ID
	 */
	public String getMetadataId() {
		return metadataId;
	}

	/**
	 * ���ã�������SP��ADMIN
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.DOMAIN
	 * 2018-04-27 12:17:58
	 */
	public void setDomain(String domain) {
		this.domain = domain == null ? null : domain.trim();
	}

	/**
	 * ��ȡ��������SP��ADMIN
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * ���ã�������˳��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation.ORDER_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setOrderKey(Integer orderKey) {
		this.orderKey = orderKey;
	}

	/**
	 * ��ȡ��������˳��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation.ORDER_KEY
	 */
	public Integer getOrderKey() {
		return orderKey;
	}

	/**
	 * ���ã�secResources
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public void setsecResources(SecResources secResources) {
		this.secResources = secResources;
	}

	/**
	 * ��ȡ��secResources
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