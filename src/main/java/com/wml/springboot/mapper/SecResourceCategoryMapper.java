/**
 * SecResourceCategoryMapper.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecResourceCategory;

/**
 * 资源分类Mapper
 * <pre>
 * <b>Title：</b>SecResourceCategoryMapper.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</b>V1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecResourceCategoryMapper {

	/**
	 * 数据列表
	 * @param  map
	 * @return 数据列表
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecResourceCategory> getPageList(Map<String, Object> map);

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
	 * @param record	SecResourceCategory对象
	 * @return 新增影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insert(SecResourceCategory record);

	/**
	 * 新增（属性通过非空验证，为空属性不参与操作）
	 * @param  record	SecResourceCategory对象
	 * @return 新增影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insertSelective(SecResourceCategory record);

	/**
	 * 根据主键id查询对应数据
	 * @param  id	主键id
	 * @return SecResourceCategory对象
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	SecResourceCategory selectByPrimaryKey(Long id);

	/**
	 * 查询SecResourceCategory对象的数据集合
	 * @return SecResourceCategory对象集合
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecResourceCategory> selectAll();

	/**
	 * 根据SecResourceCategory对象更新对应数据
	 * @param  record	SecResourceCategory对象
	 * @return 更新影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKeySelective(SecResourceCategory record);

	/**
	 * 根据SecResourceCategory对象更新对应数据（属性通过非空验证，为空属性不参与操作）
	 * @param  record	SecResourceCategory对象
	 * @return 更新影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKey(SecResourceCategory record);

	/**
	 * 根据Map对象批量删除
	 * @param  map	map对象  [ list:主键id集合 ]
	 * @return 批量删除影响行数
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int batchDelete(Map<String, Object> map);

}