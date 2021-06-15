package kr.or.ddit.basic.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {
	public static void main(String[] args) {
		//FileOutputStrem을 이용해서 출력하기
		try {
			//FileOutputStream객체 생성
			File file = new File("d:/d_other/out.txt");
			//OutputStream이 정상작동하면 없는 파일은 만들어진다.
			//만약 파일이 존재한다면 덮어쓴다.
			FileOutputStream fout = new FileOutputStream(file);
			
			for(char ch='a'; ch<'z'; ch++) {
				fout.write(ch); //ch변수의 값을 파일로 출력한다.
			}
			System.out.println("출력 완료...");
			fout.close(); //스트림 닫기
			
			//=============================================
			//위에서 저장한 파일 나용을 읽어와 화면에 출력하시오
			FileInputStream input = new FileInputStream("d:/d_other/out.txt");
			int c;
			while((c = input.read()) != -1) {
				System.out.print((char)c);
			}
			input.close();
		} catch (IOException e) {
		}
	}
}
