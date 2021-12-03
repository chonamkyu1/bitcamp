package com.mystudy.set1_hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class TreeSetLotto {
	public static void main(String[] args) {
		// set을 이용한 로또 만들기: 1~45 랜덤숫자 6개를 set에 저장
		// 1. 로또번호 6개를 추첨하고, 작은 숫자부터 순서대로 화면 출력
		// Math.random(): 0.0 ~ 0.999999 실수형데이터 중 랜덤 값 리턴(0~1 미만 실수형)
		// Math.random(): (int)(Math.random() * 45 + 1)
		// 2. 출력은 작은숫자부터 큰 숫자 형태로
		// 예) 금주의 로또번호: 5, 8, 10, 25, 33, 41
		// ------------------------------------------------
		Random random = new Random();

		HashSet<Integer> lottoSet = new HashSet<>();
//		System.out.println(Math.random());
//		System.out.println( (int)Math.random() * 45 ); // 0*45 -> 0
//		System.out.println( (int)Math.random() * 45 ); // 0*45 -> 0
//		System.out.println( (int) (Math.random() * 45 )); // 0~44
//		System.out.println( (int) (Math.random() * 45 )); // 0~44
//		System.out.println( (int) (Math.random() * 45 ) + 1); // 0~44 + 1 -> 1~45

		int lottoNum;
		for (; lottoSet.size() < 6;) {
			lottoNum = (int) (Math.random() * 45) + 1;
			System.out.print(lottoNum + ", ");
			lottoSet.add(lottoNum);
		}

//		int lottoNum = (int)(Math.random() * 45) +1 ;
//		lottoSet.add(lottoNum);
//		
//		 lottoNum = (int)(Math.random() * 45) +1 ;
//		lottoSet.add(lottoNum);
//		
//		 lottoNum = (int)(Math.random() * 45) +1 ;
//		lottoSet.add(lottoNum);
//		
//		 lottoNum = (int)(Math.random() * 45) +1 ;
//		lottoSet.add(lottoNum);
//		
		System.out.println();
		System.out.println("로또번호" + lottoSet);

		System.out.println("-------------------------------");
		lottoSet.clear();
		while (lottoSet.size() < 6) { // Set 데이터가 6개가 될때 까지
		
			lottoSet.add((int) (Math.random() * 45) + 1);

		}
		System.out.println();

		System.out.println("로또번호(Set): " + lottoSet);

		System.out.println("---- 정렬작업 진행 ----");
		ArrayList<Integer> list = new ArrayList<>(lottoSet);
		System.out.println("list: " + list);
		
		Collections.sort(list); //sort는 리스트만 받을수 있다.
		System.out.println("정렬된로또번호(list): " + list);
		
		
		
		
		
		
		
		
		
		
		
		
		
		// for (int i = 0; i <100; i++) {

		// System.out.print((int)(Math.random()* 45) + 1 + " , ");
		// }

	}
}
