/**
 * SecOperationAddress.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.entity;


import com.wml.springboot.entity.SecOperation;

/**
 * ��Դ������ַ
 * <pre>
 * <b>Title��</b>SecOperationAddress.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</bV1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public class SecOperationAddress {

	/**
	 * ���ʵ�ַID
	 */
	private Long addressId;

	/**
	 * ��ԴID
	 */
	private Long resourceId;

	/**
	 * ��Դ��������
	 */
	private String operationKey;

	/**
	 * ���ʵ�ַ����
	 */
	private String operationAddressName;

	/**
	 * ���ʵ�ַURL��������Э�顢IP���˿ڡ�contextpath��
	 */
	private String operationAddressUrl;

	/**
	 * ������һ
	 */
	private String parameterName1;

	/**
	 * ����ֵһ
	 */
	private String parameterValue1;

	/**
	 * ��������
	 */
	private String parameterName2;

	/**
	 * ����ֵ��
	 */
	private String parameterValue2;

	/**
	 * ��������
	 */
	private String parameterName3;

	/**
	 * ����ֵ��
	 */
	private String parameterValue3;

	/**
	 * Ԫ����ID
	 */
	private String metadataId;

	/**
	 * ������SP��ADMIN
	 */
	private String domain;

	/**
	 * һ��һ��ϵ����
	 */
	private SecOperation secOperation;


	/**
	 * ���ã����ʵ�ַID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.ADDRESS_ID
	 * 2018-04-27 12:17:58
	 */
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	/**
	 * ��ȡ�����ʵ�ַID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.ADDRESS_ID
	 */
	public Long getAddressId() {
		return addressId;
	}

	/**
	 * ���ã���ԴID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.RESOURCE_ID
	 * 2018-04-27 12:17:58
	 */
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * ��ȡ����ԴID
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.RESOURCE_ID
	 */
	public Long getResourceId() {
		return resourceId;
	}

	/**
	 * ���ã���Դ��������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.OPERATION_KEY
	 * 2018-04-27 12:17:58
	 */
	public void setOperationKey(String operationKey) {
		this.operationKey = operationKey == null ? null : operationKey.trim();
	}

	/**
	 * ��ȡ����Դ��������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.OPERATION_KEY
	 */
	public String getOperationKey() {
		return operationKey;
	}

	/**
	 * ���ã����ʵ�ַ����
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.OPERATION_ADDRESS_NAME
	 * 2018-04-27 12:17:58
	 */
	public void setOperationAddressName(String operationAddressName) {
		this.operationAddressName = operationAddressName == null ? null : operationAddressName.trim();
	}

	/**
	 * ��ȡ�����ʵ�ַ����
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.OPERATION_ADDRESS_NAME
	 */
	public String getOperationAddressName() {
		return operationAddressName;
	}

	/**
	 * ���ã����ʵ�ַURL��������Э�顢IP���˿ڡ�contextpath��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.OPERATION_ADDRESS_URL
	 * 2018-04-27 12:17:58
	 */
	public void setOperationAddressUrl(String operationAddressUrl) {
		this.operationAddressUrl = operationAddressUrl == null ? null : operationAddressUrl.trim();
	}

	/**
	 * ��ȡ�����ʵ�ַURL��������Э�顢IP���˿ڡ�contextpath��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.OPERATION_ADDRESS_URL
	 */
	public String getOperationAddressUrl() {
		return operationAddressUrl;
	}

	/**
	 * ���ã�������һ
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_NAME1
	 * 2018-04-27 12:17:58
	 */
	public void setParameterName1(String parameterName1) {
		this.parameterName1 = parameterName1 == null ? null : parameterName1.trim();
	}

	/**
	 * ��ȡ��������һ
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_NAME1
	 */
	public String getParameterName1() {
		return parameterName1;
	}

	/**
	 * ���ã�����ֵһ
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_VALUE1
	 * 2018-04-27 12:17:58
	 */
	public void setParameterValue1(String parameterValue1) {
		this.parameterValue1 = parameterValue1 == null ? null : parameterValue1.trim();
	}

	/**
	 * ��ȡ������ֵһ
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_VALUE1
	 */
	public String getParameterValue1() {
		return parameterValue1;
	}

	/**
	 * ���ã���������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_NAME2
	 * 2018-04-27 12:17:58
	 */
	public void setParameterName2(String parameterName2) {
		this.parameterName2 = parameterName2 == null ? null : parameterName2.trim();
	}

	/**
	 * ��ȡ����������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_NAME2
	 */
	public String getParameterName2() {
		return parameterName2;
	}

	/**
	 * ���ã�����ֵ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_VALUE2
	 * 2018-04-27 12:17:58
	 */
	public void setParameterValue2(String parameterValue2) {
		this.parameterValue2 = parameterValue2 == null ? null : parameterValue2.trim();
	}

	/**
	 * ��ȡ������ֵ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_VALUE2
	 */
	public String getParameterValue2() {
		return parameterValue2;
	}

	/**
	 * ���ã���������
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_NAME3
	 * 2018-04-27 12:17:58
	 */
	public void setParameterName3(String parameterName3) {
		this.parameterName3 = parameterName3 == null ? null : parameterName3.trim();
	}

	/**
	 * ��ȡ����������
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_NAME3
	 */
	public String getParameterName3() {
		return parameterName3;
	}

	/**
	 * ���ã�����ֵ��
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.PARAMETER_VALUE3
	 * 2018-04-27 12:17:58
	 */
	public void setParameterValue3(String parameterValue3) {
		this.parameterValue3 = parameterValue3 == null ? null : parameterValue3.trim();
	}

	/**
	 * ��ȡ������ֵ��
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 * @return the value of sec_operation_address.PARAMETER_VALUE3
	 */
	public String getParameterValue3() {
		return parameterValue3;
	}

	/**
	 * ���ã�Ԫ����ID
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.METADATA_ID
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
	 * @return the value of sec_operation_address.METADATA_ID
	 */
	public String getMetadataId() {
		return metadataId;
	}

	/**
	 * ���ã�������SP��ADMIN
	 * @author Miles
	 * @version V1.0
	 * @param id the value for sec_operation_address.DOMAIN
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
	 * @return the value of sec_operation_address.DOMAIN
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * ���ã�secOperation
	 * @author Miles
	 * @version V1.0
	 * 2018-04-27 12:17:58
	 */
	public void setsecOperation(SecOperation secOperation) {
		this.secOperation = secOperation;
	}

	/**
	 * ��ȡ��secOperation
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