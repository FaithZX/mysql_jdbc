package update.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * ��������
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
			// ע������
			Class.forName(driver);
			// �������ݿ�
			conn = DriverManager.getConnection(url, user, password);
			
			
			String sql = "insert into employee ( empName ) values ( ? ) ";
			
			//����sql
			ps = conn.prepareStatement(sql);
			//ps.setString(1, "1020xxx");
			
			for (int i = 1051; i <= 1060; i++) {
			
				
				//  �ȸ�ռλ����ֵ
				ps.setString(1, i + "xxx");
				// ���  ����
				ps.addBatch();
				
				
				System.out.println(i);
			}
			
			// ִ��SQL���
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
