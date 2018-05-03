package com.zx.controller;

import java.util.List;

import com.zx.service.EmpService;
import com.zx.service.impl.EmpServiceImpl;

public class EmpController {
	
	private EmpService eService = new EmpServiceImpl();
	
	public static void main(String[] args) {
		
		/**
		 * 
		 MVC 设计模式   
		 M   model  模型
		 V   view   页面 jsp
		 C   controller  处理请求的
		 
		 1.		页面发送请求给controller   http://www.cnblogs.com/dongguacai/p/7197193.html?empId=1&empName=zhangsan
		 1.5 	controller 》 service 》 Dao
		 2.		controller 解析请求
		 3.		解析成功后传送给service进行业务逻辑处理
		 4.		service将处理完的数据封装成Dao层想要的模式
		 5.		dao层就把service传送过来的数据 进行数据库 持久化
		 6.		然后返回数据  dao 》  service 》 controller 
		  
		  springMVC
		 */
		EmpController eController = new EmpController();
		List queryEmp = eController.queryEmp();
		
		
		for (Object object : queryEmp) {
			System.out.println(object.toString());
		}
	}

	
	/**
	 * 处理页面请求  
	 * @return
	 */
	public List queryEmp(){
		
		// 解析完页面发送的请求  然后将参数传给service进行处理
		List empDatas = eService.getEmpDatas();
		return empDatas;
	}
	
	
	
}
