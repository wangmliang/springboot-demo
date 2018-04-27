/**
 * SecLoginHistoryMapper.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:58  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecLoginHistory;

/**
 * ��Ա��¼��־Mapper
 * <pre>
 * <b>Title��</b>SecLoginHistoryMapper.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</b>V1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecLoginHistoryMapper {

	/**
	 * �����б�
	 * @param  map
	 * @return �����б�
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecLoginHistory> getPageList(Map<String, Object> map);

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
	 * @param record	SecLoginHistory����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insert(SecLoginHistory record);

	/**
	 * ����������ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecLoginHistory����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insertSelective(SecLoginHistory record);

	/**
	 * ��������id��ѯ��Ӧ����
	 * @param  id	����id
	 * @return SecLoginHistory����
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	SecLoginHistory selectByPrimaryKey(Long id);

	/**
	 * ��ѯSecLoginHistory��������ݼ���
	 * @return SecLoginHistory���󼯺�
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecLoginHistory> selectAll();

	/**
	 * ����SecLoginHistory������¶�Ӧ����
	 * @param  record	SecLoginHistory����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKeySelective(SecLoginHistory record);

	/**
	 * ����SecLoginHistory������¶�Ӧ���ݣ�����ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecLoginHistory����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKey(SecLoginHistory record);

	/**
	 * ����Map��������ɾ��
	 * @param  map	map����  [ list:����id���� ]
	 * @return ����ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int batchDelete(Map<String, Object> map);

}