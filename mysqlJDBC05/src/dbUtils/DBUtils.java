package dbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



/**
 * JDBC������
 * @author Administrator
 *
 */
public class DBUtils {
	
	/**
	 * �������ݿ���û���
	 */
	static String user = null;
	/**
	 * �������ݿ�����
	 */
	static String password = null;
	/**
	 * �������ݿ�ĵ�ַ
	 */
	static String url = null;
	/**
	 * �������ݿ������
	 */
	static String driver = null;
	
	
	static {
		InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties p = new Properties();
		try {
			p.load(in);
			user = p.get("user").toString();
			password = p.get("password").toString();
			url = p.get("url").toString();
			driver = p.get("driver").toString();
			Class.forName(driver);
		} catch (IOException e) {
			System.out.println("�����ļ���ȡʧ�ܣ�����");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("����ע��ʧ�ܣ�����");
		}
	}
	
	
	/**
	 * ��ȡ���ݿ������ 
	 * @return java.sql.Connection
	 */
	public static Connection getConnection(){
		Connection conn = null;
		
	 	try {
	 		// �������ݿ�
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ȡ���ݿ�����ʧ��");
		}
		return conn;
	}
	
	
	/**
	 * �ر���Դ
	 * @param conn java.sql.Connection
	 * @param stas java.sql.Statement
	 * @param rs   java.sql.ResultSet
	 */
	public static void close(Connection conn, Statement stas,ResultSet rs){
			try {
				if(null != rs)rs.close();
				if(null != stas)stas.close();
				if(null != conn)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
	}
	

}
