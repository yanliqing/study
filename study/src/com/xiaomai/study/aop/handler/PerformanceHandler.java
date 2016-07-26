package com.xiaomai.study.aop.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.xiaomai.study.aop.monitor.PerformanceMoitor;

public class PerformanceHandler implements InvocationHandler{
	private Object target;

	public PerformanceHandler(Object target) {//target为目标的业务类
		this.target = target;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		PerformanceMoitor.begin(target.getClass().getName()+"."+method.getName());
		Object obj =method.invoke(target, args);
		PerformanceMoitor.end();
		return obj;
	}

}
