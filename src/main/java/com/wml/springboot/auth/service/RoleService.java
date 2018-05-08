package com.wml.springboot.auth.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wml.springboot.auth.entity.*;
import com.wml.springboot.auth.mapper.*;
import com.wml.springboot.auth.tree.CheckTreeNode;
import com.wml.springboot.auth.tree.TreeBuilder;
import com.wml.springboot.auth.tree.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private StaffDao staffDao;

	@Autowired
	private DepartmentMapper departmentDao;

	@Autowired
	private OperationDao operationDao;

	@Autowired
	private ResourceDao resourceDao;

	@Autowired
	private ResourceCategoryDao resourceCategoryDao;

	@Transactional(rollbackFor={Exception.class})
	public void createRole(Role role)
			throws Exception
	{
		if (null != this.roleDao.findRoleByKey(role.getRoleKey())) {
			throw new Exception("角色助记码不能重复！");
		}
		if (null != this.roleDao.findRoleByName(role.getRoleName())) {
			throw new Exception("角色名称不能重复！");
		}
		this.roleDao.insertRole(role);
	}

	@Transactional(rollbackFor={Exception.class})
	public void updateRole(Role role)
			throws Exception
	{
		Role roleTemp = this.roleDao.findRoleByKey(role.getRoleKey());
		if ((null != roleTemp) && (!role.getRoleId().equals(roleTemp.getRoleId()))) {
			throw new Exception("角色助记码不能重复！");
		}
		roleTemp = this.roleDao.findRoleByName(role.getRoleName());
		if ((null != roleTemp) && (!role.getRoleId().equals(roleTemp.getRoleId()))) {
			throw new Exception("角色名称不能重复！");
		}
		Role oldRole = this.roleDao.findRole(role.getRoleId());
		if (null == oldRole) {
			throw new Exception("角色不存在！");
		}
		if (Role.CAN_NOT_MODIFY.equals(oldRole.getCanModify())) {
			throw new Exception("此角色不能修改！");
		}
		role.setCanModify(oldRole.getCanModify());
		role.setAutoAssign(oldRole.getAutoAssign());



		this.roleDao.updateRole(role);
	}

	@Transactional(rollbackFor={Exception.class})
	public void deleteRole(Long roleId)
			throws Exception
	{
		if (roleId == null) {
			throw new Exception("没有指定要删除的角色[roleId=" + roleId + "]");
		}
		Role role = this.roleDao.findRole(roleId);
		if (role == null) {
			throw new Exception("没有指定要删除的角色[roleId=" + roleId + "]");
		}
		this.roleDao.deleteRoleResourceOperationById(roleId);


		this.staffDao.deleteStaffRolesByRoleId(roleId);


		this.departmentDao.deleteDepartmentRolesByRoleId(roleId);


		this.roleDao.deleteRole(roleId);
	}

	@Transactional(rollbackFor = { Exception.class })
	public Role findRole(Long roleId) throws Exception {
		return this.roleDao.findRole(roleId);
	}

	/*@Transactional(rollbackFor = { Exception.class })
	public Page<Role> listRole(Page<Role> page) throws Exception {
		page.setDatas(this.roleDao.listRole(page));

		return page;
	}*/
	@Transactional(rollbackFor = { Exception.class })
	public PageInfo<Role> listRole(Map<String, Object> map, Integer pageNumber, Integer pageSize) throws Exception {
		PageHelper.startPage(pageNumber, pageSize);
		return new PageInfo<Role>(this.roleDao.listRole(map));
	}


	@Transactional(rollbackFor = { Exception.class })
	public List<Role> listStaffRoles(Long staffId) throws Exception {
		return this.roleDao.listStaffRoles(staffId);
	}

	@Transactional(rollbackFor = { Exception.class })
	public List<Role> listDepartmentRoles(Long departmentId) throws Exception {
		return this.roleDao.listDepartmentRoles(departmentId);
	}

	public List<TreeNode> buildRoleResourceTree() {
		TreeBuilder tree = new TreeBuilder();

		addResourceCategory(tree);

		addResource(tree);

		addOperation(tree);

		return tree.buildTree();
	}

	public List<TreeNode> buildRoleResourceTree(Long roleId) {
		TreeBuilder tree = new TreeBuilder();

		addResourceCategory(tree);

		addResource(tree);

		addOperation(tree);

		List<Operation> oList = this.operationDao.listOperationByRoleId(roleId);

		for (Operation op : oList) {
			String key = op.getResourceId() + "-" + op.getOperationKey();
			tree.markChecked(key);
		}

		return tree.buildTree();
	}

	@Transactional(rollbackFor = { Exception.class })
	public void updateRoleResource(Long roleId, List<RoleResourceOperation> list) {
		if (list != null) {
			this.roleDao.deleteRoleResourceOperationById(roleId);

			for (RoleResourceOperation roleResourceOperation : list) {
				roleResourceOperation.setRoleId(roleId);

				this.roleDao.insertRoleResourceOperation(roleResourceOperation);
			}
		}
	}

	private void addResourceCategory(TreeBuilder tree) {
		ResourceCategory category = new ResourceCategory();

		List<ResourceCategory> rcs = this.resourceCategoryDao
				.listRootResourceCategory(category);

		for (ResourceCategory ca : rcs) {
			TreeNode node = new TreeNode(longToString(ca.getCategoryId()),
					longToString(ca.getParentId()), ca.getCategoryName());

			tree.addNode(node);
		}
	}

	private void addResource(TreeBuilder tree) {
		Resource param = new Resource();

		List<Resource> rList = this.resourceDao.listResource(param);

		for (Resource res : rList) {
			TreeNode node = new TreeNode("res-"
					+ longToString(res.getResourceId()),
					longToString(res.getCategoryId()), res.getResourceName());

			tree.addNode(node);
		}
	}

	private void addOperation(TreeBuilder tree) {
		Operation operParam = new Operation();

		List<Operation> oList = this.operationDao.listOperation(operParam);

		for (Operation op : oList) {
			CheckTreeNode node = new CheckTreeNode(op.getResourceId() + "-"
					+ op.getOperationKey(), "res-" + op.getResourceId(),
					op.getOperationName());

			tree.addNode(node);
		}
	}

	public Role findRoleByKey(String roleKey) {
		return this.roleDao.findRoleByKey(roleKey);
	}

	private String longToString(Long value) {
		if (value == null) {
			return null;
		}

		return value.toString();
	}
}