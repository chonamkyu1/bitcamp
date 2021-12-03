package com.mystudy.jdbc_member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mystudy.jdbc_member.common.CommonUtil;
import com.mystudy.jdbc_member.vo.MemberVO;

public class MemberDAO {
	// SELECT: 테이블 전체 데이터 조회 - selectAll: List<MemberVO>
	// SELECT: 하나의 데이터 조회(ID) - selectOne: MemberVO
	// SELECT: 하나의 데이터 조회(VO) - selectOne: MemberVO
	// SELECT: 로그인(id, password) - login : boolean
	// SELECT: 전체 인원수 확인 - getCountAll() : int

	// INSERT: VO 객체를 받아서 입력 - insert: int

	// UPDATE: VO 이름을 받아서 수정 - updateName(vo): boolean
	// UPDATE: VO 이름을 받아서 수정 - updateName(id, name): boolean
	// UPDATE: VO 패스워드를 받아서 수정 - updatePassword: boolean
	// UPDATE: VO 전화번호를 받아서 수정 - updatePhone: boolean
	// UPDATE: VO 주소를 받아서 수정 - updateAddress: boolean

	// DELETE: VO 객체를 받아서 삭제 - delete: int
	// DELETE: 키값(ID)을 받아서 삭제 - delete: int

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		
		conn = CommonUtil.getConnection();

		if (conn == null) return null;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS");
			sql.append(" FROM MEMBER");

			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<MemberVO>();
			while (rs.next()) {
				MemberVO vo = new MemberVO(rs.getString("ID"),
						rs.getString("NAME"), rs.getString("PASSWORD"),
						rs.getString("PHONE"), rs.getString("ADDRESS"));
			list.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt, rs);
		}

		return list;
	}
	
	public MemberVO selectOne(String id) {
		MemberVO vo = null;
		
		conn = CommonUtil.getConnection();
		
		if (conn == null) return null;

		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS ");
			sql.append("FROM MEMBER ");
			sql.append("WHERE id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			vo = new MemberVO(rs.getString("ID")
					, rs.getString("NAME")
					, rs.getString("PASSWORD")
					, rs.getString("PHONE")
					, rs.getString("ADDRESS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt, rs);
			
		}
		
		return vo;
	}
	public int insert(MemberVO vo) {
		int result = 0;
		
		conn = CommonUtil.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER" );
			sql.append(" (ID, NAME, PASSWORD, PHONE, ADDRESS)");
			sql.append("VALUES (?, ?, ?, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getAddress());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt);
		}
		
		return result;
		
	}
	
	public boolean updateName(MemberVO vo) {
		boolean result = false;
		conn = CommonUtil.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE MEMBER WHERE NAME = ?" );
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getName());
			
			 result = pstmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt);
		}
		
		
		
		return false;
		
	}
}
