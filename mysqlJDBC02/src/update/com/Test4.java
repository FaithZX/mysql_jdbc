package update.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


/**
 * 更新
 * @author Administrator
 *
 */
public class Test4 {
	
	public static void main(String[] args) {
		
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/test1";
		String driver = "com.mysql.jdbc.Driver";
		Connection conn = null;
		PreparedStatement ps = null;
		
		
		try {
			// 注册驱动
			Class.forName(driver);
			// 连接数据库
			conn = DriverManager.getConnection(url, user, password);
			
			
			String sql2 = "update employee set empAge = 22,empSex = 2 where depId in (select depId from department where depName = ? )";
			//编译sql
			ps = conn.prepareStatement(sql2);
			
			//ps.setString(1, "zhang");
			ps.setString(1, "c++");
			
			// 执行SQL语句
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
	}

}
