package com.mystudy.poly2_overriding;

public class Cat extends Animal	{

	/* 메소드 오버라이딩(Method Overriding)
	 상속관계(확장, extends)에 있는 클래스에서 
	 수퍼(부모)타입에 있는 메소드를 서브(자녀)타입 클래스에서 재정의(최종정의)
	 - 선언은 동일하고, 기능만 다르게 구현한다.
	 - 동일형태 : 리턴타입, 메소드명, 파라미터가 동일(타입, 갯수, 순서일치)해야한다.
	
	*/
	
	@Override // 오버라이딩 된 메소드를 알리는 어노테이션(컴파일러 사용 주석)
	// 어노테이션 = 주석 , 컴파일러가 보는 주석 우리가쓰는// 주석은 개발자 주석
	
	void sound() { //접근제한자가 큰거는 상관없지만 작게하면 오류발생한다.
		//super.sound(); // 부모클래스의 기능을 그대로 쓰겠다는뜻
		System.out.println(">> 야옹~야용");
	}
}
