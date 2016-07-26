package com.xiaomai.study.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
public static void main(String[] args) {
	Socket socket;
	try {
		socket = new Socket("127.0.0.1",8800);
		PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    pw.println("hello");
	    String line = br.readLine();
	    System.out.println("========"+line);

	    br.close();
	    pw.close();
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
