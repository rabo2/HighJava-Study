package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashcodeTest {
	public static void main(String[] args) {
		Person p1 = new Person(1,"홍길동");
		Person p2 = new Person(1,"홍길동");
		Person p3 = p1;
		
		System.out.println("p1 = "+p1);
		System.out.println("p2 = "+p2);
		System.out.println(p1 == p2);//false
		System.out.println(p1.equals(p2));
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		Set<Person> testSet = new HashSet<Person>();
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println(testSet.size());
	}
}


class Person {
	private int id;
	private String name;

	public Person() {
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//객체의 참조값을 동일하게 만드는 메서드
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		//참조값이 같은지 검사
		if (this == obj)
			return true;
		//매개변수의 값이 null인지 체크
		if (obj == null)
			return false;
		//같은 타입의 클래스인지를 검사
		if (getClass() != obj.getClass())
			return false;
		//객체의 필드가 같은지 혹은 null 값인지를 확인
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}