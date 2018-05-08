package com.wml.springboot.auth.service;

import com.wml.springboot.auth.entity.Menu;
import com.wml.springboot.auth.entity.SubSystem;
import com.wml.springboot.auth.mapper.MenuDao;
import com.wml.springboot.auth.mapper.SubSystemDao;
import com.wml.springboot.auth.tree.MenuTreeNode;
import com.wml.springboot.auth.tree.TreeNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("menuService")
public class MenuService {
	private static Map<String, SubSystem> subSystemMap = null;

	@Autowired
	private MenuDao menuDao;

	@Autowired
	private SubSystemDao subSystemDao;

	@Autowired
	private AuthService authService;

	public List<MenuTreeNode> buildMenuTree(String loginName, String ticket, String defaultPath) throws Exception {
		List<Menu> menus = this.menuDao.listMenu(new Menu());

		List<Menu> targetMenus = new ArrayList<Menu>();

		Map<String, String> urlMap = this.authService.listAddressUrlByLoginName(loginName);

		for (Menu m : menus) {
			if (StringUtils.isEmpty(m.getUrl())) {
				targetMenus.add(m);
			} else if (this.authService.authorizeSuccess(m.getUrl(), urlMap)) {
				targetMenus.add(m);
			}

		}

		List<MenuTreeNode> list = new ArrayList<MenuTreeNode>();

		Map<String, MenuTreeNode> map = new LinkedHashMap<String, MenuTreeNode>();

		List<MenuTreeNode> roots = new ArrayList<MenuTreeNode>();

		for (Menu m : targetMenus) {
			MenuTreeNode node = toMenuNode(m, ticket, defaultPath);

			list.add(node);
			map.put(node.getId(), node);
		}

		for (MenuTreeNode node : list) {
			MenuTreeNode parent = (MenuTreeNode) map.get(node.getParentId());

			if (parent != null) {
				parent.addChild(node);
			}

		}

		for (MenuTreeNode node : list) {
			if ((node.isLeaf()) && (node.getUrl() == null)) {
				removeNode(map, node);
			}

		}

		for (MenuTreeNode node : map.values()) {
			if ("0".equals(node.getParentId())) {
				roots.add(node);
			}
		}

		return roots;
	}

	private Map<String, SubSystem> getSubSystem() {
		if (subSystemMap == null) {
			subSystemMap = loadSubSystem();
		}

		return subSystemMap;
	}

	private Map<String, SubSystem> loadSubSystem() {
		Map<String, SubSystem> map = new HashMap<String, SubSystem>();

		List<SubSystem> list = this.subSystemDao.listSubSystem();

		for (SubSystem sys : list) {
			map.put(sys.getSubSystemId(), sys);
		}

		return map;
	}

	private void removeNode(Map<String, MenuTreeNode> treeNodes, TreeNode node) {
		treeNodes.remove(node.getId());

		if (treeNodes.containsKey(node.getParentId())) {
			TreeNode parent = (TreeNode) treeNodes.get(node.getParentId());
			parent.removeChild(node);

			if (parent.isLeaf())
				removeNode(treeNodes, parent);
		}
	}

	private MenuTreeNode toMenuNode(Menu m, String ticket, String defaultPath) {
		MenuTreeNode node = new MenuTreeNode();
		node.setId(m.getMenuId().toString());
		node.setParentId(m.getParentId().toString());
		node.setText(m.getMenuName());
		node.setMenuKey(m.getMenuKey());
		node.setIcon(m.getImageUrl());

		if ((m.getUrl() != null) && (!"".equals(m.getUrl()))) {
			String contextPath = getSubSystemContext(m.getSubsystem());

			if ((contextPath == null) || ("".equals(contextPath))) {
				contextPath = defaultPath;
			}
			node.setUrl(contextPath + m.getUrl() + "?ticket=" + ticket);
		}

		return node;
	}

	private String getSubSystemContext(String subSystemId) {
		Map<String, SubSystem> subSystems = getSubSystem();

		if (subSystems.containsKey(subSystemId)) {
			return ((SubSystem) subSystems.get(subSystemId)).getHopDomain();
		}
		return "";
	}
}