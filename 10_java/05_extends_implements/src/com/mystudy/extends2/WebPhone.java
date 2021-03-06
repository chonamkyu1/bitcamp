package com.mystudy.extends2;

// 클래스 상속(extends) 해서 클래스 생성
/*
 WebPhone 클래스 작성
 Phone 클래스를 상속확장해서 작성
 생성자 정의
 	- 폰번호(phoneNo)만 받아서 객체(인스턴스) 생성 : 타입명 "WebPhone타입" 적용
 기능 : 전화걸고, 받고, 전화정보보기, 웹검색 할 수 있는 전화기
 웹 검색 기능
 	- webSearch() : ">>WebPhone - 웹 검색" 문구 화면 출력
 */
class WebPhone extends Phone { // 처음에 오류가 나는이유는 기본생성자가 없어서
	// 필드(속성) -------------------------
	// 아무것도없다

	// 생성자 -------------------------
	public WebPhone(String phoneNo) {
		super("webPhone타입", phoneNo);
	}

	public WebPhone(String type, String phoneNo) {
		super(type, phoneNo);
	}

	// 메소드 ---------------------------

	public void WebSearch() {
		System.out.println(">>WebPhone - 웹 검색");
	}

	public void WebSearch(String word) {  //메소드 오버로딩(overloading)
		System.out.println(">>WebPhone - 웹 검색" + word + "로 검색");
	}
	

	
	
	
	
	
	
	
	
	
	
}
