package insert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


/**
 * 插入时返回主键   多表插入(带关系的)
 * @author Administrator
 *
 */
public class Test2 {
	
	public static void main(String[] args) {
		
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/test1";
		String driver = "com.mysql.jdbc.Driver";
		Connection conn = null;
		PreparedStatement ps = null;
		int key = 0;
		
		try {
			// 注册驱动
			Class.forName(driver);
			// 连接数据库
			conn = DriverManager.getConnection(url, user, password);
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("请添加部门！！");
			
			String depName = input.next();
			
			System.out.println("请输入员工姓名！！");
			
			String name = input.next();
			
			
			// 准备sql语句
			String sql = "insert into department (depName) values (?)";
			
			// 准备sql语句
			String sql2 = "insert into employee (empName,depId) values (?,?)";
			
			//编译sql
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, depName);
			
			// 执行SQL语句  自带 commit  执行完马上就提交
			ps.executeUpdate();
			
			
			//  返回key  主键
			ResultSet keys = ps.getGeneratedKeys();
			while(keys.next()){
				
				// 获取第一个主键
				key = keys.getInt(1);
				
				
				System.out.println(key);
			}
			
			//编译sql2
			ps = conn.prepareStatement(sql2);
			
			ps.setString(1, name);
			ps.setInt(2, key);
			
			// 执行SQL2语句
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
