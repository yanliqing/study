package com.xiaomai.study.aop;

import java.lang.reflect.Proxy;

import com.xiaomai.study.aop.handler.PerformanceHandler;
import com.xiaomai.study.aop.proxy.CglibProxy;
import com.xiaomai.study.aop.service.FromService;
import com.xiaomai.study.aop.service.imp.FromServiceImpl;

public class TestForumService {
	public static void main(String[] args) {
//		FromServiceImpl serviceImpl = new FromServiceImpl();
//		serviceImpl.removeForum(40);
//		serviceImpl.removeTopic(20);
		
		
		FromService fromService = new FromServiceImpl(); 
		PerformanceHandler handler = new PerformanceHandler(fromService);
		FromService proxy = (FromService) Proxy.newProxyInstance(fromService.getClass().getClassLoader(), fromService.getClass().getInterfaces(), handler);
		proxy.removeForum(40);
		proxy.removeTopic(20);
		
		
		CglibProxy proxy = new CglibProxy();
		FromServiceImpl fromServiceImpl = (FromServiceImpl) proxy.getProxy(FromServiceImpl.class);
		fromServiceImpl.removeForum(40);
		fromServiceImpl.removeTopic(20);
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
	}
}
