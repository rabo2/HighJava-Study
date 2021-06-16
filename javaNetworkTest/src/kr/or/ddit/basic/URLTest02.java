package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest02 {
	public static void main(String[] args) throws IOException {
		//URLConnection => 애플리케이션과 URL간의 통신연결을 위한 클래스
		
		//특정서버의 정보와 파일내용을 가져와 출력하는 예제
		URL url = new URL("https://www.naver.com/index.html");
		
		//URLConnection 객체 구하기 => URL객체를 이용해서 구한다.
		URLConnection urlCon = url.openConnection();
		
		//Header 정보 가져오기  
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();
		
		//headerMap의 key값과 value값 출력
		for (String headerKey : headerMap.keySet()) {
			System.out.println(headerKey +" : "+headerMap.get(headerKey));
		}
		System.out.println("--------------------------------------------");
		System.out.println();
		
		//해당 문서의 내용을 가져오기(지금은 index.html문서 내용 가져오기)
		
		//방법 1 =>URLConnection객체를 이용하는 방법
		
		
		//파일을 읽어오기 위한 스트림 객체 생성
		InputStream is = urlCon.getInputStream();
		//바이트 기반 입력을 문자기반 입력으로 변경
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		//스트림 객체를 이용해서 자료를 읽어와 출력하기
		while(true) {
			//한줄씩 읽기
			String str = br.readLine();
			if(str == null) {
				break;
			}
			System.out.println(str);
		}
		br.close();
		
		
		//방법2 => URL객체의 openStream()메소드 이용
		
		
		InputStream is2 = url.openStream();
		BufferedReader br2 = new BufferedReader(
				new InputStreamReader(is2, "utf-8"));
		
		BufferedWriter bw = 
				new BufferedWriter(
						new FileWriter("d:/d_other/naver.html"));
		
		while(true) {
			String str2 = br2.readLine();
			if(str2 == null) {
				break;
			}
//			System.out.println(str2);
			bw.write(str2);
		}
		br2.close();
		System.out.println("작업 완료...");
	}
}
