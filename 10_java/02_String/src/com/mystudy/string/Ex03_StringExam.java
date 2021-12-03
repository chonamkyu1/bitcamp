package com.mystudy.string;

public class Ex03_StringExam {

	public static void main(String[] args) {
		/* String str = "900108-1234567" 주민번호
		 1. 정확히 입력된 데이터 여부확인
		  (전체자릿수 : 14자리인지 확인, '-' : 7번째 확인)
		 2. 생년월일 출력(1-2번째 : 년도, 3-4번째: 월 5-6번째: 일)
		 3. 성별확인하고 출력(1,3: 남성, 2,4: 여성)
		 4. 데이터의 값 검증(월: 1~12, 일: 1~31)
		 (참고) : int num = Interger.parstInt("12") ; //"12" --> 12
		 */
		//			  01234567890123
		String str = "900108-1234567";
		// 1. 정확히 입력된 데이터 여부확인 (전체자릿수 : 14자리인지 확인, '-' : 7번째 확인)
		System.out.println(str.length());
		if(str.length() == 14) {
			System.out.println("[정상]");
		} else {
			System.out.println("[비정상] 전체길이 " + str.length());
		}
		
		int strLen = str.length();
		if(strLen == 14) {
			System.out.println("[정상]");
		} else {
			System.out.println("[비정상] 전체길이 " + strLen);
		}
		
		// '-' : 7번째 확인
		System.out.println(str.substring(6, 7)); //substring 잘라쓰기
		if(str.substring(6, 7).equals("-")) {
			System.out.println("[정상] '-' 문자위치 7번째");
		} else {
			System.out.println("[비정상] '-' 문자위치 7번째 아님");
		}
		
		 System.out.println("str.indexOf(\"-\"): " + str.indexOf("-")); // 인덱스번호로는 6번
		 if(str.indexOf("-") != 6) {
			 System.out.println("[비정상] '-' 문자위치가 7번째가 아님");
		 }
		 System.out.println("str.charAt(6): " + str.charAt(6));
		 if(str.charAt(6) != '-') { //char은 ""이비교 x ''로 비교
				System.out.println("[비정상] '-' 문자위치 7번째 아님");
		 }
		 
		 
		 System.out.println("=====================");
		 // 2. 생년월일 출력 (1-2번 : 년도 3-4번 : 월, 5-6: 일)
		 //		   	     01234567890123
		 //String str = "900108-1234567";
		 String yymmdd = str.substring(0, 6); // substring 잘라쓰기
		 System.out.println("yymmdd: " + yymmdd);
		 String yy = yymmdd.substring(0,2); //시작이상 끝 미만 = 0,1
		 String mm = yymmdd.substring(2, 4); // 시작이상 끝 미만 = 2,3
		 String dd = yymmdd.substring(4, 6); // 시작이상 끝 미만 = 4,5
		 String flag = str.substring(7, 8); // 성별 구분
		 
		 String yyyy =  "";
		 if(flag.equals("1") || flag.equals("2")) {
			 yyyy = "19" + yy;
		 } else if (flag.equals("3") || flag.equals("4")) {
			 yyyy = "20" + yy;
		}
		 System.out.println("생년월일 : " + yy + "년 " + mm +"월 " +dd +"일");
		 System.out.println("생년월일 : " + yyyy + "년 " + mm +"월 " +dd +"일");
		 // 3. 성별 확인하고 출력(1,3 남성 2,4: 여성)
		 //		   	     01234567890123
		 //String str = "900108-1234567";
		String gender = str.substring(7, 8);
		if(gender.equals("1") || gender.equals("3")) {
			System.out.println("주민번호뒷자리(첫글자) : " + gender + "(남성)");
		} else if(gender.equals("2") || gender.equals("4")) {
			System.out.println("주민번호뒷자리(첫글자) : " + gender + "(여성)");
		}
		
		switch (gender) {
		case "1" : case "3" :
			System.out.println("주민번호뒷자리(첫글자) : " + gender + "(남성)");
			break;
		case "2" : case "4" :
			System.out.println("주민번호뒷자리(첫글자) : " + gender + "(여성)");
			break;
		}
		//------------ charAt() -----------
		char gender2 = str.charAt(7);
		switch (gender2) {
		case '1' : case '3' :
			System.out.println("주민번호뒷자리(첫글자) : " + gender2 + "(남성)");
			break;
		case '2' : case '4' :
			System.out.println("주민번호뒷자리(첫글자) : " + gender2 + "(여성)");
			break;
		default :
			System.out.println("외국인????");
			break;
		}
		
		System.out.println("===========================");
		// 4. 데이터의 값 검증(월: 1~12, 일: 1~31)
	    //		   	    01234567890123
		//String str = "900108-1234567";
		String sMonth = str.substring(2,4);
		int month = Integer.parseInt(sMonth); //int타입으로 형변환
		if(month >= 1 && month <=12) {
			System.out.println("[정상] 월 데이터가 정상(1~12)" );
		} else {
			System.out.println("[정상] 월 데이터가 비정상 1~12 범위를 벗어남" );
		}
		
		if(month < 1 || month > 12) {
			System.out.println("[비정상] 월 데이터가 비정상 1~12 범위를 벗어남" );
		}
		
		// 일자 데이터 확인 (1~31 범위내에 있는지)
		int date = Integer.parseInt(str.substring(4, 6)); // "08" -> 8 숫자로 형변환
		if(date >= 1 && date <= 31) {
			System.out.println("[정상] 일 데이터가 정상(1~31)");
		} else {
			System.out.println("[정상] 일 데이터가 비정상 1~31 범위를 벗어남");

		}
		
		 System.out.println("----------main 끝-----------");
		 
	}

}
