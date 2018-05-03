package dbUtils;

import java.util.List;
import java.util.Map;



/**
 * @author Administrator
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
		//limit  ? , ?  
		String sql = "select empId,empName name,password,empAge age from employee where empId > ? and empName = ? group by empName HAVING AVG(empAge) > ? ";
		
		List<Map<String, Object>> datas = DBHelper.getDatas(sql, new Object[]{10,"hahah",10},null,null);
		
		for (Map<String, Object> map : datas) {
			for (String key : map.keySet()) {
				System.out.println(key + " : "  + map.get(key) );
			}
		}
 		
	}

}
