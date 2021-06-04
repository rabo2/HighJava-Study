package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelAssignment {
	private Map<Integer, Room> room;
	private List<Integer> roomNum;
	private Scanner scan;

	public static void main(String[] args) {
		new HotelAssignment().hotelManagement();
	}

	public HotelAssignment() {
		room = new HashMap<>();
		roomNum = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	private void hotelManagement() {
		roomSet();
		while (true) {
			int mainPage = mainPage();
			switch (mainPage) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomState();
				break;
			case 4:
				System.out.println("안녕히 가세요");
				return;
			}
		}
	}

	private int mainPage() {
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>>");
		int num = scan.nextInt();
		return num;
	}

	private void roomSet() {
		for (int i = 1; i < 10; i++) {
			roomNum.add(200+i);
			room.put(200 + i, new Room(200 + i, "싱글룸"));
		}
		for (int i = 1; i < 10; i++) {
			roomNum.add(300+i);
			room.put(300 + i, new Room(300 + i, "더블룸"));
		}
		for (int i = 1; i < 10; i++) {
			roomNum.add(400+i);
			room.put(400 + i, new Room(400 + i, "스위트룸"));
		}
	}

	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력 >>");
		int roomNum = scan.nextInt();
		if(!room.containsKey(roomNum)) {
			System.out.println(roomNum+"호 객실은 존재하지 않습니다.");
			return;
		}
		if(!room.get(roomNum).getGuestName().equals("-")) {
			System.out.println(roomNum+"호 객실은 이미 손님이 있습니다.");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 >>");
		String guestName = scan.next();
		Room room2 = room.get(roomNum);
		room2.setGuestName(guestName);
		System.out.println("체크인이 완료되었습니다.");
	}

	private void checkOut() {
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방번호 입력 >>");
		int roomNum = scan.nextInt();
		if(!room.containsKey(roomNum)) {
			System.out.println(roomNum+"호 객실은 존재하지 않습니다.");
			return;
		}
		if(room.get(roomNum).getGuestName().equals("-")) {
			System.out.println(roomNum+"호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}
		Room room2 = room.get(roomNum);
		String guestName = room2.getGuestName();
		System.out.println(roomNum+"호 객실의 "+guestName+"님 체크아웃을 완료하였습니다.");
		room2.setGuestName("-");
	}

	private void roomState() {
		System.out.println("----------------------------------------------");
		System.out.println("	현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");

		for (Integer num : roomNum) {
			Room room2 = room.get(num);
			System.out.println(num+"\t"+room2.getRoomKinds()+"\t"+room2.getGuestName());
		}

		System.out.println("----------------------------------------------");
	}
}

class Room {
	private int roomNum;
	private String roomKinds;
	private String guestName;

	public Room(int roomNum, String roomKinds) {
		super();
		this.roomNum = roomNum;
		this.roomKinds = roomKinds;
		this.guestName = "-";
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomKinds() {
		return roomKinds;
	}

	public void setRoomKinds(String roomKinds) {
		this.roomKinds = roomKinds;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
}