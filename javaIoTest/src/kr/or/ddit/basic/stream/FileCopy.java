package kr.or.ddit.basic.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
   public static void main(String[] args) {
      System.out.println("작업 시작...");
      File file = new File("d:/d_other/펭귄.jpg");

      if (!file.exists()) {
         System.out.println(file.getPath() + " 파일이 없습니다.");
         System.out.println("복사 작업을 중지합니다.");
         return;
      }
      try {
         System.out.println("복사 시작...");
         // 원본 데이터를 읽어올 입력용 스트림 객체 생성
         FileInputStream fis = new FileInputStream(file);
         BufferedInputStream bis = new BufferedInputStream(fis);
         
         
         // 저장할 출력용 스트림 객체 생성
         FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/복사본-펭귄.jpg");
         BufferedOutputStream bout = new BufferedOutputStream(fout);
         int data;
         /*
         while ((data = fis.read()) != -1) {
            fout.write(data);
         }
         // 스트림 닫기
         fout.flush();
         fis.close();
         */
         while ((data = bis.read()) != -1) {
            bout.write(data);
         }
         bout.flush();
         
         // 스트림 닫기
         bout.close();
         bis.close();
         
         System.out.println("복사 완료...");

      } catch (IOException e) {
         // TODO Auto-generated catch block

      }

   }
}