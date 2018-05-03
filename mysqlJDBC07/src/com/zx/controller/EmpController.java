package com.zx.controller;

import java.sql.SQLException;

import com.zx.entity.Employee;
import com.zx.service.EmpService;
import com.zx.service.impl.EmpServiceImpl;
import com.zx.service.proxy.ProxyServiceImpl;

public class EmpController {
	public static void main(String[] args) {
		
		/*Connection connection = DBCPUtils.getInstance().getConnection();
		Connection connection2 = DBCPUtils.getInstance().getConnection();
		
		System.out.println(connection == connection2);
		System.out.println(connection.equals(connection2));
		System.out.println(connection2);
		System.out.println(connection);*/
		
		
		/*EmpService eService = new EmpServiceImpl();
		Employee emp = new Employee();
		emp.setEmpName("20180110");
		emp.setPassword(123456789);
		emp.setDelete_flag("1");
		eService.addDepAndEmp("研发部2", emp);*/
		
		
		Employee emp = new Employee();
		emp.setEmpName("20180111");
		emp.setPassword(123456789);
		emp.setDelete_flag("1");
		
		ProxyServiceImpl<EmpServiceImpl> proxyService = new ProxyServiceImpl<EmpServiceImpl>();
		
		EmpService bind = proxyService.bind(EmpServiceImpl.class);
		
		try {
			bind.addDepAndEmp("研发部4", emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
