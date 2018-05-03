package service2.com;


/**
 * 厂商的实现
 * @author Administrator
 *
 */
public class ProductServiceImpl implements ProductService {

	@Override
	public String save(String name,int price) {
		System.out.println("生产了一个：" + name + "   厂商指导价：" + price);
		return "返回："+name;
	}

	@Override
	public String query(String name,int price) {
		System.out.println("查询一个" + name + "   厂商售价：" + price);
		return "返回" + name;
	}

}
