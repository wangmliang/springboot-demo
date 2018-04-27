/**
 * SecStaffDepartmentRoleMapper.java
 * �����л��������Ƽ����޹�˾
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
 * ��Ա��֯��ɫ������Mapper
 * <pre>
 * <b>Title��</b>SecStaffDepartmentRoleMapper.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</b>V1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecStaffDepartmentRoleMapper {

	/**
	 * �����б�
	 * @param  map
	 * @return �����б�
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecStaffDepartmentRole> getPageList(Map<String, Object> map);

	/**
	 * ��������idɾ����Ӧ����
	 * @param  id		����id
	 * @return ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * ����
	 * @param record	SecStaffDepartmentRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insert(SecStaffDepartmentRole record);

	/**
	 * ����������ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecStaffDepartmentRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insertSelective(SecStaffDepartmentRole record);

	/**
	 * ��������id��ѯ��Ӧ����
	 * @param  id	����id
	 * @return SecStaffDepartmentRole����
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	SecStaffDepartmentRole selectByPrimaryKey(Long id);

	/**
	 * ��ѯSecStaffDepartmentRole��������ݼ���
	 * @return SecStaffDepartmentRole���󼯺�
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecStaffDepartmentRole> selectAll();

	/**
	 * ����SecStaffDepartmentRole������¶�Ӧ����
	 * @param  record	SecStaffDepartmentRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKeySelective(SecStaffDepartmentRole record);

	/**
	 * ����SecStaffDepartmentRole������¶�Ӧ���ݣ�����ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecStaffDepartmentRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKey(SecStaffDepartmentRole record);

	/**
	 * ����Map��������ɾ��
	 * @param  map	map����  [ list:����id���� ]
	 * @return ����ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int batchDelete(Map<String, Object> map);

}