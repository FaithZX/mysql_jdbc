package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * sql 封装
 * @author Administrator
 *
 */
public class DBHelper {
	
	/**
	 * 主要进行sql语句执行，这里是自动提交事务 并且已经关闭了资源
	 * 注意：几个占位符就需要传入几个参数
	 * @param sql 传进来的sql语句  类似于：insert into table (tableName) values (?)
	 * @param params 参数   类似与：new Object []{"参数1","参数2","参数3","参数4","参数5",...}
	 * @param autoGeneratedkeys  Boolean类型的   false就是不需要返回主键，true就是需要返回主键
	 * @return 返回的是一个主键  如果没有就返回null
	 */
	public static Object executeUpdateSql(String sql,Object [] params,Boolean autoGeneratedkeys){
		Connection conn = null;
		PreparedStatement ps = null;
		Integer key = null;
		//编译sql
		try {
			// 连接数据库
			conn = DBUtils.getConnection();
			
			if(autoGeneratedkeys){
				ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			}else{
				ps = conn.prepareStatement(sql);
			}
			
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			// 执行SQL语句
			ps.executeUpdate();
			
			if(autoGeneratedkeys){
				ResultSet keys = ps.getGeneratedKeys();
				while(keys.next()){
					key = keys.getInt(1);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn, ps, null);
		}
		
		return key;
		
	}
	
	
	/**
	 * 主要进行sql语句执行，这里是自动提交事务 并且已经关闭了资源
	 * 注意：几个占位符就需要传入几个参数
	 * @param sql 传进来的sql语句  类似于：insert into table (tableName) values (?)
	 * @param params 参数   类似与：new Object []{"参数1","参数2","参数3","参数4","参数5",...}
	 */
	public static void executeUpdateSql(String sql,Object [] params){
		DBHelper.executeUpdateSql(sql, params, false);
	}
	
	
	/**
	 * 
	 * @param sqlAndParams   Map<String, Object[]>  key 对应的是sql   value对应的是上sql所对应的参数
	 */
	public static void executeUpdateSqls(Map<String, Object[]> sqlAndParams){
		Connection conn = null;
		PreparedStatement ps = null;
		//编译sql
		try {
			// 连接数据库
			conn = DBUtils.getConnection();
			
			conn.setAutoCommit(false);
			
			Set<Entry<String, Object[]>> entrySet = sqlAndParams.entrySet();
			
			for (Entry<String, Object[]> entry : entrySet) {
				String sql = entry.getKey();
				Object[] params = entry.getValue();
				
				ps = conn.prepareStatement(sql);
				
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
				// 执行SQL语句
				ps.executeUpdate();
			}
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("sql执行出错！！ 已经回滚！");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DBUtils.close(conn, ps, null);
		}
	}
	
	
	/**
	 * 需要手动管控事物 ，也是就说数据库连接需要当做参数传入进来
	 * @param sql 传进来的sql语句  类似于：insert into table (tableName) values (?)
	 * @param params 参数   类似与：new Object []{"参数1","参数2","参数3","参数4","参数5",...}
	 * @param autoGeneratedkeys  Boolean类型的   false就是不需要返回主键，true就是需要返回主键
	 * @return 返回的是一个主键  如果没有就返回null
	 * @param conn  数据库连接   java.sql.Connection 对像
	 * @return  返回的 insert sql 执行后往数据库插入的数据的 主键
	 * @throws SQLException  抛出异常   谁调用的我我就抛给谁，注意需要铺货异常。
	 */
	public static Object executeSql(String sql,Object [] params,Boolean autoGeneratedkeys,Connection conn) throws SQLException{
		PreparedStatement ps = null;
		Integer key = null;
			
		if(autoGeneratedkeys){
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		}else{
			ps = conn.prepareStatement(sql);
		}
		
		for (int i = 0; i < params.length; i++) {
			ps.setObject(i+1, params[i]);
		}
		// 执行SQL语句
		ps.executeUpdate();
		
		if(autoGeneratedkeys){
			ResultSet keys = ps.getGeneratedKeys();
			while(keys.next()){
				key = keys.getInt(1);
			}
		}
		
		return key;
		
	}
	
	public static void executeSql(String sql,Object [] params,Connection conn) throws SQLException{
		DBHelper.executeSql(sql, params, conn);
	}
	
	
	
	

}
