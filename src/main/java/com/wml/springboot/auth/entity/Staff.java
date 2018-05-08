package com.wml.springboot.auth.entity;import com.fasterxml.jackson.annotation.JsonIgnore;import java.io.Serializable;import java.text.SimpleDateFormat;import java.util.Date;import java.util.HashMap;import java.util.List;import java.util.Map;public class Staff extends BaseEntity implements Serializable {	private static final long serialVersionUID = 6309997035381648458L;	private Long staffId;	private String loginName;	private Long departmentId;	private String realName;	@JsonIgnore	private String password;	private Status status;	private Sex sex;	private String telephone;	private String mobile;	private String email;	@JsonIgnore	private String createUser;	@JsonIgnore	private Date createDate;	@JsonIgnore	private Date expireDate;	@JsonIgnore	private String expireDateStr;	private Date lockDate;	@JsonIgnore	private Date passwordExpireDate;	@JsonIgnore	private Date lastUpdateDate;	private Department department;	@SuppressWarnings({ "unchecked", "rawtypes" })	private Map<String, String> extendProperties = new HashMap();	@JsonIgnore	private List<Role> roles;	@JsonIgnore	private boolean choose = false;	private Integer cityId;	public boolean isChoose() {		return this.choose;	}	public void setChoose(boolean choose) {		this.choose = choose;	}	public List<Role> getRoles() {		return this.roles;	}	public void setRoles(List<Role> roles) {		this.roles = roles;	}	public Date getCreateDate() {		return this.createDate;	}	public void setCreateDate(Date createDate) {		this.createDate = createDate;	}	public String getCreateUser() {		return this.createUser;	}	public void setCreateUser(String createUser) {		this.createUser = createUser;	}	public Long getDepartmentId() {		return this.departmentId;	}	public void setDepartmentId(Long departmentId) {		this.departmentId = departmentId;	}	public String getEmail() {		return this.email;	}	public void setEmail(String email) {		this.email = email;	}	public Date getExpireDate() {		return this.expireDate;	}	public void setExpireDate(Date expireDate) {		this.expireDate = expireDate;	}	public Date getLastUpdateDate() {		return this.lastUpdateDate;	}	public void setLastUpdateDate(Date lastUpdateDate) {		this.lastUpdateDate = lastUpdateDate;	}	public Date getLockDate() {		return this.lockDate;	}	public void setLockDate(Date lockDate) {		this.lockDate = lockDate;	}	public String getLoginName() {		return this.loginName;	}	public void setLoginName(String loginName) {		this.loginName = loginName;	}	public String getMobile() {		return this.mobile;	}	public void setMobile(String mobile) {		this.mobile = mobile;	}	public String getPassword() {		return this.password;	}	public void setPassword(String password) {		this.password = password;	}	public Date getPasswordExpireDate() {		return this.passwordExpireDate;	}	public void setPasswordExpireDate(Date passwordExpireDate) {		this.passwordExpireDate = passwordExpireDate;	}	public String getRealName() {		return this.realName;	}	public void setRealName(String realName) {		this.realName = realName;	}	public Sex getSex() {		return this.sex;	}	public String getSexName() {		return this.sex.toCnString();	}	public void setSex(Sex sex) {		this.sex = sex;	}	public Long getStaffId() {		return this.staffId;	}	public void setStaffId(Long staffId) {		this.staffId = staffId;	}	public Status getStatus() {		return this.status;	}	public void setStatus(Status status) {		this.status = status;	}	public String getStatusName() {		return this.status.toCnString();	}	public String getTelephone() {		return this.telephone;	}	public void setTelephone(String telephone) {		this.telephone = telephone;	}	public Integer getCityId() {		return this.cityId;	}	public void setCityId(Integer cityId) {		this.cityId = cityId;	}	public String getExpireDateStr() {		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");		if (this.expireDate != null) {			return df.format(this.expireDate);		}		return "";	}	public Map<String, String> getExtendProperties() {		return this.extendProperties;	}	public void setExtendProperties(Map<String, String> extendProperties) {		this.extendProperties = extendProperties;	}	public String getExtendProperty(String name) {		return (String) this.extendProperties.get(name);	}	public void addExtendProperty(String name, String value) {		this.extendProperties.put(name, value);	}	public Department getDepartment() {		return this.department;	}	public void setDepartment(Department department) {		this.department = department;	}	public static enum Sex {		MALE,		FEMALE, UNKNOWN;		public String getValue() {			return toString();		}		@SuppressWarnings("incomplete-switch")		public String toCnString() {			switch (this) {			case FEMALE:				return "��";			case MALE:				return "Ů";			}			return "δ֪";		}	}	public static enum Status {		INITIAL,		NORMAL, AUTO_LOCKED, LOCKED, PASSWORD_EXPIRED, EXPIRED, DELETED;		public String getValue() {			return toString();		}		public String toCnString() {			switch (this) {			case AUTO_LOCKED:				return "����";			case DELETED:				return "����";			case EXPIRED:				return "�Զ�����";			case INITIAL:				return "����";			case LOCKED:				return "�������";			case NORMAL:				return "�ʺŹ���";			case PASSWORD_EXPIRED:				return "ɾ��";			}			return "δ֪";		}	}}