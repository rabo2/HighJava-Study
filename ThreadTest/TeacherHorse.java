package kr.or.ddit.basic;

import java.util.Arrays;

/*

10마리의 말들이 경주하는 경마 프로그램을 작성하시오.

말은 Horse 라는 이름의 쓰레드 클래스로 작성하는데 이 클래스는 말이름(String) 현재위치(int)

등수(int)를 멤버변수로 갖는다.

그리고, 이 클래스는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.

(comparable 인터페이스 구현)

경기구간은 1 ~ 50 구간으로 되어 있다.

경기 중 중간 중간에  각 말들의 위치를 아래와 같이 나타내시오.
예시)
01번말 ---->--------------------------------
02번말 ------------>------------------------
...
10번말 -------------------->----------------

경기 끝나면 등수 순으로 출력한다.
*/

public class TeacherHorse {
   public static void main(String[] args) {
      HorseExam[] horses = new HorseExam[] { new HorseExam("01번말"), new HorseExam("02번말"), new HorseExam("03번말"), new HorseExam("04번말"),
            new HorseExam("05번말"), new HorseExam("06번말"), new HorseExam("07번말"), new HorseExam("08번말"), new HorseExam("09번말"),
            new HorseExam("10번말") };
      
      GameState gs = new GameState(horses);
      
      for (HorseExam h : horses) {
         h.start();
      }
      gs.start();
      
      try {
         for(HorseExam h : horses) {
            h.join();
         }
         gs.join();
      } catch (InterruptedException e) {
      }
      
      System.out.println();
      System.out.println("경기 끝!!!!");
      System.out.println();
      
      //등수의 오름차순 정렬하기
      Arrays.sort(horses);
      
      for(HorseExam h : horses) {
         System.out.println(h.toString());
      }
   }
}

class HorseExam extends Thread implements Comparable<HorseExam> {
   public static int currentRank = 0; // 경주가 끝난 말의 등수를 구하기 위한 변수 선언

   private String HorseName; // 말이름
   private int position; // 현재위치
   private int rank; // 등수

   // 생성자
   public HorseExam(String horseName) {
      this.HorseName = horseName;
   }

   // getter , setter
   public String getHorseName() {
      return HorseName;
   }

   public void setHorseName(String horseName) {
      HorseName = horseName;
   }

   public int getPosition() {
      return position;
   }

   public void setPosition(int position) {
      this.position = position;
   }

   public int getRank() {
      return rank;
   }

   public void setRank(int rank) {
      this.rank = rank;
   }

   @Override
   public String toString() {
      return "경주마" + HorseName + "은(는)" + rank + "등 입니다.";
   }

   // 등수를 오름차순으로 정렬할 수 있는 정렬 기준 설정
   @Override
   public int compareTo(HorseExam horse) {

      return Integer.compare(rank, horse.getRank());
   }
   // 쓰레드처리

   @Override
   public void run() {
      for (int i = 1; i <= 50; i++) {
         this.position = i; // 말의 현재 위치 저장
         try {
            Thread.sleep((int) (Math.random() * 500));
         } catch (InterruptedException e) {

         }
      } // for 문 끝..(경기끝) 그다음 현재 말의 등수 구하기

      // 한 마리의 말이 경주가 끝나면 등수를 구해서 설정한다.
      currentRank++;
      this.rank = currentRank;
   }
}

/*
 * 경기 중 중간 중간에 각 말들의 위치를 아래와 같이 나타내시오. 예시) 01번말
 * ---->-------------------------------- 02번말
 * ------------>------------------------ ... 10번말
 * -------------------->----------------
 * 
 * 경기 끝나면 등수 순으로 출력한다.
 */
// 경기 말중 현재 말의 위치를 출력해 주는 쓰레드
class GameState extends Thread {
   HorseExam[] horses; // 경주를하는 말들의 정보가 저장될 배열 변수 선언

   public GameState(HorseExam[] horses) {
      this.horses = horses;
   }

   @Override
   public void run() {
      while (true) {
         // 모든 말의 경주가 끝났는지 여부 검사
         if (HorseExam.currentRank == this.horses.length) {
            break;
         }
         //긴줄출력
         for(int i = 1; i<=10; i++) {
            System.out.println();
         }
         
         
         for (int i = 0; i < this.horses.length; i++) {
            System.out.print(horses[i].getHorseName() + " : ");
            for (int j = 1; j <= 50; j++) {
               if (horses[i].getPosition() == j) { // 현재말의 위치를 확인해서 출력한다.
                  System.out.print("🐎");
               } else {
                  System.out.print("-");
               }
            }
            System.out.println();// 줄바꿈
         }
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
         }
      }
   }
}