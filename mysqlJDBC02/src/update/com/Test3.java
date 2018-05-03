package update.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


/**
 * 删除     如果有建立关系的表   需要先删除 /修改    有外键的表的值   (外键在哪个表就先操作那个表)
 * @author Administrator
 *
 */
public class Test3 {
	
	public static void main(String[] args) {
		
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/test1";
		String driver = "com.mysql.jdbc.Driver";
		Connection conn = null;
		PreparedStatement ps = null;
		
		//  注意需要事物的一致性     此处没有有添加事物
		try {
			// 注册驱动
			Class.forName(driver);
			// 连接数据库
			conn = DriverManager.getConnection(url, user, password);
			
			
			// 准备sql语句
			String sql = "delete from department where depId = ?";
			
			
			
			//  更新 数据  可以更新为null   前提是字段允许为null
			String sql2 = "update employee set depId = null where depId = ?";
			//编译sql
			ps = conn.prepareStatement(sql2);
			
			ps.setInt(1, 8);
			
			// 执行SQL语句
			ps.executeUpdate();
			
			
			//编译sql
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, 8);
			
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
