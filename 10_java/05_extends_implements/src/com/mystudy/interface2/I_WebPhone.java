package com.mystudy.interface2;

// 전화기 기본기능 + 음악플레이 + 웹서치기능

public interface I_WebPhone extends I_phone, I_Mp3Phone { //인터페이스간에는 여려개 확장해서 사용가능

	// 전화기 기본기능
//	public abstract void view();
//	public void call(); // abstract 생력해도 abstract 메소드
//	void receiveCall(); // public abstract 임
//	void sendSMS(); // public abstract 임
//	void receiveSMS(); // public abstract 임

	// Mp3 기능 : 음악플레이
//	void playMusic();

	// 웹서치기능
	void webSearch();
}
