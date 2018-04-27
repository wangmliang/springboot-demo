/**
 * SecDepartmentRoleMapper.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecDepartmentRole;

/**
 * ��֯��ɫ������Mapper
 * <pre>
 * <b>Title��</b>SecDepartmentRoleMapper.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</b>V1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecDepartmentRoleMapper {

	/**
	 * �����б�
	 * @param  map
	 * @return �����б�
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecDepartmentRole> getPageList(Map<String, Object> map);

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
	 * @param record	SecDepartmentRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insert(SecDepartmentRole record);

	/**
	 * ����������ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecDepartmentRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insertSelective(SecDepartmentRole record);

	/**
	 * ��������id��ѯ��Ӧ����
	 * @param  id	����id
	 * @return SecDepartmentRole����
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	SecDepartmentRole selectByPrimaryKey(Long id);

	/**
	 * ��ѯSecDepartmentRole��������ݼ���
	 * @return SecDepartmentRole���󼯺�
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecDepartmentRole> selectAll();

	/**
	 * ����SecDepartmentRole������¶�Ӧ����
	 * @param  record	SecDepartmentRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKeySelective(SecDepartmentRole record);

	/**
	 * ����SecDepartmentRole������¶�Ӧ���ݣ�����ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecDepartmentRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKey(SecDepartmentRole record);

	/**
	 * ����Map��������ɾ��
	 * @param  map	map����  [ list:����id���� ]
	 * @return ����ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int batchDelete(Map<String, Object> map);

}