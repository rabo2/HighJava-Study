package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

//이 클래스는 소켓에서 메시지를 받아서 화면에 출력하는 역활을 담당하는 Thread
public class Receiver extends Thread{
	private Socket socket;
	private DataInputStream dis;
	
	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void run() {
		while(dis != null) {
			try {
				System.out.println(dis.readUTF());
			} catch (IOException e) {
			}
		}
	}
}
