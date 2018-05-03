package com.zx.service.impl;

import java.util.List;

import com.zx.dao.EmpDao;
import com.zx.dao.impl.EmpDaoImpl;
import com.zx.service.EmpService;

/**
 * controller  和   dao的中间层    主要进行逻辑处理(复杂算法)数据封装
 * @author Administrator
 *
 */
public class EmpServiceImpl implements EmpService{
	
	private EmpDao eDao = new EmpDaoImpl();

	@Override
	public List getEmpDatas() {
		
		System.out.println("进行仓鼠封装 ，逻辑处理！！");
		
		List emp = eDao.getEmp();
		
		System.out.println("进行数据库查询出来的结果集处理数据！！！");
		return emp;
	}

}
