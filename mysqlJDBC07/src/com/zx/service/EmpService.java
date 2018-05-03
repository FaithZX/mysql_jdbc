package com.zx.service;

import java.sql.SQLException;

import com.zx.entity.Employee;


public interface EmpService {

	public void addDepAndEmp(String depName,Employee emp) throws SQLException ;
}
