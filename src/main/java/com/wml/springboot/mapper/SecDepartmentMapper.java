/**
 * SecDepartmentMapper.java
 * �����л��������Ƽ����޹�˾
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
 * ��֯Mapper
 * <pre>
 * <b>Title��</b>SecDepartmentMapper.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</b>V1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecDepartmentMapper {

	/**
	 * �����б�
	 * @param  map
	 * @return �����б�
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecDepartment> getPageList(Map<String, Object> map);

	/**
	 * ��������idɾ����Ӧ����
	 * @param  id		����id
	 * @return ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * ����
	 * @param record	SecDepartment����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insert(SecDepartment record);

	/**
	 * ����������ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecDepartment����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insertSelective(SecDepartment record);

	/**
	 * ��������id��ѯ��Ӧ����
	 * @param  id	����id
	 * @return SecDepartment����
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	SecDepartment selectByPrimaryKey(Long id);

	/**
	 * ��ѯSecDepartment��������ݼ���
	 * @return SecDepartment���󼯺�
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecDepartment> selectAll();

	/**
	 * ����SecDepartment������¶�Ӧ����
	 * @param  record	SecDepartment����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKeySelective(SecDepartment record);

	/**
	 * ����SecDepartment������¶�Ӧ���ݣ�����ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecDepartment����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKey(SecDepartment record);

	/**
	 * ����Map��������ɾ��
	 * @param  map	map����  [ list:����id���� ]
	 * @return ����ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int batchDelete(Map<String, Object> map);

}