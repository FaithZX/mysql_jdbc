package dbUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 */
public class Test1 {
	public static void main(String[] args) throws SQLException {
		
		
		//  普通的JDBC  1000 需要的时间  12761ms
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Connection conn = DBUtils.getConnection();
			
			conn.close();
		}
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime  + "ms");
 		
	}

}
