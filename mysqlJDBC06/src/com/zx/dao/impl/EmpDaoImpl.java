package com.zx.dao.impl;

import java.util.List;

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
	public List getEmp() {
		String sql = "select * from employee";
		List entityDatas = DBHelper.getEntityDatas(sql, new Object[]{}, Employee.class);
		return entityDatas;
	}

}
