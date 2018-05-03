package dbUtils;

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

import com.sun.org.apache.bcel.internal.generic.NEW;

import sun.security.jca.GetInstance;
import sun.security.jca.GetInstance.Instance;



/**
 * JDBC������
 * @author Administrator
 *
 */
public class DBCPUtils {
	
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
	private DataSourceConnectionFactory connectionFactory = null;
	
	
	private DBCPUtils(){
		InputStream in = DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties p = new Properties();
		try {
			p.load(in);
			user = p.get("user").toString();
			password = p.get("password").toString();
			url = p.get("url").toString();
			driver = p.get("driver").toString();
			
			//�½�һ����������Դ
			BasicDataSource basicDataSource = new BasicDataSource();
			
			// �����û���
			basicDataSource.setUsername(user);
			// ��������
			basicDataSource.setPassword(password);
			// ���õ�ַ
			basicDataSource.setUrl(url);
			// �������ݿ�����
			basicDataSource.setDriverClassName(driver);
			
			// �������ݿ������
			//initialSize 	0 	��ʼ������:���ӳ�����ʱ�����ĳ�ʼ����������,1.2�汾��֧��
			/*basicDataSource.setInitialSize(10);
			//maxActive 	8 	�������:���ӳ���ͬһʱ���ܹ������������ӵ�����, �������Ϊ���������ʾ������
			basicDataSource.setMaxActive(20);
			//maxIdle 	8 	����������:���ӳ����������ֿ���״̬�������������,�����Ŀ������ӽ����ͷ�,�������Ϊ������ʾ������
			basicDataSource.setMaxIdle(20);
			//minIdle 	0 	��С��������:���ӳ����������ֿ���״̬����С��������,������������������µ�����,�������Ϊ0�򲻴���
			basicDataSource.setMinIdle(10);
			*/
			
			// �½�һ�����ݿ����ӹ���    ��������
			connectionFactory = new DataSourceConnectionFactory(basicDataSource);
			
		} catch (IOException e) {
			System.out.println("�����ļ���ȡʧ�ܣ�����");
			e.printStackTrace();
		}
	}
	
	private static DBCPUtils instance = null;
	
	
	
	/**
	 * ��ȡ���ݿ������ 
	 * @return java.sql.Connection
	 */
	public synchronized static DBCPUtils getInstance (){
		if(instance == null){
	 		// �������ݿ�
	 		//instance = connectionFactory.createConnection();
			instance = new DBCPUtils();
		}
		return instance;
	}
	
	// ��Ҫ���ڹܿ�ͬһ�̵߳����ݿ�����
	ThreadLocal<Connection> tLocal = new ThreadLocal<Connection>();
	
	/**
	 * ��ȡ���ݿ������ 
	 * @return java.sql.Connection
	 * 1 ����  tLocal = null;  ����һ������
	 * 2 ͬһ���߳�   tLocal  != null  ֱ��ȡtLocal
	 */
	public synchronized Connection getConnection(){
		Connection conn = null;
	 	try {
	 		if(tLocal.get() == null){
	 			// �������ݿ�
				conn = connectionFactory.createConnection();
				tLocal.set(conn);
	 		}
	 		conn = tLocal.get();
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
	public void close(Statement stas,ResultSet rs){
		try {
			if(null != rs)rs.close();
			if(null != stas)stas.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConn(){
		if(tLocal.get() != null){
			try {
				tLocal.get().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}