package com.mystudy.list5_sort_vo;

import java.util.ArrayList;
import java.util.Collections;


public class StudentSortTest {
	public static void main(String[] args) {
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77);

		ArrayList<StudentVO> list = new ArrayList();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		printData(list);
		
		
		System.out.println("----- sort 진행전 -----");
		printData(list);
		
		//StudentVO에서 오버라이딩된값에 따라 이름,점수 등 오름차순 정렬할수있다.
		Collections.sort(list);
		
		System.out.println("----- sort 진행후 -----");
		printData(list);
		
		
		
	}
	static void printData(ArrayList<StudentVO> list) {

		for (StudentVO vo : list) {
			vo.printData();
		}
	}
}
