/**
 * SecOperationMapper.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecOperation;

/**
 * ��Դ����Mapper
 * <pre>
 * <b>Title��</b>SecOperationMapper.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</b>V1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecOperationMapper {

	/**
	 * �����б�
	 * @param  map
	 * @return �����б�
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecOperation> getPageList(Map<String, Object> map);

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
	 * @param record	SecOperation����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insert(SecOperation record);

	/**
	 * ����������ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecOperation����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insertSelective(SecOperation record);

	/**
	 * ��������id��ѯ��Ӧ����
	 * @param  id	����id
	 * @return SecOperation����
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	SecOperation selectByPrimaryKey(Long id);

	/**
	 * ��ѯSecOperation��������ݼ���
	 * @return SecOperation���󼯺�
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecOperation> selectAll();

	/**
	 * ����SecOperation������¶�Ӧ����
	 * @param  record	SecOperation����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKeySelective(SecOperation record);

	/**
	 * ����SecOperation������¶�Ӧ���ݣ�����ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecOperation����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKey(SecOperation record);

	/**
	 * ����Map��������ɾ��
	 * @param  map	map����  [ list:����id���� ]
	 * @return ����ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int batchDelete(Map<String, Object> map);

}