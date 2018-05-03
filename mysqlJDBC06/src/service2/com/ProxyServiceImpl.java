package service2.com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyServiceImpl<T> implements InvocationHandler {
	
	// 传一个对象
	private Object target;
	
	// 绑定一个代理对象
	/*public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}*/
	public T bind(Class clazz){
		try {
			this.target = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		//  把厂商包装成代理商
		return (T)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("我是奸商！！");
		
		if(null != args && args.length > 1 && args[1].getClass() == Integer.class){
			args[1] = Integer.parseInt(args[1].toString()) + 10000;
			System.out.println(args[1]);
		}
		
		// target =  new ProductServiceImpl  反射机制  bind.save("锤子", 10);
		Object returns = method.invoke(target, args);
		
		
		
		System.out.println(returns + "---------------");
		
		System.out.println("卖出去了 ！！ 赚发了！！");
		return null;
	}



}
