package kr.or.ddit.basic.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 할글이 저장될 파일 읽어오기(한글의 인코징 방식으로 출력한다.
 */
public class FileIOTest05 {
	public static void main(String[] args) {
		try {
//			FileReader fr = new FileReader("d:/d_other/test_ansi.txt");
//			FileReader fr = new FileReader("d:/d_other/test_utf8.txt");
			
			FileInputStream fis = new FileInputStream("d:/d_other/test_utf8");
			
			//기본 인코딩 방식으로 읽어온다.
//			InputStreamReader isr = new InputStreamReader(fis);
			
//			인코딩 방식을 지정해서 읽어오기
//			인코딩 방식 예시
//			-MS949  => 윈도우의 기본할 글 인코딩 방식(ANSI와 같다.)
//			-UTF-8 => 유니코드 UTF-8방식
//			-UC-ASCII => 영문자용 인코딩 방식
			
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
				
			int c;
			while((c=isr.read()) != -1) {
				System.out.print((char)c);
			}
			
//			fr.close();
			fis.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
