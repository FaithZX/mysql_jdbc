package service2.com;


/**
 * ��̬����
 * @author Administrator
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// �½�һ�����ܵĴ���
		ProxyServiceImpl<ProductServiceImpl> proxyServiceImpl = new ProxyServiceImpl<ProductServiceImpl>();
		// �����ܵĴ����ProductServiceImpl  ������һ�������̣�ProductService bind
		ProductService bind = proxyServiceImpl.bind(ProductServiceImpl.class);
		bind.save("����", 10);
		
		
		
		System.out.println("---------------------------------------------------");
		ProxyServiceImpl<EmployeeServiceImpl> proxyServiceImpl2 = new ProxyServiceImpl<EmployeeServiceImpl>();
		Employee bind2 = proxyServiceImpl2.bind(EmployeeServiceImpl.class);

		bind2.add("����");
		
	}

}
