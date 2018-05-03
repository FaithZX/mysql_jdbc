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
 * JDBC工具类
 * @author Administrator
 *
 */
public class DBUtils {
	
	/**
	 * 连接数据库的用户名
	 */
	static String user = null;
	/**
	 * 连接数据库密码
	 */
	static String password = null;
	/**
	 * 连接数据库的地址
	 */
	static String url = null;
	/**
	 * 连接数据库的驱动
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
			System.out.println("配置文件读取失败！！！");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动注册失败！！！");
		}
	}
	
	
	/**
	 * 获取数据库的连接 
	 * @return java.sql.Connection
	 */
	public static Connection getConnection(){
		Connection conn = null;
		
	 	try {
	 		// 连接数据库
			conn = DriverManager.getConnection(url, user, password);
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
