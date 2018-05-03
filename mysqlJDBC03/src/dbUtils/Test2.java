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
public class Test2 {
	
	public static void main(String[] args) {
		Map<String, Object[]> sqlAndParams = new HashMap<String, Object[]>();
		
		
		String sql = "insert into department (depName) values (?)";
		sqlAndParams.put(sql,  new Object[]{"54444"});
		
		String sql2 = "insert into employee (empName,empAge) values (?,?)";
		sqlAndParams.put(sql2, new Object[]{"54333",33});
		
		
		DBHelper.executeUpdateSqls(sqlAndParams);
		

		
		
		
	}

}
