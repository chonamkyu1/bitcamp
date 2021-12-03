package com.mystudy.viewer;


import java.util.Scanner;

public class BankATM {
   private static int money = 10000; 
   private static Scanner scan = new Scanner(System.in);
   private static String menu = "1. 입금 2. 출금 3. 잔액확인 0. 종료\n번호를 선택해주세요 >";

   public static void main(String[] args) {
      System.out.println(">> ATM 기계를 사용합니다");

      System.out.println(menu);
      int userChoice = scan.nextInt();
      while (true) {
         if (userChoice == 1) {
            deposit();
            checkAccount();
            System.out.println();
         } else if (userChoice == 2) {
            withdraw();
            checkAccount();
            System.out.println();
         } else if (userChoice == 3) {
            checkAccount();
            System.out.println();
         } else if (userChoice == 0) {
            System.out.println("프로그램을 종료합니다.\n이용해주셔서 감사합니다.");
            break;
         } else {
            System.out.println("잘못된 입력입니다.");
            System.out.println(menu);
            userChoice = scan.nextInt();
         }
         System.out.println(menu);
         userChoice = scan.nextInt();
      }
   }

   // 입금 처리 메소드
   public static void deposit() {
      System.out.println("입금하실 금액을 입력해주세요.");
      System.out.println(">> ");
      int userInput = scan.nextInt();
      money += userInput;
      System.out.println("::: 입금 금액 : " + userInput + "원");
   }

   // 출금 처리 메소드
   public static void withdraw() {
      while (true) {
         if (money > 0) {
            System.out.println("출금하실 금액을 입력해주세요.");
            checkAccount();
            System.out.println(">> ");
            int userInput = scan.nextInt();
            if (money < userInput) {
               System.out.println("출금 가능한 잔액이 부족합니다.");
               checkAccount();
               System.out.println();
            } else {
               money -= userInput;
               System.out.println("::: 출금 금액 : " + userInput + "원");
               break;
            }
         } else {
            System.out.println("출금 가능한 잔액이 부족합니다.");
            break;
         }
      }
   }

   // 계좌 확인 메소드
   public static void checkAccount() {
      System.out.println("::: 현재 잔액 : " + money + "원");
   }
}