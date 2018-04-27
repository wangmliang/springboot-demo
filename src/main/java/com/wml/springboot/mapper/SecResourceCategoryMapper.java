/**
 * SecResourceCategoryMapper.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018-04-27 12:17:59  Created
 * <b>Copyright (c) 2018 ASPire Tech.</b>  
 */
package com.wml.springboot.mapper;

import java.util.List;
import java.util.Map;

import com.wml.springboot.entity.SecResourceCategory;

/**
 * ��Դ����Mapper
 * <pre>
 * <b>Title��</b>SecResourceCategoryMapper.java<br/>
 * <b>@author�� </b>Miles<br/>
 * <b>@version��</b>V1.0<br/>
 * <b>@date��</b>2018-04-27 12:17:59 Created<br/>  
 * <b>Copyright (c) 2018 ASPire Tech.</b>   
 * </pre>
 */
public interface SecResourceCategoryMapper {

	/**
	 * �����б�
	 * @param  map
	 * @return �����б�
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecResourceCategory> getPageList(Map<String, Object> map);

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
	 * @param record	SecResourceCategory����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insert(SecResourceCategory record);

	/**
	 * ����������ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecResourceCategory����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int insertSelective(SecResourceCategory record);

	/**
	 * ��������id��ѯ��Ӧ����
	 * @param  id	����id
	 * @return SecResourceCategory����
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	SecResourceCategory selectByPrimaryKey(Long id);

	/**
	 * ��ѯSecResourceCategory��������ݼ���
	 * @return SecResourceCategory���󼯺�
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	List<SecResourceCategory> selectAll();

	/**
	 * ����SecResourceCategory������¶�Ӧ����
	 * @param  record	SecResourceCategory����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKeySelective(SecResourceCategory record);

	/**
	 * ����SecResourceCategory������¶�Ӧ���ݣ�����ͨ���ǿ���֤��Ϊ�����Բ����������
	 * @param  record	SecResourceCategory����
	 * @return ����Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int updateByPrimaryKey(SecResourceCategory record);

	/**
	 * ����Map��������ɾ��
	 * @param  map	map����  [ list:����id���� ]
	 * @return ����ɾ��Ӱ������
	 * @author Miles
	 * 2018-04-27 12:17:59  Created
	 */
	int batchDelete(Map<String, Object> map);

}