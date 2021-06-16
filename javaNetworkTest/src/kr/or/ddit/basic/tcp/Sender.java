package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

//이 클래스는 소켓을 통해서 메시지를 보내는 역활을 담당하는 Thread클래스이다.
public class Sender extends Thread{
	private Socket socket;
	private	DataOutputStream dos;
	private String name;
	private Scanner scan;
	
	public Sender(Socket socket) {
		this.socket = socket;
		this.scan = new Scanner(System.in);
		
		System.out.print("이름을 입력 >> ");
		this.name = scan.nextLine();
		
		try {
			this.dos = new DataOutputStream(socket.getOutputStream());
		}catch(Exception e) {
			
		}
	}

	@Override
	public void run() {
		while(dos != null) {
			try {
				dos.writeUTF(name + " : " + scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
