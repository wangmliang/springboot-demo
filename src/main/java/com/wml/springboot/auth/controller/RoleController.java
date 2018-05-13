package com.wml.springboot.auth.controller;

import java.util.*;

import com.wml.springboot.auth.BaseController;
import com.wml.springboot.auth.entity.Role;
import com.wml.springboot.auth.entity.RoleResourceOperation;
import com.wml.springboot.auth.service.RoleService;
import com.wml.springboot.auth.tree.TreeNode;
import com.wml.springboot.util.DateUtil;
import com.wml.springboot.util.LayerPage;
import com.wml.springboot.util.StaffUtil;
import org.apache.commons.lang3.StringUtils;
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

/**
 * 角色Controller
 * <pre>
 * <b>Title：</b>RoleController.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2016年11月8日 - 上午8:46:20<br/>
 * <b>@version v1.0</b></br/>
 * <b>Copyright (c) 2016 ASPire Tech.</b>
 * </pre>
 */
@Controller
@RequestMapping({ "/auth/role" })
public class RoleController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;

	/**
	 * 更新角色信息
	 * @param role
	 * @return
	 * @author WML
	 * 2016年11月8日 - 上午8:51:23
	 */
	@RequestMapping(value = { "/updateRole.json" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public Map<String, ? extends Object> updateRole(Role role) {
		try {
			String text = "";
			if (role == null) {
				throw new Exception("空对象错误");
			}
			role.setLastUpdateDate(new Date());
			if (isEmpty(role.getRoleId())) {
				if ((role != null) && (role.getCanModify() == null)) {
					role.setCanModify(Integer.valueOf(1));
				}
				if (StaffUtil.getLoginStaff() == null)
					role.setCreateUser("nouser");
				else {
					role.setCreateUser(StaffUtil.getLoginStaff().getLoginName());
				}
				this.roleService.createRole(role);
				text = "创建角色成功";
			} else {
				this.roleService.updateRole(role);
				text = "修改角色成功";
			}
			return success(text);
		} catch (Exception e) {
			logger.error("修改角色失败", e);
			return fail(e.getMessage());
		}
	}

	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 * @author WML
	 * 2016年11月8日 - 上午8:51:44
	 */
	@RequestMapping(value = { "/deleteRole.json" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public Map<String, ? extends Object> deleteRole(Long roleId) {
		try {
			this.roleService.deleteRole(roleId);
			return success("删除角色成功");
		} catch (Exception e) {
			logger.error("删除角色失败", e);
			return fail(e.getMessage());
		}
	}

	/**
	 * 列表页
	 * @param id 主键id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/page.html")
	public String page() throws Exception{
		return "admin/auth/role/page";
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
		Role role = new Role();
		if(null != id) {
			role = roleService.findRole(id);
		}
		model.addAttribute("record", role);
		return "admin/auth/role/edit";
	}

	/**
	 * 角色列表
	 * @param
	 * @return
	 * @author WML
	 * 2016年11月8日 - 上午8:51:53
	 */
	@RequestMapping({ "/listRoles.json" })
	@ResponseBody
	public LayerPage<Role> listRoles(HttpServletRequest request) {
		LayerPage layerPage = null;
		try {
			Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "");
			Integer page = Integer.valueOf(searchParams.get("page").toString());
			Integer limit = Integer.valueOf(searchParams.get("limit").toString());
			layerPage = new LayerPage<Role>(this.roleService.listRole(searchParams, page,limit));
		} catch (Exception e) {
			layerPage.setCode(1);
			layerPage.setMsg("请求错误");
		}
		return layerPage;
	}

	/**
	 * 根据id查询角色信息
	 * @param roleId
	 * @return
	 * @author WML
	 * 2016年11月8日 - 上午8:52:05
	 */
	@RequestMapping({ "/findRole.ajax" })
	@ResponseBody
	public Map<String, ? extends Object> findRoles(Long roleId) {
		try {
			if (roleId == null) {
				throw new Exception("查询角色ID不能为空");
			}
			Role r = this.roleService.findRole(roleId);
			if (r == null) {
				throw new Exception("找不到对应的角色[id=" + roleId + "]");
			}
			return success(r);
		} catch (Exception e) {
			return fail(e.getMessage());
		}
	}

	/**
	 * 根据id和key验证是否存在
	 * @param roleId
	 * @param roleKey
	 * @return
	 * @author WML
	 * 2016年11月8日 - 上午8:53:17
	 */
	@RequestMapping({ "/checkRoleKey.ajax" })
	@ResponseBody
	public String checkRoleKey(Long roleId, String roleKey) {
		try {
			if (isEmpty(roleKey)) {
				return "参数为空";
			}
			Role role = this.roleService.findRoleByKey(roleKey);
			if (role != null) {
				if (isNotEmpty(roleId)) {
					Role role2 = this.roleService.findRole(roleId);
					if ((null != role2) && (role2.getRoleKey().equals(roleKey))) {
						return "true";
					}
				}
				return "角色助记码已存在";
			}
		} catch (Exception e) {
			logger.error("检查roleKey[" + roleKey + "]是否存在出错", e);
			return "发生系统异常";
		}
		return "true";
	}

	/**
	 * 角色集合资源权限
	 * @param roleId
	 * @return
	 * @author WML
	 * 2016年11月8日 - 上午8:50:27
	 */
	@RequestMapping({ "/listRoleResource.html" })
	public String listRoleResource(Long roleId, Model model) throws Exception {
		Map<String, Object> map = new HashMap<>();
		List<TreeNode> tree = null;
		if (roleId == null)
			tree = this.roleService.buildRoleResourceTree();
		else {
			tree = this.roleService.buildRoleResourceTree(roleId);
		}
		model.addAttribute("role", roleService.findRole(roleId));
		model.addAttribute("tree", tree);
		return "admin/auth/role/roleResource";
	}

	/**
	 * 更新角色资源权限
	 * @param roleId
	 * @param resourceIdAndOperationKey
	 * @return
	 * @author WML
	 * 2016年11月8日 - 上午8:53:48
	 */
	@RequestMapping(value = { "/updateRoleResource.json" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public Map<String, ? extends Object> updateRoleResource(
			@RequestParam Long roleId,
			@RequestParam String resourceIdAndOperationKey) {
		try {
			if (isEmpty(roleId)) {
				throw new Exception("角色ID为空");
			}
			this.roleService.updateRoleResource(roleId, createRoleResourceOperationList(resourceIdAndOperationKey));
			return success("成功更新角色权限");
		} catch (Exception e) {
			return fail(e.getMessage());
		}
	}

	/**
	 * 添加角色资源权限
	 * @param idAndKeys
	 * @return
	 * @author WML
	 * 2016年11月8日 - 上午8:54:24
	 */
	private List<RoleResourceOperation> createRoleResourceOperationList(String idAndKeys) {
		List<RoleResourceOperation> roleResourceOperations = new ArrayList<RoleResourceOperation>();
		if (isEmpty(idAndKeys)) {
			return roleResourceOperations;
		}
		if (isNotEmpty(idAndKeys)) {
			String[] resourceIdAndOperationKeys = idAndKeys.split(",");
			for (int i = 0; i < resourceIdAndOperationKeys.length; i++) {
				String[] idAndKey = resourceIdAndOperationKeys[i].split("-");
				if (idAndKey.length == 2) {
					String resourceId = idAndKey[0];
					String operationKey = idAndKey[1];
					RoleResourceOperation roleResourceOperation = new RoleResourceOperation();
					roleResourceOperation.setResourceId(resourceId);
					roleResourceOperation.setOperationKey(operationKey);
					roleResourceOperations.add(roleResourceOperation);
				}
			}
		}
		return roleResourceOperations;
	}
}