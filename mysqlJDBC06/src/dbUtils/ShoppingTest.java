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
		System.out.println("#######################��ӭ����XXX�̳ǹ���ϵͳ###########################");
		System.out.println("���¼");
		Scanner input = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = input.next();
		System.out.println("���������룡");
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
				System.out.println("��¼�ɹ�������");
				index();
			}else{
				System.out.println("��¼ʧ�� ,���������룡����");
				login();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void index(){
		System.out.println("#######################��ӭ����XXX�̳ǹ���ϵͳ###########################");
		System.out.println("1.��Ʒ����");
		System.out.println("2.��Ա����");
		System.out.println("��ѡ������Ҫ�����ҳ��");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		if(num == 1){
			shoppingAndProduct();
		}else{
			
		}
	}
	
	public void shoppingAndProduct(){
		System.out.println("#######################��ӭ����XXX�̳ǹ���ϵͳ###########################");
		System.out.println("1.��ѯ������Ʒ");
		System.out.println("2.�����Ʒ");
		System.out.println("3.ɾ����Ʒ");
		System.out.println("4.������Ʒ");
		System.out.println("5.������");
		System.out.println("��ѡ������Ҫ�����ҳ��");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		if(num == 1){
			
		}else{
			
		}
	}

}
