package com.spring.exam.member.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.exam.member.service.MemberService;
import com.spring.exam.member.service.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO selectOneMember(String id) {
		return memberDAO.selectOneMember(id);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return memberDAO.selectAllMember();
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO checkIdPassword(String id, String password) {
		return memberDAO.checkIdPassword(id, password);
	}

}
