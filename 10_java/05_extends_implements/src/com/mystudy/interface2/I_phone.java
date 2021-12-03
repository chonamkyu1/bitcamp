package com.mystudy.interface2;
/*
 - 기능: 
 	1. 전화정보 확인(view)
 	2. 전화걸기(call)
 	3. 전화받기(receiveCall)
 	4. 메시지 보내기
 	5. 메시지 받기
 */
public interface I_phone { 
	// {} 없음: 추상메소드(abstract 메소드 - 구현부 없음)
	 //interface에 정의되는 메소드는 기본적으로 public abstract 임
	public abstract void view() ;
	public void call(); //abstract 생력해도 abstract 메소드
	void receivecall(); // public abstract 임
	void sendSMS(); // public abstract 임
	void receiveSMS(); // public abstract 임

}

