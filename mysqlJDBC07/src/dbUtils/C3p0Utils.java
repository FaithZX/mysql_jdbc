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
 * JDBC工具类
 * @author Administrator
 *
 */
public class C3p0Utils {
	
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
			
			
			// 设置用户名
			c3p0.setUser(user);
			// 设置密码
			c3p0.setPassword(password);
			// 设置地址
			c3p0.setJdbcUrl(url);
			// 设置数据库驱动
			c3p0.setDriverClass(driver);
			
			
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
			
			
		} catch (IOException e) {
			System.out.println("配置文件读取失败！！！");
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static C3p0Utils instance = null;
	
	/**
	 * 获取数据库的连接 
	 * @return java.sql.Connection
	 */
	public static C3p0Utils getInstance (){
		if(instance == null){
	 		// 连接数据库
	 		//instance = connectionFactory.createConnection();
			instance = new C3p0Utils();
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
			conn = c3p0.getConnection();
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
