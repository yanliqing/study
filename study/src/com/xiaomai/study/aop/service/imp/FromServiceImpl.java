package com.xiaomai.study.aop.service.imp;

import com.xiaomai.study.aop.monitor.PerformanceMoitor;
import com.xiaomai.study.aop.service.FromService;

public class FromServiceImpl implements FromService{

	@Override
	public void removeForum(int formId) {
		System.out.println("模拟删除Forum记录"+formId);
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeTopic(int topicId) {
		System.out.println("模拟删除Topic记录"+topicId);
		try {
			Thread.currentThread().sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
