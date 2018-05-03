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

import sun.security.jca.GetInstance;
import sun.security.jca.GetInstance.Instance;



/**
 * JDBC工具类
 * @author Administrator
 *
 */
public class DBCPUtils {
	
	/**
	 * 连接数据库的用户名
	 */
	private String user = null;
	/**
	 * 连接数据库密码
	 */
	private String password = null;
	/**
	 * 连接数据库的地址
	 */
	private String url = null;
	/**
	 * 连接数据库的驱动
	 */
	private String driver = null;
	
	/**
	 * 数据库连接工厂
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
			
			//新建一个基础数据源
			BasicDataSource basicDataSource = new BasicDataSource();
			
			// 设置用户名
			basicDataSource.setUsername(user);
			// 设置密码
			basicDataSource.setPassword(password);
			// 设置地址
			basicDataSource.setUrl(url);
			// 设置数据库驱动
			basicDataSource.setDriverClassName(driver);
			
			// 配置数据库的连接
			//initialSize 	0 	初始化连接:连接池启动时创建的初始化连接数量,1.2版本后支持
			/*basicDataSource.setInitialSize(10);
			//maxActive 	8 	最大活动连接:连接池在同一时间能够分配的最大活动连接的数量, 如果设置为非正数则表示不限制
			basicDataSource.setMaxActive(20);
			//maxIdle 	8 	最大空闲连接:连接池中容许保持空闲状态的最大连接数量,超过的空闲连接将被释放,如果设置为负数表示不限制
			basicDataSource.setMaxIdle(20);
			//minIdle 	0 	最小空闲连接:连接池中容许保持空闲状态的最小连接数量,低于这个数量将创建新的连接,如果设置为0则不创建
			basicDataSource.setMinIdle(10);
			*/
			
			// 新建一个数据库连接工厂    进行生产
			connectionFactory = new DataSourceConnectionFactory(basicDataSource);
			
		} catch (IOException e) {
			System.out.println("配置文件读取失败！！！");
			e.printStackTrace();
		}
	}
	
	private static DBCPUtils instance = null;
	
	/**
	 * 获取数据库的连接 
	 * @return java.sql.Connection
	 */
	public static DBCPUtils getInstance (){
		if(instance == null){
	 		// 连接数据库
	 		//instance = connectionFactory.createConnection();
			instance = new DBCPUtils();
		}
		return instance;
	}
	
	
	/**
	 * 获取数据库的连接 
	 * @return java.sql.Connection
	 */
	public Connection getConnection(){
		Connection conn = null;
	 	try {
	 		// 连接数据库
			conn = connectionFactory.createConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取数据库连接失败");
		}
		return conn;
	}
	
	
	/**
	 * 关闭资源
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
