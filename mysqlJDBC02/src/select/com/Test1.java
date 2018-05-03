package select.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


/**
 * 分页
 * @author Administrator
 *
 */
public class Test1 {
	
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
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("请问从第几条开始显示？？");
			
			int start = input.nextInt();
			
			System.out.println("每页显示多少条？？");
			
			int pageMax = input.nextInt();
			
			// 准备sql语句
			String sql = "select * from employee limit ?,?";
			
			//编译sql
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, start);
			ps.setInt(2, pageMax);
			
			// 执行SQL语句
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				
				System.out.println(empId + "   :   " + empName);
			}
			
			
			
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
