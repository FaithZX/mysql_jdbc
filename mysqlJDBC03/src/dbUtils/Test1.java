package dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


/**
 * @author Administrator
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		// ×¼±¸sqlÓï¾ä
		//String sql = "insert into employee (empName) values (?)";
		//DBHelper.executeUpdateSql(sql, new Object[]{"54321"});
		
		String sql = "insert into employee (empName,empAge) values (?,?)";
		DBHelper.executeUpdateSql(sql, new Object[]{"54322",88});
		
		String sql2 = "insert into employee (empName,empAge) values (?,?)";
		int key = (int) DBHelper.executeUpdateSql(sql2, new Object[]{"54333",66},true);
		
		System.out.println(key);
		
	}

}
