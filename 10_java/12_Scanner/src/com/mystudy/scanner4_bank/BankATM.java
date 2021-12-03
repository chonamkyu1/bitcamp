package com.mystudy.scanner4_bank;

import java.util.Scanner;

// 실습 은행의 ATM 기계 만들기
// 1. 입금 2. 출금 3. 통장확인 0. 종료
// ---------------------------------- 
// 계좌를 하나 만들고 입금/출금/통장확인 작업을 처리

public class BankATM {
	private int money; // 통장 계좌(금액)
	private Scanner scan = new Scanner(System.in);
	private int totalMoney; // 합계금액


	public void startBank() {
		System.out.println(">> ATM 기계를 사용합니다.");
		showMenu();
		System.out.println(">> ATN 기계사용을 종료합니다.");
	}

	public void showMenu() {
		while (true) {
			System.out.println("1. 입금 2. 출금 3. 통장확인 0. 종료");
			System.out.println("1~4번 중 하나를 선택해주세요");
			int userChoice = scan.nextInt();

			if (userChoice == 1) {
				deposit();
			
			} else if (userChoice == 2) {
				whihdraw();
			
			
			} else if (userChoice == 3) {
				System.out.println("통장 잔액은" + totalMoney + "입니다.");
				
				
			} else if (userChoice == 0) {
				System.out.println("종료하겠습니다.");
				break;
			} else {
				System.out.println("잘못입력하셨습니다.");
				System.out.println("다시 입력해주세요");
				
			}
		}
	}

	private void deposit() {
		System.out.println(">> 입금액을 입력해주세요.");
		money = scan.nextInt();
		totalMoney += money;
		System.out.println(money + "원이 입금되었습니다.");
		System.out.println("::통장금액: "  + totalMoney);
		
	}

	private void whihdraw() {
		System.out.println(">> 출금액을 입력해주세요.");
		money = scan.nextInt();
		totalMoney -= money;
		if (totalMoney < 0) {
			System.out.println("잔액이 부족합니다.");
			System.out.println("다시한번 확인해주세요.");
		} else {
			System.out.println("::통장금액: "  + totalMoney);
		}
		
	}

	
		
	}

/*
 * 1.입금 2. 출금 3. 통장확인 0. 종료 작업선택: 1 입금액: 10000원 ::통장금액: 10000원
 * 
 * 1.입금 2. 출금 3. 통장확인 0. 종료 작업선택: 2 >> 출금액: 5000원 :: 통장금액: 5000원
 * 
 * 1.입금 2. 출금 3. 통장확인 0. 종료 작업선택: 3 :: 통장금액: 5000원
 * 
 * 1.입금 2. 출금 3. 통장확인 0. 종료 작업선택: 0 작업을 종료합니다.
 * 
 * 
 */
