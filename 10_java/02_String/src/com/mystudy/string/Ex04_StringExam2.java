package com.mystudy.string;

public class Ex04_StringExam2 {

	public static void main(String[] args) {
		// "홍길동", "이순신", "이순신", "을지문덕", "김유신", "연계소문", "tom", "TOM"
		String[] names = { "홍길동", "이순신", "이순신", "을지문덕", "김유신", "연계소문", "Tom", "TOM" };
		System.out.println("names 데이터 갯수: " + names.length); // length 배열의 크기

		// 2번 구분자 " " 이 부분을 ,로 바꾸기
		// 홍길동,이순신,이순신,을지문덕, 등등 -> println -> print하고 맨뒤 ,처리
		// 홍길동,이순신,이순신,을지문덕,김유신,연개소문,Tom,TOM
		System.out.println("--- 2번 ---");
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				System.out.print(names[i]);  //0번 홍길동
			} else {
				System.out.print("," + names[i]); // 1번 ,이순신 2번 ,이순신 ... ,TOM 하고 끝
			}
		}
		System.out.println();
		System.out.println("-----------------------");

		if (names.length > 1) {
			System.out.print(names[0]);
		}
		for (int i = 1; i < names.length; i++) {
			System.out.print("," + names[i]);
		}

		// 3번 데이터 첫글자만 입력해서 ,로 나열
		// ex) 홍,이,이,을,김 등등
		System.out.println();
		System.out.println("--- 3번 ---");
		if (names.length > 0) {
			System.out.println(names[0].charAt(0));
		}
		if (names.length > 0) {
			System.out.print(names[0].charAt(0));
		}
		for (int i = 1; i < names.length; i++) {
			System.out.print("," + names[i].charAt(0));
		}

		// 4번 4글자 이상 이름을 인덱스번호:이름 형태로 출력
		// ex) 3:을지문덕

		System.out.println();
		System.out.println("--- 4번 ---");
		for (int i = 1; i < names.length; i++) {
			if (names[i].length() >= 4) {
				System.out.println(i + ":" + names[i]);

			}
		}

		// 5번 이름이 같은 데이터를 인덱스번호:이름=인덱스번호:이름 형태로 출력
		// ex) 1:이순신=2:이순신
		// 이름 비교시 대소문가 구분없이 비교처리
		// ex) tom, TOM은 같다
		// "홍길동", "이순신", "이순신", "을지문덕", "김유신", "연계소문", "tom", "TOM"
		// 0 1 2 3 4 5 6 7
		// ---------------
		// 기준인덱스 : 0 일때
		System.out.println();
		System.out.println("--- 5번 ---");
		/*
		 * if(names[0].equalsIgnoreCase(names[1])) { System.out.println(0 + ":" +
		 * names[0] + "=" + 1 + ":" + names[1]); }
		 * if(names[0].equalsIgnoreCase(names[2])) { System.out.println(0 + ":" +
		 * names[0] + "=" + 2 + ":" + names[2]); }
		 * if(names[0].equalsIgnoreCase(names[3])) { System.out.println(0 + ":" +
		 * names[0] + "=" + 3 + ":" + names[3]); } //.....
		 * if(names[0].equalsIgnoreCase(names[names.length -1])) { System.out.println(0
		 * + ":" + names[0] + "=" + (names.length-1) + ":" + names[names.length-1]); }
		 */
		// 기준 인덱스 : 0
		for (int i = 1; i < names.length; i++) {
			if (names[0].equalsIgnoreCase(names[i])) {
				System.out.println(0 + ":" + names[0] + "=" + 1 + ":" + names[i]);

			}
		}

		// 기준 인덱스 : 1
		for (int i = 2; i < names.length; i++) {
			if (names[1].equalsIgnoreCase(names[i])) {
				System.out.println(1 + ":" + names[1] + "=" + 1 + ":" + names[i]);
			}
		}
		// 기준 인덱스 : 2
		for (int i = 3; i < names.length; i++) {
			if (names[2].equalsIgnoreCase(names[i])) {
				System.out.println(2 + ":" + names[2] + "=" + 1 + ":" + names[i]);
			}
		}
		
		// .....
		// 기준 마지막 인덱스 : names.length - 2
		// 비교 대상 마지막 인덱스 : names.length -1
		for (int i = names.length -1; i < names.length; i++) {
			if (names[names.length-2].equalsIgnoreCase(names[i])) {
				System.out.println(names.length-2+ ":" + names[names.length-2] + "=" + 1 + ":" + names[i]);
			}
		}
	
	//======================================================================
	
	// 이중 반복문 만들기
		System.out.println("-------이중반복문(최종) -----");
		for (int gijun= 0; gijun < names.length-1; gijun++) {
			for (int i = gijun + 1; i < names.length; i++) {
				if (names[gijun].equalsIgnoreCase(names[i])) {
					System.out.println(gijun + ":" + names[gijun] + "=" + 1 + ":" + names[i]);
				}
			}
		}
	
	}

}
