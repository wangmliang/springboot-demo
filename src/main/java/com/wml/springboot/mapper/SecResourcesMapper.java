/**
 * SecResourcesMapper.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecResources;

/**
 * ��ԴMapper
 * <pre>
 * <b>Title��</b>SecResourcesMapper.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</b>V1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecResourcesMapper {

	/**
	 * �����б�
	 * @param  map
	 * @return �����б�
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecResources> getPageList(Map<String, Object> map);

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
	 * @param record	SecResources����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insert(SecResources record);

	/**
	 * ����������ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecResources����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insertSelective(SecResources record);

	/**
	 * ��������id��ѯ��Ӧ����
	 * @param  id	����id
	 * @return SecResources����
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	SecResources selectByPrimaryKey(Long id);

	/**
	 * ��ѯSecResources��������ݼ���
	 * @return SecResources���󼯺�
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecResources> selectAll();

	/**
	 * ����SecResources������¶�Ӧ����
	 * @param  record	SecResources����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKeySelective(SecResources record);

	/**
	 * ����SecResources������¶�Ӧ���ݣ�����ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecResources����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKey(SecResources record);

	/**
	 * ����Map��������ɾ��
	 * @param  map	map����  [ list:����id���� ]
	 * @return ����ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int batchDelete(Map<String, Object> map);

}