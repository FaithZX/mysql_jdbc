package com.zx.dao.impl;

import java.sql.SQLException;

import com.zx.dao.EmpDao;
import com.zx.entity.Employee;

import dbUtils.DBHelper;


/**
 * �������ݿ�����   ��ȡ���߿�����    ��ɾ�Ĳ�
 * ����������һ������߼�����
 * @author Administrator
 *
 */
public class EmpDaoImpl implements EmpDao {

	@Override
	public int addDep(String depName) throws SQLException {
		String sql = "insert into department (dep_name) values (?) ";
		Object key = DBHelper.executeUpdateSql(sql, new Object[]{depName}, true);
		return (int) key;
	}

	@Override
	public void addEmp(Employee emp) throws SQLException {
		String sql = "insert into employee (emp_name,password,dep_id,delete_flag) values (?,?,?,?) ";
		DBHelper.executeUpdateSql(sql, new Object[]{emp.getEmpName(),emp.getPassword(),emp.getDepId(),emp.getDelete_flag()});
	}



}
