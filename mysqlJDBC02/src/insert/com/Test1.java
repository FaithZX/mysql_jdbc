package insert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


/**
 * ����ʱ��������
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
			// ע������
			Class.forName(driver);
			// �������ݿ�
			conn = DriverManager.getConnection(url, user, password);
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("������Ա����������");
			
			String name = input.next();
			
			// ׼��sql���
			String sql = "insert into employee (empName) values (?)";
			
			//����sql
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, name);
			
			// ִ��SQL���
			ps.executeUpdate();
			
			
			//  ����key  ����
			ResultSet keys = ps.getGeneratedKeys();
			while(keys.next()){
				
				// ��ȡ��һ������
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
