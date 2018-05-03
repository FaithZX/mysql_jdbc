package insert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


/**
 * ����ʱ��������   ������(����ϵ��)
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
			// ע������
			Class.forName(driver);
			// �������ݿ�
			conn = DriverManager.getConnection(url, user, password);
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("����Ӳ��ţ���");
			
			String depName = input.next();
			
			System.out.println("������Ա����������");
			
			String name = input.next();
			
			
			// ׼��sql���
			String sql = "insert into department (depName) values (?)";
			
			// ׼��sql���
			String sql2 = "insert into employee (empName,depId) values (?,?)";
			
			//����sql
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, depName);
			
			// ִ��SQL���  �Դ� commit  ִ�������Ͼ��ύ
			ps.executeUpdate();
			
			
			//  ����key  ����
			ResultSet keys = ps.getGeneratedKeys();
			while(keys.next()){
				
				// ��ȡ��һ������
				key = keys.getInt(1);
				
				
				System.out.println(key);
			}
			
			//����sql2
			ps = conn.prepareStatement(sql2);
			
			ps.setString(1, name);
			ps.setInt(2, key);
			
			// ִ��SQL2���
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
