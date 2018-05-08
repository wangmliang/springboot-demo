package com.wml.springboot.auth.entity;import java.util.HashMap;import java.util.LinkedList;import java.util.List;import java.util.Map;/** * 操作 * <pre> * <b>Title：</b>Operation.java<br/> * <b>@author：</b>WML<br/> * <b>@date：</b>2016年11月9日 - 上午9:16:54<br/>   * <b>@version V1.0</b></br/> * <b>Copyright (c) 2016 ASPire Tech.</b>    * </pre> */@SuppressWarnings({ "unchecked", "rawtypes" })public class Operation extends BaseEntity {		private static final long serialVersionUID = -7387368957838961357L;		/**	 * 操作id	 */	private Long operationId;		/**	 * 资源id	 */	private Long resourceId;		/**	 * 资源key	 */	private String resourceKey;	/**	 * 操作key	 */	private String operationKey;	/**	 * 操作名称	 */	private String operationName;		/**	 * 操作描述	 */	private String operationDesc;	/**	 * 依赖操作KEY	 */	private String dependKey;	/**	 * 被依赖操作KEY	 */	private String dependByKey;	/**	 * 元数据ID	 */	private String metadataId;	/**	 * 管理域：SP、ADMIN	 */	private String domain;	/**	 * 操作顺序	 */	private int orderKey;	/**	 * 操作地址集合	 */	private List<OperationAddress> operationAddresses = new LinkedList();	/**	 * 	 */	private Map<String, OperationAddress> operationAddressesMap = new HashMap();	public boolean equals(Object obj) {		if ((obj instanceof Operation)) {			Operation operation = (Operation) obj;			if ((operation.getResourceId() == null)					|| (operation.getOperationKey() == null)) {				return operation == this;			}			return (operation.getResourceId().equals(this.resourceId))					&& (operation.getOperationKey().equals(this.operationKey));		}		return false;	}	public int hashCode() {		if ((this.resourceId == null) && (this.operationKey == null)) {			return 0;		}		return (this.resourceId + this.operationKey).hashCode();	}	public String toString() {		return this.resourceId + " --> " + this.operationKey;	}	public Long getOperationId() {		return this.operationId;	}	public void setOperationId(Long operationId) {		this.operationId = operationId;	}	public String getMetadataId() {		return this.metadataId;	}	public void setMetadataId(String metadataId) {		this.metadataId = metadataId;	}	public String getOperationDesc() {		return this.operationDesc;	}	public void setOperationDesc(String operationDesc) {		this.operationDesc = operationDesc;	}	public String getOperationKey() {		return this.operationKey;	}	public void setOperationKey(String operationKey) {		this.operationKey = operationKey;	}	public String getOperationName() {		return this.operationName;	}	public void setOperationName(String operationName) {		this.operationName = operationName;	}	public Long getResourceId() {		return this.resourceId;	}	public void setResourceId(Long resourceId) {		this.resourceId = resourceId;	}	public List<OperationAddress> getOperationAddresses() {		return this.operationAddresses;	}	public void setOperationAddresses(List<OperationAddress> operationAddresses) {		this.operationAddresses = operationAddresses;	}	public String getDependKey() {		return this.dependKey;	}	public void setDependKey(String dependKey) {		this.dependKey = dependKey;	}	public String getDependByKey() {		return this.dependByKey;	}	public void setDependByKey(String dependByKey) {		this.dependByKey = dependByKey;	}	public Map<String, OperationAddress> getOperationAddressesMap() {		return this.operationAddressesMap;	}	public void setOperationAddressesMap(			Map<String, OperationAddress> operationAddressesMap) {		this.operationAddressesMap = operationAddressesMap;	}	public String getDomain() {		return this.domain;	}	public void setDomain(String domain) {		this.domain = domain;	}	public int getOrderKey() {		return this.orderKey;	}	public void setOrderKey(int orderKey) {		this.orderKey = orderKey;	}	public String getResourceKey() {		return this.resourceKey;	}	public void setResourceKey(String resourceKey) {		this.resourceKey = resourceKey;	}	}