package kr.or.ddit.basic.stream;

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * 복사할 원본 파일과 출력될 파일을 JfileChooser객체를 이용해서 선택하여 처리하도록 하여라.
 */
public class FileCopy2 {
   public static void main(String[] args) {
      System.out.println("작업 시작...");
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter img = new FileNameExtensionFilter("그림파일", "png", "jpg", "gif");

      /*
       * 복사할 파일의 경로 탐색(Dialog)
       */
      chooser.addChoosableFileFilter(img);
      int result = chooser.showOpenDialog(new Panel());
      
      File selectedFile = null;
      if(result == JFileChooser.APPROVE_OPTION) {
		selectedFile = chooser.getSelectedFile();
      }
      File sourceFile = new File(selectedFile.getAbsolutePath());

      if (!sourceFile.exists()) {
    	  System.out.println(sourceFile.getPath() + " 파일이 없습니다.");
    	  System.out.println("복사 작업을 중지합니다.");
    	  return;
      }else {
    	  System.out.println("복사할 대상 파일을 선택하지 않았습니다.");
      }
      
      
     /*
      * 저장할 파일의 경로 탐색(Dialog) 
      */
      chooser.setCurrentDirectory(new File("d:/d_other"));
      int targetFile = chooser.showSaveDialog(new Panel());
      
      File saveFile = null;
      if(targetFile == JFileChooser.APPROVE_OPTION) {
    	  saveFile = chooser.getSelectedFile();
      }else {
    	  System.out.println("저장될 대상 파일을 선택하지 않았습니다.");
    	  return;
      }
      saveFile = saveFile.getAbsoluteFile();
      
      try {
         System.out.println("복사 시작...");
         BufferedInputStream bis = 
        		 new BufferedInputStream(new FileInputStream(sourceFile));
         
         
         BufferedOutputStream bout = 
        		 new BufferedOutputStream(new FileOutputStream(saveFile));
         
         int data;
         while ((data = bis.read()) != -1) {
            bout.write(data);
         }
         bout.flush();
         
         bout.close();
         bis.close();
         
         System.out.println("복사 완료...");

      } catch (IOException e) {

      }

   }
}