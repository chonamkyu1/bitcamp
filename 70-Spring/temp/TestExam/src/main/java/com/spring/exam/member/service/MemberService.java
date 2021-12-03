package com.spring.exam.member.service;

import java.util.List;

public interface MemberService {
	public MemberVO selectOneMember(String id);
	public List<MemberVO> selectAllMember();
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(String id);
	public MemberVO checkIdPassword(String id, String password);
}
