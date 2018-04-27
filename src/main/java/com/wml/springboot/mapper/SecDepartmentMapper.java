/**
 * SecDepartmentMapper.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecDepartment;

/**
 * 组织Mapper
 * <pre>
 * <b>Title：</b>SecDepartmentMapper.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</b>V1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecDepartmentMapper {

	/**
	 * 数据列表
	 * @param  map
	 * @return 数据列表
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecDepartment> getPageList(Map<String, Object> map);

	/**
	 * 根据主键id删除对应数据
	 * @param  id		主键id
	 * @return 删除影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 新增
	 * @param record	SecDepartment对象
	 * @return 新增影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insert(SecDepartment record);

	/**
	 * 新增（属性通过非空验证，为空属性不参与操作）
	 * @param  record	SecDepartment对象
	 * @return 新增影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insertSelective(SecDepartment record);

	/**
	 * 根据主键id查询对应数据
	 * @param  id	主键id
	 * @return SecDepartment对象
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	SecDepartment selectByPrimaryKey(Long id);

	/**
	 * 查询SecDepartment对象的数据集合
	 * @return SecDepartment对象集合
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecDepartment> selectAll();

	/**
	 * 根据SecDepartment对象更新对应数据
	 * @param  record	SecDepartment对象
	 * @return 更新影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKeySelective(SecDepartment record);

	/**
	 * 根据SecDepartment对象更新对应数据（属性通过非空验证，为空属性不参与操作）
	 * @param  record	SecDepartment对象
	 * @return 更新影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKey(SecDepartment record);

	/**
	 * 根据Map对象批量删除
	 * @param  map	map对象  [ list:主键id集合 ]
	 * @return 批量删除影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int batchDelete(Map<String, Object> map);

}