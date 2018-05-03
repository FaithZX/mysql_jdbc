package com.zx.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.zx.dao.EmpDao;
import com.zx.dao.impl.EmpDaoImpl;
import com.zx.entity.Employee;
import com.zx.service.EmpService;

import dbUtils.DBCPUtils;

/**
 * controller  ��   dao���м��    ��Ҫ�����߼�����(�����㷨)���ݷ�װ
 * @author Administrator
 *
 */
public class EmpServiceImpl implements EmpService{
	
	private EmpDao eDao = new EmpDaoImpl();

	@Override
	public void addDepAndEmp(String depName,Employee emp) throws SQLException {
		try {
			int depId = eDao.addDep(depName);
			emp.setDepId(depId);
			eDao.addEmp(emp);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}



}
