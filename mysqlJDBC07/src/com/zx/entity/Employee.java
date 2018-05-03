package com.zx.entity;


/**
 * 实体类   命名方式是驼峰式命名  
 * 所对应着数据的字段   列如： 数据库字段名叫 emp_id == 实体类命名方式  empId
 * @author Administrator
 *
 */
public class Employee {
	
	
	private Integer empId;
	private String empName;
	private Integer empAge;
	private Integer empSex;
	private Integer password;
	private String delete_flag;
	private Integer depId;
	
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	public Integer getEmpSex() {
		return empSex;
	}
	public void setEmpSex(Integer empSex) {
		this.empSex = empSex;
	}
	public Integer getPassword() {
		return password;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public String getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
	public Integer getDepId() {
		return depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empAge=" + empAge + ", empSex=" + empSex + ", password="
				+ password +  ", delete_flag="
				+ delete_flag + "]";
	}
	
	
	
	

}
