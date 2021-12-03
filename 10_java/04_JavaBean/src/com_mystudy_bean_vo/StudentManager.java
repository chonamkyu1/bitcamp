package com_mystudy_bean_vo;

import java.util.Arrays;

/* 3명의 성적처리
 * 홍길동: 100, 90, 81
 * 이순신: 95, 88, 92
 * 김유신: 90, 87, 77
 * ==========================
 * 홍길동: 100 90 81 271 90.33
 * 이순신: 95 88 92 275 91.66
 * 김유신: 90 87 77 254 84.66 
 */
public class StudentManager {
	public static void main(String[] args) {
		
		//입력
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77);

		System.out.println(stu1);
		stu1.setName("홍길동");
		System.out.println(stu1.getName() +"\t" + stu1.getKor() +"\t" + stu1.getEng()+"\t" + stu1.getMath() +
					stu1.getTot()+"\t" + stu1.getAvg());
		
		
		//stu1.setKor(100);
		//stu1.setEng(90);
		//stu1.setMath(81);
		//System.out.println(stu1.getKor() + stu1.getEng() + stu1.getMath());
		//int tot = stu1.getKor() + stu1.getEng() + stu1.getMath();
		//System.out.println(tot);
		//double avg = tot * 100 / 3 / 100.0; 		
		//System.out.println(avg);
		
		System.out.println(stu1);
				
		//출력
		stu1.printData();
		stu2.printData();
		stu3.printData();
		
		//=========================================================
		
		System.out.println("-------- 배열에 저장해서 사용---------");
		StudentVO[] students = new StudentVO[3];
		System.out.println(Arrays.toString(students)); // 하나도 안담겨있는 모습
		students[0] = stu1;
		students[1] = stu2;
		students[2] = stu3;
		System.out.println(Arrays.toString(students));
		
		System.out.println("--------- 배열데이터 화면 출력 ---------");
		//students[0].setKor(95); // .set 메소드 사용하면 값도 바꿔서 출력도가능
		students[0].printData();
		students[1].printData();
		students[2].printData();	
		
		System.out.println("-----------------");
		printData(students);
	}
	
	static void printData(StudentVO[] students) { // 전달받은 배열 데이터를 화면에 출력
		for(StudentVO vo : students) {
			vo.printData();
		}
	}
	
	
	
	
}
