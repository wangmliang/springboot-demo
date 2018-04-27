/*
 * LinuxUtil.java
 * 深圳市互缆众联科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018年4月19日 下午4:24:48 Created
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
 * Linux远程操作工具类
 * <pre>
 * <b>@ClassName：</b>LinuxUtil.java<br/>
 * <b>@author：</b>Miles<br/>
 * <b>@E-mail：</b>miles@lan360.com<br/>
 * <b>@date：</b>2018年4月19日 - 下午4:24:48<br/>  
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class LinuxUtil {

	private static Logger logger = LoggerFactory.getLogger(LinuxUtil.class);

	// 默认文件名称
	public static final String SSR_FILE_NAME = "shadowsocks.json";
	// 默认文件存储目录
	public static final String LINUX_FINT_DIRECTORY = "/etc/" + SSR_FILE_NAME;
	// 默认添加账号存储位置(在这个账号前面)
	public static final String DEFAULT_ACCOUNT_INFO = "\t\t\"-999\": \"wml_test\"";

	/**
	 * 配置文件路径：/etc/shadowsocks.json
	 * 日志文件路径：/var/log/shadowsocks.log
	 */
	/** 启动 */
	public static final String START_SERVICE = "/etc/init.d/shadowsocks start";
	/** 停止 */
	public static final String STOP_SERVICE = "/etc/init.d/shadowsocks stop";
	/** 重启 */
	public static final String RESTART_SERVICE = "/etc/init.d/shadowsocks restart";
	/** 状态 */
	public static final String STATUS_SERVICE = "/etc/init.d/shadowsocks status";

	// 字符编码默认是utf-8
	private static String DEFAULTCHART = "UTF-8";

	/**
	 * 连接对象
	 */
	private Connection conn;

	/**
	 * IP地址
	 */
	private String ip;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 登录密码
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
	 * 远程登录linux的主机
	 * @author wml
	 * @since V0.1
	 * @return 登录成功返回true，否则返回false
	 */
	public Boolean login() {
		boolean flg = false;
		try {
			// 连接会话为null标识没有建立连接
			conn = new Connection(ip);
			conn.connect();// 连接
			flg = conn.authenticateWithPassword(userName, userPwd);// 认证
		} catch (IOException e) {
			logger.error("远程登录服务器失败：" + e.getMessage(), e);
		}
		return flg;
	}

	/**
	 * 远程执行shll脚本或者命令
	 * @author Wml
	 * @param cmd 即将执行的命令
	 * @return 命令执行完后返回的结果值
	 * @since V0.1
	 */
	public String execute(String cmd) {
		String result = "";
		try {
			if (login()) {
				Session session = conn.openSession();// 打开一个会话
				session.execCommand(cmd);// 执行命令
				result = processStdout(session.getStdout(), DEFAULTCHART);
				// 如果为得到标准输出为空，说明脚本执行出错了
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
	 * 远程执行shll脚本或者命令
	 * @author Wml
	 * @param cmd 即将执行的命令
	 * @return 命令执行成功后返回的结果值，如果命令执行失败，返回空字符串，不是null
	 * @since V0.1
	 */
	public String executeSuccess(String cmd) {
		String result = "";
		try {
			if (login()) {
				Session session = conn.openSession();// 打开一个会话
				session.execCommand(cmd);// 执行命令
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
	 * 解析脚本执行返回的结果集
	 * @author Wml
	 * @param in 输入流对象
	 * @param charset 编码
	 * @since V0.1
	 * @return 以纯文本的格式返回
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
	 * 远程获取服务器文件
	 * @param remoteFile	服务器文件目录
	 * @param localTargetDirectory 本地存放目录(需要先创建)
	 */
	public void getFile(String remoteFile, String localTargetDirectory) {
		try {
			if(login()) {
				SCPClient client = new SCPClient(conn);
				client.get(remoteFile, localTargetDirectory);
				conn.close();
			}
		} catch (IOException e) {
			logger.error("远程读取文件异常：" + e.getMessage(), e);
		}
	}

	/**
	 * 上传文件
	 * @param localFile	本地文件
	 * @param remoteTargetDirectory	服务器目录
	 */
	public void putFile(String localFile, String remoteTargetDirectory) {
		try {
			if(login()) {
				SCPClient client = new SCPClient(conn);
				client.put(localFile, remoteTargetDirectory);
				conn.close();
			}
		} catch (IOException e) {
			logger.error("远程上传文件异常：" + e.getMessage(), e);
		}
	}


	/**
	 * 上传文件
	 * @param localFile	本地文件
	 * @param remoteFileName	待更新文件名
	 * @param remoteTargetDirectory	服务器目录
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

				//重命名
				ch.ethz.ssh2.Session sess = conn.openSession();
				String tmpPathName = remoteTargetDirectory + File.separator + remoteFileName;
				String newPathName = tmpPathName.substring(0, tmpPathName.lastIndexOf("."));
				sess.execCommand("mv " + remoteFileName + " " + newPathName);//重命名回来

				conn.close();
			}
		} catch (IOException e) {
			logger.error("远程上传文件异常：" + e.getMessage(), e);
		}
	}

	/**
	 * 读写文件
	 * @param file		文件目录
	 * @param newStr	待添加账号信息
	 * @return
	 */
	public static boolean modifyFileContent(String file, String newStr) {
		try {
			/* 读入TXT文件 */
			FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
			BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
			StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
			String s = "";
			while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
				sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
			}
			bReader.close();
			// 替换文本，添加账号
			String configTxt = sb.toString();
			configTxt = configTxt.replace(DEFAULT_ACCOUNT_INFO, newStr);

			/* 写入Txt文件*/
			File writename = new File(file); // 相对路径，如果没有则要建立一个新的output。txt文件
			// writename.createNewFile(); // 创建新文件
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(configTxt); // \r\n即为换行
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	public static void main(String[] args) {
		ssrOperating("45.77.223.60", "root", "Nf4_ybkg=_?CG{$V", "603", "lan360");
	}

	/**
	 * 读取文件目录夹列表
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
	 * SSR操作蜂蜜
	 * @param ip	服务器Id
	 * @param userName	服务器用户名
	 * @param password	服务器密码
	 * @param ssrPort		SSR端口
	 * @param ssrPassword	SSR密码
	 */
	public static void ssrOperating(String ip, String userName, String password, String ssrPort, String ssrPassword) {
		boolean flag = false;
		String backFileName = "";
		LinuxUtil rec = null;
		String backDir = "/etc/shadowsocks_back/" + getTime(1);

		try {
			rec = new LinuxUtil(ip, userName, password);
			backFileName = "/shadowsocks_" + getTime(2) + ".json";

			// 创建备份文件报错目录(不存在则创建)
			rec.execute("mkdir " + backDir);
			// 备份操作前配置文件
			rec.executeSuccess("cp /etc/shadowsocks.json " + backDir + backFileName);

			//执行命令
			rec.getFile("/etc/shadowsocks.json", "C://wml");

			String str = "\t\t\"" + ssrPort + "\": \"" + ssrPassword + "\",\n" + DEFAULT_ACCOUNT_INFO;
			modifyFileContent("c://wml/" + SSR_FILE_NAME, str);

			// 重新上传配置文件
			rec.putFile("c://wml/" + SSR_FILE_NAME, "/etc");
			number++;

			// 重启SSR服务
			rec.execute(RESTART_SERVICE);
		} catch(Exception e) {
			flag = true;
			logger.error(e.getMessage(), e);
		} finally {
			// 发生异常回滚当前操作项
			if(flag && number >= 1) {
				// 回滚当前SSR配置
				callbackSSR(backFileName, backDir, rec);
			}
		}
	}

	/**
	 * 回滚当前操作项
	 * @param backFileName
	 * @param backDir
	 * @param linuxUtil
	 */
	public static void callbackSSR(String backFileName, String backDir, LinuxUtil linuxUtil) {
		if(null == linuxUtil)
			return;

		// 删除当前配置文件
		linuxUtil.executeSuccess("rm -f /etc/shadowsocks.json");

		// 还原Config文件
		linuxUtil.executeSuccess("cp " + (StringUtils.isBlank(backDir) ? backFileName : backDir  + backFileName) + " /etc/shadowsocks.json");

		// 重启服务
		linuxUtil.execute(RESTART_SERVICE);
	}

	/**
	 * 指定版本还原SR配置
	 * @param version
	 */
	public void reductionSSR(String version) {
		callbackSSR(version, null, null);
	}

	/**
	 * 获取系统时间
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