package Exam0806;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentManagerTest {

	public static void main(String[] args) {
		StudentManager students = new StudentManagerImpl();
		StudentVO svo1 = new StudentVO("1", "김유신", 100, 90, 80);
		StudentVO svo2 = new StudentVO("2", "홍길동", 90, 80, 70);
		StudentVO svo3 = new StudentVO("3", "이순신", 95, 95, 95);
		StudentVO svo4 = new StudentVO("4", "이순신", 85, 85, 85);
		StudentVO svo5 = new StudentVO("5", "조남규", 100, 100, 100);

		System.out.println("11" + svo1);
		//int result = students.insert(svo1);
		int result = 0;
		System.out.println(svo1);

		System.out.println("=== 입력 ===");
		result = students.insert(svo1);
		Insert(result);
		result = students.insert(svo1);
		Insert(result);
		result = students.insert(svo2);
		Insert(result);
		result = students.insert(svo3);
		Insert(result);
		result = students.insert(svo4);
		Insert(result);
		result = students.insert(svo5);
		Insert(result);
		
		result = students.insert(svo5);
		Insert(result);
		System.out.println(students.selectAll());
		System.out.println();
		
		System.out.println("=== id로 조회 ===");
		System.out.println(students.selectOne("3"));
		System.out.println();
		
		System.out.println("== 이름으로 검색 ===");
		System.out.println(students.selectList("이순신"));
		System.out.println();
		
		System.out.println("=== 수정 ===");
		svo1.setName("조남규");
		svo1.setKor(0);
		result = students.update(svo1);
		Update(result);
		System.out.println(students.selectAll());
		System.out.println();
		
		System.out.println("=== 삭제 ===");
		result = students.delete("1");
		Delete(result);
		result = students.delete("2");
		Delete(result);
		System.out.println(students.selectAll());
		System.out.println();
	

	}

	private static void Insert(int result) {
		if(result >= 0) {
			System.out.println("입력에 성공하였습니다.");
		} else {
			System.out.println("입력에 실패하였습니다.");
		}
	}
	private static void Update(int result) {
		if (result >= 0) {
			System.out.println("수정에 성공하였습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private static void Delete(int result) {
		if (result >= 0) {
			System.out.println("삭제에 성공하였습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}
	
}