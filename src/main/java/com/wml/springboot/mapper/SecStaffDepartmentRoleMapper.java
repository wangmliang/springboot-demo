/**
 * SecStaffDepartmentRoleMapper.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecStaffDepartmentRole;

/**
 * 成员组织角色关联表Mapper
 * <pre>
 * <b>Title：</b>SecStaffDepartmentRoleMapper.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</b>V1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecStaffDepartmentRoleMapper {

	/**
	 * 数据列表
	 * @param  map
	 * @return 数据列表
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecStaffDepartmentRole> getPageList(Map<String, Object> map);

	/**
	 * 根据主键id删除对应数据
	 * @param  id		主键id
	 * @return 删除影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 新增
	 * @param record	SecStaffDepartmentRole对象
	 * @return 新增影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insert(SecStaffDepartmentRole record);

	/**
	 * 新增（属性通过非空验证，为空属性不参与操作）
	 * @param  record	SecStaffDepartmentRole对象
	 * @return 新增影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insertSelective(SecStaffDepartmentRole record);

	/**
	 * 根据主键id查询对应数据
	 * @param  id	主键id
	 * @return SecStaffDepartmentRole对象
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	SecStaffDepartmentRole selectByPrimaryKey(Long id);

	/**
	 * 查询SecStaffDepartmentRole对象的数据集合
	 * @return SecStaffDepartmentRole对象集合
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecStaffDepartmentRole> selectAll();

	/**
	 * 根据SecStaffDepartmentRole对象更新对应数据
	 * @param  record	SecStaffDepartmentRole对象
	 * @return 更新影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKeySelective(SecStaffDepartmentRole record);

	/**
	 * 根据SecStaffDepartmentRole对象更新对应数据（属性通过非空验证，为空属性不参与操作）
	 * @param  record	SecStaffDepartmentRole对象
	 * @return 更新影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKey(SecStaffDepartmentRole record);

	/**
	 * 根据Map对象批量删除
	 * @param  map	map对象  [ list:主键id集合 ]
	 * @return 批量删除影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int batchDelete(Map<String, Object> map);

}