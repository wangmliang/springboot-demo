package com.wml.springboot.auth.controller;

import com.wml.springboot.auth.BaseController;
import com.wml.springboot.auth.entity.Department;
import com.wml.springboot.auth.entity.Role;
import com.wml.springboot.auth.entity.Staff;
import com.wml.springboot.auth.service.DepartmentService;
import com.wml.springboot.auth.service.RoleService;
import com.wml.springboot.auth.service.StaffService;
import com.wml.springboot.util.LayerPage;
import com.wml.springboot.util.StaffUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * ����Controller
 * <pre>
 * <b>Title��</b>DepartmentController.java<br/>
 * <b>@author��</b>WML<br/>
 * <b>@date��</b>2016��11��7�� - ����5:55:03<br/>  
 * <b>@version v1.0</b></br/>
 * <b>Copyright (c) 2016 ASPire Tech.</b>   
 * </pre>
 */
@Controller
@RequestMapping({ "/auth/department" })
public class DepartmentController extends BaseController {

	private Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	@Qualifier("departmentService")
	private DepartmentService departmentService;

	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;

	@Autowired
	@Qualifier("staffService")
	private StaffService staffService;

	/**
	 * 列表页
	 * @param id 主键id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/page.html")
	public String page() throws Exception{
		return "admin/auth/department/page";
	}

	/**
	 * 编辑页
	 * @param id 角色id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = {"/add.html", "/edit.html"})
	public String edit(Long id, Model model) throws Exception{
		Department role = new Department();
		if(null != id) {
			role = departmentService.findDepartment(id);
		}
		model.addAttribute("record", role);
		return "admin/auth/department/edit";
	}

	/**
	 * 根据部门id查询部门信息
	 * @param departmentId	部门id
	 * @return
	 * @author WML
	 * 2016年11月7日 - 下午5:55:21
	 */
	@RequestMapping({ "/findDepartment.json" })
	@ResponseBody
	public Map<String, ? extends Object> findRoles(Long departmentId) {
		try {
			if (departmentId == null) {
				throw new Exception("查询部门ID不能为空");
			}
			Department d = this.departmentService.findDepartment(departmentId);
			if (d == null) {
				throw new Exception("找不到对应的部门[id=" + departmentId + "]");
			}
			return success(d);
		} catch (Exception e) {
			LOGGER.error("根据[id=" + departmentId + "]查询角色出错", e);
			return fail(e.getMessage());
		}
	}

	/**
	 * 更新部门信息
	 * @param department
	 * @return
	 * @author WML
	 * 2016年11月7日 - 下午5:55:46
	 */
	@RequestMapping(value = { "/updateDepartment.ajax" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public Map<String, ? extends Object> updateDepartment(Department department) {
		try {
			String text = "";
			if (department == null) {
				throw new Exception("空对象错误");
			}
			if (isEmpty(department.getDepartmentId())) {
				department.setAddSub("1");
				if (StaffUtil.getLoginStaff() == null)
					department.setCreateUser("system");
				else {
					department.setCreateUser(StaffUtil.getLoginStaff().getLoginName());
				}
				this.departmentService.insertDepartment(department);
				text = "创建部门成功";
			} else {
				this.departmentService.updateDepartment(department);
				text = "修改部门成功";
			}
			LOGGER.debug(text);
			return success(department);
		} catch (Exception e) {
			LOGGER.error("修改部门信息出错", e);
			return fail(e.getMessage());
		}
	}

	/**
	 * 删除部门信息
	 * @param departmentId
	 * @return
	 * @author WML
	 * 2016年11月7日 - 下午5:56:05
	 */
	@RequestMapping({ "/delDepartment.ajax" })
	@ResponseBody
	public Map<String, ? extends Object> delDepartment(Long departmentId) {
		try {
			if (departmentId == null) {
				throw new Exception("部门ID不能为空");
			}
			Staff staff = StaffUtil.getLoginStaff();
			if ((null != staff) && (staff.getDepartmentId() == departmentId)) {
				throw new Exception("你没有权限删除当前组织!");
			}
			this.departmentService.deleteDepartment(departmentId);
			return success("删除部门成功");
		} catch (Exception e) {
			LOGGER.error("根据[departmentId]=" + departmentId + ",删除部门出错", e);
			return fail(e.getMessage());
		}
	}

	/**
	 * 获取部门信息
	 * @return
	 * @author WML
	 * 2016年11月7日 - 下午5:56:15
	 */
	@RequestMapping({ "/listDepartmentTree.json" })
	@ResponseBody
	public Map<String, ? extends Object> listDepartmentTree() {
		try {
			return success(this.departmentService.buildDepartmentTree());
		} catch (Exception e) {
			LOGGER.error("获取组织列表出错", e);
			return fail(e.getMessage());
		}
	}

	/**
	 * 根据部门id查询部门对应的角色信息
	 * @param departmentId
	 * @return
	 * @author WML
	 * 2016年11月7日 - 下午5:56:50
	 */
	@RequestMapping({ "/findDepartmentInfo.json" })
	@ResponseBody
	public Map<String, ? extends Object> findDepartmentInfo(Long departmentId) {
		try {
			if (departmentId == null) {
				throw new Exception("查询部门ID不能为空");
			}
			Department d = this.departmentService.findDepartment(departmentId);
			if (d == null) {
				throw new Exception("找不到对应的部门[id=" + departmentId + "]");
			}
			List<Role> roles = this.roleService.listDepartmentRoles(departmentId);
			d.addOtherField("roles", roles);
			List<Staff> staffs = this.staffService.listDepartmentStaffs(departmentId);
			d.addOtherField("staffs", staffs);
			return success(d);
		} catch (Exception e) {
			LOGGER.error("根据[departmentId]=" + departmentId + ",查询部门出错", e);
			return fail(e.getMessage());
		}
	}

	/**
	 * 根据部门id查询对应的角色集合
	 * @param departmentId
	 * @return
	 * @author WML
	 * 2016年11月7日 - 下午5:57:15
	 */
	@RequestMapping({ "/listDepartmentRoles.ajax" })
	@ResponseBody
	public LayerPage<Role> listDepartmentRoles(HttpServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "");
		LayerPage<Role> layerPage = null;
		Long departmentId = Long.valueOf(searchParams.get("departmentId").toString());
		try {
			Integer page = Integer.valueOf(searchParams.get("page").toString());
			Integer limit = Integer.valueOf(searchParams.get("limit").toString());
			//layerPage = new LayerPage<Role>(this.departmentService.listDepartmentRoles(departmentId));
		} catch (Exception e) {
			LOGGER.error("根据[departmentId]=" + departmentId + ",查询角色出错", e);
			layerPage.setCode(1);
			layerPage.setMsg("请求错误");
		}
		return layerPage;
	}

	/**
	 * 添加或删除角色信息
	 * @param operation
	 * @param departmentId
	 * @param roleId
	 * @return
	 * @author WML
	 * 2016年11月7日 - 下午5:58:08
	 */
	@RequestMapping(value = { "/updateDepartmentRole.ajax" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public Map<String, ? extends Object> updateStaffRole(
			@RequestParam String operation, @RequestParam Long departmentId,
			@RequestParam Long roleId) {
		try {
			if ((isEmpty(operation)) || (isEmpty(departmentId))
					|| (isEmpty(roleId))) {
				throw new Exception("参数为空");
			}
			if ("add".equalsIgnoreCase(operation)) {
				this.departmentService.insertDepartmentRole(departmentId, roleId);
				return success("添加角色成功。");
			}
			this.departmentService.deleteDepartmentRoleByRoleIdAndDeptId(departmentId, roleId);
			return success("删除角色成功。");
		} catch (Exception e) {
			LOGGER.error("根据[][departmentId]=" + departmentId + ",查询角色出错", e);
			return fail(e.getMessage());
		}
	}

	/**
	 * 更新部门用户信息
	 * @param departmentId
	 * @param staffIds
	 * @param oraginalIds
	 * @return
	 * @author WML
	 * 2016年11月7日 - 下午5:59:38
	 */
	@RequestMapping(value = { "/updateStaffDepartment.ajax" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public Map<String, ? extends Object> updateStaffDepartment(
			@RequestParam Long departmentId, @RequestParam String staffIds,
			@RequestParam String oraginalIds) {
		try {
			if (isEmpty(departmentId)) {
				throw new Exception("部门Id不能为空");
			}
			if (isEmpty(staffIds)) {
				staffIds = "''";
			}
			if (isEmpty(oraginalIds)) {
				oraginalIds = "''";
			}
			this.staffService.updateStaffDepartment(null, wrapIds(oraginalIds));
			this.staffService.updateStaffDepartment(departmentId, wrapIds(staffIds));
			return success("更新部门用户成功");
		} catch (Exception e) {
			LOGGER.error("根据[staffIds]=" + staffIds + ",[oraginalIds]="
					+ oraginalIds + ",[departmentId]=" + departmentId
					+ ",更新部门用户出错", e);
			return fail(e.getMessage());
		}
	}

	/**
	 * 获取id
	 * @param ids
	 * @return
	 * @author WML
	 * 2016年11月7日 - 下午5:58:46
	 */
	private String wrapIds(String ids) {
		if (ids.indexOf(",") > 0) {
			return "'" + ids.replace(",", "','") + "'";
		}
		return ids;
	}
}