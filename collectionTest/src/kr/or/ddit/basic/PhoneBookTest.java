package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookTest {
	static HashMap<String, Phone> phoneBook = new HashMap<>();

	public static void main(String[] args) {
		do {
			switch (mainPage()) {
			case "1":
				signUp();
				break;
			case "2":
				modifyPh();
				break;
			case "3":
				deletePh();
				break;
			case "4":
				researchPh();
				break;
			case "5":
				printPh();
				break;
			case "0" :
				exit();
			}
		} while(true);
	}

	public static String mainPage() {
		System.out.println("---------------------");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("---------------------");
		System.out.print("번호 입력 >> ");
		return inputData();
	}

	public static Phone getInstance(String ph, String add) {
		return new Phone(ph, add);
	}

	public static String inputData() {
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}

	public static void signUp() {
		System.out.println("새롭게 등록한 정보를 입력하세요");
		System.out.print("이름 >>");
		String name = inputData();
		if (check(name)) {
			System.out.println("이미 등록된 사람입니다.");
		} else {
			System.out.print("번호 입력 >>");
			String newPh = inputData();
			System.out.print("주소 입력 >>");
			String newAdd = inputData();
			phoneBook.put(name, getInstance(newPh, newAdd));
		}

	}

	public static void modifyPh() {
		System.out.println("이름을 입력하세요");
		String name = inputData();
		if (check(name)) {
			System.out.print("수정할 전화번호를 입력해주세요");
			String modifyNum = inputData();
			phoneBook.replace(name, getInstance(modifyNum, phoneBook.get(name).getAdd()));
		}
	}

	private static boolean check(String name) {
		if (phoneBook.containsKey(name)) {
			return true;
		} else {
			return false;
		}
	}

	public static void deletePh() {
		String name = scanName();
		if (check(name)) {
			phoneBook.remove(name);
		}
		System.out.println("안녕히 가세요");
	}

	public static void researchPh() {
		String name = scanName();
		if (check(name)) {
			System.out.println("-----------------------------------");
			System.out.println("이름\t전화번호\t\t주소");
			System.out.println(name + "\t" + phoneBook.get(name).getPh() + "\t" + phoneBook.get(name).getAdd());
			System.out.println("-----------------------------------");
		}else {
			System.out.println("등록되지 않은 이름입니다.");
		}
	}

	public static void printPh() {
		System.out.println("---------------------------------------------");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("---------------------------------------------");
		Iterator<String> iterator = phoneBook.keySet().iterator();
		int count  = 1;
		while (iterator.hasNext()) {
			String key = iterator.next();
			String ph = phoneBook.get(key).getPh();
			String add = phoneBook.get(key).getAdd();
				System.out.println(count+"\t"+key+"\t"+ph+"\t"+add);
				count++;
		}
		System.out.println("---------------------------------------------\n");
	}

	public static String scanName() {
		System.out.println("이름을 입력해주세요");
		System.out.print(">>");
		String name = inputData();
		return name;
	}
	public static void exit() {
		System.out.println("안녕히 가세요");
		System.exit(0);
	}

}
