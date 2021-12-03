package com.mystudy.set1_hashset;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExam {
	public static void main(String[] args) {
		// HasgSet: Set 인터페이스를 구현한 구현체(클래스)
		// 순서가 없고, 중복데이터 허용안한다.(동일데이터는 하나만 저장한다.)
		// Set 에서 동일데이터 여부 확인은 hashCode(), equals() 값 확인한다.
		// 1. 해시코드 값 확인: hashCode()
		// 2. equals() 메소드 결과값이 모두 일치하면 동일데이터
		// -----------------------------------------
		HashSet<String> set = new HashSet<>();
		
		set.add("홍길동");
		set.add("홍길동");
		set.add("김유신");
		set.add(new String("홍길동"));
		"홍길동".hashCode();
		System.out.println("홍길동 해시코드: " + "홍길동".hashCode());
		System.out.println("new String(\"홍길동\") 해시코드: " + new String("홍길동").hashCode());
		System.out.println("set: " + set);
		
		System.out.println("set.size(): " + set.size()); // 홍길동, 김유신
		System.out.println("set.contains(\"홍길동\"): " + set.contains("홍길동"));
		
		set.add("을지문덕");
		set.add("홍경래");
		System.out.println("set: " + set); // 들어가는데 순서대로 들어가는게아니라 무작위로 저장된다.
	
		
		// Iterator은 한번 사용되면 재사용 할 수 없다.
		System.out.println("----- set 전체 데이터 조회(Iterator) -----");
		Iterator<String> ite = set.iterator(); // 스트링으로 저장되어있다.
		while (ite.hasNext()) { 
			System.out.println(ite.next());
		}
		
		System.out.println("-----------");
		for (String name : set ) {
			System.out.println(name);
		}
		
		// -------------------------------------
		// (실습) 수정(변경): 김유신 -> 강감찬 바꿔보기
		// 김유신 삭제 and 강감찬 입력
		// 강감찬 입력 and 김유신 삭제
		System.out.println("--- 김유신 ==> 강감찬(수정/변경 처리) ---");
		//System.out.println("set.remove(\"일지매\"): " + set.remove("일지매"));
		//System.out.println("set.remove(\"김유신\"): " + set.remove("김유신"));
		
		set.remove("김유신"); // 가장 쉽게 데이터 제거
		set.add("강감찬"); // 가장 쉽게 데이터 추가
		
		
		if(set.contains("김유신")) {
			set.remove("김유신");
			System.out.println(">> 김유신 데이터가 삭제되었습니다.");
			set.add("강감찬");
		} else {
			System.out.println(">> 김유신 데이터가 없습니다.");
		}
		
		if (set.remove("홍길동")) {
			System.out.println(">> 홍길동 데이터가 삭제되었습니다.");
		} else {
			System.out.println(">> 홍길동 삭제 실패! 데이터를 확인하세요!");	
		}
		
		System.out.println(set);
		
		
		
		
		
	}
}
