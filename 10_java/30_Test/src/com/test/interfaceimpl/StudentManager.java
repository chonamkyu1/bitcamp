package com.test.interfaceimpl;

import java.util.List;

public interface StudentManager{
	boolean add(StudentVO obj); // 추가하는 기능
	StudentVO find(String id); 
	List<StudentVO> findList(String name); // 리스트 일부
	// List<StudentVO> selectAll(); // 리스트 전체 -> 파라미터가 따로없다. 
	
	boolean changeKor(String id, int kor);
	boolean changeEng(String id, int eng);
	boolean changeMath(String id, int math);
	
	//boolean update(StudentVO vo);
	//int update(List<StudentVO> list); // 일괄 수정
	//boolean delete(String id);
	//int delete(StudentVO vo);
	//int delete(List<StudentVO> list); // 일괄 삭제
}
