package com.mystudy.list3_linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListExam {
	public static void main(String[] args) {
		// LinkedList: List 속성
		LinkedList<String> list = new LinkedList<>();
		list.add("홍길동"); // 데이터 중복 허용된다
		// list.add("홍길동");
		// list.add("김유신");
		
		System.out.println("list: " + list);
		System.out.println(list.get(0)); // 0번째 인덱스

		String str = "홍길동,김유신,강감찬,을지문덕,홍경래,김유신";
		String[] strs = str.split(","); // 문자열타입의 배열을 얻을 수 있다.
		System.out.println("strs: " + Arrays.toString(strs));

		// 배열에 있는 데이터를 리스트에 추가
		for (int i = 0; i < strs.length; i++) {
			list.add(strs[i]);
		}
		System.out.println("list: " + list);
		// --------------------------------------------

		// (실습) 리스트에 잇는 데이터 변경하기
		// 변경할 데이터를 찾고, 해당 위치값 처리하기
		// 김유신 삭제 -> remove 메소드 사용
		// 홍길동 -> 홍길동2로 바꾸기 -> set메소드사용
		System.out.println("변경전 list: " + list);
		// 김유신 삭제

		list.remove("김유신"); // remove(int 방법, Object 방법)
		// -> 김유신 데이터 맨앞쪽에 있는것 1개 삭제
		// 만약에 김유신이 한개가아니라 여러개의 데이터가 있으면 삭제, 없으면 작업끝
		while (true) {
			if (list.contains("김유신")) { // 있으면
				list.remove("김유신");
			} else { // 없으면 작업끝
				break;
			}
		}

		// 홍길동 -> 홍길동2로 바꾸기
		// list.set(0, "홍길동2");
		// list.set(1, "홍길동2");
//		int index = list.indexOf("홍길동"); // 홍길동의 위치를 찾는다.
//		System.out.println("index: " + index);
//		if (index >= 0) {
//			list.set(index, "홍길동2");			
//		}

		// 리스트 전체 데이터 대상으로
		while (true) {
			int index = list.indexOf("홍길동");
			if (index == -1) {  // -1 = 홍길동값이 없다는 뜻
				break;
			} else {
				list.set(index, "홍길동2");
			}
		}
		System.out.println("변경후 list: " + list);

	}

}
