package com.wml.springboot.auth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import com.wml.springboot.auth.PasswordAdapter;
import com.wml.springboot.auth.SessionContext;
import com.wml.springboot.auth.entity.Department;
import com.wml.springboot.auth.entity.Staff;
import com.wml.springboot.auth.entity.StaffExtendProperty;
import com.wml.springboot.auth.mapper.DepartmentMapper;
import com.wml.springboot.auth.mapper.StaffDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
@SuppressWarnings("unused")
public class LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	private static final String CONTRACT_AGREEMENT_KEY = "contractAgreement";
	private static final String CONTRACT_AGREEMENT_VALUE = "1";

	@Autowired
	private StaffDao staffDao;

	@Autowired
	private DepartmentMapper departmentDao;

	public Staff findStaffByKeyword(String keyword) {
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("keyword", keyword);
		List<Staff> staffs = this.staffDao.findStaffByMap(queryParams);
		if ((null != staffs) && (!staffs.isEmpty())) {
			return (Staff) staffs.get(0);
		}
		return null;
	}

	public void login(String name, String password, HttpSession session)
			throws Exception {
		Staff loginStaff = null;

		loginStaff = this.staffDao.findStaffByLoginName(name);

		if (loginStaff == null) {
			logger.info("用户[" + name + "]登录失败,没有找到对应的用户。");
			throw new Exception("登录名或者密码不正确");
		}

		if ((!Staff.Status.NORMAL.equals(loginStaff.getStatus()))
				&& (!Staff.Status.INITIAL.equals(loginStaff.getStatus()))) {
			throw new Exception("用户状态异常");
		}

		Staff paramStaff = new Staff();
		paramStaff.setStaffId(loginStaff.getStaffId());
		paramStaff.setLoginName(name);
		paramStaff.setPassword(password);

		PasswordAdapter loginPwd = new PasswordAdapter(paramStaff);

		if (!loginStaff.getPassword().equals(loginPwd.encryptPassword())) {
			logger.info("用户[" + name + "]登录失败,登录密码不正确。");
			throw new Exception("登录名或者密码不正确");
		}

		if (loginStaff.getDepartmentId() != null) {
			Department department = this.departmentDao.findDepartment(loginStaff.getDepartmentId());

			loginStaff.setDepartment(department);
		}

		session.setAttribute("LOGIN_NAME", loginStaff.getLoginName());

		session.setAttribute("LOGIN_STAFF", loginStaff);

		SessionContext.getContext().addSession(session);
	}

	public boolean isReadContractAgreement(
			List<StaffExtendProperty> staffExtendProperties) {
		for (StaffExtendProperty staffExtendProperty : staffExtendProperties) {
			if (("contractAgreement".equals(staffExtendProperty.getProperty()))
					&& ("1".equals(staffExtendProperty.getValue()))) {
				return true;
			}
		}
		return false;
	}

	public StaffExtendProperty setReadContractAgreement(Staff staff) {
		StaffExtendProperty staffExtendProperty = new StaffExtendProperty();
		staffExtendProperty.setStaffId(staff.getStaffId());
		staffExtendProperty.setProperty("contractAgreement");
		staffExtendProperty.setValue("1");
		this.staffDao.insertStaffExtendProperties(staffExtendProperty);
		return staffExtendProperty;
	}

	public void logout(HttpSession session) throws Exception {
		System.out.println("注销session");

		SessionContext.getContext().deleteSession(session.getId());

		session.invalidate();
	}
}