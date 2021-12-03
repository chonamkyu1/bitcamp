package com.spring.exam.member.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.exam.member.service.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberVO selectOneMember(String id) {
		return mybatis.selectOne("member.selectOneMember", id);
	}

	public List<MemberVO> selectAllMember() {
		return mybatis.selectList("member.selectOneMember");
	}

	public int insertMember(MemberVO vo) {
		return mybatis.update("member.insertMember", vo);
	}

	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public MemberVO checkIdPassword(String id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		return mybatis.selectOne("member.checkIdPassword", map);
	}

}
