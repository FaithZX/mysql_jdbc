package com.zx.service.impl;

import java.util.List;

import com.zx.dao.EmpDao;
import com.zx.dao.impl.EmpDaoImpl;
import com.zx.service.EmpService;

/**
 * controller  ��   dao���м��    ��Ҫ�����߼�����(�����㷨)���ݷ�װ
 * @author Administrator
 *
 */
public class EmpServiceImpl implements EmpService{
	
	private EmpDao eDao = new EmpDaoImpl();

	@Override
	public List getEmpDatas() {
		
		System.out.println("���в����װ ���߼�������");
		
		List emp = eDao.getEmp();
		
		System.out.println("�������ݿ��ѯ�����Ľ�����������ݣ�����");
		return emp;
	}

}
