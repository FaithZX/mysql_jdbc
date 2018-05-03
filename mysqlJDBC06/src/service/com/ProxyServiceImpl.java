package service.com;

public class ProxyServiceImpl implements ProductService {

	
	private ProductService productService;
	
	public ProxyServiceImpl(ProductService service){
		this.productService = service;
	}
	
	@Override
	public String save(String name,int price) {
		System.out.println("进入了代理商！！");
		price += 1000;
		
		
		productService.save("高级："+name ,price);
		
		
		
		System.out.println("卖出去了");
		return null;
	}

	@Override
	public String query(String name,int price) {
		System.out.println("进入了代理商！！");
		price += 1000;
		productService.query("高级："+name,price);
		System.out.println("卖出去了");
		return null;
	}

}
