package com.zx.dao;

import java.sql.SQLException;

import com.zx.entity.Employee;


public interface EmpDao {

	/**
	 * ����һ������ 
	 * @return  ��������
	 */
	public int addDep(String depName) throws SQLException ;
	
	/**
	 * ����һ��Ա��
	 */
	public void addEmp(Employee emp) throws SQLException ;
}
