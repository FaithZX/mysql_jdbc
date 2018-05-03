package dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator
 *
 */
public class Test3 {
	public static void main(String[] args) throws SQLException {
		Long startTime = System.currentTimeMillis();
		
		
		//  ��ͨ��JDBC  1000 ��Ҫ��ʱ��  12761ms   1000��ȡ����  15168ms
		/*for (int i = 0; i < 1000; i++) {
			Connection conn = DBUtils.getConnection();
			//4. ׼��sql���
			String sql = "select count(*) from employee";
			
			//5. ׼��sql�������  ����sql���
			Statement cs = conn.createStatement();
			
			//ִ��sql���
			ResultSet rs = cs.executeQuery(sql);
			int count = 0;
			while(rs.next()){
				count = rs.getInt(1);
			}
			
			System.out.println(count);
			conn.close();
		}*/
		
		//  DBCP  1000 ��Ҫ��ʱ��  599ms   10000 ��Ҫ���¼�  767ms   ��ȡ���� 1000 �� 1922ms   1538ms
		for (int i = 0; i < 1000; i++) {
			Connection conn = DBCPUtils.getInstance().getConnection();
			
			//4. ׼��sql���
			String sql = "select count(*) from employee";
			
			//5. ׼��sql�������  ����sql���
			Statement cs = conn.createStatement();
			
			//ִ��sql���
			ResultSet rs = cs.executeQuery(sql);
			int count = 0;
			while(rs.next()){
				count = rs.getInt(1);
			}
			
			System.out.println(count);
			
			conn.close();
		}
		
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime  + "ms");
		

		
		
 		
	}

}
