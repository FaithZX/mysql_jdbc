package service.com;

public class ProxyServiceImpl implements ProductService {

	
	private ProductService productService;
	
	public ProxyServiceImpl(ProductService service){
		this.productService = service;
	}
	
	@Override
	public String save(String name,int price) {
		System.out.println("�����˴����̣���");
		price += 1000;
		
		
		productService.save("�߼���"+name ,price);
		
		
		
		System.out.println("����ȥ��");
		return null;
	}

	@Override
	public String query(String name,int price) {
		System.out.println("�����˴����̣���");
		price += 1000;
		productService.query("�߼���"+name,price);
		System.out.println("����ȥ��");
		return null;
	}

}
