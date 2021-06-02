package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HighJavaAssignment1 {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "임성민", 40, 20, 30));
		students.add(new Student(2, "이인환", 20, 80, 40));
		students.add(new Student(3, "안병준", 70, 40, 50));
		students.add(new Student(4, "이웅희", 100, 50, 80));
		students.add(new Student(5, "송진협", 80, 80, 70));

		rank(students);
		
		Collections.shuffle(students);
		System.out.println("정렬 전 ......");
		for (Student student : students) {
			System.out.println(student);
		}

		Collections.sort(students);
		System.out.println("학번 순서로 정렬 후.....");
		for (Student student : students) {
			System.out.println(student);
		}

		Collections.sort(students, new TotalDesc());
		System.out.println("총점 순서로 정렬 후 ....");
		for (Student student : students) {
			System.out.println(student);
		}

	}

	public static void rank(List<Student> students) {
		for (Student student : students) {
			int rank = 1;
			for (Student student2 : students) {
				if(student.getTotal() < student2.getTotal()) {
					rank++;
				}
				student.setRank(rank);
			}
		}
	}
}
