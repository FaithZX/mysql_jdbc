package com.zx.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

import dbUtils.DBCPUtils;

public class ProxyServiceImpl<T> implements InvocationHandler {
	
	// 传一个对象
	private Object target;
	
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
		Connection connection =  null;
		try {
			connection = DBCPUtils.getInstance().getConnection();
			
			connection.setAutoCommit(false);
			
			method.invoke(target, args);
			
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DBCPUtils.getInstance().closeConn();
		}
		return null;
	}



}
