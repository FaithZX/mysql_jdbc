package service2.com;


/**
 * 静态代理
 * @author Administrator
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 新建一个万能的代理
		ProxyServiceImpl<ProductServiceImpl> proxyServiceImpl = new ProxyServiceImpl<ProductServiceImpl>();
		// 将万能的代理绑定ProductServiceImpl  诞生了一个代理商：ProductService bind
		ProductService bind = proxyServiceImpl.bind(ProductServiceImpl.class);
		bind.save("锤子", 10);
		
		
		
		System.out.println("---------------------------------------------------");
		ProxyServiceImpl<EmployeeServiceImpl> proxyServiceImpl2 = new ProxyServiceImpl<EmployeeServiceImpl>();
		Employee bind2 = proxyServiceImpl2.bind(EmployeeServiceImpl.class);

		bind2.add("张三");
		
	}

}
