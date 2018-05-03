package dbUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * 静态代理(奸商)   and      动态代理       (spring AOP(面向切面编程) )
 * 
 * 静态代理
 *   厂家 A类(华为手机10元)       代理 B类(10+100元)          C类(110元)
 * 
 * spring AOP面向切面编程
 * 植入一段代码   system.out.print("早上好！！");  并且不影响原代码
 * system.out.print("今天天气不错！！");
 * 
 * 
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
