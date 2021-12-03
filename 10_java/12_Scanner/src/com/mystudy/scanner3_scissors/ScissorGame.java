package com.mystudy.scanner3_scissors;

import java.util.Random;
import java.util.Scanner;

/* ***** Scanner를 이용한 가위 바위 보 게임 *****
 컴퓨터와 함께하는 가위(1), 바위(2), 보(3) 게임
 0. 컴퓨터가 가위,바위,보를 선택(Math.random() or Random)
 1. 가위, 바위, 보 선택 메뉴 출력
 2. 선택값 입력
 3. 결과 비교후 승자, 패자 결정
 (반복) 게임 반복 진행 - 0 선택시 종료
 */
// (추가구현) 상수값 변수처리
// (추가구현) 메소드로 분리하기


public class ScissorGame {
	private Scanner scan = new Scanner(System.in);
	private static final String SCISSORS = "가위";
	private boolean oneMoreGame = true;
	
	public void startGame() {
		System.out.println(">>> 가위, 바위, 보 게임을 시작합니다.");

		while (oneMoreGame) {

			// 0. 컴퓨터가 가위, 바위, 보를 선택(Math.random() or Random)
			int comSelect = (int) (Math.random() * 3) + 1; // 0, 1,2 가 나오는 값이 + 1을 해줘서 1,2,3이 나오게 처리해준다.
//			System.out.println("랜덤 comSelect:" + comSelect);
//			comSelect = 1;
//			System.out.println("comSelect:" + comSelect);

			// 1. 가위, 바위, 보 메뉴 보여주고 선택하기
			System.out.println(">> 가위, 바위, 보 중에서 하나를 선택해주세요.");
			System.out.println("1. 가위 2. 바위 3. 보");
			System.out.print(">> 당신의 선택은 (1 ~ 3)?");

			// 2. 선택값 입력
			int select = Integer.parseInt(scan.nextLine()); // 형변환처리 해주기 앞에는 인트 뒤에는 스트링이니까
			
			String strComputer = "선택안함";
			if (comSelect == 1) {
				strComputer = SCISSORS;
			} else if (comSelect == 2) {
				strComputer = "바위";
			} else if (comSelect == 3) {
				strComputer = "보";
			}

			String strPerson = "선택안함";
			switch (select) {
			case 1:
				strPerson = SCISSORS;
				break;
			case 2:
				strPerson = "바위";
				break;
			case 3:
				strPerson = "보";
				break;
			default:
				System.out.println("1~3 중에 하나를 선택해주세요.");
			}
			//System.out.println(">> 나의 선택: " + strPerson);
			//System.out.println(">> 컴퓨터의 선택 " + strComputer);

			// 3. 결과 비교 후 승자, 패자 결정
			String result = "결정안됨";
			// 사람이 <가위>인 경우
			if (SCISSORS.equals(strPerson)) {
				if (SCISSORS.equals(strComputer)) {
					result = "무승부";
				}
				if ("바위".equals(strComputer)) {
					result = " 컴퓨터 승";
				}
				if ("보".equals(strComputer)) {
					result = " 나자신 승";
				}
			}
			// 사람이 <바위>인 경우
			if ("바위".equals(strPerson)) {
				if (SCISSORS.equals(strComputer)) {
					result = "나자신 승";
				}
				if ("바위".equals(strComputer)) {
					result = " 무승부";
				}
				if ("보".equals(strComputer)) {
					result = " 컴퓨터 승";
				}
			}
			// 사람이 <보>인 경우
			if ("보".equals(strPerson)) {
				if (SCISSORS.equals(strComputer)) {
					result = "컴퓨터 승";
				}
				if ("바위".equals(strComputer)) {
					result = " 나자신 승";
				}
				if ("보".equals(strComputer)) {
					result = "무승부";
				}
			}

			// 결과 출력
			System.out.println("------ 결과 --------");
			System.out.println(">> 나의 선택: " + strPerson);
			System.out.println(">> 컴퓨터의 선택 " + strComputer);
			System.out.println(">> 결과: " + result);
			
			// 추가 게임 여부 확인
			System.out.println("-----------------");
			System.out.print(">> 한 번 더 하시겠습니까?? (y/n) ");
			String yn =  scan.nextLine();
			if ("n".equalsIgnoreCase(yn)) {
				System.out.println(">> 게임을 종료합니다.");
				oneMoreGame = false;
			}
		}
	}
}
