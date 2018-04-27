/**
 * SecRoleMapper.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecRole;

/**
 * ��ɫMapper
 * <pre>
 * <b>Title��</b>SecRoleMapper.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</b>V1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecRoleMapper {

	/**
	 * �����б�
	 * @param  map
	 * @return �����б�
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecRole> getPageList(Map<String, Object> map);

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
	 * @param record	SecRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insert(SecRole record);

	/**
	 * ����������ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insertSelective(SecRole record);

	/**
	 * ��������id��ѯ��Ӧ����
	 * @param  id	����id
	 * @return SecRole����
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	SecRole selectByPrimaryKey(Long id);

	/**
	 * ��ѯSecRole��������ݼ���
	 * @return SecRole���󼯺�
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecRole> selectAll();

	/**
	 * ����SecRole������¶�Ӧ����
	 * @param  record	SecRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKeySelective(SecRole record);

	/**
	 * ����SecRole������¶�Ӧ���ݣ�����ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecRole����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKey(SecRole record);

	/**
	 * ����Map��������ɾ��
	 * @param  map	map����  [ list:����id���� ]
	 * @return ����ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int batchDelete(Map<String, Object> map);

}