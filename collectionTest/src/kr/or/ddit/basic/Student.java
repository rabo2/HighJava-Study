package kr.or.ddit.basic;

//문제) 학번(int), 이름(String), 국어점수, 영어점수, 수학점수, 총점, 등수(int)를
//멤버로 갖는 Student클래스를 만든다. 이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수,
//수학점수만 매개변수로 받아서 초기화 처리를 한다.
//
//이 Student객체는 List에 저장하여 관리한다.
//
//List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준으로 구현하고, 총점의 역순
//으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는 외부정렬 기준 클래스를 작성하여
//정렬된 결과를 출력하시오.
//
//(단, 등수는 List에 전체 데이터가 추가된 후에 구하도록 한다.)

public class Student implements Comparable<Student> {
	private int stundentNum;
	private String name;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
	private int total;
	private int rank;

	public Student(int stundentNum, String name, int koreanScore, int englishScore, int mathScore) {
		this.stundentNum = stundentNum;
		this.name = name;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
		this.total = koreanScore+englishScore+mathScore;
	}

	public int getStundentNum() {
		return stundentNum;
	}

	public void setStundentNum(int stundentNum) {
		this.stundentNum = stundentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	@Override
	public String toString() {
		return "Student [stundentNum=" + stundentNum + ", name=" + name + ", koreanScore=" + koreanScore
				+ ", englishScore=" + englishScore + ", mathScore=" + mathScore + ", total=" + total + ", rank=" + rank
				+ "]";
	}

	@Override
	public int compareTo(Student student) {
		return Integer.compare(this.stundentNum, student.getStundentNum());
	}

}
