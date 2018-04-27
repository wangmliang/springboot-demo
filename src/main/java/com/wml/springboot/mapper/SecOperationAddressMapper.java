/**
 * SecOperationAddressMapper.java
 * �����л��������Ƽ����޹�˾
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
 * ��Դ������ַMapper
 * <pre>
 * <b>Title��</b>SecOperationAddressMapper.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</b>V1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:58 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecOperationAddressMapper {

	/**
	 * �����б�
	 * @param  map
	 * @return �����б�
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecOperationAddress> getPageList(Map<String, Object> map);

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
	 * @param record	SecOperationAddress����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insert(SecOperationAddress record);

	/**
	 * ����������ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecOperationAddress����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int insertSelective(SecOperationAddress record);

	/**
	 * ��������id��ѯ��Ӧ����
	 * @param  id	����id
	 * @return SecOperationAddress����
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	SecOperationAddress selectByPrimaryKey(Long id);

	/**
	 * ��ѯSecOperationAddress��������ݼ���
	 * @return SecOperationAddress���󼯺�
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	List<SecOperationAddress> selectAll();

	/**
	 * ����SecOperationAddress������¶�Ӧ����
	 * @param  record	SecOperationAddress����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKeySelective(SecOperationAddress record);

	/**
	 * ����SecOperationAddress������¶�Ӧ���ݣ�����ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecOperationAddress����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int updateByPrimaryKey(SecOperationAddress record);

	/**
	 * ����Map��������ɾ��
	 * @param  map	map����  [ list:����id���� ]
	 * @return ����ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:58  Created
	 */
	int batchDelete(Map<String, Object> map);

}