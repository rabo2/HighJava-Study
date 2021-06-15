package kr.or.ddit.basic.stream;

import java.io.FileReader;

public class FileIOTest03 {
	public static void main(String[] args) {
		//문자기반의 스트림을 이용하여 파일내용 읽어와 출력하기
		try {
		//입력용 문자 기반 스트림 객체 생성
		FileReader fr = new FileReader("d:/d_other/test.txt");
		int c; 
		while((c=fr.read()) != -1) {
			System.out.print((char)c);
		}
		fr.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
