package dbUtils;

import java.util.List;
import java.util.Map;



/**
 * @author Administrator
 *
 */
public class Test2 {
	
	public static void main(String[] args) {
		//String sql = "select emp_id,emp_name name,password,emp_age age,dep_id from employee where emp_id > ? and emp_name = ? group by emp_name HAVING AVG(emp_age) > ? ";
		String sql = "select emp_id,emp_name name,password,emp_age age,dep_id from employee where emp_id > ? ";
		List<Employee> entityDatas = DBHelper.getEntityDatas(sql, new Object[]{10}, null, null, Employee.class);
		
		for (Employee employee : entityDatas) {
			System.out.println(employee.toString());
		}
	
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				
			}
		}).start();
 		
	}

}
