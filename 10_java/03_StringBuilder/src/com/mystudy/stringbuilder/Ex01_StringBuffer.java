package com.mystudy.stringbuilder;

public class Ex01_StringBuffer {

	public static void main(String[] args) {
		// StringBuffer 클래스
		int num = 100;
		String str1 = "Hello"; // 사용가능
		String str = new String("Hello Java!!!");
		System.out.println(str);
		
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb);
		System.out.println(sb.toString()); //toString 조회, 검색이라는 뜻
		String sbValue = sb.toString();
		System.out.println("sb.toString() : " + sbValue);
		
		System.out.println("sb.capacity() : " + sb.capacity());
		
		System.out.println("---- StringBuffer -----");
		sb.append("반갑습니다.").append("@@@@@@");
		System.out.println(sb); 
		
		sb.reverse(); // 문자열 뒤집기
		System.out.println(sb); 
		System.out.println(sb.reverse());
		System.out.println(sb); 

		System.out.println("----- delete(), insert(), replace() -----");
		// Hello Java!!!반갑습니다.@@@@@
		System.out.println("sb.delete(0, 6) : " + sb.delete(0, 6));
		// 삭제 substring랑 사용법 같음 
		System.out.println(sb);
		
		sb.insert(0, "Hello "); // 삽입(추가, 입력)
		System.out.println(sb);
		// replace(int start, int end, String str)
		sb.replace(0, 5, "Hi,"); // 수정
		System.out.println(sb);
		
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
	
		//===================================================
		
		System.out.println("--------------------------------");
		StringBuffer sb2 = new StringBuffer(100); //저장공간을 100개 확보
		System.out.println("sb2.lnngth(): " + sb2.length()); //저장 데이터 크기(저장된게없어서 0)
		System.out.println("sb2.capacity() : " + sb2.capacity()); // 저장 공간의 크기(100)

		sb2.append("안녕하세요").append(" 반갑습니다!!!");
		System.out.println("sb2.lnngth(): " + sb2.length()); //저장 데이터 크기(저장된게 14개)
		System.out.println("sb2.capacity() : " + sb2.capacity()); // 저장 공간의 크기(100)
	
		System.out.println("--- trimToSize() 실행 후 ---");
		sb2.trimToSize();
		System.out.println("sb2.lnngth(): " + sb2.length()); //저장 데이터 크기(저장된게 14개)
		System.out.println("sb2.capacity() : " + sb2.capacity()); // 저장 공간의 크기(14)
	
		System.out.println(">>> append() 실행 후 ---");
		sb2.append(" 자바공부중~");
		System.out.println("sb2 : " + sb2);
		System.out.println("sb2.lnngth(): " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity()); 
	
		System.out.println(">> setLength() 실행 후---");
		sb2.setLength(5); // 데이터 크기 설정(작게 지정하면 delete 효과발생)
		System.out.println("sb2 : " + sb2.toString());
		System.out.println("sb2.lnngth(): " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity()); 
	
	
	
	
	
	
	
	
	
	
	
	}

}
