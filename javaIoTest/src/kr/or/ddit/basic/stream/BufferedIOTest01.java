package kr.or.ddit.basic.stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {
	public static void main(String[] args) {
		try {
			System.out.println("작업 시작");
			//입출력의 성능 향상을 위해서 Buffered스트림을 사용한다.
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
			
			//버퍼의 크기를 지정하지 않으면 기본 크기인 8kb(8192byte)로 설정된다.
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for(char i = '1'; i <= '9'; i++) {
				bout.write(i);
			}
			
//			bout.flush();//버퍼에 남아잇는 모든 데이터를 강제로 출력한다.
//			fout.close();
			bout.close();//보조스트림을 닫으면 보조스트림이 
						//사용한 기반이 되는 스트림은 자동으로 닫힌다.
			
			System.out.println("작업 종료");
			
		}catch (IOException e) {
		
		}
	}
}
