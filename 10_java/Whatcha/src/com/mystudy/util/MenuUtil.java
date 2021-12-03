/*
 * package com.mystudy.util;
 * 
 * import java.util.InputMismatchException; import java.util.Scanner;
 * 
 * public class MenuUtil { private ScannerUtil scannerUtil;
 * 
 * public MenuUtil() { scannerUtil = new ScannerUtil(); }
 * 
 * public int selectMenu(String[] menuList, int min) { while (true) { try {
 * return scannerUtil.nextInt(printMenuList(menuList), min,
 * maxMenuList(menuList, min)); } catch (InputMismatchException e) {
 * System.out.println("잘못된 입력입니다."); } } }
 * 
 * private String printMenuList(String[] menuList) { return String.join("    ",
 * menuList); }
 * 
 * private int maxMenuList(String[] menuList, int min) { int result = -1; if
 * (min == 0) { result = menuList.length - 1; } if (min == 1) { result =
 * menuList.length; } return result; } }
 */