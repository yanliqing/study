package com.xiaomai.study.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;

import com.xiaomai.study.mail.MailSenderInfo;
import com.xiaomai.study.mail.SimpleMailSender;

public class Test {
	public static void main(String[] args) throws Exception {
	
//		List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
//	
//		for (int i = 0; i < 1000; i++) {
//			WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
//			d.put(new byte[1000][1000], new byte[1000][1000]);
//			maps.add(d);
//			System.gc();
//			System.err.println(i);
//	
//	
//		}
	         //这个类主要是设置邮件
//		  MailSenderInfo mailInfo = new MailSenderInfo(); 
//		  mailInfo.setMailServerHost("smtp.qq.com"); 
//		  mailInfo.setMailServerPort("25"); 
//		  mailInfo.setValidate(true); 
//		  mailInfo.setUserName("1034914256@qq.com"); 
//		  mailInfo.setPassword("78927aab43q");//您的邮箱密码 
//		  mailInfo.setFromAddress("1034914256@qq.com"); 
//		  mailInfo.setToAddress("1034914256@qq.com"); 
//		  mailInfo.setSubject("设置邮箱标题"); 
//		  mailInfo.setContent("设置邮箱内容"); 
//	         //这个类主要来发送邮件
//		  SimpleMailSender sms = new SimpleMailSender();
//	          sms.sendTextMail(mailInfo);//发送文体格式 
//	          sms.sendHtmlMail(mailInfo);//发送html格式
		System.out.println(UUID.randomUUID());

	}
}

