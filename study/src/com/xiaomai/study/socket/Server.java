package com.xiaomai.study.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) {
	try {
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(8800);
		Socket socket = serverSocket.accept();
		InputStream is = socket.getInputStream();
		BufferedReader br  = new BufferedReader(new InputStreamReader(is));
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		String info =null;
		while(!((info=br.readLine())==null)){
			System.out.println(info);
		}
		pw.write("welcom");
		pw.flush();
		pw.close();
		os.close();
		is.close();
		socket.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
