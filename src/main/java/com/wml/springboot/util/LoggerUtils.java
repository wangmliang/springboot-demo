package com.wml.springboot.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ��־��¼������
 * <pre>
 * <b>@ClassName��</b>LoggerUtils.java<br/>
 * <b>@author��</b>Miles<br/>
 * <b>@E-mail��</b>miles@lan360.com<br/>
 * <b>@date��</b>2018��4��19�� - ����4:24:48<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class LoggerUtils {

	/**
	 * �Ƿ���Debug
	 */
	public static boolean isDebug =  LoggerFactory.getLogger(LoggerUtils.class).isDebugEnabled();

	/**
	 * Debug ���
	 * @param clazz  	Ŀ��.Class
	 * @param message	�����Ϣ
	 */
	public static void debug(Class<? extends Object> clazz ,String message){
		if(!isDebug)return ;
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.debug(message);
	}
	/**
	 * Debug ���
	 * @param clazz  	Ŀ��.Class
	 * @param fmtString �����Ϣkey
	 * @param value		�����Ϣvalue
	 */
	public static void fmtDebug(Class<? extends Object> clazz,String fmtString,Object...value){
		if(!isDebug)return ;
		if(StringUtils.isBlank(fmtString)){
			return ;
		}
		if(null != value && value.length != 0){
			fmtString = String.format(fmtString, value);
		}
		debug(clazz, fmtString);
	}
	/**
	 * Error ���
	 * @param clazz  	Ŀ��.Class
	 * @param message	�����Ϣ
	 * @param e			�쳣��
	 */
	public static void error(Class<? extends Object> clazz ,String message,Exception e){
		Logger logger = LoggerFactory.getLogger(clazz);
		if(null == e){
			logger.error(message);
			return ;
		}
		logger.error(message, e);
	}
	/**
	 * Error ���
	 * @param clazz  	Ŀ��.Class
	 * @param message	�����Ϣ
	 */
	public static void error(Class<? extends Object> clazz ,String message){
		error(clazz, message, null);
	}
	/**
	 * �쳣���ֵ���
	 * @param clazz 	Ŀ��.Class
	 * @param fmtString	�����Ϣkey
	 * @param e			�쳣��
	 * @param value		�����Ϣvalue
	 */
	public static void fmtError(Class<? extends Object> clazz,Exception e,String fmtString,Object...value){
		if(StringUtils.isBlank(fmtString)){
			return ;
		}
		if(null != value && value.length != 0){
			fmtString = String.format(fmtString, value);
		}
		error(clazz, fmtString, e);
	}
	/**
	 * �쳣���ֵ���
	 * @param clazz		Ŀ��.Class
	 * @param fmtString �����Ϣkey
	 * @param value		�����Ϣvalue
	 */
	public static void fmtError(Class<? extends Object> clazz, String fmtString, Object...value) {
		if(StringUtils.isBlank(fmtString)){
			return ;
		}
		if(null != value && value.length != 0){
			fmtString = String.format(fmtString, value);
		}
		error(clazz, fmtString);
	}
}
