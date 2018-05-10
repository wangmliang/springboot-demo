-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.24


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema test
--

CREATE DATABASE IF NOT EXISTS test;
USE test;

--
-- Definition of table `menu`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

--
-- Dumping data for table `menu`
--

/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;


--
-- Definition of table `person_shortcut`
--

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

--
-- Dumping data for table `person_shortcut`
--

/*!40000 ALTER TABLE `person_shortcut` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_shortcut` ENABLE KEYS */;


--
-- Definition of table `sec_department`
--

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

--
-- Dumping data for table `sec_department`
--

/*!40000 ALTER TABLE `sec_department` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_department` ENABLE KEYS */;


--
-- Definition of table `sec_department_role`
--

DROP TABLE IF EXISTS `sec_department_role`;
CREATE TABLE `sec_department_role` (
  `DEPARTMENT_ID` bigint(16) NOT NULL COMMENT '组织ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`DEPARTMENT_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织角色关联表';

--
-- Dumping data for table `sec_department_role`
--

/*!40000 ALTER TABLE `sec_department_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_department_role` ENABLE KEYS */;


--
-- Definition of table `sec_login_history`
--

DROP TABLE IF EXISTS `sec_login_history`;
CREATE TABLE `sec_login_history` (
  `STAFF_ID` bigint(20) NOT NULL COMMENT '成员ID',
  `LOGIN_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `LOGIN_FLAG` varchar(10) NOT NULL COMMENT 'LOGOUT：注销；SUCCESS：登录成功；FAIL：登录失败；TIMEOUT：用户超时；UNLOCK：解锁；AUTOLOCK：密码尝试过多被锁',
  `DESCRIPTION` varchar(20) DEFAULT NULL COMMENT '备注，现在用来记录用户登录密码尝试过多被锁前的用户状态',
  PRIMARY KEY (`STAFF_ID`,`LOGIN_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员登录日志';

--
-- Dumping data for table `sec_login_history`
--

/*!40000 ALTER TABLE `sec_login_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_login_history` ENABLE KEYS */;


--
-- Definition of table `sec_metadata_log`
--

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

--
-- Dumping data for table `sec_metadata_log`
--

/*!40000 ALTER TABLE `sec_metadata_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_metadata_log` ENABLE KEYS */;


--
-- Definition of table `sec_operation`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源操作';

--
-- Dumping data for table `sec_operation`
--

/*!40000 ALTER TABLE `sec_operation` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_operation` ENABLE KEYS */;


--
-- Definition of table `sec_operation_address`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源操作地址';

--
-- Dumping data for table `sec_operation_address`
--

/*!40000 ALTER TABLE `sec_operation_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_operation_address` ENABLE KEYS */;


--
-- Definition of table `sec_resource_category`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源分类';

--
-- Dumping data for table `sec_resource_category`
--

/*!40000 ALTER TABLE `sec_resource_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_resource_category` ENABLE KEYS */;


--
-- Definition of table `sec_resources`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源';

--
-- Dumping data for table `sec_resources`
--

/*!40000 ALTER TABLE `sec_resources` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_resources` ENABLE KEYS */;


--
-- Definition of table `sec_role`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

--
-- Dumping data for table `sec_role`
--

/*!40000 ALTER TABLE `sec_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_role` ENABLE KEYS */;


--
-- Definition of table `sec_role_resource_operation`
--

DROP TABLE IF EXISTS `sec_role_resource_operation`;
CREATE TABLE `sec_role_resource_operation` (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `RESOURCE_ID` bigint(32) NOT NULL COMMENT '资源ID',
  `OPERATION_KEY` varchar(32) NOT NULL COMMENT '资源操作关键字',
  PRIMARY KEY (`ROLE_ID`,`RESOURCE_ID`,`OPERATION_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与资源操作';

--
-- Dumping data for table `sec_role_resource_operation`
--

/*!40000 ALTER TABLE `sec_role_resource_operation` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_role_resource_operation` ENABLE KEYS */;


--
-- Definition of table `sec_staff`
--

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
  PRIMARY KEY (`STAFF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员';

--
-- Dumping data for table `sec_staff`
--

/*!40000 ALTER TABLE `sec_staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_staff` ENABLE KEYS */;


--
-- Definition of table `sec_staff_department_role`
--

DROP TABLE IF EXISTS `sec_staff_department_role`;
CREATE TABLE `sec_staff_department_role` (
  `STAFF_ID` bigint(20) NOT NULL COMMENT '成员ID',
  `DEPARTMENT_ID` bigint(16) NOT NULL COMMENT '组织ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员组织角色关联表';

--
-- Dumping data for table `sec_staff_department_role`
--

/*!40000 ALTER TABLE `sec_staff_department_role` DISABLE KEYS */;
INSERT INTO `sec_staff_department_role` (`STAFF_ID`,`DEPARTMENT_ID`,`ROLE_ID`) VALUES
 (-999,-998,2),
 (-999,-998,3),
 (-999,-998,4);
/*!40000 ALTER TABLE `sec_staff_department_role` ENABLE KEYS */;


--
-- Definition of table `sec_staff_role`
--

DROP TABLE IF EXISTS `sec_staff_role`;
CREATE TABLE `sec_staff_role` (
  `STAFF_ID` bigint(20) NOT NULL COMMENT '成员ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`STAFF_ID`,`ROLE_ID`),
  KEY `FK_sec_staff_role2` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员角色关系表';

--
-- Dumping data for table `sec_staff_role`
--

/*!40000 ALTER TABLE `sec_staff_role` DISABLE KEYS */;
INSERT INTO `sec_staff_role` (`STAFF_ID`,`ROLE_ID`) VALUES
 (-999,2),
 (-999,3),
 (-999,4);
/*!40000 ALTER TABLE `sec_staff_role` ENABLE KEYS */;


--
-- Definition of table `seq_sec_metadata_log_id`
--

DROP TABLE IF EXISTS `seq_sec_metadata_log_id`;
CREATE TABLE `seq_sec_metadata_log_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seq_sec_metadata_log_id`
--

/*!40000 ALTER TABLE `seq_sec_metadata_log_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `seq_sec_metadata_log_id` ENABLE KEYS */;


--
-- Definition of table `seq_sec_operation_id`
--

DROP TABLE IF EXISTS `seq_sec_operation_id`;
CREATE TABLE `seq_sec_operation_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seq_sec_operation_id`
--

/*!40000 ALTER TABLE `seq_sec_operation_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `seq_sec_operation_id` ENABLE KEYS */;


--
-- Definition of table `seq_sec_resource_category_id`
--

DROP TABLE IF EXISTS `seq_sec_resource_category_id`;
CREATE TABLE `seq_sec_resource_category_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seq_sec_resource_category_id`
--

/*!40000 ALTER TABLE `seq_sec_resource_category_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `seq_sec_resource_category_id` ENABLE KEYS */;


--
-- Definition of table `seq_sec_resources_id`
--

DROP TABLE IF EXISTS `seq_sec_resources_id`;
CREATE TABLE `seq_sec_resources_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seq_sec_resources_id`
--

/*!40000 ALTER TABLE `seq_sec_resources_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `seq_sec_resources_id` ENABLE KEYS */;


--
-- Definition of table `seq_sec_role_id`
--

DROP TABLE IF EXISTS `seq_sec_role_id`;
CREATE TABLE `seq_sec_role_id` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stub` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seq_sec_role_id`
--

/*!40000 ALTER TABLE `seq_sec_role_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `seq_sec_role_id` ENABLE KEYS */;


--
-- Definition of function `SEQ_SEC_METADATA_LOG_ID.Nextval`
--

DROP FUNCTION IF EXISTS `SEQ_SEC_METADATA_LOG_ID.Nextval`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_METADATA_LOG_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_METADATA_LOG_ID (stub) VALUES ('SEQ_SEC_METADATA_LOG_ID');
	RETURN LAST_INSERT_ID();
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `SEQ_SEC_OPERATION_ID.Nextval`
--

DROP FUNCTION IF EXISTS `SEQ_SEC_OPERATION_ID.Nextval`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_OPERATION_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_OPERATION_ID (stub) VALUES ('SEQ_SEC_OPERATION_ID');
	RETURN LAST_INSERT_ID();
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `SEQ_SEC_RESOURCES_ID.Nextval`
--

DROP FUNCTION IF EXISTS `SEQ_SEC_RESOURCES_ID.Nextval`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_RESOURCES_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_RESOURCES_ID (stub) VALUES ('SEQ_SEC_RESOURCES_ID');
	RETURN LAST_INSERT_ID();
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `SEQ_SEC_RESOURCE_CATEGORY_ID.Nextval`
--

DROP FUNCTION IF EXISTS `SEQ_SEC_RESOURCE_CATEGORY_ID.Nextval`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_RESOURCE_CATEGORY_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_RESOURCE_CATEGORY_ID (stub) VALUES ('SEQ_SEC_RESOURCE_CATEGORY_ID');
	RETURN LAST_INSERT_ID();
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of function `SEQ_SEC_ROLE_ID.Nextval`
--

DROP FUNCTION IF EXISTS `SEQ_SEC_ROLE_ID.Nextval`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `SEQ_SEC_ROLE_ID.Nextval`() RETURNS bigint(20)
    READS SQL DATA
BEGIN
	REPLACE INTO SEQ_SEC_ROLE_ID (stub) VALUES ('SEQ_SEC_ROLE_ID');
	RETURN LAST_INSERT_ID();
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;


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


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


 --> 菜单(Menu) --> 资源分类(resource-category) -->  资源(resource) -->  操作(operation) -->  访问Address
 --> 组织架构(department) 					角色(role)								用户(staff) --> 
			-- 关联(组织拥有某类角色)  		用户是组织架构下成员，拥有自己的角色   	角色拥有哪些资源

1	admin		admin	509ed3482038db08cee1d82e344933103882471b	NORMAL						2018-05-10 15:54:04						0302bc07536bd185

-999	根组织	所有组织的根		xx@xx.com	xx	0	system	2015-08-13 11:31:26	2015-08-13 11:31:26
-998	一级目录	一级目录	-999	xx@xx.com	xx	1	system	2015-08-13 17:42:47	2015-08-13 17:42:47	SYS_ADMIN


1	-998	5
1	-998	6