package com.mystudy.set1_hashset;

import java.util.HashSet;
import java.util.Objects;

class Person{
	String name; // 이름
	int age; // 나이
	String jumin; // 주민번호
	public Person(String name, int age, String jumin) {
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", jumin=" + jumin + "]";
	}
	@Override
	public int hashCode() {
		System.out.println(">> hashCode() 실행");
		return Objects.hash(jumin);
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println(">> equals() 실행");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(jumin, other.jumin);
	}
	
	
	
	
}

public class HashSetExam2_equals {
	public static void main(String[] args) {
		// set: 중복데이터는 허용하지않는다.(하나만 저장)
		// 참조형 데이터의 동일 데이터 여부는 equals 메소드 기준이다.
		// equals() 메소드 오버라이딩 할 때는 hashCode() 메소드도 함께 재정의
		// set의 동일데이터 확인
		// 1. 해시코드 값 확인: hashCode()
		// 2. equals() 메소드 결과값이 모두 일치하면 동일데이터
		HashSet<Person> set = new HashSet<>();
		set.add(new Person("홍길동", 27, "901010-1234567"));
		set.add(new Person("홍길동", 27, "901010-1234567"));
//		set.add(new Person("홍경래", 27, "901010-1234567"));
//		
//		set.add(new Person("김유신", 30, "881111-2222222"));
//		set.add(new Person("홍길동", 27, "900202-3333333"));
		
		System.out.println(set);
	}
}
