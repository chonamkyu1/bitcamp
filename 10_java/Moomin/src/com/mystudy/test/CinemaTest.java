package com.mystudy.test;

import java.util.List;

import com.mystudy.dao.CinemaDAO;
import com.mystudy.vo.CinemaVO;

public class CinemaTest {
	public static void main(String[] args) {
		CinemaDAO dao = new CinemaDAO();
		List<CinemaVO> list = dao.selectAll();
		
		for (CinemaVO cvo : list ) {
			System.out.println(list);
		}
		
		System.out.println("데이터 1개 조회");
		CinemaVO vo = dao.selectOne(1);
		System.out.println(vo);
		
	
//		System.out.println("==== 데이터 1개 추가(INSERT)");
//		CinemaVO insertVO = new CinemaVO(2, "인천", "010-1234-5678");
//		int result = dao.insert(insertVO);
//		System.out.println(result);
//		
//		System.out.println("==== 데이터 1개 업데이트(이름으로) ====");
//		CinemaVO updateVO = new CinemaVO(2, "부천", "010-2345-6789");
//		int resultUpdate = dao.update(updateVO);
//		System.out.println("업데이트: " + resultUpdate);
//		
//		System.out.println("==== 데이터 1개 삭제(ID) ====");
		//int resultDelete = dao.delete(3);
		//System.out.println("삭제: " + resultDelete);
	//	dao.delete(1);
	}
}
