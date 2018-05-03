package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShoppingTest {
	
	public static void main(String[] args) {
		ShoppingTest st = new ShoppingTest();
		st.login();
	}
	
	public void login(){
		System.out.println("#######################欢迎来到XXX商城管理系统###########################");
		System.out.println("请登录");
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名！");
		String username = input.next();
		System.out.println("请输入密码！");
		String password = input.next();
		String sql = "select count(*) from employee where emp_name = ? and password = ? ";
		Connection connection = DBCPUtils.getInstance().getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if(count > 0){
				System.out.println("登录成功！！！");
				index();
			}else{
				System.out.println("登录失败 ,请重新输入！！！");
				login();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void index(){
		System.out.println("#######################欢迎进入XXX商城管理系统###########################");
		System.out.println("1.商品管理");
		System.out.println("2.会员管理");
		System.out.println("请选择你需要进入的页面");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		if(num == 1){
			shoppingAndProduct();
		}else{
			
		}
	}
	
	public void shoppingAndProduct(){
		System.out.println("#######################欢迎进入XXX商城管理系统###########################");
		System.out.println("1.查询所有商品");
		System.out.println("2.添加商品");
		System.out.println("3.删除商品");
		System.out.println("4.更新商品");
		System.out.println("5.库存管理");
		System.out.println("请选择你需要进入的页面");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		if(num == 1){
			
		}else{
			
		}
	}

}
