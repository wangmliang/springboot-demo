/*
 * LinuxUtil.java
 * �����л��������Ƽ����޹�˾
 * All rights reserved.
 * -----------------------------------------------
 * 2018��4��19�� ����4:24:48 Created
 */
package com.wml.springboot.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LinuxԶ�̲���������
 * <pre>
 * <b>@ClassName��</b>LinuxUtil.java<br/>
 * <b>@author��</b>Miles<br/>
 * <b>@E-mail��</b>miles@lan360.com<br/>
 * <b>@date��</b>2018��4��19�� - ����4:24:48<br/>  
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class LinuxUtil {

	private static Logger logger = LoggerFactory.getLogger(LinuxUtil.class);

	// Ĭ���ļ�����
	public static final String SSR_FILE_NAME = "shadowsocks.json";
	// Ĭ���ļ��洢Ŀ¼
	public static final String LINUX_FINT_DIRECTORY = "/etc/" + SSR_FILE_NAME;
	// Ĭ������˺Ŵ洢λ��(������˺�ǰ��)
	public static final String DEFAULT_ACCOUNT_INFO = "\t\t\"-999\": \"wml_test\"";

	/**
	 * �����ļ�·����/etc/shadowsocks.json
	 * ��־�ļ�·����/var/log/shadowsocks.log
	 */
	/** ���� */
	public static final String START_SERVICE = "/etc/init.d/shadowsocks start";
	/** ֹͣ */
	public static final String STOP_SERVICE = "/etc/init.d/shadowsocks stop";
	/** ���� */
	public static final String RESTART_SERVICE = "/etc/init.d/shadowsocks restart";
	/** ״̬ */
	public static final String STATUS_SERVICE = "/etc/init.d/shadowsocks status";

	// �ַ�����Ĭ����utf-8
	private static String DEFAULTCHART = "UTF-8";

	/**
	 * ���Ӷ���
	 */
	private Connection conn;

	/**
	 * IP��ַ
	 */
	private String ip;

	/**
	 * �û���
	 */
	private String userName;

	/**
	 * ��¼����
	 */
	private String userPwd;

	public static void setCharset(String charset) {
		DEFAULTCHART = charset;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public LinuxUtil(String ip, String userName, String userPwd) {
		this.ip = ip;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public LinuxUtil() {

	}

	/**
	 * Զ�̵�¼linux������
	 * @author wml
	 * @since V0.1
	 * @return ��¼�ɹ�����true�����򷵻�false
	 */
	public Boolean login() {
		boolean flg = false;
		try {
			// ���ӻỰΪnull��ʶû�н�������
			conn = new Connection(ip);
			conn.connect();// ����
			flg = conn.authenticateWithPassword(userName, userPwd);// ��֤
		} catch (IOException e) {
			logger.error("Զ�̵�¼������ʧ�ܣ�" + e.getMessage(), e);
		}
		return flg;
	}

	/**
	 * Զ��ִ��shll�ű���������
	 * @author Wml
	 * @param cmd ����ִ�е�����
	 * @return ����ִ����󷵻صĽ��ֵ
	 * @since V0.1
	 */
	public String execute(String cmd) {
		String result = "";
		try {
			if (login()) {
				Session session = conn.openSession();// ��һ���Ự
				session.execCommand(cmd);// ִ������
				result = processStdout(session.getStdout(), DEFAULTCHART);
				// ���Ϊ�õ���׼���Ϊ�գ�˵���ű�ִ�г�����
				if (StringUtils.isBlank(result)) {
					result = processStdout(session.getStderr(), DEFAULTCHART);
				}
				conn.close();
				session.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Զ��ִ��shll�ű���������
	 * @author Wml
	 * @param cmd ����ִ�е�����
	 * @return ����ִ�гɹ��󷵻صĽ��ֵ���������ִ��ʧ�ܣ����ؿ��ַ���������null
	 * @since V0.1
	 */
	public String executeSuccess(String cmd) {
		String result = "";
		try {
			if (login()) {
				Session session = conn.openSession();// ��һ���Ự
				session.execCommand(cmd);// ִ������
				result = processStdout(session.getStdout(), DEFAULTCHART);
				conn.close();
				session.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �����ű�ִ�з��صĽ����
	 * @author Wml
	 * @param in ����������
	 * @param charset ����
	 * @since V0.1
	 * @return �Դ��ı��ĸ�ʽ����
	 */
	private String processStdout(InputStream in, String charset) {
		InputStream stdout = new StreamGobbler(in);
		StringBuffer buffer = new StringBuffer();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(stdout, charset));
			String line = null;
			while ((line = br.readLine()) != null) {
				buffer.append(line + "\n");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}

	/**
	 * Զ�̻�ȡ�������ļ�
	 * @param remoteFile	�������ļ�Ŀ¼
	 * @param localTargetDirectory ���ش��Ŀ¼(��Ҫ�ȴ���)
	 */
	public void getFile(String remoteFile, String localTargetDirectory) {
		try {
			if(login()) {
				SCPClient client = new SCPClient(conn);
				client.get(remoteFile, localTargetDirectory);
				conn.close();
			}
		} catch (IOException e) {
			logger.error("Զ�̶�ȡ�ļ��쳣��" + e.getMessage(), e);
		}
	}

	/**
	 * �ϴ��ļ�
	 * @param localFile	�����ļ�
	 * @param remoteTargetDirectory	������Ŀ¼
	 */
	public void putFile(String localFile, String remoteTargetDirectory) {
		try {
			if(login()) {
				SCPClient client = new SCPClient(conn);
				client.put(localFile, remoteTargetDirectory);
				conn.close();
			}
		} catch (IOException e) {
			logger.error("Զ���ϴ��ļ��쳣��" + e.getMessage(), e);
		}
	}


	/**
	 * �ϴ��ļ�
	 * @param localFile	�����ļ�
	 * @param remoteFileName	�������ļ���
	 * @param remoteTargetDirectory	������Ŀ¼
	 * @param mode
	 */
	public void putFile(String localFile, String remoteFileName,String remoteTargetDirectory,String mode) {
		try {
			if(login()) {
				SCPClient client = new SCPClient(conn);
				if ((mode == null) || (mode.length() == 0)) {
					mode = "0600";
				}
				client.put(localFile, remoteFileName, remoteTargetDirectory, mode);

				//������
				ch.ethz.ssh2.Session sess = conn.openSession();
				String tmpPathName = remoteTargetDirectory + File.separator + remoteFileName;
				String newPathName = tmpPathName.substring(0, tmpPathName.lastIndexOf("."));
				sess.execCommand("mv " + remoteFileName + " " + newPathName);//����������

				conn.close();
			}
		} catch (IOException e) {
			logger.error("Զ���ϴ��ļ��쳣��" + e.getMessage(), e);
		}
	}

	/**
	 * ��д�ļ�
	 * @param file		�ļ�Ŀ¼
	 * @param newStr	������˺���Ϣ
	 * @return
	 */
	public static boolean modifyFileContent(String file, String newStr) {
		try {
			/* ����TXT�ļ� */
			FileReader reader = new FileReader(file);//����һ��fileReader����������ʼ��BufferedReader
			BufferedReader bReader = new BufferedReader(reader);//newһ��BufferedReader���󣬽��ļ����ݶ�ȡ������
			StringBuilder sb = new StringBuilder();//����һ���ַ������棬���ַ�����Ż�����
			String s = "";
			while ((s =bReader.readLine()) != null) {//���ж�ȡ�ļ����ݣ�����ȡ���з���ĩβ�Ŀո�
				sb.append(s + "\n");//����ȡ���ַ�����ӻ��з����ۼӴ���ڻ�����
			}
			bReader.close();
			// �滻�ı�������˺�
			String configTxt = sb.toString();
			configTxt = configTxt.replace(DEFAULT_ACCOUNT_INFO, newStr);

			/* д��Txt�ļ�*/
			File writename = new File(file); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
			// writename.createNewFile(); // �������ļ�
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(configTxt); // \r\n��Ϊ����
			out.flush(); // �ѻ���������ѹ���ļ�
			out.close(); // ���ǵùر��ļ�
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	public static void main(String[] args) {
		ssrOperating("45.77.223.60", "root", "Nf4_ybkg=_?CG{$V", "603", "lan360");
	}

	/**
	 * ��ȡ�ļ�Ŀ¼���б�
	 * @param dir
	 * @return
	 */
	public static List<String> getFileDir(String dir, String ip, String userName, String password) {
		LinuxUtil rec = new LinuxUtil(ip, userName, password);
		String success = rec.execute("ls /etc/shadowsocks_back" + (StringUtils.isBlank(dir) ? "" : "/" + dir));
		List<String> list = new ArrayList<>();
		String[] sp = success.split("\n");
		for (String i : sp) {
			list.add(i);
			System.out.println(i);
		}
		return list;
	}

	public static int number = 0;

	/**
	 * SSR��������
	 * @param ip	������Id
	 * @param userName	�������û���
	 * @param password	����������
	 * @param ssrPort		SSR�˿�
	 * @param ssrPassword	SSR����
	 */
	public static void ssrOperating(String ip, String userName, String password, String ssrPort, String ssrPassword) {
		boolean flag = false;
		String backFileName = "";
		LinuxUtil rec = null;
		String backDir = "/etc/shadowsocks_back/" + getTime(1);

		try {
			rec = new LinuxUtil(ip, userName, password);
			backFileName = "/shadowsocks_" + getTime(2) + ".json";

			// ���������ļ�����Ŀ¼(�������򴴽�)
			rec.execute("mkdir " + backDir);
			// ���ݲ���ǰ�����ļ�
			rec.executeSuccess("cp /etc/shadowsocks.json " + backDir + backFileName);

			//ִ������
			rec.getFile("/etc/shadowsocks.json", "C://wml");

			String str = "\t\t\"" + ssrPort + "\": \"" + ssrPassword + "\",\n" + DEFAULT_ACCOUNT_INFO;
			modifyFileContent("c://wml/" + SSR_FILE_NAME, str);

			// �����ϴ������ļ�
			rec.putFile("c://wml/" + SSR_FILE_NAME, "/etc");
			number++;

			// ����SSR����
			rec.execute(RESTART_SERVICE);
		} catch(Exception e) {
			flag = true;
			logger.error(e.getMessage(), e);
		} finally {
			// �����쳣�ع���ǰ������
			if(flag && number >= 1) {
				// �ع���ǰSSR����
				callbackSSR(backFileName, backDir, rec);
			}
		}
	}

	/**
	 * �ع���ǰ������
	 * @param backFileName
	 * @param backDir
	 * @param linuxUtil
	 */
	public static void callbackSSR(String backFileName, String backDir, LinuxUtil linuxUtil) {
		if(null == linuxUtil)
			return;

		// ɾ����ǰ�����ļ�
		linuxUtil.executeSuccess("rm -f /etc/shadowsocks.json");

		// ��ԭConfig�ļ�
		linuxUtil.executeSuccess("cp " + (StringUtils.isBlank(backDir) ? backFileName : backDir  + backFileName) + " /etc/shadowsocks.json");

		// ��������
		linuxUtil.execute(RESTART_SERVICE);
	}

	/**
	 * ָ���汾��ԭSR����
	 * @param version
	 */
	public void reductionSSR(String version) {
		callbackSSR(version, null, null);
	}

	/**
	 * ��ȡϵͳʱ��
	 * @return
	 */
	public static String getTime(Integer type) {
		if(type == 1) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(new Date());
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			return sdf.format(new Date());
		}
	}
}
