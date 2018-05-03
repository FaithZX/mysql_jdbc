package com.zx.dao;

import java.sql.SQLException;

import com.zx.entity.Employee;


public interface EmpDao {

	/**
	 * 插入一个部门 
	 * @return  返回主键
	 */
	public int addDep(String depName) throws SQLException ;
	
	/**
	 * 插入一个员工
	 */
	public void addEmp(Employee emp) throws SQLException ;
}
