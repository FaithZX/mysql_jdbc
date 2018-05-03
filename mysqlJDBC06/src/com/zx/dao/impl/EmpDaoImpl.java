package com.zx.dao.impl;

import java.util.List;

import com.zx.dao.EmpDao;
import com.zx.entity.Employee;

import dbUtils.DBHelper;


/**
 * 进行数据库连接   获取出具库数据    怎删改查
 * 不建议在这一层进行逻辑处理
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
