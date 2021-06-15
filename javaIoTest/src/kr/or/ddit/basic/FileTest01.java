package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {
	public static void main(String[] args) {
		//File객체 만들기
		
		//1. new File(String 파일 또는 경로)
		//	=> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분문자는 
		//	=> '/'또는 '\'를 사용할 수 있다.
		
		//File f1 = new File("D:/D_Other/test.txt");// 구분문자를 '/'로 썼을 때
		File f1 = new File("D:\\D_Other\\test.txt");// 구분문자를 '\'로 썼을 때
		System.out.println("파일명 : " + f1.getName());
		System.out.println("디렉토리 인가? : " + f1.isDirectory());
		System.out.println("파일 인가? :" + f1.isFile());
		System.out.println();
		
		File f2 = new File("d:/d_other");
		//윈도우는 경로와 파일이름에 대소문자 구분이 없다.
		System.out.println("파일명 : " + f2.getName());
		System.out.println("디렉토리 인가? : " + f2.isDirectory());
		System.out.println("파일 인가? :" + f2.isFile());
		System.out.println();
		
		//2. new File(File parent, String child)
		File f3 = new File(f2, "test.txt");
		System.out.println("파일명 : " + f3.getName());
		System.out.println("디렉토리 인가? : " + f3.isDirectory());
		System.out.println("파일 인가? :" + f3.isFile());
		System.out.println();
		
		//3. new File(String parent, String child)
		// 	=> 'parent' 디렉토리 안에 잇는 'child'파일을 나타낸다.
		File f4 = new File("d:/d_other", "test.txt");
		System.out.println("파일명 : " + f4.getName());
		System.out.println("디렉토리 인가? : " + f4.isDirectory());
		System.out.println("파일 인가? :" + f4.isFile());
		System.out.println();
		System.out.println("-----------------------------------");
		//====================================================
		
		//디렉토리(폴더) 만들기
		//- mkdir() ==> File객체의 경로 중 마지막 위치의 디렉토리를 만든다.
		//			==> 반환 값 : 만든 여부에 따라서 boolean을 반환
		//			==> 최종적으로 만들려고 하는 폴더의 상위 폴더들이 미리 만들어져 있어야 한다.
		// -mkdirs()==> 만들려고하는 폴더의 상위 폴더가 없으면 상위폴더까지 만들어준다.
		File f5 = new File("d:/d_other/연습용");
		System.out.println(f5.getName()+"의 존재 여부 : "+ f5.exists());
		
		if(f5.mkdir()) {
			System.out.println(f5.getName() + "폴더 생성 완료!!");
		}else {
			System.out.println(f5.getName() + "폴더 생성 실패");
		}
		System.out.println();
		
		File f6 = new File("d:d_other/test/java/src");
		if(f6.mkdirs()) {
			System.out.println(f6.getName()+" 만들기 성공");
		}else {
			System.out.println(f6.getName()+" 만들기 실패");
		}
		
	}
	
}
