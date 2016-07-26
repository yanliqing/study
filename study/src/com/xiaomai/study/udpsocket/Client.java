package com.xiaomai.study.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
public static void main(String[] args) {
	String message = "dsfskdjfskjfs";
	InetAddress ia = null ;
	byte[] buf = message.getBytes();
	try {
		 ia = InetAddress.getByName("localhost");
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int port = 8800;
	DatagramPacket dp = new DatagramPacket(buf, buf.length, ia, port);
	DatagramSocket socket = null;
	try {
		 socket = new DatagramSocket();
	} catch (SocketException e) {
		e.printStackTrace();
	}
	try {
		socket.send(dp);
	} catch (IOException e) {
		e.printStackTrace();
	}
	socket.close();
}
}
