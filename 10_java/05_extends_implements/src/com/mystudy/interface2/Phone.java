package com.mystudy.interface2;

// 인터페이스(interface) 구현(implements)하는 방식으로 클래스 만들기
public class Phone implements I_phone {
	// 필드(속성) -----------------------
	private String type; // 전화타입(형태)
	private String PhoneNo;

	// 생성자 ----------------------------
	public Phone(String phoneNo) {
		this.type = "Phone 타입";
		this.PhoneNo = phoneNo;
	}

	public Phone(String type, String phoneNo) {
		super();
		this.type = type;
		this.PhoneNo = phoneNo;
	}

	// 메소드 ------------------------

	public String getType() {
		return type;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}
	
	
	@Override
	public void view() {
		System.out.println("타입: " + type + ", 전화번호: " + PhoneNo);
	}

	@Override
	public void call() {
		System.out.println(">> 전화걸기");
	}

	@Override
	public void receivecall() {
		System.out.println(">> 전화받기");
	}

	@Override
	public void sendSMS() {
		System.out.println(">> 메시지 보내기");
	}

	@Override
	public void receiveSMS() {
		System.out.println(">> 메시지 받기");
	}

}
