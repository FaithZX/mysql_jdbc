package service.com;


/**
 * ��̬����
 * @author Administrator
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProductService pService = new ProductServiceImpl();
		
		pService.query("ƻ��",10);
		pService.save("����",10);
		
		System.out.println("======================================================");
		
		ProductService proxyService = new ProxyServiceImpl(pService);
		proxyService.query("С����",10);
		proxyService.save("ƻ��",10);
		

	}

}
