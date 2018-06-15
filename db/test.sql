/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-05-10 19:02:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `MENU_ID` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `MENU_NAME` varchar(64) NOT NULL COMMENT '菜单名称',
  `MENU_KEY` varchar(100) NOT NULL COMMENT '菜单外码',
  `PARENT_ID` bigint(10) NOT NULL COMMENT '父菜单ID',
  `IMAGE_URL` varchar(128) DEFAULT NULL COMMENT '图标Url',
  `URL` varchar(128) DEFAULT NULL COMMENT '资源URL',
  `MENU_ORDER` varchar(6) DEFAULT NULL COMMENT '菜单顺序',
  `SUBSYSTEM` varchar(32) DEFAULT NULL COMMENT '子系统名称',
  `DOMAIN` varchar(32) DEFAULT NULL COMMENT '菜单所属域（admin、sp）',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('24', '系统管理', 'auth_sysmgt_admin_sysmgtall', '0', 'menu-icon fa fa-pencil-square-o', null, '900000', 'auth_sysmgt', 'admin');
INSERT INTO `menu` VALUES ('25', '修改帐号信息', 'auth_sysmgt_admin_sysmgtall_indiv_modifyinfo', '24', 'icon-user', '/auth/individual/modifyInfo', '10000', 'auth_sysmgt', 'admin');
INSERT INTO `menu` VALUES ('26', '修改密码', 'auth_sysmgt_admin_sysmgtall_indiv_modifypwd', '24', 'icon-lock', '/auth/individual/modifyPwd', '20000', 'auth_sysmgt', 'admin');
INSERT INTO `menu` VALUES ('27', '设置个性化参数', 'auth_sysmgt_admin_sysmgtall_indiv_setting', '24', ' icon-magnet', '/auth/individual/selfConfigSetting', '30000', 'auth_sysmgt', 'admin');
INSERT INTO `menu` VALUES ('28', '组织管理', 'auth_sysmgt_admin_sysmgtall_dept_deptmsg', '24', 'icon-sitemap', '/auth/dept', '40000', 'auth_sysmgt', 'admin');
INSERT INTO `menu` VALUES ('29', '成员管理', 'auth_sysmgt_admin_sysmgtall_dept_staffmgt', '24', 'icon-user-md', '/auth/staff', '50000', 'auth_sysmgt', 'admin');
INSERT INTO `menu` VALUES ('30', '角色管理', 'auth_sysmgt_admin_sysmgtall_dept_rolemgt', '24', 'icon-group', '/auth/role/page', '60000', 'auth_sysmgt', 'admin');
INSERT INTO `menu` VALUES ('31', '组织管理日志', 'auth_sysmgt_admin_sysmgtall_orgoperationlog', '24', 'icon-table', '/auth/log/queryAccountLog', '70000', 'auth_sysmgt', 'admin');

-- ----------------------------
-- Table structure for menu_180510152245
-- ----------------------------
DROP TABLE IF EXISTS `menu_180510152245`;
CREATE TABLE `menu_180510152245` (
  `MENU_ID` bigint(10) NOT NULL DEFAULT '0' COMMENT '菜单ID',
  `MENU_NAME` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '菜单名称',
  `MENU_KEY` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '菜单外码',
  `PARENT_ID` bigint(10) NOT NULL COMMENT '父菜单ID',
  `IMAGE_URL` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '图标Url',
  `URL` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源URL',
  `MENU_ORDER` varchar(6) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单顺序',
  `SUBSYSTEM` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '子系统名称',
  `DOMAIN` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单所属域（admin、sp）'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of menu_180510152245
-- ----------------------------

-- ----------------------------
-- Table structure for menu_180510174320
-- ----------------------------
DROP TABLE IF EXISTS `menu_180510174320`;
CREATE TABLE `menu_180510174320` (
  `MENU_ID` bigint(10) NOT NULL DEFAULT '0' COMMENT '菜单ID',
  `MENU_NAME` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '菜单名称',
  `MENU_KEY` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '菜单外码',
  `PARENT_ID` bigint(10) NOT NULL COMMENT '父菜单ID',
  `IMAGE_URL` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '图标Url',
  `URL` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源URL',
  `MENU_ORDER` varchar(6) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单顺序',
  `SUBSYSTEM` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '子系统名称',
  `DOMAIN` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单所属域（admin、sp）'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of menu_180510174320
-- ----------------------------
INSERT INTO `menu_180510174320` VALUES ('16', '系统管理', 'auth_sysmgt_admin_sysmgtall', '0', 'menu-icon fa fa-pencil-square-o', null, '900000', 'auth_sysmgt', 'admin');
INSERT INTO `menu_180510174320` VALUES ('17', '修改帐号信息', 'auth_sysmgt_admin_sysmgtall_indiv_modifyinfo', '16', 'icon-user', '/auth/individual/modifyInfo', '10000', 'auth_sysmgt', 'admin');
INSERT INTO `menu_180510174320` VALUES ('18', '修改密码', 'auth_sysmgt_admin_sysmgtall_indiv_modifypwd', '16', 'icon-lock', '/auth/individual/modifyPwd', '20000', 'auth_sysmgt', 'admin');
INSERT INTO `menu_180510174320` VALUES ('19', '设置个性化参数', 'auth_sysmgt_admin_sysmgtall_indiv_setting', '16', ' icon-magnet', '/auth/individual/selfConfigSetting', '30000', 'auth_sysmgt', 'admin');
INSERT INTO `menu_180510174320` VALUES ('20', '组织管理', 'auth_sysmgt_admin_sysmgtall_dept_deptmsg', '16', 'icon-sitemap', '/auth/dept', '40000', 'auth_sysmgt', 'admin');
INSERT INTO `menu_180510174320` VALUES ('21', '成员管理', 'auth_sysmgt_admin_sysmgtall_dept_staffmgt', '16', 'icon-user-md', '/auth/staff', '50000', 'auth_sysmgt', 'admin');
INSERT INTO `menu_180510174320` VALUES ('22', '角色管理', 'auth_sysmgt_admin_sysmgtall_dept_rolemgt', '16', 'icon-group', '/auth/role/page', '60000', 'auth_sysmgt', 'admin');
INSERT INTO `menu_180510174320` VALUES ('23', '组织管理日志', 'auth_sysmgt_admin_sysmgtall_orgoperationlog', '16', 'icon-table', '/auth/log/queryAccountLog', '70000', 'auth_sysmgt', 'admin');

-- ----------------------------
-- Table structure for person_shortcut
-- ----------------------------
DROP TABLE IF EXISTS `person_shortcut`;
CREATE TABLE `person_shortcut` (
  `SHORTCUT_ID` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '快捷方式ID',
  `STAFF_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `TITLE` varchar(64) NOT NULL COMMENT '标题',
  `MENU_ID` bigint(10) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`SHORTCUT_ID`),
  KEY `FK_PERSON_SHORTCUT` (`MENU_ID`),
  CONSTRAINT `FK_PERSON_SHORTCUT` FOREIGN KEY (`MENU_ID`) REFERENCES `menu` (`MENU_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户快捷方式设置';

-- ----------------------------
-- Records of person_shortcut
-- ----------------------------

-- ----------------------------
-- Table structure for person_shortcut_180510152245
-- ----------------------------
DROP TABLE IF EXISTS `person_shortcut_180510152245`;
CREATE TABLE `person_shortcut_180510152245` (
  `SHORTCUT_ID` tinyint(4) NOT NULL DEFAULT '0' COMMENT '快捷方式ID',
  `STAFF_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `TITLE` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '标题',
  `MENU_ID` bigint(10) NOT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of person_shortcut_180510152245
-- ----------------------------

-- ----------------------------
-- Table structure for person_shortcut_180510174320
-- ----------------------------
DROP TABLE IF EXISTS `person_shortcut_180510174320`;
CREATE TABLE `person_shortcut_180510174320` (
  `SHORTCUT_ID` tinyint(4) NOT NULL DEFAULT '0' COMMENT '快捷方式ID',
  `STAFF_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `TITLE` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '标题',
  `MENU_ID` bigint(10) NOT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of person_shortcut_180510174320
-- ----------------------------

-- ----------------------------
-- Table structure for sec_department
-- ----------------------------
DROP TABLE IF EXISTS `sec_department`;
CREATE TABLE `sec_department` (
  `DEPARTMENT_ID` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '组织ID',
  `DEPARTMENT_NAME` varchar(100) NOT NULL COMMENT '组织名称',
  `DEPARTMENT_DESC` varchar(100) DEFAULT NULL COMMENT '组织描述',
  `PARENT_ID` bigint(16) DEFAULT NULL COMMENT '父级组织',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '组织的邮件',
  `ADDRESS` varchar(200) DEFAULT NULL COMMENT '组织地址',
  `ADD_SUB` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否可以创建下级组织',
  `CREATE_USER` varchar(20) NOT NULL COMMENT '组织创建者',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '组织创建时间',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '组织最后修改时间',
  `DOMAIN` varchar(10) DEFAULT 'SYS_ADMIN' COMMENT '管理域：SP、SYS_ADMIN',
  PRIMARY KEY (`DEPARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织';

-- ----------------------------
-- Records of sec_department
-- ----------------------------
INSERT INTO `sec_department` VALUES ('-999', '根组织', '所有组织的根', null, 'xx@xx.com', 'xx', '0', 'system', '2015-08-13 11:31:26', '2015-08-13 11:31:26', '');
INSERT INTO `sec_department` VALUES ('-998', '一级目录', '一级目录', '-999', 'xx@xx.com', 'xx', '1', 'system', '2015-08-13 17:42:47', '2015-08-13 17:42:47', 'SYS_ADMIN');

-- ----------------------------
-- Table structure for sec_department_role
-- ----------------------------
DROP TABLE IF EXISTS `sec_department_role`;
CREATE TABLE `sec_department_role` (
  `DEPARTMENT_ID` bigint(16) NOT NULL COMMENT '组织ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`DEPARTMENT_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织角色关联表';

-- ----------------------------
-- Records of sec_department_role
-- ----------------------------

-- ----------------------------
-- Table structure for sec_login_history
-- ----------------------------
DROP TABLE IF EXISTS `sec_login_history`;
CREATE TABLE `sec_login_history` (
  `STAFF_ID` bigint(20) NOT NULL COMMENT '成员ID',
  `LOGIN_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `LOGIN_FLAG` varchar(10) NOT NULL COMMENT 'LOGOUT：注销；SUCCESS：登录成功；FAIL：登录失败；TIMEOUT：用户超时；UNLOCK：解锁；AUTOLOCK：密码尝试过多被锁',
  `DESCRIPTION` varchar(20) DEFAULT NULL COMMENT '备注，现在用来记录用户登录密码尝试过多被锁前的用户状态',
  PRIMARY KEY (`STAFF_ID`,`LOGIN_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员登录日志';

-- ----------------------------
-- Records of sec_login_history
-- ----------------------------

-- ----------------------------
-- Table structure for sec_metadata_log
-- ----------------------------
DROP TABLE IF EXISTS `sec_metadata_log`;
CREATE TABLE `sec_metadata_log` (
  `LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Logid',
  `HOST_NAME` varchar(250) DEFAULT NULL COMMENT '执行导入操作的主机名',
  `CLIENT_IP` varchar(32) DEFAULT NULL COMMENT '执行导入操作的主机IP',
  `FILE_NAME` varchar(500) DEFAULT NULL COMMENT '导入的文件名',
  `BACKUP_FILE_NAME` varchar(500) DEFAULT NULL COMMENT '导入的文件名备份的名字',
  `SUFFIX` varchar(20) DEFAULT NULL COMMENT '备份表的后缀',
  `OPERATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `OPERATOR` varchar(50) DEFAULT NULL COMMENT '操作人(操作系统的当前成员)',
  `RESULT` varchar(50) DEFAULT NULL COMMENT '导入结果',
  `OPERATION` varchar(50) DEFAULT NULL COMMENT '操作类型:delete| import',
  `METADATA_ID` varchar(500) DEFAULT NULL COMMENT '元数据ID',
  `SYSTEM_NAME` varchar(32) DEFAULT NULL COMMENT '系统名称',
  `PREFIX` varchar(5) DEFAULT NULL COMMENT '备份表的前缀',
  `domain` varchar(20) DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='元数据导入日志';

-- ----------------------------
-- Records of sec_metadata_log
-- ----------------------------
INSERT INTO `sec_metadata_log` VALUES ('3', 'DESKTOP-L1K1T2H', '192.168.0.216', '../auth/metadata_auth_common_admin_all.xml', 'C:\\wml\\workspace\\IDEA\\springboot-demo\\db\\metadata\\tools\\..\\auth\\metadata_auth_common_admin_all_180510152247.xml', '_180510152247', '2018-05-10 15:22:49', 'wangml', 'SUCCESS', 'import', 'auth, exclude_portal_admin, exclude_auth_admin', null, 'BAK_', 'admin');
INSERT INTO `sec_metadata_log` VALUES ('4', 'DESKTOP-L1K1T2H', '192.168.0.216', '../auth/metadata_auth_common_admin_all.xml', 'C:\\wml\\workspace\\IDEA\\springboot-demo\\db\\metadata\\tools\\..\\auth\\metadata_auth_common_admin_all_180510174322.xml', '_180510174322', '2018-05-10 17:43:24', 'wangml', 'SUCCESS', 'import', 'auth, exclude_portal_admin, exclude_auth_admin', null, 'BAK_', 'admin');

-- ----------------------------
-- Table structure for sec_operation
-- ----------------------------
DROP TABLE IF EXISTS `sec_operation`;
CREATE TABLE `sec_operation` (
  `OPERATION_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源操作主键',
  `RESOURCE_ID` bigint(20) NOT NULL COMMENT '资源主键',
  `OPERATION_KEY` varchar(32) NOT NULL COMMENT '操作关键字',
  `OPERATION_NAME` varchar(100) NOT NULL COMMENT '操作名称',
  `OPERATION_DESC` varchar(100) DEFAULT NULL COMMENT '操作描述',
  `DEPEND_KEY` varchar(32) DEFAULT NULL COMMENT '依赖操作KEY',
  `DEPEND_BY_KEY` varchar(500) DEFAULT NULL COMMENT '被依赖操作KEY',
  `METADATA_ID` varchar(32) DEFAULT NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(5) DEFAULT NULL COMMENT '操作的顺序',
  PRIMARY KEY (`OPERATION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='资源操作';

-- ----------------------------
-- Records of sec_operation
-- ----------------------------
INSERT INTO `sec_operation` VALUES ('49', '21', 'EXCLUDE', '例外', '例外', null, null, 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('50', '22', 'EXCLUDE', '前台鉴权例外', '登录后就可访问', null, null, 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('51', '23', 'EXCLUDE', '例外', '例外', null, null, 'exclude_auth_admin', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('52', '25', 'QUERY', '修改', '修改', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('53', '26', 'QUERY', '修改', '修改', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('54', '27', 'QUERY', '查询', '查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('55', '28', 'QUERY', '组织查询', '组织查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('56', '28', 'MODIFY', '组织修改', '组织修改', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('57', '28', 'DELETE', '组织删除', '组织删除', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('58', '28', 'ROLE2DEPT', '组织添加角色', '组织添加角色', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('59', '28', 'STAFF2DEPT', '组织添加用户', '组织添加用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('60', '28', 'AUTH2STAFF', '组织成员授权', '组织成员授权', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('61', '29', 'QUERY', '查询', '查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('62', '29', 'ADD', '创建', '创建用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('63', '29', 'UPDATE', '修改', '更新用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('64', '29', 'DELETE', '删除', '删除用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('65', '29', 'LOCKSTAFF', '锁定', '查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('66', '29', 'RESETPWD', '重置密码', '重置密码', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('67', '29', 'AUTHSTAFF', '授权', '用户授权', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('68', '30', 'QUERY', '查询', '查询', null, 'ADD,MODIFY,DELETE', 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('69', '30', 'ADD', '新增角色', '新增角色', 'QUERY', null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('70', '30', 'MODIFY', '修改角色', '修改角色', 'QUERY', null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('71', '30', 'DELETE', '删除角色', '删除角色', 'QUERY', null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('72', '30', 'AUTHROLE', '角色关联权限', '角色关联权限', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('73', '31', 'EXCLUDE', '例外', '例外', null, null, 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('74', '32', 'EXCLUDE', '前台鉴权例外', '登录后就可访问', null, null, 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('75', '33', 'EXCLUDE', '例外', '例外', null, null, 'exclude_auth_admin', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('76', '35', 'QUERY', '修改', '修改', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('77', '36', 'QUERY', '修改', '修改', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('78', '37', 'QUERY', '查询', '查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('79', '38', 'QUERY', '组织查询', '组织查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('80', '38', 'MODIFY', '组织修改', '组织修改', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('81', '38', 'DELETE', '组织删除', '组织删除', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('82', '38', 'ROLE2DEPT', '组织添加角色', '组织添加角色', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('83', '38', 'STAFF2DEPT', '组织添加用户', '组织添加用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('84', '38', 'AUTH2STAFF', '组织成员授权', '组织成员授权', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('85', '39', 'QUERY', '查询', '查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('86', '39', 'ADD', '创建', '创建用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('87', '39', 'UPDATE', '修改', '更新用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('88', '39', 'DELETE', '删除', '删除用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('89', '39', 'LOCKSTAFF', '锁定', '查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('90', '39', 'RESETPWD', '重置密码', '重置密码', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('91', '39', 'AUTHSTAFF', '授权', '用户授权', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('92', '40', 'QUERY', '查询', '查询', null, 'ADD,MODIFY,DELETE', 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('93', '40', 'ADD', '新增角色', '新增角色', 'QUERY', null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('94', '40', 'MODIFY', '修改角色', '修改角色', 'QUERY', null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('95', '40', 'DELETE', '删除角色', '删除角色', 'QUERY', null, 'auth', 'admin', '100');
INSERT INTO `sec_operation` VALUES ('96', '40', 'AUTHROLE', '角色关联权限', '角色关联权限', null, null, 'auth', 'admin', '100');

-- ----------------------------
-- Table structure for sec_operation_180510152247
-- ----------------------------
DROP TABLE IF EXISTS `sec_operation_180510152247`;
CREATE TABLE `sec_operation_180510152247` (
  `OPERATION_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源操作主键',
  `RESOURCE_ID` bigint(20) NOT NULL COMMENT '资源主键',
  `OPERATION_KEY` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '操作关键字',
  `OPERATION_NAME` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '操作名称',
  `OPERATION_DESC` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '操作描述',
  `DEPEND_KEY` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '依赖操作KEY',
  `DEPEND_BY_KEY` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '被依赖操作KEY',
  `METADATA_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(5) DEFAULT NULL COMMENT '操作的顺序'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_operation_180510152247
-- ----------------------------

-- ----------------------------
-- Table structure for sec_operation_180510174322
-- ----------------------------
DROP TABLE IF EXISTS `sec_operation_180510174322`;
CREATE TABLE `sec_operation_180510174322` (
  `OPERATION_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源操作主键',
  `RESOURCE_ID` bigint(20) NOT NULL COMMENT '资源主键',
  `OPERATION_KEY` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '操作关键字',
  `OPERATION_NAME` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '操作名称',
  `OPERATION_DESC` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '操作描述',
  `DEPEND_KEY` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '依赖操作KEY',
  `DEPEND_BY_KEY` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '被依赖操作KEY',
  `METADATA_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(5) DEFAULT NULL COMMENT '操作的顺序'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_operation_180510174322
-- ----------------------------
INSERT INTO `sec_operation_180510174322` VALUES ('49', '21', 'EXCLUDE', '例外', '例外', null, null, 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('50', '22', 'EXCLUDE', '前台鉴权例外', '登录后就可访问', null, null, 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('51', '23', 'EXCLUDE', '例外', '例外', null, null, 'exclude_auth_admin', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('52', '25', 'QUERY', '修改', '修改', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('53', '26', 'QUERY', '修改', '修改', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('54', '27', 'QUERY', '查询', '查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('55', '28', 'QUERY', '组织查询', '组织查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('56', '28', 'MODIFY', '组织修改', '组织修改', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('57', '28', 'DELETE', '组织删除', '组织删除', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('58', '28', 'ROLE2DEPT', '组织添加角色', '组织添加角色', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('59', '28', 'STAFF2DEPT', '组织添加用户', '组织添加用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('60', '28', 'AUTH2STAFF', '组织成员授权', '组织成员授权', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('61', '29', 'QUERY', '查询', '查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('62', '29', 'ADD', '创建', '创建用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('63', '29', 'UPDATE', '修改', '更新用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('64', '29', 'DELETE', '删除', '删除用户', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('65', '29', 'LOCKSTAFF', '锁定', '查询', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('66', '29', 'RESETPWD', '重置密码', '重置密码', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('67', '29', 'AUTHSTAFF', '授权', '用户授权', null, null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('68', '30', 'QUERY', '查询', '查询', null, 'ADD,MODIFY,DELETE', 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('69', '30', 'ADD', '新增角色', '新增角色', 'QUERY', null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('70', '30', 'MODIFY', '修改角色', '修改角色', 'QUERY', null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('71', '30', 'DELETE', '删除角色', '删除角色', 'QUERY', null, 'auth', 'admin', '100');
INSERT INTO `sec_operation_180510174322` VALUES ('72', '30', 'AUTHROLE', '角色关联权限', '角色关联权限', null, null, 'auth', 'admin', '100');

-- ----------------------------
-- Table structure for sec_operation_address
-- ----------------------------
DROP TABLE IF EXISTS `sec_operation_address`;
CREATE TABLE `sec_operation_address` (
  `ADDRESS_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问地址ID',
  `RESOURCE_ID` bigint(20) NOT NULL COMMENT '资源ID',
  `OPERATION_KEY` varchar(32) NOT NULL COMMENT '资源操作外码',
  `OPERATION_ADDRESS_NAME` varchar(100) DEFAULT NULL COMMENT '访问地址名称',
  `OPERATION_ADDRESS_URL` varchar(128) NOT NULL COMMENT '访问地址URL（不包含协议、IP、端口、contextpath）',
  `PARAMETER_NAME1` varchar(64) DEFAULT NULL COMMENT '参数名一',
  `PARAMETER_VALUE1` varchar(64) DEFAULT NULL COMMENT '参数值一',
  `PARAMETER_NAME2` varchar(64) DEFAULT NULL COMMENT '参数名二',
  `PARAMETER_VALUE2` varchar(64) DEFAULT NULL COMMENT '参数值二',
  `PARAMETER_NAME3` varchar(64) DEFAULT NULL COMMENT '参数名三',
  `PARAMETER_VALUE3` varchar(64) DEFAULT NULL COMMENT '参数值三',
  `METADATA_ID` varchar(32) DEFAULT NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=303 DEFAULT CHARSET=utf8 COMMENT='资源操作地址';

-- ----------------------------
-- Records of sec_operation_address
-- ----------------------------
INSERT INTO `sec_operation_address` VALUES ('153', '21', 'EXCLUDE', '登录action', '/login', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('154', '21', 'EXCLUDE', '退出登录', '/logout', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('155', '21', 'EXCLUDE', '404错误页面', '/404.html', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('156', '21', 'EXCLUDE', '500错误页面', '/pages/500.shtml', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('157', '21', 'EXCLUDE', '未授权提醒页面', '/403', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('158', '21', 'EXCLUDE', '页面签权url', '/auth/pageAuth', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('159', '22', 'EXCLUDE', '首页菜单请求', '/portal/menu.ajax', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('160', '22', 'EXCLUDE', '首页', '/index', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('161', '22', 'EXCLUDE', '取用户信息', '/auth/staff/findLoginStaff', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('162', '22', 'EXCLUDE', '退出登录', '/main.html', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('163', '22', 'EXCLUDE', '退出登录', '/logout', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('164', '22', 'EXCLUDE', '个人管理页面', '/auth/individual/modifyInfo', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('165', '22', 'EXCLUDE', '查询个人资料', '/auth/staff/findLoginStaff', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('166', '22', 'EXCLUDE', '修改个人资料', '/auth/staff/updateStaff', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('167', '22', 'EXCLUDE', '修改个人密码页面', '/auth/individual/modifyPwd', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('168', '22', 'EXCLUDE', '修改个人密码', '/auth/staff/changePwd', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('169', '23', 'EXCLUDE', '启动', '/root.jsp', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('170', '23', 'EXCLUDE', '上传组件添加action', '/attachment/add.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('171', '23', 'EXCLUDE', '上传组件添加action', '/attachment/addForMulti.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('172', '23', 'EXCLUDE', '上传组件下载action', '/attachment/download.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('173', '23', 'EXCLUDE', '上传组件打包下载action', '/attachment/downloadMulti.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('174', '23', 'EXCLUDE', '上传组件列表action', '/attachment/list.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('175', '23', 'EXCLUDE', '上传组件回退action', '/attachment/withdraw.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('176', '25', 'QUERY', '个人管理页面', '/auth/individual/modifyInfo', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('177', '25', 'QUERY', '查询个人资料', '/auth/staff/findLoginStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('178', '25', 'QUERY', '修改个人资料', '/auth/staff/updateStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('179', '25', 'QUERY', '查询个人扩展属性', '/auth/staff/findStaffExtendProperties', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('180', '26', 'QUERY', '修改个人密码页面', '/auth/individual/modifyPwd', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('181', '26', 'QUERY', '修改个人密码', '/auth/staff/changePwd', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('182', '27', 'QUERY', '个性化参数修改页面', '/auth/individual/selfConfigSetting', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('183', '27', 'QUERY', '个性化参数查询', '/auth/pendTaskSetting/get', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('184', '27', 'QUERY', '个性化参数设置', '/auth/pendTaskSetting/update', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('185', '28', 'QUERY', '组织管理页面', '/auth/dept', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('186', '28', 'QUERY', '组织树查询', '/auth/department/listDepartmentTree', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('187', '28', 'QUERY', '组织查询', '/auth/department/findDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('188', '28', 'QUERY', '组织详情查询', '/auth/department/findDepartmentInfo', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('189', '28', 'QUERY', '更新组织', '/auth/department/updateDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('190', '28', 'QUERY', '删除组织', '/auth/department/delDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('191', '28', 'MODIFY', '更新组织', '/auth/department/updateDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('192', '28', 'DELETE', '删除组织', '/auth/department/delDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('193', '28', 'ROLE2DEPT', '添加组织角色', '/auth/department/updateDepartmentRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('194', '28', 'ROLE2DEPT', '查询组织角色列表', '/auth/department/listDepartmentRoles', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('195', '28', 'STAFF2DEPT', '查询组织用户列表', '/auth/staff/listStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('196', '28', 'STAFF2DEPT', '添加组织用户', '/auth/staff/updateStaffDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('197', '28', 'AUTH2STAFF', '查询角色关联下用户列表', '/auth/staff/listRoleByStaffIds', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('198', '28', 'AUTH2STAFF', '组织里用户权限修改', '/auth/staff/updateStaffRolesDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('199', '29', 'QUERY', '成员管理页面', '/auth/staff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('200', '29', 'QUERY', '查询请求', '/auth/staff/listStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('201', '29', 'ADD', '查询用户是否存在', '/auth/staff/checkStaffLoginName', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('202', '29', 'ADD', '查询用户是否存在', '/auth/staff/checkStaffMobile', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('203', '29', 'ADD', '查询用户是否存在', '/auth/staff/checkStaffEmail', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('204', '29', 'ADD', '创建请求', '/auth/staff/createStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('205', '29', 'ADD', '查询个人扩展属性', '/auth/staff/findStaffExtendProperties', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('206', '29', 'UPDATE', '查询用户是否存在', '/auth/staff/checkStaffLoginName', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('207', '29', 'UPDATE', '获取用户详情', '/auth/staff/findStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('208', '29', 'UPDATE', '更新', '/auth/staff/updateStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('209', '29', 'UPDATE', '查询个人扩展属性', '/auth/staff/findStaffExtendProperties', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('210', '29', 'DELETE', '删除请求', '/auth/staff/deleteStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('211', '29', 'LOCKSTAFF', '锁定请求', '/auth/staff/lockStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('212', '29', 'RESETPWD', '重置密码请求', '/auth/staff/resetPwd', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('213', '29', 'AUTHSTAFF', '获取用户详情', '/auth/staff/findStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('214', '29', 'AUTHSTAFF', '查询用户角色列表', '/auth/staff/listStaffRoles', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('215', '29', 'AUTHSTAFF', '更新用户角色', '/auth/staff/updateStaffRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('216', '30', 'QUERY', '浏览角色页面', '/auth/role/page', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('217', '30', 'QUERY', '查看', '/auth/role/listRoles', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('218', '30', 'ADD', '查询角色助记码是否存在', '/auth/role/checkRoleKey', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('219', '30', 'ADD', '添加', '/auth/role/updateRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('220', '30', 'MODIFY', '查询角色助记码是否存在', '/auth/role/checkRoleKey', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('221', '30', 'MODIFY', '查询角色详情', '/auth/role/findRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('222', '30', 'MODIFY', '修改', '/auth/role/updateRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('223', '30', 'DELETE', '删除角色', '/auth/role/deleteRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('224', '30', 'AUTHROLE', '浏览角色页面', '/auth/roleSetting', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('225', '30', 'AUTHROLE', '权限列表', '/auth/role/listRoleResource', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('226', '30', 'AUTHROLE', '关联角色权限', '/auth/role/updateRoleResource', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('227', '31', 'EXCLUDE', '登录action', '/login', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('228', '31', 'EXCLUDE', '退出登录', '/logout', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('229', '31', 'EXCLUDE', '404错误页面', '/404.html', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('230', '31', 'EXCLUDE', '500错误页面', '/pages/500.shtml', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('231', '31', 'EXCLUDE', '未授权提醒页面', '/403', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('232', '31', 'EXCLUDE', '页面签权url', '/auth/pageAuth', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('233', '32', 'EXCLUDE', '首页菜单请求', '/portal/menu.ajax', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('234', '32', 'EXCLUDE', '首页', '/index', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('235', '32', 'EXCLUDE', '取用户信息', '/auth/staff/findLoginStaff', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('236', '32', 'EXCLUDE', '退出登录', '/main.html', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('237', '32', 'EXCLUDE', '退出登录', '/logout', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('238', '32', 'EXCLUDE', '个人管理页面', '/auth/individual/modifyInfo', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('239', '32', 'EXCLUDE', '查询个人资料', '/auth/staff/findLoginStaff', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('240', '32', 'EXCLUDE', '修改个人资料', '/auth/staff/updateStaff', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('241', '32', 'EXCLUDE', '修改个人密码页面', '/auth/individual/modifyPwd', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('242', '32', 'EXCLUDE', '修改个人密码', '/auth/staff/changePwd', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('243', '33', 'EXCLUDE', '启动', '/root.jsp', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('244', '33', 'EXCLUDE', '上传组件添加action', '/attachment/add.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('245', '33', 'EXCLUDE', '上传组件添加action', '/attachment/addForMulti.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('246', '33', 'EXCLUDE', '上传组件下载action', '/attachment/download.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('247', '33', 'EXCLUDE', '上传组件打包下载action', '/attachment/downloadMulti.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('248', '33', 'EXCLUDE', '上传组件列表action', '/attachment/list.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('249', '33', 'EXCLUDE', '上传组件回退action', '/attachment/withdraw.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_address` VALUES ('250', '35', 'QUERY', '个人管理页面', '/auth/individual/modifyInfo', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('251', '35', 'QUERY', '查询个人资料', '/auth/staff/findLoginStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('252', '35', 'QUERY', '修改个人资料', '/auth/staff/updateStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('253', '35', 'QUERY', '查询个人扩展属性', '/auth/staff/findStaffExtendProperties', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('254', '36', 'QUERY', '修改个人密码页面', '/auth/individual/modifyPwd', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('255', '36', 'QUERY', '修改个人密码', '/auth/staff/changePwd', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('256', '37', 'QUERY', '个性化参数修改页面', '/auth/individual/selfConfigSetting', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('257', '37', 'QUERY', '个性化参数查询', '/auth/pendTaskSetting/get', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('258', '37', 'QUERY', '个性化参数设置', '/auth/pendTaskSetting/update', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('259', '38', 'QUERY', '组织管理页面', '/auth/dept', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('260', '38', 'QUERY', '组织树查询', '/auth/department/listDepartmentTree', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('261', '38', 'QUERY', '组织查询', '/auth/department/findDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('262', '38', 'QUERY', '组织详情查询', '/auth/department/findDepartmentInfo', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('263', '38', 'QUERY', '更新组织', '/auth/department/updateDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('264', '38', 'QUERY', '删除组织', '/auth/department/delDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('265', '38', 'MODIFY', '更新组织', '/auth/department/updateDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('266', '38', 'DELETE', '删除组织', '/auth/department/delDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('267', '38', 'ROLE2DEPT', '添加组织角色', '/auth/department/updateDepartmentRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('268', '38', 'ROLE2DEPT', '查询组织角色列表', '/auth/department/listDepartmentRoles', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('269', '38', 'STAFF2DEPT', '查询组织用户列表', '/auth/staff/listStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('270', '38', 'STAFF2DEPT', '添加组织用户', '/auth/staff/updateStaffDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('271', '38', 'AUTH2STAFF', '查询角色关联下用户列表', '/auth/staff/listRoleByStaffIds', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('272', '38', 'AUTH2STAFF', '组织里用户权限修改', '/auth/staff/updateStaffRolesDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('273', '39', 'QUERY', '成员管理页面', '/auth/staff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('274', '39', 'QUERY', '查询请求', '/auth/staff/listStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('275', '39', 'ADD', '查询用户是否存在', '/auth/staff/checkStaffLoginName', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('276', '39', 'ADD', '查询用户是否存在', '/auth/staff/checkStaffMobile', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('277', '39', 'ADD', '查询用户是否存在', '/auth/staff/checkStaffEmail', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('278', '39', 'ADD', '创建请求', '/auth/staff/createStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('279', '39', 'ADD', '查询个人扩展属性', '/auth/staff/findStaffExtendProperties', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('280', '39', 'UPDATE', '查询用户是否存在', '/auth/staff/checkStaffLoginName', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('281', '39', 'UPDATE', '获取用户详情', '/auth/staff/findStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('282', '39', 'UPDATE', '更新', '/auth/staff/updateStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('283', '39', 'UPDATE', '查询个人扩展属性', '/auth/staff/findStaffExtendProperties', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('284', '39', 'DELETE', '删除请求', '/auth/staff/deleteStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('285', '39', 'LOCKSTAFF', '锁定请求', '/auth/staff/lockStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('286', '39', 'RESETPWD', '重置密码请求', '/auth/staff/resetPwd', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('287', '39', 'AUTHSTAFF', '获取用户详情', '/auth/staff/findStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('288', '39', 'AUTHSTAFF', '查询用户角色列表', '/auth/staff/listStaffRoles', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('289', '39', 'AUTHSTAFF', '更新用户角色', '/auth/staff/updateStaffRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('290', '40', 'QUERY', '浏览角色页面', '/auth/role/page', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('291', '40', 'QUERY', '查看', '/auth/role/listRoles', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('292', '40', 'ADD', '新增角色页面', '/auth/role/edit', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('293', '40', 'ADD', '查询角色助记码是否存在', '/auth/role/checkRoleKey', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('294', '40', 'ADD', '添加', '/auth/role/updateRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('295', '40', 'MODIFY', '编辑角色页面', '/auth/role/edit', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('296', '40', 'MODIFY', '查询角色助记码是否存在', '/auth/role/checkRoleKey', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('297', '40', 'MODIFY', '查询角色详情', '/auth/role/findRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('298', '40', 'MODIFY', '修改', '/auth/role/updateRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('299', '40', 'DELETE', '删除角色', '/auth/role/deleteRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('300', '40', 'AUTHROLE', '浏览角色页面', '/auth/roleSetting', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('301', '40', 'AUTHROLE', '权限列表', '/auth/role/listRoleResource', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_address` VALUES ('302', '40', 'AUTHROLE', '关联角色权限', '/auth/role/updateRoleResource', null, null, null, null, null, null, 'auth', 'admin');

-- ----------------------------
-- Table structure for sec_operation_url_180510152247
-- ----------------------------
DROP TABLE IF EXISTS `sec_operation_url_180510152247`;
CREATE TABLE `sec_operation_url_180510152247` (
  `ADDRESS_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '访问地址ID',
  `RESOURCE_ID` bigint(20) NOT NULL COMMENT '资源ID',
  `OPERATION_KEY` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '资源操作外码',
  `OPERATION_ADDRESS_NAME` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '访问地址名称',
  `OPERATION_ADDRESS_URL` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '访问地址URL（不包含协议、IP、端口、contextpath）',
  `PARAMETER_NAME1` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数名一',
  `PARAMETER_VALUE1` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数值一',
  `PARAMETER_NAME2` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数名二',
  `PARAMETER_VALUE2` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数值二',
  `PARAMETER_NAME3` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数名三',
  `PARAMETER_VALUE3` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数值三',
  `METADATA_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理域：SP、ADMIN'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_operation_url_180510152247
-- ----------------------------

-- ----------------------------
-- Table structure for sec_operation_url_180510174322
-- ----------------------------
DROP TABLE IF EXISTS `sec_operation_url_180510174322`;
CREATE TABLE `sec_operation_url_180510174322` (
  `ADDRESS_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '访问地址ID',
  `RESOURCE_ID` bigint(20) NOT NULL COMMENT '资源ID',
  `OPERATION_KEY` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '资源操作外码',
  `OPERATION_ADDRESS_NAME` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '访问地址名称',
  `OPERATION_ADDRESS_URL` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '访问地址URL（不包含协议、IP、端口、contextpath）',
  `PARAMETER_NAME1` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数名一',
  `PARAMETER_VALUE1` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数值一',
  `PARAMETER_NAME2` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数名二',
  `PARAMETER_VALUE2` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数值二',
  `PARAMETER_NAME3` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数名三',
  `PARAMETER_VALUE3` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数值三',
  `METADATA_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理域：SP、ADMIN'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_operation_url_180510174322
-- ----------------------------
INSERT INTO `sec_operation_url_180510174322` VALUES ('153', '21', 'EXCLUDE', '登录action', '/login', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('154', '21', 'EXCLUDE', '退出登录', '/logout', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('155', '21', 'EXCLUDE', '404错误页面', '/404.html', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('156', '21', 'EXCLUDE', '500错误页面', '/pages/500.shtml', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('157', '21', 'EXCLUDE', '未授权提醒页面', '/403', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('158', '21', 'EXCLUDE', '页面签权url', '/auth/pageAuth', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('159', '22', 'EXCLUDE', '首页菜单请求', '/portal/menu.ajax', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('160', '22', 'EXCLUDE', '首页', '/index', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('161', '22', 'EXCLUDE', '取用户信息', '/auth/staff/findLoginStaff', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('162', '22', 'EXCLUDE', '退出登录', '/main.html', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('163', '22', 'EXCLUDE', '退出登录', '/logout', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('164', '22', 'EXCLUDE', '个人管理页面', '/auth/individual/modifyInfo', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('165', '22', 'EXCLUDE', '查询个人资料', '/auth/staff/findLoginStaff', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('166', '22', 'EXCLUDE', '修改个人资料', '/auth/staff/updateStaff', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('167', '22', 'EXCLUDE', '修改个人密码页面', '/auth/individual/modifyPwd', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('168', '22', 'EXCLUDE', '修改个人密码', '/auth/staff/changePwd', null, null, null, null, null, null, 'exclude_portal_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('169', '23', 'EXCLUDE', '启动', '/root.jsp', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('170', '23', 'EXCLUDE', '上传组件添加action', '/attachment/add.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('171', '23', 'EXCLUDE', '上传组件添加action', '/attachment/addForMulti.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('172', '23', 'EXCLUDE', '上传组件下载action', '/attachment/download.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('173', '23', 'EXCLUDE', '上传组件打包下载action', '/attachment/downloadMulti.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('174', '23', 'EXCLUDE', '上传组件列表action', '/attachment/list.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('175', '23', 'EXCLUDE', '上传组件回退action', '/attachment/withdraw.ajax', null, null, null, null, null, null, 'exclude_auth_admin', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('176', '25', 'QUERY', '个人管理页面', '/auth/individual/modifyInfo', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('177', '25', 'QUERY', '查询个人资料', '/auth/staff/findLoginStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('178', '25', 'QUERY', '修改个人资料', '/auth/staff/updateStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('179', '25', 'QUERY', '查询个人扩展属性', '/auth/staff/findStaffExtendProperties', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('180', '26', 'QUERY', '修改个人密码页面', '/auth/individual/modifyPwd', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('181', '26', 'QUERY', '修改个人密码', '/auth/staff/changePwd', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('182', '27', 'QUERY', '个性化参数修改页面', '/auth/individual/selfConfigSetting', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('183', '27', 'QUERY', '个性化参数查询', '/auth/pendTaskSetting/get', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('184', '27', 'QUERY', '个性化参数设置', '/auth/pendTaskSetting/update', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('185', '28', 'QUERY', '组织管理页面', '/auth/dept', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('186', '28', 'QUERY', '组织树查询', '/auth/department/listDepartmentTree', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('187', '28', 'QUERY', '组织查询', '/auth/department/findDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('188', '28', 'QUERY', '组织详情查询', '/auth/department/findDepartmentInfo', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('189', '28', 'QUERY', '更新组织', '/auth/department/updateDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('190', '28', 'QUERY', '删除组织', '/auth/department/delDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('191', '28', 'MODIFY', '更新组织', '/auth/department/updateDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('192', '28', 'DELETE', '删除组织', '/auth/department/delDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('193', '28', 'ROLE2DEPT', '添加组织角色', '/auth/department/updateDepartmentRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('194', '28', 'ROLE2DEPT', '查询组织角色列表', '/auth/department/listDepartmentRoles', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('195', '28', 'STAFF2DEPT', '查询组织用户列表', '/auth/staff/listStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('196', '28', 'STAFF2DEPT', '添加组织用户', '/auth/staff/updateStaffDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('197', '28', 'AUTH2STAFF', '查询角色关联下用户列表', '/auth/staff/listRoleByStaffIds', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('198', '28', 'AUTH2STAFF', '组织里用户权限修改', '/auth/staff/updateStaffRolesDepartment', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('199', '29', 'QUERY', '成员管理页面', '/auth/staff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('200', '29', 'QUERY', '查询请求', '/auth/staff/listStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('201', '29', 'ADD', '查询用户是否存在', '/auth/staff/checkStaffLoginName', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('202', '29', 'ADD', '查询用户是否存在', '/auth/staff/checkStaffMobile', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('203', '29', 'ADD', '查询用户是否存在', '/auth/staff/checkStaffEmail', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('204', '29', 'ADD', '创建请求', '/auth/staff/createStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('205', '29', 'ADD', '查询个人扩展属性', '/auth/staff/findStaffExtendProperties', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('206', '29', 'UPDATE', '查询用户是否存在', '/auth/staff/checkStaffLoginName', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('207', '29', 'UPDATE', '获取用户详情', '/auth/staff/findStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('208', '29', 'UPDATE', '更新', '/auth/staff/updateStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('209', '29', 'UPDATE', '查询个人扩展属性', '/auth/staff/findStaffExtendProperties', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('210', '29', 'DELETE', '删除请求', '/auth/staff/deleteStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('211', '29', 'LOCKSTAFF', '锁定请求', '/auth/staff/lockStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('212', '29', 'RESETPWD', '重置密码请求', '/auth/staff/resetPwd', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('213', '29', 'AUTHSTAFF', '获取用户详情', '/auth/staff/findStaff', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('214', '29', 'AUTHSTAFF', '查询用户角色列表', '/auth/staff/listStaffRoles', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('215', '29', 'AUTHSTAFF', '更新用户角色', '/auth/staff/updateStaffRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('216', '30', 'QUERY', '浏览角色页面', '/auth/role/page', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('217', '30', 'QUERY', '查看', '/auth/role/listRoles', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('218', '30', 'ADD', '查询角色助记码是否存在', '/auth/role/checkRoleKey', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('219', '30', 'ADD', '添加', '/auth/role/updateRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('220', '30', 'MODIFY', '查询角色助记码是否存在', '/auth/role/checkRoleKey', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('221', '30', 'MODIFY', '查询角色详情', '/auth/role/findRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('222', '30', 'MODIFY', '修改', '/auth/role/updateRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('223', '30', 'DELETE', '删除角色', '/auth/role/deleteRole', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('224', '30', 'AUTHROLE', '浏览角色页面', '/auth/roleSetting', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('225', '30', 'AUTHROLE', '权限列表', '/auth/role/listRoleResource', null, null, null, null, null, null, 'auth', 'admin');
INSERT INTO `sec_operation_url_180510174322` VALUES ('226', '30', 'AUTHROLE', '关联角色权限', '/auth/role/updateRoleResource', null, null, null, null, null, null, 'auth', 'admin');

-- ----------------------------
-- Table structure for sec_resources
-- ----------------------------
DROP TABLE IF EXISTS `sec_resources`;
CREATE TABLE `sec_resources` (
  `RESOURCE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `RESOURCE_KEY` varchar(100) NOT NULL COMMENT '资源外码',
  `RESOURCE_NAME` varchar(100) NOT NULL COMMENT '资源名称',
  `RESOURCE_DESC` varchar(100) DEFAULT NULL COMMENT '资源描述',
  `CATEGORY_ID` bigint(20) NOT NULL COMMENT '资源分类ID',
  `AUTH_TYPE` varchar(10) NOT NULL COMMENT '鉴权类型(AUTH：鉴权，UNAUTH：不鉴权，LOGIN_AUTH：登录鉴权)',
  `METADATA_ID` varchar(32) DEFAULT NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(11) DEFAULT NULL COMMENT '资源的顺序',
  PRIMARY KEY (`RESOURCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='资源';

-- ----------------------------
-- Records of sec_resources
-- ----------------------------
INSERT INTO `sec_resources` VALUES ('31', 'exclude_portal_admin_session', 'session例外资源', 'session例外资源', '22', 'UNAUTH', 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_resources` VALUES ('32', 'exclude_portal_admin_perm', '鉴权例外资源', '鉴权例外资源', '22', 'LOGIN_AUTH', 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_resources` VALUES ('33', 'exclude_auth_admin_session', 'session例外资源', 'session例外资源', '23', 'UNAUTH', 'exclude_auth_admin', 'admin', '100');
INSERT INTO `sec_resources` VALUES ('34', 'exclude_auth_admin_perm', '鉴权例外资源', '鉴权例外资源', '23', 'LOGIN_AUTH', 'exclude_auth_admin', 'admin', '100');
INSERT INTO `sec_resources` VALUES ('35', 'auth_admin_sys_individual_modifyInfo', '修改帐号信息', '修改帐号信息', '25', 'AUTH', 'auth', 'admin', '100');
INSERT INTO `sec_resources` VALUES ('36', 'auth_admin_sys_individual_modifyPwd', '修改个人密码', '修改个人密码', '25', 'AUTH', 'auth', 'admin', '100');
INSERT INTO `sec_resources` VALUES ('37', 'auth_admin_sys_individual_selfconfig', '个性化参数设置', '个性化参数设置', '25', 'AUTH', 'auth', 'admin', '100');
INSERT INTO `sec_resources` VALUES ('38', 'auth_admin_sys_dept_deptManage', '组织管理', '组织管理', '26', 'AUTH', 'auth', 'admin', '100');
INSERT INTO `sec_resources` VALUES ('39', 'auth_admin_sys_staff_staffManage', '成员管理', '成员管理', '27', 'AUTH', 'auth', 'admin', '100');
INSERT INTO `sec_resources` VALUES ('40', 'auth_admin_sys_role_roleManage', '角色管理', '角色管理', '28', 'AUTH', 'auth', 'admin', '100');

-- ----------------------------
-- Table structure for sec_resources_180510152247
-- ----------------------------
DROP TABLE IF EXISTS `sec_resources_180510152247`;
CREATE TABLE `sec_resources_180510152247` (
  `RESOURCE_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源ID',
  `RESOURCE_KEY` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '资源外码',
  `RESOURCE_NAME` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '资源名称',
  `RESOURCE_DESC` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源描述',
  `CATEGORY_ID` bigint(20) NOT NULL COMMENT '资源分类ID',
  `AUTH_TYPE` varchar(10) CHARACTER SET utf8 NOT NULL COMMENT '鉴权类型(AUTH：鉴权，UNAUTH：不鉴权，LOGIN_AUTH：登录鉴权)',
  `METADATA_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(11) DEFAULT NULL COMMENT '资源的顺序'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_resources_180510152247
-- ----------------------------

-- ----------------------------
-- Table structure for sec_resources_180510174322
-- ----------------------------
DROP TABLE IF EXISTS `sec_resources_180510174322`;
CREATE TABLE `sec_resources_180510174322` (
  `RESOURCE_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源ID',
  `RESOURCE_KEY` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '资源外码',
  `RESOURCE_NAME` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '资源名称',
  `RESOURCE_DESC` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源描述',
  `CATEGORY_ID` bigint(20) NOT NULL COMMENT '资源分类ID',
  `AUTH_TYPE` varchar(10) CHARACTER SET utf8 NOT NULL COMMENT '鉴权类型(AUTH：鉴权，UNAUTH：不鉴权，LOGIN_AUTH：登录鉴权)',
  `METADATA_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(11) DEFAULT NULL COMMENT '资源的顺序'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_resources_180510174322
-- ----------------------------
INSERT INTO `sec_resources_180510174322` VALUES ('21', 'exclude_portal_admin_session', 'session例外资源', 'session例外资源', '15', 'UNAUTH', 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_resources_180510174322` VALUES ('22', 'exclude_portal_admin_perm', '鉴权例外资源', '鉴权例外资源', '15', 'LOGIN_AUTH', 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_resources_180510174322` VALUES ('23', 'exclude_auth_admin_session', 'session例外资源', 'session例外资源', '16', 'UNAUTH', 'exclude_auth_admin', 'admin', '100');
INSERT INTO `sec_resources_180510174322` VALUES ('24', 'exclude_auth_admin_perm', '鉴权例外资源', '鉴权例外资源', '16', 'LOGIN_AUTH', 'exclude_auth_admin', 'admin', '100');
INSERT INTO `sec_resources_180510174322` VALUES ('25', 'auth_admin_sys_individual_modifyInfo', '修改帐号信息', '修改帐号信息', '18', 'AUTH', 'auth', 'admin', '100');
INSERT INTO `sec_resources_180510174322` VALUES ('26', 'auth_admin_sys_individual_modifyPwd', '修改个人密码', '修改个人密码', '18', 'AUTH', 'auth', 'admin', '100');
INSERT INTO `sec_resources_180510174322` VALUES ('27', 'auth_admin_sys_individual_selfconfig', '个性化参数设置', '个性化参数设置', '18', 'AUTH', 'auth', 'admin', '100');
INSERT INTO `sec_resources_180510174322` VALUES ('28', 'auth_admin_sys_dept_deptManage', '组织管理', '组织管理', '19', 'AUTH', 'auth', 'admin', '100');
INSERT INTO `sec_resources_180510174322` VALUES ('29', 'auth_admin_sys_staff_staffManage', '成员管理', '成员管理', '20', 'AUTH', 'auth', 'admin', '100');
INSERT INTO `sec_resources_180510174322` VALUES ('30', 'auth_admin_sys_role_roleManage', '角色管理', '角色管理', '21', 'AUTH', 'auth', 'admin', '100');

-- ----------------------------
-- Table structure for sec_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `sec_resource_category`;
CREATE TABLE `sec_resource_category` (
  `CATEGORY_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源分类ID',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '上级资源分类ID',
  `CATEGORY_NAME` varchar(100) DEFAULT NULL COMMENT '资源分类名称',
  `CATEGORY_DESC` varchar(100) DEFAULT NULL COMMENT '资源分类描述',
  `METADATA_ID` varchar(32) DEFAULT NULL COMMENT '元数据ID',
  `CATEGORY_KEY` varchar(100) DEFAULT NULL COMMENT '资源分类外码',
  `DOMAIN` varchar(20) DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(11) DEFAULT NULL COMMENT '资源分类的顺序',
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='资源分类';

-- ----------------------------
-- Records of sec_resource_category
-- ----------------------------
INSERT INTO `sec_resource_category` VALUES ('22', null, 'portal例外资源', 'portal例外资源', 'exclude_portal_admin', 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_resource_category` VALUES ('23', null, 'admin端例外资源', 'admin端例外资源', 'exclude_auth_admin', 'exclude_auth_admin', 'admin', '100');
INSERT INTO `sec_resource_category` VALUES ('24', null, '系统管理', '系统管理', 'auth', 'auth_admin', 'admin', '1000');
INSERT INTO `sec_resource_category` VALUES ('25', '24', '个人管理', '个人管理', 'auth', 'auth_admin_sys_individual', 'admin', '100');
INSERT INTO `sec_resource_category` VALUES ('26', '24', '组织管理', '组织管理', 'auth', 'auth_admin_sys_dept', 'admin', '100');
INSERT INTO `sec_resource_category` VALUES ('27', '24', '成员管理', '成员管理', 'auth', 'auth_admin_sys_staff', 'admin', '100');
INSERT INTO `sec_resource_category` VALUES ('28', '24', '角色管理', '角色管理', 'auth', 'auth_admin_sys_role', 'admin', '100');

-- ----------------------------
-- Table structure for sec_resource_cat_180510152247
-- ----------------------------
DROP TABLE IF EXISTS `sec_resource_cat_180510152247`;
CREATE TABLE `sec_resource_cat_180510152247` (
  `CATEGORY_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源分类ID',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '上级资源分类ID',
  `CATEGORY_NAME` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源分类名称',
  `CATEGORY_DESC` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源分类描述',
  `METADATA_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '元数据ID',
  `CATEGORY_KEY` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源分类外码',
  `DOMAIN` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(11) DEFAULT NULL COMMENT '资源分类的顺序'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_resource_cat_180510152247
-- ----------------------------

-- ----------------------------
-- Table structure for sec_resource_cat_180510174322
-- ----------------------------
DROP TABLE IF EXISTS `sec_resource_cat_180510174322`;
CREATE TABLE `sec_resource_cat_180510174322` (
  `CATEGORY_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源分类ID',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '上级资源分类ID',
  `CATEGORY_NAME` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源分类名称',
  `CATEGORY_DESC` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源分类描述',
  `METADATA_ID` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '元数据ID',
  `CATEGORY_KEY` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '资源分类外码',
  `DOMAIN` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(11) DEFAULT NULL COMMENT '资源分类的顺序'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_resource_cat_180510174322
-- ----------------------------
INSERT INTO `sec_resource_cat_180510174322` VALUES ('15', null, 'portal例外资源', 'portal例外资源', 'exclude_portal_admin', 'exclude_portal_admin', 'admin', '100');
INSERT INTO `sec_resource_cat_180510174322` VALUES ('16', null, 'admin端例外资源', 'admin端例外资源', 'exclude_auth_admin', 'exclude_auth_admin', 'admin', '100');
INSERT INTO `sec_resource_cat_180510174322` VALUES ('17', null, '系统管理', '系统管理', 'auth', 'auth_admin', 'admin', '1000');
INSERT INTO `sec_resource_cat_180510174322` VALUES ('18', '17', '个人管理', '个人管理', 'auth', 'auth_admin_sys_individual', 'admin', '100');
INSERT INTO `sec_resource_cat_180510174322` VALUES ('19', '17', '组织管理', '组织管理', 'auth', 'auth_admin_sys_dept', 'admin', '100');
INSERT INTO `sec_resource_cat_180510174322` VALUES ('20', '17', '成员管理', '成员管理', 'auth', 'auth_admin_sys_staff', 'admin', '100');
INSERT INTO `sec_resource_cat_180510174322` VALUES ('21', '17', '角色管理', '角色管理', 'auth', 'auth_admin_sys_role', 'admin', '100');

-- ----------------------------
-- Table structure for sec_role
-- ----------------------------
DROP TABLE IF EXISTS `sec_role`;
CREATE TABLE `sec_role` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLE_NAME` varchar(100) NOT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(400) DEFAULT NULL COMMENT '角色描述',
  `CREATE_USER` varchar(20) NOT NULL COMMENT '角色创建者',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '角色创建时间',
  `CAN_MODIFY` int(11) NOT NULL DEFAULT '1' COMMENT '是否允许修改 1：允许 0: 不充许 缺省=1',
  `LAST_UPDATE_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '角色最后修改时间',
  `ROLE_KEY` varchar(64) DEFAULT NULL COMMENT '角色外码',
  `AUTO_ASSIGN` int(1) NOT NULL DEFAULT '0' COMMENT '自动分配(0:不自动分配；1：自动分配给所有注册成员)',
  `visible` int(1) NOT NULL DEFAULT '1' COMMENT '是否在界面上可见(0：不可见；1：可见)',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sec_role
-- ----------------------------
INSERT INTO `sec_role` VALUES ('5', '已注册成员拥有的角色', '所有已注册成员都属于该角色', 'roleImporter', '2018-05-10 15:22:51', '0', '2018-05-10 00:00:00', '101', '1', '0');
INSERT INTO `sec_role` VALUES ('6', '系统管理角色', '能够维护成员和组织信息、分配角色', 'roleImporter', '2018-05-10 15:22:51', '1', '2018-05-10 00:00:00', '1001', '0', '1');
INSERT INTO `sec_role` VALUES ('7', '组织管理角色', '组织成员拥有该角色后，自动成为组织管理员，能够维护组织成员和子组织', 'roleImporter', '2018-05-10 15:22:51', '1', '2018-05-10 00:00:00', '1002', '0', '1');
INSERT INTO `sec_role` VALUES ('8', '系统配置角色', '能够进行角色管理', 'roleImporter', '2018-05-10 15:22:51', '1', '2018-05-10 00:00:00', '1003', '0', '1');
INSERT INTO `sec_role` VALUES ('13', '23', '3', 'admin', '2018-05-10 18:56:25', '1', '2018-05-10 18:56:25', '23', '0', '1');
INSERT INTO `sec_role` VALUES ('14', '434', '343', 'admin', '2018-05-10 18:56:30', '1', '2018-05-10 18:56:30', '43', '0', '1');

-- ----------------------------
-- Table structure for sec_role_resource_180510152247
-- ----------------------------
DROP TABLE IF EXISTS `sec_role_resource_180510152247`;
CREATE TABLE `sec_role_resource_180510152247` (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `RESOURCE_ID` bigint(32) NOT NULL COMMENT '资源ID',
  `OPERATION_KEY` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '资源操作关键字'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_role_resource_180510152247
-- ----------------------------

-- ----------------------------
-- Table structure for sec_role_resource_180510174322
-- ----------------------------
DROP TABLE IF EXISTS `sec_role_resource_180510174322`;
CREATE TABLE `sec_role_resource_180510174322` (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `RESOURCE_ID` bigint(32) NOT NULL COMMENT '资源ID',
  `OPERATION_KEY` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '资源操作关键字'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sec_role_resource_180510174322
-- ----------------------------
INSERT INTO `sec_role_resource_180510174322` VALUES ('5', '26', 'QUERY');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '28', 'AUTH2STAFF');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '28', 'DELETE');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '28', 'MODIFY');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '28', 'QUERY');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '28', 'ROLE2DEPT');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '28', 'STAFF2DEPT');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '29', 'ADD');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '29', 'AUTHSTAFF');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '29', 'DELETE');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '29', 'LOCKSTAFF');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '29', 'QUERY');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '29', 'RESETPWD');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '29', 'UPDATE');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '30', 'ADD');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '30', 'AUTHROLE');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '30', 'DELETE');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '30', 'MODIFY');
INSERT INTO `sec_role_resource_180510174322` VALUES ('6', '30', 'QUERY');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '28', 'AUTH2STAFF');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '28', 'DELETE');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '28', 'MODIFY');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '28', 'QUERY');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '28', 'ROLE2DEPT');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '28', 'STAFF2DEPT');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '29', 'ADD');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '29', 'AUTHSTAFF');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '29', 'DELETE');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '29', 'LOCKSTAFF');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '29', 'QUERY');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '29', 'RESETPWD');
INSERT INTO `sec_role_resource_180510174322` VALUES ('7', '29', 'UPDATE');
INSERT INTO `sec_role_resource_180510174322` VALUES ('8', '30', 'ADD');
INSERT INTO `sec_role_resource_180510174322` VALUES ('8', '30', 'AUTHROLE');
INSERT INTO `sec_role_resource_180510174322` VALUES ('8', '30', 'DELETE');
INSERT INTO `sec_role_resource_180510174322` VALUES ('8', '30', 'MODIFY');
INSERT INTO `sec_role_resource_180510174322` VALUES ('8', '30', 'QUERY');

-- ----------------------------
-- Table structure for sec_role_resource_operation
-- ----------------------------
DROP TABLE IF EXISTS `sec_role_resource_operation`;
CREATE TABLE `sec_role_resource_operation` (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `RESOURCE_ID` bigint(32) NOT NULL COMMENT '资源ID',
  `OPERATION_KEY` varchar(32) NOT NULL COMMENT '资源操作关键字',
  PRIMARY KEY (`ROLE_ID`,`RESOURCE_ID`,`OPERATION_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与资源操作';

-- ----------------------------
-- Records of sec_role_resource_operation
-- ----------------------------
INSERT INTO `sec_role_resource_operation` VALUES ('5', '36', 'QUERY');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '38', 'AUTH2STAFF');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '38', 'DELETE');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '38', 'MODIFY');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '38', 'QUERY');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '38', 'ROLE2DEPT');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '38', 'STAFF2DEPT');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '39', 'ADD');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '39', 'AUTHSTAFF');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '39', 'DELETE');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '39', 'LOCKSTAFF');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '39', 'QUERY');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '39', 'RESETPWD');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '39', 'UPDATE');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '40', 'ADD');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '40', 'AUTHROLE');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '40', 'DELETE');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '40', 'MODIFY');
INSERT INTO `sec_role_resource_operation` VALUES ('6', '40', 'QUERY');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '38', 'AUTH2STAFF');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '38', 'DELETE');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '38', 'MODIFY');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '38', 'QUERY');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '38', 'ROLE2DEPT');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '38', 'STAFF2DEPT');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '39', 'ADD');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '39', 'AUTHSTAFF');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '39', 'DELETE');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '39', 'LOCKSTAFF');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '39', 'QUERY');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '39', 'RESETPWD');
INSERT INTO `sec_role_resource_operation` VALUES ('7', '39', 'UPDATE');
INSERT INTO `sec_role_resource_operation` VALUES ('8', '40', 'ADD');
INSERT INTO `sec_role_resource_operation` VALUES ('8', '40', 'AUTHROLE');
INSERT INTO `sec_role_resource_operation` VALUES ('8', '40', 'DELETE');
INSERT INTO `sec_role_resource_operation` VALUES ('8', '40', 'MODIFY');
INSERT INTO `sec_role_resource_operation` VALUES ('8', '40', 'QUERY');

-- ----------------------------
-- Table structure for sec_staff
-- ----------------------------
DROP TABLE IF EXISTS `sec_staff`;
CREATE TABLE `sec_staff` (
  `STAFF_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '成员ID',
  `LOGIN_NAME` varchar(100) NOT NULL COMMENT '登录名',
  `DEPARTMENT_ID` bigint(16) DEFAULT NULL COMMENT '组织ID',
  `REAL_NAME` varchar(100) NOT NULL COMMENT '成员姓名',
  `PASSWORD` varchar(128) NOT NULL COMMENT '密码（经过加密）',
  `STATUS` varchar(20) NOT NULL DEFAULT 'INITIAL' COMMENT '成员状态',
  `SEX` varchar(10) DEFAULT NULL COMMENT '性别：MALE-男性；FEMALE-女性；',
  `TELEPHONE` varchar(30) DEFAULT NULL COMMENT '电话',
  `MOBILE` varchar(16) NOT NULL COMMENT '手机号码',
  `EMAIL` varchar(64) DEFAULT NULL COMMENT '邮件地址',
  `CREATE_USER` varchar(16) NOT NULL COMMENT '成员创建者',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '成员创建时间',
  `EXPIRE_DATE` timestamp NULL DEFAULT NULL COMMENT '成员帐号过期时间',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '成员最后修改时间',
  `PASSWORD_EXPIRE_DATE` timestamp NULL DEFAULT NULL COMMENT '密码失效时间',
  `LOCK_DATE` timestamp NULL DEFAULT NULL COMMENT '用户锁定时间',
  `CITY_ID` int(11) DEFAULT NULL COMMENT '成员所在城市（参见CITY表）',
  `SALT` varchar(64) NOT NULL COMMENT '加密码',
  PRIMARY KEY (`STAFF_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='成员';

-- ----------------------------
-- Records of sec_staff
-- ----------------------------
INSERT INTO `sec_staff` VALUES ('1', 'admin', null, 'admin', '509ed3482038db08cee1d82e344933103882471b', 'NORMAL', null, null, '', null, '', '2018-05-10 15:54:04', null, null, null, null, null, '0302bc07536bd185');

-- ----------------------------
-- Table structure for sec_staff_department_role
-- ----------------------------
DROP TABLE IF EXISTS `sec_staff_department_role`;
CREATE TABLE `sec_staff_department_role` (
  `STAFF_ID` bigint(20) NOT NULL COMMENT '成员ID',
  `DEPARTMENT_ID` bigint(16) NOT NULL COMMENT '组织ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员组织角色关联表';

-- ----------------------------
-- Records of sec_staff_department_role
-- ----------------------------
INSERT INTO `sec_staff_department_role` VALUES ('1', '-998', '5');
INSERT INTO `sec_staff_department_role` VALUES ('1', '-998', '6');
INSERT INTO `sec_staff_department_role` VALUES ('1', '-998', '7');
INSERT INTO `sec_staff_department_role` VALUES ('1', '-998', '8');

-- ----------------------------
-- Table structure for sec_staff_role
-- ----------------------------
DROP TABLE IF EXISTS `sec_staff_role`;
CREATE TABLE `sec_staff_role` (
  `STAFF_ID` bigint(20) NOT NULL COMMENT '成员ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`STAFF_ID`,`ROLE_ID`),
  KEY `FK_sec_staff_role2` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员角色关系表';

-- ----------------------------
-- Records of sec_staff_role
-- ----------------------------
INSERT INTO `sec_staff_role` VALUES ('1', '2');
INSERT INTO `sec_staff_role` VALUES ('1', '3');
INSERT INTO `sec_staff_role` VALUES ('1', '4');

-- ----------------------------
-- Table structure for seq_sec_metadata_log_id
-- ----------------------------
DROP TABLE IF EXISTS `seq_sec_metadata_log_id`;
CREATE TABLE `seq_sec_metadata_log_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seq_sec_metadata_log_id
-- ----------------------------
INSERT INTO `seq_sec_metadata_log_id` VALUES ('4', 'SEQ_SEC_METADATA_LOG_ID');

-- ----------------------------
-- Table structure for seq_sec_operation_id
-- ----------------------------
DROP TABLE IF EXISTS `seq_sec_operation_id`;
CREATE TABLE `seq_sec_operation_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seq_sec_operation_id
-- ----------------------------
INSERT INTO `seq_sec_operation_id` VALUES ('96', 'SEQ_SEC_OPERATION_ID');

-- ----------------------------
-- Table structure for seq_sec_resources_id
-- ----------------------------
DROP TABLE IF EXISTS `seq_sec_resources_id`;
CREATE TABLE `seq_sec_resources_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seq_sec_resources_id
-- ----------------------------
INSERT INTO `seq_sec_resources_id` VALUES ('40', 'SEQ_SEC_RESOURCES_ID');

-- ----------------------------
-- Table structure for seq_sec_resource_category_id
-- ----------------------------
DROP TABLE IF EXISTS `seq_sec_resource_category_id`;
CREATE TABLE `seq_sec_resource_category_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seq_sec_resource_category_id
-- ----------------------------
INSERT INTO `seq_sec_resource_category_id` VALUES ('28', 'SEQ_SEC_RESOURCE_CATEGORY_ID');

-- ----------------------------
-- Table structure for seq_sec_role_id
-- ----------------------------
DROP TABLE IF EXISTS `seq_sec_role_id`;
CREATE TABLE `seq_sec_role_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seq_sec_role_id
-- ----------------------------
INSERT INTO `seq_sec_role_id` VALUES ('8', 'SEQ_SEC_ROLE_ID');

-- ----------------------------
-- Table structure for seq_sec_staff_id
-- ----------------------------
DROP TABLE IF EXISTS `seq_sec_staff_id`;
CREATE TABLE `seq_sec_staff_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seq_sec_staff_id
-- ----------------------------

-- ----------------------------
-- Table structure for sub_system
-- ----------------------------
DROP TABLE IF EXISTS `sub_system`;
CREATE TABLE `sub_system` (
  `SUB_SYSTEM_ID` varchar(20) NOT NULL COMMENT '子系统ID',
  `SUB_SYSTEM_NAME` varchar(50) NOT NULL COMMENT '子系统名称',
  `SUB_SYSTEM_DESC` varchar(200) DEFAULT NULL COMMENT '子系统描述',
  `HOP_DOMAIN` varchar(200) DEFAULT NULL COMMENT 'PORTAL跳转业务系统使用的域名',
  `INTERFACE_DOMAIN` varchar(200) DEFAULT NULL,
  `DEPLOY_MODE` varchar(20) NOT NULL DEFAULT 'Remote',
  `DOMAIN` varchar(20) NOT NULL COMMENT '子系统所属的域',
  PRIMARY KEY (`SUB_SYSTEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='子系统表';

-- ----------------------------
-- Records of sub_system
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `available` int(11) NOT NULL COMMENT '标识是否可用',
  `name` varchar(256) NOT NULL COMMENT '名称',
  `parent_id` int(11) NOT NULL COMMENT '父编号',
  `parent_ids` varchar(256) NOT NULL COMMENT '父编号列表',
  `permission` varchar(256) NOT NULL COMMENT '权限字符串',
  `resource_type` varchar(256) NOT NULL COMMENT '资源类型，[menu|button]',
  `url` varchar(256) NOT NULL COMMENT '资源路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `available` int(11) NOT NULL COMMENT '标识是否可用',
  `description` varchar(256) NOT NULL COMMENT '描述',
  `role` varchar(64) NOT NULL COMMENT '角色标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `salt` varchar(64) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for user_jpa
-- ----------------------------
DROP TABLE IF EXISTS `user_jpa`;
CREATE TABLE `user_jpa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_jpa
-- ----------------------------

-- ----------------------------
-- Function structure for SEQ_ATTACH_FILE_ID.Nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `SEQ_ATTACH_FILE_ID.Nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_ATTACH_FILE_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO `SEQ_ATTACH_FILE_ID` (stub) VALUES ('SEQ_ATTACH_FILE_ID');
	return LAST_INSERT_ID();
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SEQ_ATTACH_TYPE_ID.Nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `SEQ_ATTACH_TYPE_ID.Nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_ATTACH_TYPE_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_ATTACH_TYPE_ID (stub) VALUES ('SEQ_ATTACH_TYPE_ID');
	return LAST_INSERT_ID();
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for Seq_email_Id.Nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `Seq_email_Id.Nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `Seq_email_Id.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO `SEQ_EMAIL_ID` (stub) VALUES ('SEQ_EMAIL_ID');
	RETURN LAST_INSERT_ID();
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SEQ_SEC_DEPARTMENT_ID.Nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `SEQ_SEC_DEPARTMENT_ID.Nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_DEPARTMENT_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_DEPARTMENT_ID (stub) VALUES ('SEQ_SEC_DEPARTMENT_ID');
	return LAST_INSERT_ID();
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SEQ_SEC_METADATA_LOG_ID.Nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `SEQ_SEC_METADATA_LOG_ID.Nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_METADATA_LOG_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_METADATA_LOG_ID (stub) VALUES ('SEQ_SEC_METADATA_LOG_ID');
	RETURN LAST_INSERT_ID();
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SEQ_SEC_OPERATION_ID.Nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `SEQ_SEC_OPERATION_ID.Nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_OPERATION_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_OPERATION_ID (stub) VALUES ('SEQ_SEC_OPERATION_ID');
	RETURN LAST_INSERT_ID();
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SEQ_SEC_RESOURCES_ID.Nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `SEQ_SEC_RESOURCES_ID.Nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_RESOURCES_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_RESOURCES_ID (stub) VALUES ('SEQ_SEC_RESOURCES_ID');
	RETURN LAST_INSERT_ID();
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SEQ_SEC_RESOURCE_CATEGORY_ID.Nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `SEQ_SEC_RESOURCE_CATEGORY_ID.Nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_RESOURCE_CATEGORY_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_RESOURCE_CATEGORY_ID (stub) VALUES ('SEQ_SEC_RESOURCE_CATEGORY_ID');
	RETURN LAST_INSERT_ID();
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SEQ_SEC_ROLE_ID.Nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `SEQ_SEC_ROLE_ID.Nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_ROLE_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_ROLE_ID (stub) VALUES ('SEQ_SEC_ROLE_ID');
	RETURN LAST_INSERT_ID();
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SEQ_SEC_STAFF_ID.Nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `SEQ_SEC_STAFF_ID.Nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_STAFF_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_STAFF_ID (stub) VALUES ('SEQ_SEC_STAFF_ID');
	return LAST_INSERT_ID();
END
;;
DELIMITER ;


DROP TABLE IF EXISTS `im_group`;
CREATE TABLE `im_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `group_name` varchar(255) NOT NULL COMMENT '分组名称',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `type` int(11) NOT NULL COMMENT '类型(0:用户分组 1:群组)',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `desc` varchar(255) DEFAULT NULL COMMENT '群组描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `im_group_user`;
CREATE TABLE `im_group_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `group_id` bigint(20) NOT NULL COMMENT '分组id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `im_history_record`;
CREATE TABLE `im_history_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `to_user_id` bigint(20) NOT NULL COMMENT '分组id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `info` text NOT NULL COMMENT '会话消息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '会话时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `im_message`;
CREATE TABLE `im_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type` varchar(2) NOT NULL COMMENT '消息类型(1、好友申请 2、群组申请 3、拒绝好友申请  4、拒绝群组申请)',
	`uid` bigint(20) NOT NULL COMMENT '用户id',
  `from` bigint(20) NOT NULL COMMENT '请求用户id',
	`from_group` bigint(20) NOT NULL COMMENT '加入群组id',
	`content` varchar(100) NOT NULL COMMENT '展示信息',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注信息',
	`read` varchar(10) NOT NULL DEFAULT '0' COMMENT '是否已读(0:未读  1:已读)',
  `time` varchar(50) NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;