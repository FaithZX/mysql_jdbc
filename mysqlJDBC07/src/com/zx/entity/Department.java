package com.zx.entity;

public class Department {

	
	private Integer depId;
	private String depName;
	public Integer getDepId() {
		return depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + "]";
	}
	
	
	
	
	
}
