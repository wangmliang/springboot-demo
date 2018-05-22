package com.wml.springboot.auth;

import com.wml.springboot.auth.entity.Staff;
import com.wml.springboot.util.PasswordUtil;

public class PasswordAdapter {
	private Staff staff;

	public PasswordAdapter(Staff s) {
		this.staff = s;
	}

	public String encryptPassword() {
		boolean flag = true;
		// if (Config.getInstance().isOldPasswordSupport()) {
		if(flag) {
			return PasswordUtil.buildPassword(this.staff.getStaffId().toString(), this.staff.getPassword());
		}
		return PasswordUtil.buildPassword(this.staff.getLoginName(), this.staff.getPassword());
	}
}