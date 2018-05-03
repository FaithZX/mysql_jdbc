package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Mysql JDBC����
 * @author Administrator
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		
		// 1.׼���������ݿ����Ϣ
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/test1";
		String driver = "com.mysql.jdbc.Driver";
		
		Connection conn = null;
		try {
			//2. ע������
			Class.forName(driver);
			
			System.out.println("����ע��ɹ�������");
			
			//3. �������ݿ� 
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("���ݿ����ӳɹ���");
			
			
			//4. ׼��sql���
			String sql = "select * from employee";
			
			//5. ׼��sql�������  ����sql���
			Statement cs = conn.createStatement();
			
			//ִ��sql���
			ResultSet rs = cs.executeQuery(sql);
			
			
			//  ��ȡ����
			while(rs.next()){
				
				int empId = rs.getInt(1);
				
				String empName = rs.getString(2);
				
				
				String empAge = rs.getString("empAge");
				int age = Integer.parseInt(empAge);
				
				System.out.println(empId + "  :  " + empName + "  :  " + age);
				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("�������������Ϣ��jar������ ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("�������������Ϣ����");
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
