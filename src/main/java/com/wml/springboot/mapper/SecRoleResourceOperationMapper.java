/**
 * SecRoleResourceOperationMapper.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecRoleResourceOperation;

/**
 * ��ɫ����Դ����Mapper
 * <pre>
 * <b>Title��</b>SecRoleResourceOperationMapper.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</b>V1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecRoleResourceOperationMapper {

	/**
	 * �����б�
	 * @param  map
	 * @return �����б�
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecRoleResourceOperation> getPageList(Map<String, Object> map);

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
	 * @param record	SecRoleResourceOperation����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insert(SecRoleResourceOperation record);

	/**
	 * ����������ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecRoleResourceOperation����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insertSelective(SecRoleResourceOperation record);

	/**
	 * ��������id��ѯ��Ӧ����
	 * @param  id	����id
	 * @return SecRoleResourceOperation����
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	SecRoleResourceOperation selectByPrimaryKey(Long id);

	/**
	 * ��ѯSecRoleResourceOperation��������ݼ���
	 * @return SecRoleResourceOperation���󼯺�
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecRoleResourceOperation> selectAll();

	/**
	 * ����SecRoleResourceOperation������¶�Ӧ����
	 * @param  record	SecRoleResourceOperation����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKeySelective(SecRoleResourceOperation record);

	/**
	 * ����SecRoleResourceOperation������¶�Ӧ���ݣ�����ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecRoleResourceOperation����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKey(SecRoleResourceOperation record);

	/**
	 * ����Map��������ɾ��
	 * @param  map	map����  [ list:����id���� ]
	 * @return ����ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int batchDelete(Map<String, Object> map);

}