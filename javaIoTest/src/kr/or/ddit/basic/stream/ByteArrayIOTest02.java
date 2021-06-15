package kr.or.ddit.basic.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	public static void main(String[] args) {
		byte[] insrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outsrc = null;

		byte[] temp = new byte[4]; // 4개짜리 배열 생성 -> 읽어온 데이터가 저장될 배열

		ByteArrayInputStream input = new ByteArrayInputStream(insrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		try {
			// input.available() ==> 읽어온 데이터의 개수 반환한다.
			// 읽어올 데이터가 있는지 여부를 검사
			while (input.available() > 0) {
				/*
				input.read(temp); // temp배열 개수만큼 읽어와 temp배열에 저장한다.
								  // 인자가 존재하는 read(매개변수)는 읽어온 데이터의 갯수를 반환한다.
				output.write(temp);
				//temp의 배열의 길이는 4이기 때문에 입출력의 데이터의 갯수에 맞아떨어지지 않는다.
				//그래서 temp를 출력할 때 그전의 기록에서 데이터를 가져와서 배열의 갯수를 맞춘다.
				//새로 읽은 데이터와 그 뒤에 전에 읽었던 데이터를 덧붙혀서 출력한다.
				 * 
				//insrc = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
				//outsrc = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 6, 7]
			
				*/
				
				//실제 읽어온 byte수를 반환한다.
				int len = input.read(temp); 
				
				//0번째부터 len(읽어온 갯수)만큼 출력
				output.write(temp, 0, len); 
				
				System.out.println("반복문 안에서 teml :" + Arrays.toString(temp));
			}

			outsrc = output.toByteArray();
			System.out.println();
			System.out.println("insrc = " + Arrays.toString(insrc));
			System.out.println("outsrc = " + Arrays.toString(outsrc));
			
			input.close();
			output.close();
		} catch (IOException e) {

		}
	}
}
