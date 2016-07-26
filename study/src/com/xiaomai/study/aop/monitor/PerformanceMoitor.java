package com.xiaomai.study.aop.monitor;

public class PerformanceMoitor {
	private static ThreadLocal<MethodPerformance> local = new ThreadLocal<MethodPerformance>();
	
	public static void begin(String method){
		MethodPerformance performance = new MethodPerformance(method);
		local.set(performance);
	}
	
	public static void end(){
		MethodPerformance performance =local.get();
		performance.printPerformance();
	}
}
