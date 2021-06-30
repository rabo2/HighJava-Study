package kr.or.ddit.basic;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//로그 기록 남기는 예쩨
public class LoggingTest {
	//Logger클래스의 인스턴스를 받아온다.
	static Logger logger = Logger.getLogger(LoggingTest.class);
	public static void main(String[] args) {
		//각 레벨별로 메시지를 출력하는 명령을 사용하여 메시지를 출력한다.
		//형식 1) logger.레벨이름("출력할 메시지");
		logger.trace("이것은 lgo4j의 'TRACE'레벨의 출력입니다.");
		logger.debug("이것은 lgo4j의 'debug'레벨의 출력입니다.");
		logger.info("이것은 lgo4j의 'info'레벨의 출력입니다.");

		//형식 2) logger.log(Level.레벨이름, "출력할 메시지");
		logger.log(Level.WARN, "이것은 lgo4j의 'WARN'레벨의 출력입니다.");
		logger.log(Level.ERROR, "이것은 lgo4j의 'ERROR'레벨의 출력입니다.");
		logger.log(Level.FATAL, "이것은 lgo4j의 'FATAL'레벨의 출력입니다.");
	}
}
