package com.xiaomai.study.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
public static void main(String[] args) {
	DatagramSocket socket;
	try {
		socket = new DatagramSocket(8800);
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		String message = new String(buf,0,packet.getLength());
		System.out.println(message);
		socket.close();
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
