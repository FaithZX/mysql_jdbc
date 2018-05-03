package service.com;


/**
 * 静态代理
 * @author Administrator
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProductService pService = new ProductServiceImpl();
		
		pService.query("苹果",10);
		pService.save("锤子",10);
		
		System.out.println("======================================================");
		
		ProductService proxyService = new ProxyServiceImpl(pService);
		proxyService.query("小辣椒",10);
		proxyService.save("苹果",10);
		

	}

}
