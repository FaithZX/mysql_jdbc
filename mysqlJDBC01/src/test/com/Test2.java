package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Mysql JDBC连接    传参数的方式  注意sql注入
 * @author Administrator
 *
 */
public class Test2 {
	
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
			
			int sex = 2;
			
			//4. 准备sql语句
			String sql = "select * from employee where empSex = " + sex;
			
			//5. 准备sql编译对象  编译sql语句
			Statement cs = conn.createStatement();
			
			//执行sql语句
			ResultSet rs = cs.executeQuery(sql);
			
			
			//  获取数据
			while(rs.next()){
				
				int empId = rs.getInt(1);
				
				String empName = rs.getString(2);
				
				
				String empAge = rs.getString("empAge");
				int age = Integer.parseInt(empAge);
				
				System.out.println(empId + "  :  " + empName + "  :  " + age);
				
			}
			
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
