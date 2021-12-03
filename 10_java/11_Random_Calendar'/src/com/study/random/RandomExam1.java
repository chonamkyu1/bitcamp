package com.study.random;

import java.util.Random;

public class RandomExam1 {

	public static void main(String[] args) {
		// Random: 난수(임의의 수)를 생성하는 클래스
		// 정수형: nextInt() - int 타입의 난수를 생성한다.
		//       nextInt(10): 0~9까지 범위의 정수형 난수 발생한다.
		//       nextLong() - long 타입의 난수를 생성한다.
		// 실수형: nextFloat() - 실수형 float 타입 난수를 생성한다.
		//		 nextDouble() - 실수형 Double 타입 난수를 생성한다.
		// 논리형: nextBoolean() - true, false 둘 중 하나 발생한다.
		// -------------------------------------------------
		
		Random ran = new Random();
		System.out.println("---- nextBoolean() ----");
		System.out.println("ran.nextBoolean(): " + ran.nextBoolean());
		System.out.println("ran.nextBoolean(): " + ran.nextBoolean());
		for (int i = 0; i < 10; i++) {
			System.out.print(ran.nextBoolean() + " " );
		}
		System.out.println();
		
		
		System.out.println("---- nextInt() ----");
		System.out.println("ran.nextInt(): " + ran.nextInt());
		System.out.println("ran.nextInt(): " + ran.nextInt());
		System.out.println("ran.nextInt(): " + ran.nextInt());
		
		for (int i = 0; i < 100; i++) {
			System.out.print(ran.nextInt(10) + " ");
		}
		System.out.println();
		
		System.out.println("---- nextFloat() ----");
		System.out.println("ran.nextFloat(): " + ran.nextFloat());
		System.out.println("ran.nextFloat(): " + ran.nextFloat());
		System.out.println("ran.nextFloat(): " + ran.nextFloat());
		
		System.out.println("---- nextDouble() ----");
		System.out.println("ran.nextDouble(): " + ran.nextDouble());
		System.out.println("ran.nextDouble(): " + ran.nextDouble());
		System.out.println("ran.nextDouble(): " + ran.nextDouble());

		System.out.println("---- Math.random() vs Random nextDouble() ----");
		// 두가지의 차이점은 객체를 생성하는지 안하는지의 차이다 (Math는 x Random은 객체생성해야한다)
		for (int i =0; i < 10; i++) {
			double mathRan = Math.random(); // 0 <= ran < 1 double 타입
			System.out.println(mathRan + " - Math.ranDom()");
			System.out.println(ran.nextDouble() + " - Random nextDouble()"); 
		}
		
		
		

	}

}
