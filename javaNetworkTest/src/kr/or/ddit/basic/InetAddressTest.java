package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress 클래스 => ip주소를 다루기 위한 클래스
		
		//www.naver.com의 ip정보 가져오기
		InetAddress naverIp = InetAddress.getByName("www.daum.net");
		
		System.out.println("Host Name : " + naverIp.getHostName());
		System.out.println("Host Address : " + naverIp.getHostAddress());
		System.out.println("toString : " + naverIp.toString());
		
		//자신의 컴퓨터의 IP정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("Host Name : " + localIp.getHostName());
		System.out.println("Host Address : " + localIp.getHostAddress());
		System.out.println("toString : " + localIp.toString());
		
		
		//IP주소가 여러개인 Host의 정보 가져오기
		InetAddress[] ips = InetAddress.getAllByName("www.naver.com");
		for (InetAddress inetAddressP : ips) {
			System.out.println(inetAddressP);
		}
		
	}
}
