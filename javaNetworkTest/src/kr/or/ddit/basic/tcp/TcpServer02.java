package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {
	public static void main(String[] args) throws IOException {
		//ServerSocket을 만들고, 클라이언트가 접속해 오면 소켓을 만들어서
		//메시지를 받는 Thread와 메시지를 보내는 Thread에 이 소켓을 넘겨준다.
		ServerSocket server = new ServerSocket(7777);
		
		System.out.println("서버가 준비중 입니다.");
		
		//socket을 반복시켜 List에 담으면 멀티채팅 가능
		Socket socket = server.accept();
		System.out.println("클라이언트와 연결되었습니다.");
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
	}
}
