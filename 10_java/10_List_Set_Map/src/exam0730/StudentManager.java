package exam0730;

import java.util.ArrayList;


public class StudentManager {
/*
 * 성명, 국어점수, 영어점수, 수학점수
	"홍길동", 100, 90, 81
	"이순신", 95, 88, 92
	"김유신", 90, 87, 77
	개인별 추가 데이터 2개
	
	1.	제공된 3명과 추가한 2명 합계 5명의 학생데이터를 생성하시오.
	2.	5명의 데이터를 선택한 List / Set / Map 타입의 저장공간을 만들고 저장하시오.
	3.	저장되어 있는 학생데이터를 성명, 국어, 영어, 수학, 총점, 평균을 목록형태로 화면출력하시오
	4.	<홍길동> 학생의 데이터 중 영어점수를 95점, 수학점수를 85점으로 수정하고 수정된 데이터를 출력하시오.
	5.	최종 처리 완료된 모든 학생 정보를 출력하시오.
	6.	학생데이터 중 성명, 총점, 평균만 화면에 출력하시오

 */
	public static void main(String[] args) {
		
		
		// 1번 
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77);
		StudentVO stu4 = new StudentVO("박혁거세", 100, 92, 93);
		StudentVO stu5 = new StudentVO("조남규", 95, 95, 95);
		
		//stu1.printData();
		//System.out.println("---------------------------------");
		
		// 2번.
		ArrayList<StudentVO> list = new ArrayList<>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
		
		//System.out.println("list: " + list);
		//System.out.println("stu1.getName(): " + stu1.getName());
		System.out.println("-----------------------------------");
		
		for (int i = 0; i < list.size(); i++) {
			StudentVO vo = list.get(i);
			vo.printData();
			// printData(list); 5번 반복된다.
		}
		
		// 3번
		System.out.println("-----------------------------------");
		System.out.println("----- 데이터 변경 전 -----------");
		//stu1.printData(); // 홍길동 내용 출력
		list.get(0).printData();
		list.get(0).setEng(95);
		list.get(0).setMath(85);
		
		System.out.println("----- 데이터 변경 후 -----------");
		//stu1.printData();
		list.get(0).printData();
		
		System.out.println("-------------------------------------");
		
		
		// 4번.
		
		for (int i = 0; i < list.size(); i++) {
			StudentVO vo = list.get(i);
			vo.printData();
		}
		
		System.out.println("---------------------------------------");
		
		// 5번.
		printData2(list);
		
	
		
		
		
	}
	
	static void printData(ArrayList<StudentVO> list) {
		for (StudentVO vo : list) {
			vo.printData();
		}
	}
	
	static void printData2(ArrayList<StudentVO> list) {
		for (StudentVO vo : list) {
			vo.printData2();
		}
	}
}
