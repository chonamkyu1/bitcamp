package com.mystudy.test;

import java.util.List;

import com.mystudy.dao.CinemaDAO;
import com.mystudy.dao.MemberDAO;
import com.mystudy.vo.CinemaVO;
import com.mystudy.vo.MemberVO;

public class MemberTest {
	public static void main(String[] args) {
		
//		MemberDAO dao = new MemberDAO();
//		boolean resultCheck = dao.checkIDPassword("aaa", "1234");
//		System.out.println("로그인: " + resultCheck);

//		MemberVO insertVO = new MemberVO(3, "3", "삼", "33", "33", "3333");
//		int insertResult = dao.insert(insertVO);
//		System.out.println(insertResult);
		
		MemberDAO dao2 = new MemberDAO();
		List<MemberVO> list = dao2.selectAll();
		
		for ( MemberVO mvo : list) {
			System.out.println(list);
		}
		
		MemberDAO onedao = new MemberDAO();
		MemberVO vo = onedao.selectOne(1);
		System.out.println(vo);
		
		System.out.println("업데이트");
		MemberVO updateVO = new MemberVO(3, "4", "사", "44", "44", "4444");
		int resultUpdate = dao2.update(updateVO);
		System.out.println("업데이트: " + resultUpdate);
		
		int resultDelete = dao2.delete(3);
		System.out.println("삭제: " + resultDelete);
		
		
	}
}
