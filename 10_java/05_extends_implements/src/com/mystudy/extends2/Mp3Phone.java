package com.mystudy.extends2;

// Phone 클래스를 상속받아(extends: 확장해서) Mp3Phone 만들기
class Mp3Phone extends Phone {
	
	public Mp3Phone(String phoneNo) {
		super("Mp3Phone타입", phoneNo);  //부모클래스에 있는 생성자를 받는다
	}
	
	public Mp3Phone(String type, String phoneNo) {
		super(type, phoneNo);
	}
	
	public void playMusic() {
		System.out.println(">> MP3Phone - 음악플레이");
	}
	
	
	
}
