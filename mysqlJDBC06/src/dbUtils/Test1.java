package dbUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * ��̬����(����)   and      ��̬����       (spring AOP(����������) )
 * 
 * ��̬����
 *   ���� A��(��Ϊ�ֻ�10Ԫ)       ���� B��(10+100Ԫ)          C��(110Ԫ)
 * 
 * spring AOP����������
 * ֲ��һ�δ���   system.out.print("���Ϻã���");  ���Ҳ�Ӱ��ԭ����
 * system.out.print("��������������");
 * 
 * 
 * @author Administrator
 *
 */
public class Test1 {
	public static void main(String[] args) throws SQLException {
		
		
		//  ��ͨ��JDBC  1000 ��Ҫ��ʱ��  12761ms
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Connection conn = DBUtils.getConnection();
			
			conn.close();
		}
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime  + "ms");
 		
	}

}
