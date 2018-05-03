package service2.com;

public class EmployeeServiceImpl implements Employee {

	@Override
	public void add(String name) {
		System.out.println("添加一个人！！" + name);

	}

}
