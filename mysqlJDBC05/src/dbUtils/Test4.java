package dbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator
 *
 */
public class Test4 {
	public static void main(String[] args) throws SQLException {
		
		
		
		Long startTime = System.currentTimeMillis();
		//  普通的JDBC  1000 需要的时间  12761ms
		/*for (int i = 0; i < 1000; i++) {
			Connection conn = DBUtils.getConnection();
			
			conn.close();
		}
		*/
		
		
		// c3p0  1000 需要的时间  12761ms   1000数据   1979ms
		for (int i = 0; i < 1000; i++) {
			Connection conn = C3p0Utils.getInstance().getConnection();
			
			//4. 准备sql语句
			String sql = "select count(*) from employee";
			
			//5. 准备sql编译对象  编译sql语句
			Statement cs = conn.createStatement();
			
			//执行sql语句
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
