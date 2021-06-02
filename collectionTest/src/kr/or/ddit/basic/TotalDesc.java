package kr.or.ddit.basic;

import java.util.Comparator;

public class TotalDesc implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getTotal() == student2.getTotal()) {
			return student1.getName().compareTo(student2.getName());
		} else {
			return Integer.compare(student1.getTotal(), student2.getTotal()) * -1;
		}
	}
}
