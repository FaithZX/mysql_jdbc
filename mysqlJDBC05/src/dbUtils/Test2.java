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
public class Test2 {
	public static void main(String[] args) throws SQLException {
		Long startTime = System.currentTimeMillis();
		//  DBCP  1000 需要的时间  599ms   10000 需要的事件  767ms   获取数据 1000 次 1922ms   1538ms
		/*for (int i = 0; i < 1000; i++) {
			Connection conn = DBCPUtils.getInstance().getConnection();
			
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
		}*/
		
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Long startTime = System.currentTimeMillis();
					
					for (int i = 0; i < 1000; i++) {
						Connection conn = DBCPUtils.getInstance().getConnection();
						//4. 准备sql语句
						String sql = "select count(*) from employee";
						//5. 准备sql编译对象  编译sql语句
						Statement cs;
						try {
							cs = conn.createStatement();
							//执行sql语句
							ResultSet rs = cs.executeQuery(sql);
							int count = 0;
							while(rs.next()){
								count = rs.getInt(1);
							}
							
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					Long endTime = System.currentTimeMillis();
					System.out.println(endTime - startTime  + "ms");
				}
			}).start();
		}
		
		
		

		
		
 		
	}

}
