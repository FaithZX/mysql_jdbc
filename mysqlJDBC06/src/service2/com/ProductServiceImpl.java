package service2.com;


/**
 * ���̵�ʵ��
 * @author Administrator
 *
 */
public class ProductServiceImpl implements ProductService {

	@Override
	public String save(String name,int price) {
		System.out.println("������һ����" + name + "   ����ָ���ۣ�" + price);
		return "���أ�"+name;
	}

	@Override
	public String query(String name,int price) {
		System.out.println("��ѯһ��" + name + "   �����ۼۣ�" + price);
		return "����" + name;
	}

}
