package dbUtils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.DataSourceConnectionFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.PoolBackedDataSource;

import sun.security.jca.GetInstance;
import sun.security.jca.GetInstance.Instance;



/**
 * JDBC������
 * @author Administrator
 *
 */
public class C3p0Utils {
	
	/**
	 * �������ݿ���û���
	 */
	private String user = null;
	/**
	 * �������ݿ�����
	 */
	private String password = null;
	/**
	 * �������ݿ�ĵ�ַ
	 */
	private String url = null;
	/**
	 * �������ݿ������
	 */
	private String driver = null;
	
	/**
	 * ���ݿ����ӹ���
	 */
	private ComboPooledDataSource c3p0 = null;
	
	
	private C3p0Utils(){
		InputStream in = C3p0Utils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties p = new Properties();
		try {
			p.load(in);
			user = p.get("user").toString();
			password = p.get("password").toString();
			url = p.get("url").toString();
			driver = p.get("driver").toString();
			
			
			c3p0 = new ComboPooledDataSource();
			
			
			// �����û���
			c3p0.setUser(user);
			// ��������
			c3p0.setPassword(password);
			// ���õ�ַ
			c3p0.setJdbcUrl(url);
			// �������ݿ�����
			c3p0.setDriverClass(driver);
			
			
			// �������ݿ������
			//initialSize 	0 	��ʼ������:���ӳ�����ʱ�����ĳ�ʼ����������,1.2�汾��֧��
			/*basicDataSource.setInitialSize(10);
			//maxActive 	8 	�������:���ӳ���ͬһʱ���ܹ������������ӵ�����, �������Ϊ���������ʾ������
			basicDataSource.setMaxActive(20);
			//maxIdle 	8 	����������:���ӳ��������ֿ���״̬�������������,�����Ŀ������ӽ����ͷ�,�������Ϊ������ʾ������
			basicDataSource.setMaxIdle(20);
			//minIdle 	0 	��С��������:���ӳ��������ֿ���״̬����С��������,������������������µ�����,�������Ϊ0�򲻴���
			basicDataSource.setMinIdle(10);
			*/
			
			
		} catch (IOException e) {
			System.out.println("�����ļ���ȡʧ�ܣ�����");
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static C3p0Utils instance = null;
	
	/**
	 * ��ȡ���ݿ������ 
	 * @return java.sql.Connection
	 */
	public static C3p0Utils getInstance (){
		if(instance == null){
	 		// �������ݿ�
	 		//instance = connectionFactory.createConnection();
			instance = new C3p0Utils();
		}
		return instance;
	}
	
	
	/**
	 * ��ȡ���ݿ������ 
	 * @return java.sql.Connection
	 */
	public Connection getConnection(){
		Connection conn = null;
	 	try {
	 		// �������ݿ�
			conn = c3p0.getConnection();
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
	public void close(Connection conn, Statement stas,ResultSet rs){
		try {
			if(null != rs)rs.close();
			if(null != stas)stas.close();
			if(null != conn)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
