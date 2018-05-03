package update.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 批量插入
 * @author Administrator
 *
 */
public class Test5 {
	
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
			
			
			String sql = "insert into employee ( empName ) values ( ? ) ";
			
			//编译sql
			ps = conn.prepareStatement(sql);
			//ps.setString(1, "1020xxx");
			
			for (int i = 1051; i <= 1060; i++) {
			
				
				//  先给占位符赋值
				ps.setString(1, i + "xxx");
				// 添加  批量
				ps.addBatch();
				
				
				System.out.println(i);
			}
			
			// 执行SQL语句
			ps.executeBatch();
			
			
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
