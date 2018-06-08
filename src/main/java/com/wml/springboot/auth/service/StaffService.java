package com.wml.springboot.auth.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wml.springboot.auth.PasswordAdapter;
import com.wml.springboot.auth.entity.*;
import com.wml.springboot.auth.mapper.DepartmentMapper;
import com.wml.springboot.auth.mapper.RoleDao;
import com.wml.springboot.auth.mapper.StaffDao;
import com.wml.springboot.exception.MyException;
import com.wml.springboot.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("staffService")
public class StaffService {

	@Autowired
	private StaffDao staffDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private DepartmentMapper departmentDao;

	public boolean isStaffEmailExsit(String email) {
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("email", email);
		return findStaffByMap(queryParams) != null;
	}

	public boolean isStaffMobileExsit(String mobile) {
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("mobile", mobile);
		return findStaffByMap(queryParams) != null;
	}

	@Transactional(rollbackFor = { Exception.class })
	public void createStaff(Staff staff) throws Exception {
		_createStaff(staff);
	}

	/**
	 * 用户密码加密
	 * @param user
	 */
	public static void entryptPassword(Staff user)
	{
		byte[] salt = Digests.generateSalt(8);
		user.setSalt(Encodes.encodeHex(salt));
		byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, 1024);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	/**
	 * 修改密码时验证原始密码输入是否正常
	 * @param oldPassword	现有密码字符串
	 * @param password		页面输入旧密码
	 * @param salt			安全码
	 */
	public static boolean checkPassword(String oldPassword, String password, String salt)
	{
		byte[] hashPassword = Digests.sha1(password.getBytes(), salt.getBytes(), 1024);
		return !oldPassword.equals(Encodes.encodeHex(hashPassword));
	}

	public static void main(String[] args) {
		/*Staff staff = new Staff();
		staff.setLoginName("admin");
		staff.setPassword("123456");
		staff.setStaffId(1L);
		entryptPassword(staff);
		System.out.println("mima:" + staff.getPassword() + "=" + staff.getSalt());*/
		/*PasswordAdapter pa = new PasswordAdapter(staff);
		System.out.println("mima:" + pa.encryptPassword());
		System.out.println("mima:" + ClassUtils.getDefaultClassLoader().getResource("").getPath());*/

		/*String pwd = RSAUtil.decryptString("123456");
		staff.setPassword(pwd);
		pa = new PasswordAdapter(staff);
		System.out.println("mima:" + pa.encryptPassword());*/

		byte[] hashPassword = Digests.sha1("123456".getBytes(), "78e38a3a3646b257".getBytes(), 1024);
		System.out.println((Encodes.encodeHex(hashPassword)));
	}

	/**
	 * 验证手机号码和邮箱是否存在
	 * @param staff
	 */
	public void checkStaffInfo(Staff staff, Staff oldStaff) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", staff.getEmail());
		Staff staff_email = findStaffByMap(params);
		if ((staff_email != null && oldStaff == null) || (oldStaff != null && !staff.getEmail().equals(oldStaff.getEmail())))
			throw new MyException("邮箱已存在");
		params.put("mobile", staff.getMobile());
		Staff staff_mobile = findStaffByMap(params);
		if ((staff_mobile != null && oldStaff == null) || (oldStaff != null && !staff.getMobile().equals(oldStaff.getMobile())))
			throw new MyException("手机号码已存在");
	}

	private void _createStaff(Staff staff) {
		if (this.staffDao.findStaffByLoginName(staff.getLoginName()) != null) {
			throw new MyException("此帐号已注册，系统不允许重复注册!");
		}
		checkStaffInfo(staff, null);

		entryptPassword(staff); // 设置密码
		this.staffDao.insertStaff(staff);

/*		PasswordAdapter pa = new PasswordAdapter(staff);

		staff.setPassword(pa.encryptPassword());

		this.staffDao.updateStaffPassword(staff);*/
		String roles = (String) staff.getOthers().get("roles");
		if (StringTools.isNotEmptyString(roles)) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("departmentId", staff.getDepartmentId());
			String[] roleList = roles.split(",");
			for (int i = 0; i < roleList.length; i++) {
				if (StringTools.isNotEmptyString(roleList[i])) {
					params.put("staffId", staff.getStaffId());
					params.put("roleId", roleList[i]);
					this.staffDao.insertStaffRoles(params);
				}
			}
		}
		/*for (Entry<String, String> entry : staff.getExtendProperties()
				.entrySet()) {
			// for (Map.Entry entry : staff.getExtendProperties().entrySet()) {
			StaffExtendProperty property = new StaffExtendProperty();
			property.setStaffId(staff.getStaffId());
			property.setProperty((String) entry.getKey());
			property.setValue((String) entry.getValue());

			this.staffDao.insertStaffExtendProperties(property);
		}*/
	}

	@Transactional(rollbackFor = { Exception.class })
	public void createStaff(Staff staff, String roleIds) {
		if (staff.getDepartmentId() == null) {
			throw new IllegalArgumentException("组织ID不能为空。");
		}
		if (this.departmentDao.findDepartment(staff.getDepartmentId()) == null) {
			throw new IllegalArgumentException("通过departmentId="
					+ staff.getDepartmentId() + "，查询不到组织。");
		}
		_createStaff(staff);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("departmentId", staff.getDepartmentId());
		String[] roleIdArray = roleIds.split(",");
		for (String roleId : roleIdArray)
			if (!StringUtils.isEmpty(roleId)) {
				if (this.roleDao.findRole(Long.valueOf(roleId)) == null) {
					throw new IllegalArgumentException("根据roleId=" + roleId
							+ ", 查询不到角色信息。");
				}
				params.put("staffId", staff.getStaffId());
				params.put("roleId", roleId);
				this.staffDao.insertStaffRoles(params);
			}
	}

	@Transactional(rollbackFor = { Exception.class })
	public void updateStaff(Staff staff) {
		Staff oldStaff = this.staffDao.findStaff(staff.getStaffId());
		if (null == oldStaff) {
			throw new MyException("修改的用户不存在!");
		}

		checkStaffInfo(staff, oldStaff);

		this.staffDao.updateStaff(staff);
		/*List<StaffExtendProperty> staffExtendProperties = this.staffDao.listStaffExtendProperties(staff.getStaffId());

		for (Entry<String, String> entry : staff.getExtendProperties()
				.entrySet()) {
			// for (Map.Entry entry : staff.getExtendProperties().entrySet()) {
			StaffExtendProperty property = new StaffExtendProperty();
			property.setStaffId(staff.getStaffId());
			property.setProperty((String) entry.getKey());
			property.setValue((String) entry.getValue());

			if (isStaffExtendPropertyExsitProperty(staffExtendProperties,
					property.getProperty()))
				this.staffDao.updateStaffExtendProperties(property);
			else
				this.staffDao.insertStaffExtendProperties(property);
		}*/
	}

	private boolean isStaffExtendPropertyExsitProperty(
			List<StaffExtendProperty> staffExtendProperties, String property) {
		if (StringTools.isEmptyString(property)) {
			return false;
		}
		for (StaffExtendProperty staffExtendProperty : staffExtendProperties) {
			if (property.equals(staffExtendProperty.getProperty())) {
				return true;
			}
		}
		return false;
	}

	@Transactional(rollbackFor = { Exception.class })
	public void deleteStaffs(Long[] staffIds) {
		if (staffIds == null) {
			throw new MyException("参数非法，不能为空");
		}
		for (Long staffId : staffIds) {
			this.staffDao.deleteStaffRoles(staffId);

			this.staffDao.deleteStaff(staffId);
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	public Staff findStaff(Long staffId) {
		Staff staff = this.staffDao.findStaff(staffId);

		if (staff != null) {
			/*List<StaffExtendProperty> properties = this.staffDao
					.listStaffExtendProperties(staffId);

			for (StaffExtendProperty p : properties) {
				staff.addExtendProperty(p.getProperty(), p.getValue());
			}*/

			if (staff.getDepartmentId() != null) {
				staff.setDepartment(this.departmentDao.findDepartment(staff
						.getDepartmentId()));
			}
		}

		return staff;
	}

	@Transactional(rollbackFor = { Exception.class })
	public Staff findStaffByLoginName(String loginName) {
		if (loginName == null) {
			throw new MyException("登录名[" + loginName + "]不能为空.");
		}

		Staff staff = this.staffDao.findStaffByLoginName(loginName);

		if (staff != null) {
			/*List<StaffExtendProperty> properties = this.staffDao
					.listStaffExtendProperties(staff.getStaffId());

			for (StaffExtendProperty p : properties) {
				staff.addExtendProperty(p.getProperty(), p.getValue());
			}*/

			if (staff.getDepartmentId() != null) {
				staff.setDepartment(this.departmentDao.findDepartment(staff.getDepartmentId()));
			}
		}
		return staff;
	}

	/*@Transactional(rollbackFor = { Exception.class })
	public Page<Staff> listStaff(Page<Staff> page) throws Exception {
		if (page == null) {
			throw new Exception("查询参数不能为空");
		}

		page.setDatas(this.staffDao.listStaff(page));

		return page;
	}*/
	@Transactional(rollbackFor = { Exception.class })
	public PageInfo<Staff> listStaff(Map<String, Object> map, Integer pageNumber, Integer pageSize) {
		if (map == null) {
			throw new MyException("查询参数不能为空");
		}
		PageHelper.startPage(pageNumber, pageSize);
		return new PageInfo<Staff>(this.staffDao.listStaff(map));
	}

	/*@Transactional(rollbackFor = { Exception.class })
	public void changePassword(String loginName, String oldPassword,
							   String newPassword) throws Exception {
		if ((loginName == null) || (oldPassword == null)
				|| (newPassword == null)) {
			throw new IllegalArgumentException("用户名、旧密码或新密码没有设置！");
		}

		if (oldPassword.equals(newPassword)) {
			throw new Exception("旧密码和新密码不能相同！");
		}

		Staff staff = this.staffDao.findStaffByLoginName(loginName);
		if (staff == null) {
			throw new Exception("找不到对应的成员【loginName=" + loginName + "】");
		}

		if (!staff.getPassword().equals(buildStaffPassword(staff, oldPassword))) {
			throw new Exception("旧密码不正确！");
		}

		staff.setPassword(buildStaffPassword(staff, newPassword));

		*//*if ((staff.getStatus() == Staff.Status.INITIAL)
				|| (staff.getStatus() == Staff.Status.PASSWORD_EXPIRED)) {
			staff.setStatus(Staff.Status.NORMAL);
		}*//*

		this.staffDao.updateStaffPassword(staff);
	}*/

	@Transactional(rollbackFor = { Exception.class })
	public void changePassword(String loginName, String oldPassword, String newPassword) {
		if ((loginName == null) || (oldPassword == null) || (newPassword == null)) {
			throw new IllegalArgumentException("用户名、旧密码或新密码没有设置！");
		}

		if (oldPassword.equals(newPassword)) {
			throw new MyException("旧密码和新密码不能相同！");
		}

		Staff staff = this.staffDao.findStaffByLoginName(loginName);
		if (staff == null) {
			throw new MyException("找不到对应的成员【loginName=" + loginName + "】");
		}

		if (checkPassword(staff.getPassword(), oldPassword, staff.getSalt())) {
			throw new MyException("旧密码不正确！");
		}
		entryptPassword(staff);
		//staff.setPassword(buildStaffPassword(staff, newPassword));

		if ((staff.getStatus() == "INITIAL") || (staff.getStatus() == "PASSWORD_EXPIRED")) {
			staff.setStatus("NORMAL");
		}
		this.staffDao.updateStaffPassword(staff);
	}

	@Transactional(rollbackFor = { Exception.class })
	public void resetPassword(String loginName, String newPassword) {
		if ((loginName == null) || (newPassword == null)) {
			throw new IllegalArgumentException("用户名或新密码没有设置！");
		}

		Staff staff = this.staffDao.findStaffByLoginName(loginName);
		if (staff == null) {
			throw new MyException("找不到对应的成员【loginName=" + loginName + "】");
		}

		staff.setPassword(buildStaffPassword(staff, newPassword));

		staff.setStatus("INITIAL");

		this.staffDao.updateStaffPassword(staff);
	}

	@Transactional(rollbackFor = { Exception.class })
	public void lockStaff(Long staffId) {
		Staff staff = this.staffDao.findStaff(staffId);
		if (staff == null) {
			throw new MyException("用户[" + staffId + "]没有找到");
		}
		if ((staff.getStatus().equalsIgnoreCase("INITIAL")) || (staff.getStatus().equalsIgnoreCase("NORMAL"))) {
			staff.setStatus("LOCKED");

			this.staffDao.updateStaff(staff);
		} else {
			throw new MyException("用户状态不是初创或者正常状态,不允许锁定.");
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	public void unlockStaff(Long staffId) {
		Staff staff = this.staffDao.findStaff(staffId);
		if (staff == null) {
			throw new MyException("用户[" + staffId + "]没有找到");
		}

		staff.setStatus("NORMAL");

		this.staffDao.updateStaff(staff);
	}

	@Transactional(rollbackFor = { Exception.class })
	public void updateStaffRoles(Long staffId, List<Long> roleIds)
			throws Exception {
		Staff staff = this.staffDao.findStaff(staffId);
		if (staff == null) {
			throw new Exception("用户[" + staffId + "]没有找到");
		}

		if (staff.getDepartmentId() == null) {
			staff.setDepartmentId(new Long(-1L));
		}

		this.staffDao.deleteStaffRoles(staff.getStaffId());

		for (Long roleId : roleIds) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("staffId", staff.getStaffId());
			map.put("departmentId", staff.getDepartmentId());
			map.put("roleId", roleId);

			this.staffDao.insertStaffRoles(map);
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	public void insertStaffRole(Long staffId, Long roleId) {
		Staff staff = this.staffDao.findStaff(staffId);
		if (staff == null) {
			throw new MyException("用户[" + staffId + "]没有找到");
		}

		if (staff.getDepartmentId() == null) {
			staff.setDepartmentId(new Long(-1L));
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("staffId", staff.getStaffId());
		map.put("departmentId", staff.getDepartmentId());
		map.put("roleId", roleId);

		this.staffDao.insertStaffRoles(map);
	}

	@Transactional(rollbackFor = { Exception.class })
	public void deleteStaffRole(Long staffId, Long roleId){
		Staff staff = this.staffDao.findStaff(staffId);
		if (staff == null) {
			throw new MyException("用户[" + staffId + "]没有找到");
		}

		if (staff.getDepartmentId() == null) {
			staff.setDepartmentId(new Long(-1L));
		}

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("staffId", staff.getStaffId());
		param.put("roleId", roleId);

		this.staffDao.deleteStaffRolesByStaffIdAndRoleId(param);
	}

	public List<Staff> listDepartmentStaffs(Long departmentId) {
		Map<String, Object> map = new HashMap<>();
		map.put("departmentId", departmentId.toString());
		map.put("noAdmin", "1");
		return this.staffDao.listStaff(map);
	}

	public List<Staff> listDepartmentAllStaffs(Long departmentId, String keyword, String domain) {
		if (departmentId == null) {
			throw new MyException("departmentId不能为空");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("departmentId", departmentId);
		if (domain != null) {
			param.put("domain", domain);
		}
		List<Department> departs = this.departmentDao .listSelfAndSubDepartmentByDepartmentId(param);
		StringBuffer ids = new StringBuffer();
		for (Department d : departs) {
			ids.append(d.getDepartmentId().toString()).append(",");
		}
		if (ids.length() > 0)
			ids.delete(ids.length() - 1, ids.length());
		else {
			return new ArrayList<Staff>();
		}
		param.clear();
		param.put("departmentIds", ids.toString());
		if ((keyword != null) && (!"".equals(keyword.trim()))) {
			param.put("keyword", keyword);
		}
		return this.staffDao.listStaff(param);
	}

	public List<Staff> listStaffsByDomain(String domain, String keyword) {
		if (domain == null) {
			throw new MyException("domain不能为空");
		}
		Department dept = new Department();
		dept.setDomain(domain);

		List<Department> departs = this.departmentDao.listDepartment(dept);

		StringBuffer ids = new StringBuffer();
		for (Department d : departs) {
			ids.append(d.getDepartmentId().toString()).append(",");
		}

		if (ids.length() > 0)
			ids.delete(ids.length() - 1, ids.length());
		else {
			return new ArrayList<>();
		}

		Map<String, Object> map = new HashMap<>();
		map.put("departmentIds", ids.toString());

		if ((keyword != null) && (!"".equals(keyword.trim()))) {
			map.put("keyword", keyword);
		}
		return this.staffDao.listStaff(map);
	}

	@Transactional(rollbackFor = { Exception.class })
	public List<Staff> listStaffByRole(Long roleId) {
		return this.staffDao.listStaffByRole(roleId);
	}

	private String buildStaffPassword(Staff staff, String password) {
		PasswordAdapter pa = new PasswordAdapter(staff);

		staff.setPassword(password);

		return pa.encryptPassword();
	}

	public List<Role> listStaffRoles(Long staffId) {
		Map<String, Object> map = new HashMap<>();
		Staff staff = this.staffDao.findStaff(staffId);
		if ((null != staff) && (staff.getDepartmentId() != null)) {
			map.put("departmentId", staff.getDepartmentId().toString());
		}
		List<Role> allRoles = this.roleDao.listRole(map);
		Map<Long, Role> roleMap = createRoleMap(this.roleDao.listStaffRoles(new Long(staffId.longValue())));
		for (Role r : allRoles) {
			if (roleMap.containsKey(r.getRoleId()))
				r.addOtherField("check", "true");
			else {
				r.addOtherField("check", "false");
			}
		}
		return allRoles;
	}

	private Map<Long, Role> createRoleMap(List<Role> list) {
		Map<Long, Role> roleMap = new HashMap<>();

		for (Role r : list) {
			roleMap.put(r.getRoleId(), r);
		}

		return roleMap;
	}

	@Transactional(rollbackFor = { Exception.class })
	public void updateStaffDepartment(Long departmentId, String staffIds) {
		this.staffDao.clearStaffDepartment(departmentId);
		Map<String, Object> params = new HashMap<>();
		params.put("departmentId", departmentId);
		if (!StringUtils.isEmpty(staffIds)) {
			String[] arr = staffIds.split(",");
			params.put("staffIds", arr);
			this.staffDao.updateStaffDepartmentByStaffIds(params);
		} else {
			this.staffDao.clearStaffDepartment(departmentId);
		}
		this.staffDao.deleteStaffRolesByDepartmentIdAndNotInStaffIds(params);
	}

	public List<SecStaffDepartmentRoleKey> listRoleByStaffIds(Long departmentId, String staffIds) {
		Map<String, Object> params = new HashMap<>();
		params.put("departmentId", departmentId);
		params.put("staffIds", staffIds.split(","));
		return this.staffDao.listRoleByStaffIds(params);
	}

	@Transactional(rollbackFor = { Exception.class })
	public void updateStaffRolesDepartment(Long departmentId, String staffIds, String staffIdRoles) {
		String[] staffIdArr = staffIds.split(",");
		for (String staffId : staffIdArr) {
			this.staffDao.deleteStaffRoles(Long.valueOf(Long.parseLong(staffId)));
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("departmentId", departmentId);
		String[] staffIdRoleArr = staffIdRoles.split(",");
		for (String staffIdRole : staffIdRoleArr) {
			if (!StringUtils.isEmpty(staffIdRole)) {
				String[] roles = staffIdRole.split("\\|");
				if (roles.length == 2) {
					params.put("staffId", roles[0]);
					params.put("roleId", roles[1]);
					this.staffDao.insertStaffRoles(params);
				}
			}
		}
	}

	/*public List<Staff> listStaffs(Long departmentId, String keyword) throws Exception {
		Page<Staff> page = new Page<Staff>();
		if (null != departmentId) {
			page.addParam("departmentId", departmentId.toString());
		}
		page.setRows(Integer.valueOf(999999));
		page.addParam("keyword", keyword);

		return this.staffDao.listStaff(page);
	}*/

	public List<Staff> listStaffs(Long departmentId, String keyword) {
		Map<String, Object> map = new HashMap<>();
		if (null != departmentId) {
			map.put("departmentId", departmentId.toString());
		}
		map.put("keyword", keyword);
		return this.staffDao.listStaff(map);
	}

	public Staff findStaffByMap(Map<String, Object> params) {
		List<Staff> staffs = this.staffDao.findStaffByMap(params);
		if ((null != staffs) && (!staffs.isEmpty())) {
			return (Staff) staffs.get(0);
		}
		return null;
	}

	public List<StaffExtendProperty> listStaffExtendProperties(Long staffId) {
		return this.staffDao.listStaffExtendProperties(staffId);
	}

	public void insertStaffExtendProperty(StaffExtendProperty data) {
		this.staffDao.insertStaffExtendProperties(data);
	}
}