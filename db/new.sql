DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `MENU_ID` bigint(10) NOT NULL auto_increment COMMENT '菜单ID',
  `MENU_NAME` varchar(64) NOT NULL COMMENT '菜单名称',
  `MENU_KEY` varchar(100) NOT NULL COMMENT '菜单外码',
  `PARENT_ID` bigint(10) NOT NULL COMMENT '父菜单ID',
  `IMAGE_URL` varchar(128) default NULL COMMENT '图标Url',
  `URL` varchar(128) default NULL COMMENT '资源URL',
  `MENU_ORDER` varchar(6) default NULL COMMENT '菜单顺序',
  `SUBSYSTEM` varchar(32) default NULL COMMENT '子系统名称',
  `DOMAIN` varchar(32) default NULL COMMENT '菜单所属域（admin、sp）',
  PRIMARY KEY  (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Table structure for `sec_department`
-- ----------------------------
DROP TABLE IF EXISTS `sec_department`;
CREATE TABLE `sec_department` (
  `DEPARTMENT_ID` bigint(16) NOT NULL auto_increment COMMENT '组织ID',
  `DEPARTMENT_NAME` varchar(100) NOT NULL COMMENT '组织名称',
  `DEPARTMENT_DESC` varchar(100) default NULL COMMENT '组织描述',
  `PARENT_ID` bigint(16) default NULL COMMENT '父级组织',
  `EMAIL` varchar(50) default NULL COMMENT '组织的邮件',
  `ADDRESS` varchar(200) default NULL COMMENT '组织地址',
  `ADD_SUB` varchar(1) NOT NULL default '1' COMMENT '是否可以创建下级组织',
  `CREATE_USER` varchar(20) NOT NULL COMMENT '组织创建者',
  `CREATE_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '组织创建时间',
  `LAST_UPDATE_DATE` timestamp NULL default NULL COMMENT '组织最后修改时间',
  `DOMAIN` varchar(10) default 'SYS_ADMIN' COMMENT '管理域：SP、SYS_ADMIN',
  PRIMARY KEY  (`DEPARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织';


-- ----------------------------
-- Table structure for `sec_department_role`
-- ----------------------------
DROP TABLE IF EXISTS `sec_department_role`;
CREATE TABLE `sec_department_role` (
  `DEPARTMENT_ID` bigint(16) NOT NULL COMMENT '组织ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY  (`DEPARTMENT_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织角色关联表';


-- ----------------------------
-- Table structure for `sec_staff_department_role`
-- ----------------------------
DROP TABLE IF EXISTS `sec_staff_department_role`;
CREATE TABLE `sec_staff_department_role` (
  `STAFF_ID` bigint(20) NOT NULL COMMENT '成员ID',
  `DEPARTMENT_ID` bigint(16) NOT NULL COMMENT '组织ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员组织角色关联表';

-- ----------------------------
-- Table structure for `sec_role_resource_operation`
-- ----------------------------
DROP TABLE IF EXISTS `sec_role_resource_operation`;
CREATE TABLE `sec_role_resource_operation` (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `RESOURCE_ID` bigint(32) NOT NULL COMMENT '资源ID',
  `OPERATION_KEY` varchar(32) NOT NULL COMMENT '资源操作关键字',
  PRIMARY KEY  (`ROLE_ID`,`RESOURCE_ID`,`OPERATION_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与资源操作';

-- ----------------------------
-- Table structure for `sec_login_history`
-- ----------------------------
DROP TABLE IF EXISTS `sec_login_history`;
CREATE TABLE `sec_login_history` (
  `STAFF_ID` bigint(20) NOT NULL COMMENT '成员ID',
  `LOGIN_TIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '登录时间',
  `LOGIN_FLAG` varchar(10) NOT NULL COMMENT 'LOGOUT：注销；SUCCESS：登录成功；FAIL：登录失败；TIMEOUT：用户超时；UNLOCK：解锁；AUTOLOCK：密码尝试过多被锁',
  `DESCRIPTION` varchar(20) default NULL COMMENT '备注，现在用来记录用户登录密码尝试过多被锁前的用户状态',
  PRIMARY KEY  (`STAFF_ID`,`LOGIN_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员登录日志';

-- ----------------------------
-- Table structure for `sec_operation`
-- ----------------------------
DROP TABLE IF EXISTS `sec_operation`;
CREATE TABLE `sec_operation` (
  `OPERATION_ID` bigint(20) NOT NULL auto_increment COMMENT '资源操作主键',
  `RESOURCE_ID` bigint(20) NOT NULL COMMENT '资源主键',
  `OPERATION_KEY` varchar(32) NOT NULL COMMENT '操作关键字',
  `OPERATION_NAME` varchar(100) NOT NULL COMMENT '操作名称',
  `OPERATION_DESC` varchar(100) default NULL COMMENT '操作描述',
  `DEPEND_KEY` varchar(32) default NULL COMMENT '依赖操作KEY',
  `DEPEND_BY_KEY` varchar(500) default NULL COMMENT '被依赖操作KEY',
  `METADATA_ID` varchar(32) default NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) default NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(5) default NULL COMMENT '操作的顺序',
  PRIMARY KEY  (`OPERATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源操作';


-- ----------------------------
-- Table structure for `sec_operation_address`
-- ----------------------------
DROP TABLE IF EXISTS `sec_operation_address`;
CREATE TABLE `sec_operation_address` (
  `ADDRESS_ID` bigint(20) NOT NULL auto_increment COMMENT '访问地址ID',
  `RESOURCE_ID` bigint(20) NOT NULL COMMENT '资源ID',
  `OPERATION_KEY` varchar(32) NOT NULL COMMENT '资源操作外码',
  `OPERATION_ADDRESS_NAME` varchar(100) default NULL COMMENT '访问地址名称',
  `OPERATION_ADDRESS_URL` varchar(128) NOT NULL COMMENT '访问地址URL（不包含协议、IP、端口、contextpath）',
  `PARAMETER_NAME1` varchar(64) default NULL COMMENT '参数名一',
  `PARAMETER_VALUE1` varchar(64) default NULL COMMENT '参数值一',
  `PARAMETER_NAME2` varchar(64) default NULL COMMENT '参数名二',
  `PARAMETER_VALUE2` varchar(64) default NULL COMMENT '参数值二',
  `PARAMETER_NAME3` varchar(64) default NULL COMMENT '参数名三',
  `PARAMETER_VALUE3` varchar(64) default NULL COMMENT '参数值三',
  `METADATA_ID` varchar(32) default NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) default NULL COMMENT '管理域：SP、ADMIN',
  PRIMARY KEY  (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源操作地址';


-- ----------------------------
-- Table structure for `sec_resource_category`
-- ----------------------------
DROP TABLE IF EXISTS `sec_resource_category`;
CREATE TABLE `sec_resource_category` (
  `CATEGORY_ID` bigint(20) NOT NULL auto_increment COMMENT '资源分类ID',
  `PARENT_ID` bigint(20) default NULL COMMENT '上级资源分类ID',
  `CATEGORY_NAME` varchar(100) default NULL COMMENT '资源分类名称',
  `CATEGORY_DESC` varchar(100) default NULL COMMENT '资源分类描述',
  `METADATA_ID` varchar(32) default NULL COMMENT '元数据ID',
  `CATEGORY_KEY` varchar(100) default NULL COMMENT '资源分类外码',
  `DOMAIN` varchar(20) default NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(11) default NULL COMMENT '资源分类的顺序',
  PRIMARY KEY  (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源分类';


-- ----------------------------
-- Table structure for `sec_resources`
-- ----------------------------
DROP TABLE IF EXISTS `sec_resources`;
CREATE TABLE `sec_resources` (
  `RESOURCE_ID` bigint(20) NOT NULL auto_increment COMMENT '资源ID',
  `RESOURCE_KEY` varchar(100) NOT NULL COMMENT '资源外码',
  `RESOURCE_NAME` varchar(100) NOT NULL COMMENT '资源名称',
  `RESOURCE_DESC` varchar(100) default NULL COMMENT '资源描述',
  `CATEGORY_ID` bigint(20) NOT NULL COMMENT '资源分类ID',
  `AUTH_TYPE` varchar(10) NOT NULL COMMENT '鉴权类型(AUTH：鉴权，UNAUTH：不鉴权，LOGIN_AUTH：登录鉴权)',
  `METADATA_ID` varchar(32) default NULL COMMENT '元数据ID',
  `DOMAIN` varchar(20) default NULL COMMENT '管理域：SP、ADMIN',
  `ORDER_KEY` int(11) default NULL COMMENT '资源的顺序',
  PRIMARY KEY  (`RESOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源';


-- ----------------------------
-- Table structure for `sec_role`
-- ----------------------------
DROP TABLE IF EXISTS `sec_role`;
CREATE TABLE `sec_role` (
  `ROLE_ID` bigint(20) NOT NULL auto_increment COMMENT '角色ID',
  `ROLE_NAME` varchar(100) NOT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(400) default NULL COMMENT '角色描述',
  `CREATE_USER` varchar(20) NOT NULL COMMENT '角色创建者',
  `CREATE_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '角色创建时间',
  `CAN_MODIFY` int(11) NOT NULL default '1' COMMENT '是否允许修改 1：允许 0: 不充许 缺省=1',
  `LAST_UPDATE_DATE` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '角色最后修改时间',
  `ROLE_KEY` varchar(64) default NULL COMMENT '角色外码',
  `AUTO_ASSIGN` int(1) NOT NULL default '0' COMMENT '自动分配(0:不自动分配；1：自动分配给所有注册成员)',
  `visible` int(1) NOT NULL default '1' COMMENT '是否在界面上可见(0：不可见；1：可见)',
  PRIMARY KEY  (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';


-- ----------------------------
-- Table structure for `sec_staff`
-- ----------------------------
DROP TABLE IF EXISTS `sec_staff`;
CREATE TABLE `sec_staff` (
  `STAFF_ID` bigint(20) NOT NULL auto_increment COMMENT '成员ID',
  `LOGIN_NAME` varchar(100) NOT NULL COMMENT '登录名',
  `DEPARTMENT_ID` bigint(16) default NULL COMMENT '组织ID',
  `REAL_NAME` varchar(100) NOT NULL COMMENT '成员姓名',
  `PASSWORD` varchar(128) NOT NULL COMMENT '密码（经过加密）',
  `STATUS` varchar(20) NOT NULL default 'INITIAL' COMMENT '成员状态',
  `SEX` varchar(10) default NULL COMMENT '性别：MALE-男性；FEMALE-女性；',
  `TELEPHONE` varchar(30) default NULL COMMENT '电话',
  `MOBILE` varchar(16) NOT NULL COMMENT '手机号码',
  `EMAIL` varchar(64) default NULL COMMENT '邮件地址',
  `CREATE_USER` varchar(16) NOT NULL COMMENT '成员创建者',
  `CREATE_DATE` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '成员创建时间',
  `EXPIRE_DATE` timestamp NULL default NULL COMMENT '成员帐号过期时间',
  `LAST_UPDATE_DATE` timestamp NULL default NULL COMMENT '成员最后修改时间',
  `PASSWORD_EXPIRE_DATE` timestamp NULL default NULL COMMENT '密码失效时间',
  `LOCK_DATE` timestamp NULL default NULL COMMENT '用户锁定时间',
  `CITY_ID` int(11) default NULL COMMENT '成员所在城市（参见CITY表）',
  PRIMARY KEY  (`STAFF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员';



 --> 菜单(Menu) --> 资源分类(resource-category) -->  资源(resource) -->  操作(operation) -->  访问Address
 --> 组织架构(department) 					角色(role)								用户(staff) --> 
			-- 关联(组织拥有某类角色)  		用户是组织架构下成员，拥有自己的角色   	角色拥有哪些资源
			