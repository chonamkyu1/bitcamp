package com.mystudy.phone;

public class PhoneMain {
	
	public static void main(String[] args) {
		System.out.println("------Phone1-------");
		Phone phone1 = new Phone();
		phone1.hsize = 100;
		phone1.vsize = 200;
		phone1.view();
		phone1.call();
		phone1.receveCall();
		
		
		System.out.println("------Phone2-------");
		Phone phone2 = new Phone("갤럭시10", "스마트폰");
		phone2.hsize = 110;
		phone2.vsize = 220;
		phone2.view();
		
		System.out.println("------Phone3-------");
		Phone phone3 = new Phone("아이폰12", "스마트폰", true);
		phone3.view();
		phone3.sendSms("안녕하세요~~");
		
		String msg = phone3.receiveSms("만나서 반갑습니다~~"); // 리턴값 저장
		System.out.println("::: 받은 메시지 : " + msg); // 리턴받은 데이터 사용
		
		System.out.println("--------main 끝 ----------");
		
		
	
	
	
}
}
