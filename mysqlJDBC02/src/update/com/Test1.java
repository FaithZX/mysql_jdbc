package update.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


/**
 * ��ҳ
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
			
			/*Scanner input = new Scanner(System.in);
			
			System.out.println("���ʴӵڼ�����ʼ��ʾ����");
			
			int start = input.nextInt();
			
			System.out.println("ÿҳ��ʾ����������");
			
			int pageMax = input.nextInt();*/
			
			// ׼��sql���
			String sql = "delete from employee where empId = ?";
			
			//����sql
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, 18);
			
			// ִ��SQL���
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
