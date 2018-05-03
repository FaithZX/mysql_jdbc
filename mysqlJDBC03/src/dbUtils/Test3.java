package dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * @author Administrator
 *
 */
public class Test3 {
	
	public static void main(String[] args) {
		
		Connection conn = DBUtils.getConnection();
		try {
			conn.setAutoCommit(false);
			
			String sql = "insert into department (depName) values (?)";
			String sql2 = "insert into employee (empName,empAge,depId) values (?,?,?)";
			
			int key = (int) DBHelper.executeSql(sql, new Object[]{"54444"},true, conn);
			DBHelper.executeSql(sql2, new Object[]{"54444",33,key}, conn);
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("sql语句执行出错！！ 已经回滚！！");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
		
	}

}
