package com.xiaomai.study.aop.proxy;

import java.lang.reflect.Method;

import com.xiaomai.study.aop.monitor.PerformanceMoitor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz){
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		PerformanceMoitor.begin(obj.getClass().getName()+"."+method.getName());
		Object result = proxy.invokeSuper(obj, args);
		PerformanceMoitor.end();
		return result;
	}

}
