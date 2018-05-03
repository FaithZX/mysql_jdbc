package update.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


/**
 * ɾ��     ����н�����ϵ�ı�   ��Ҫ��ɾ�� /�޸�    ������ı��ֵ   (������ĸ�����Ȳ����Ǹ���)
 * @author Administrator
 *
 */
public class Test3 {
	
	public static void main(String[] args) {
		
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/test1";
		String driver = "com.mysql.jdbc.Driver";
		Connection conn = null;
		PreparedStatement ps = null;
		
		//  ע����Ҫ�����һ����     �˴�û�����������
		try {
			// ע������
			Class.forName(driver);
			// �������ݿ�
			conn = DriverManager.getConnection(url, user, password);
			
			
			// ׼��sql���
			String sql = "delete from department where depId = ?";
			
			
			
			//  ���� ����  ���Ը���Ϊnull   ǰ�����ֶ�����Ϊnull
			String sql2 = "update employee set depId = null where depId = ?";
			//����sql
			ps = conn.prepareStatement(sql2);
			
			ps.setInt(1, 8);
			
			// ִ��SQL���
			ps.executeUpdate();
			
			
			//����sql
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, 8);
			
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
