package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Mysql JDBC连接   insert 语句
 * @author Administrator
 *
 */
public class Test4 {
	
	public static void main(String[] args) {
		
		// 1.准备连接数据库的信息
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=utf8";
		String driver = "com.mysql.jdbc.Driver";
		
		Connection conn = null;
		try {
			//2. 注册驱动
			Class.forName(driver);
			
			System.out.println("驱动注册成功！！！");
			
			//3. 连接数据库 
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("数据库连接成功！");
			
			
			//4. 准备sql语句    ? 是jdbc的占位符
			String sql = "insert into employee (empName,empAge) values (?,?)";
			
			//5. 准备sql编译对象  编译sql语句
			//Statement cs = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//  给占位符 ? 赋值  1 代表第一个占位符    2代表第二个占位符    
			ps.setString(1, "hahah");
			ps.setInt(2, 55);
			
			//执行sql语句
			ps.executeUpdate();
			

			
		} catch (ClassNotFoundException e) {
			System.out.println("请检查你的驱动信息（jar）！！ ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("请检查你的连接信息！！");
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
	}

}
