package com.zx.controller;

import java.util.List;

import com.zx.service.EmpService;
import com.zx.service.impl.EmpServiceImpl;

public class EmpController {
	
	private EmpService eService = new EmpServiceImpl();
	
	public static void main(String[] args) {
		
		/**
		 * 
		 MVC ���ģʽ   
		 M   model  ģ��
		 V   view   ҳ�� jsp
		 C   controller  ���������
		 
		 1.		ҳ�淢�������controller   http://www.cnblogs.com/dongguacai/p/7197193.html?empId=1&empName=zhangsan
		 1.5 	controller �� service �� Dao
		 2.		controller ��������
		 3.		�����ɹ����͸�service����ҵ���߼�����
		 4.		service������������ݷ�װ��Dao����Ҫ��ģʽ
		 5.		dao��Ͱ�service���͹��������� �������ݿ� �־û�
		 6.		Ȼ�󷵻�����  dao ��  service �� controller 
		  
		  springMVC
		 */
		EmpController eController = new EmpController();
		List queryEmp = eController.queryEmp();
		
		
		for (Object object : queryEmp) {
			System.out.println(object.toString());
		}
	}

	
	/**
	 * ����ҳ������  
	 * @return
	 */
	public List queryEmp(){
		
		// ������ҳ�淢�͵�����  Ȼ�󽫲�������service���д���
		List empDatas = eService.getEmpDatas();
		return empDatas;
	}
	
	
	
}
