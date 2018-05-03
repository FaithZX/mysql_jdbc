package insert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


/**
 * 插入时返回主键
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
			
			System.out.println("请输入员工姓名！！");
			
			String name = input.next();
			
			// 准备sql语句
			String sql = "insert into employee (empName) values (?)";
			
			//编译sql
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, name);
			
			// 执行SQL语句
			ps.executeUpdate();
			
			
			//  返回key  主键
			ResultSet keys = ps.getGeneratedKeys();
			while(keys.next()){
				
				// 获取第一个主键
				int key = keys.getInt(1);
				
				
				System.out.println(key);
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
