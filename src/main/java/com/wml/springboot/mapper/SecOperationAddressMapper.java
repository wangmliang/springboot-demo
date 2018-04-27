/**
 * SecOperationAddressMapper.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecOperationAddress;

/**
 * 资源操作地址Mapper
 * <pre>
 * <b>Title：</b>SecOperationAddressMapper.java<br/>
 * <b>@author： </b>Miles<br/>
 * <b>@version：</b>V1.0<br/>
 * <b>@date：</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecOperationAddressMapper {

	/**
	 * 数据列表
	 * @param  map
	 * @return 数据列表
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecOperationAddress> getPageList(Map<String, Object> map);

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
	 * @param record	SecOperationAddress对象
	 * @return 新增影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insert(SecOperationAddress record);

	/**
	 * 新增（属性通过非空验证，为空属性不参与操作）
	 * @param  record	SecOperationAddress对象
	 * @return 新增影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insertSelective(SecOperationAddress record);

	/**
	 * 根据主键id查询对应数据
	 * @param  id	主键id
	 * @return SecOperationAddress对象
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	SecOperationAddress selectByPrimaryKey(Long id);

	/**
	 * 查询SecOperationAddress对象的数据集合
	 * @return SecOperationAddress对象集合
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecOperationAddress> selectAll();

	/**
	 * 根据SecOperationAddress对象更新对应数据
	 * @param  record	SecOperationAddress对象
	 * @return 更新影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKeySelective(SecOperationAddress record);

	/**
	 * 根据SecOperationAddress对象更新对应数据（属性通过非空验证，为空属性不参与操作）
	 * @param  record	SecOperationAddress对象
	 * @return 更新影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKey(SecOperationAddress record);

	/**
	 * 根据Map对象批量删除
	 * @param  map	map对象  [ list:主键id集合 ]
	 * @return 批量删除影响行数
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int batchDelete(Map<String, Object> map);

}