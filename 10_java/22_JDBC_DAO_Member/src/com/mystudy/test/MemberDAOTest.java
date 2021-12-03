package com.mystudy.test;

import java.util.List;

import com.mystudy.jdbc_member.dao.MemberDAO;
import com.mystudy.jdbc_member.vo.MemberVO;

public class MemberDAOTest {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.selectAll();

		for (MemberVO mvo : list) {
			System.out.println(mvo);

		}

		System.out.println("==== 데이터 1개 조회(ID)");
		MemberVO vo = dao.selectOne("HONG8");
		System.out.println(vo);
		
		System.out.println("==== 데이터 1개 추가(INSERT)");
		MemberVO insertVO = new MemberVO("CHO1", "조남규", "0000"
				,"010-1111-2222", "인천시 부평구");
		int result = dao.insert(insertVO);
		System.out.println("입력건수: " + result);
		
		System.out.println("==== 데이터 1개 업데이트(이름으로) ====");
		MemberVO updateVO = new MemberVO(null, "조남규2", null, null, null);
		boolean updateResult = dao.updateName(vo);
		System.out.println("입력건수:" + updateResult);
	}
	
}
