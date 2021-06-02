package kr.or.ddit.basic;

import java.awt.List;
import java.util.LinkedList;

/*
 * stack
 * 
 * Queue
 * 
 */

public class StackQueTest {
	public static void main(String[] args) {
		LinkedList<String> stack = new LinkedList<String>();
//		stack.push("홍길동");
//		stack.push("일지매");
//		stack.push("변학도");
//		stack.push("성춘향");
//
//		System.out.println("현재 Stack 값 : " + stack);
//
//		String data = stack.pop();
//		System.out.println("꺼내온 값 : " + data);
//		System.out.println("꺼내온 값 : " + stack.pop());
//		
//		System.out.println("현재 Stack 값 : " + stack);
//		
//		stack.push("강감찬");
//		System.out.println("추가 후 stack 값 :"+stack);
//		
//		System.out.println("꺼내온 값 : "+stack.pop());
//		System.out.println("현재 Stack 값 : " + stack);
//		
//		System.out.println("삭제 없이 꺼내온 값 : "+stack.peek());
//		System.out.println("현재 Stack 값 : " + stack);

		
		LinkedList<String> queue = new LinkedList<String>();
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("성춘향");
		
		System.out.println("현재 queue의 값 : "+ queue);
		String temp = queue.poll();
		System.out.println("꺼내온 값 : "+ temp);
		System.out.println("꺼내온 값 : "+ queue.poll());
		System.out.println("현재 queue의 값 : "+ queue);
		
		queue.offer("강감찬");
		System.out.println("현재 queue의 값 : "+ queue);
		
		System.out.println("꺼내온 값 :"+ queue.poll());
		System.out.println("현재 queue의 값 : "+ queue);
		
		System.out.println("삭제없이 꺼내온 값 :"+ queue.peek());
		System.out.println("현재 queue의 값 : "+ queue);
	}
}
